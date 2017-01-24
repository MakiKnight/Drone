import java.util.ArrayList;

/**
 * Created by makiknight on 24/01/17.
 * This abstract class represent the main drone architecture
 */
public abstract class Drone {

    //Energy attributes
    private double batteryMax;
    private double battery;

    //Travel attributes
    private int speed;
    private double range;
    private Dot location;
    private Dot target;
    private Base base;

    //Transport attributes
    private double weightCapacity;
    private double weight;
    private int maxPacket;
    private ArrayList<Packet> loadedPackets;

    //Sort attribut
    private Sort sort;

    //Tasks attribute
    private Task task;

    private boolean reloading;

    /**
     * @param batteryMax        : max level of battery
     * @param speed             : number of times the drone can move
     * @param range             : the range where can travels a drone
     * @param weightCapacity    : the max weight of the drone
     * @param maxPacket         : the number of packets can load the drone
     * @param sort              : the sort of the drone (terrestrial / aerial)
     */
    public Drone(double batteryMax, int speed, double range, double weightCapacity, int maxPacket, Sort sort, Task task) {
        this.batteryMax = batteryMax;
        this.speed = speed;
        this.range = range;
        this.weightCapacity = weightCapacity;
        this.maxPacket = maxPacket;
        this.sort = sort;
        this.battery = batteryMax;
        this.location = new Dot(0, 0);
        loadedPackets = new ArrayList<Packet>();
        reloading = false;
        weight = 0.0;
        this.task = task;
        target = task.getLocation();
        base = null;
    }

    public double getBatteryMax() {
        return batteryMax;
    }

    public void setBatteryMax(double batteryMax) {
        this.batteryMax = batteryMax;
    }

    public double getBattery() {
        return battery;
    }

    public void setBattery(double battery) {
        this.battery = battery;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public Dot getLocation() {
        return location;
    }

    public void setLocation(Dot location) {
        this.location = location;
    }

    public Dot getTarget() {
        return target;
    }

    public void setTarget(Dot target) {
        this.target = target;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public void setWeightCapacity(double weightCapacity) {
        this.weightCapacity = weightCapacity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxPacket() {
        return maxPacket;
    }

    public void setMaxPacket(int maxPacket) {
        this.maxPacket = maxPacket;
    }

    public ArrayList<Packet> getLoadedPackets() {
        return loadedPackets;
    }

    public void setLoadedPackets(ArrayList<Packet> loadedPackets) {
        this.loadedPackets = loadedPackets;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public boolean isReloading() {
        return reloading;
    }

    public void setReloading(boolean reloading) {
        this.reloading = reloading;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "batteryMax=" + batteryMax +
                ", battery=" + battery +
                ", speed=" + speed +
                ", range=" + range +
                ", location=" + location +
                ", target=" + target +
                ", weightCapacity=" + weightCapacity +
                ", maxPacket=" + maxPacket +
                ", loadedPackets=" + loadedPackets +
                ", sort=" + sort +
                ", reloading=" + reloading +
                '}';
    }

    public abstract void toDo(Dot dot);

    public void toLade(Base base) {

        boolean critPlace = false;
        boolean haveBeenLaded = false;
        int i = base.getListPacket().size();
        ArrayList<Packet> toRemove = new ArrayList<Packet>();

        //System.out.println(base.getListPacket().get(0).toString());
        while (!critPlace && i > 0) {
            if (loadedPackets.size() + 1 <= maxPacket) {
                if (base.getListPacket().get(i-1).getWeight() + weight <= weightCapacity) {
                    haveBeenLaded = true;
                    loadedPackets.add(base.getListPacket().get(i-1));
                    toRemove.add(base.getListPacket().get(i-1));
                    weight = weight + base.getListPacket().get(i-1).getWeight();
                    System.out.println("Packet ladded");
                    System.out.println("");

                }
                i--;
            } else {
                critPlace = true;
            }
        }

        for (Packet p : toRemove) {
            p.setLoaded(true);
            base.getListDrone().remove(p);
        }

        if(haveBeenLaded){
            target = loadedPackets.get(0).getTarget();
            task = new Task(Task.DUMP,target,null);
            System.out.println(this.toString());
        }

    }

    public void toDump() {
        if(location.equals(loadedPackets.get(0).getTarget())){
            loadedPackets.get(0).setLoaded(false);
            base.getDropedPacket().add(loadedPackets.get(0));
            weight = weight - loadedPackets.get(0).getWeight();
            loadedPackets.remove(0);
            if(!loadedPackets.isEmpty()){
                target = loadedPackets.get(0).getTarget();
            } else {
                task = new Task(Task.RECHARGE_BASE,new Dot(0,0),null);
            }
        }
    }
}
