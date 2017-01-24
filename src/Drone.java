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

    //Transport attributes
    private double weightCapacity;
    private double weight;
    private int maxPacket;
    private ArrayList<Packet> loadedPackets;

    //Sort attribut
    private Sort sort;

    private boolean reloading;

    /**
     * @param batteryMax        : max level of battery
     * @param speed             : number of times the drone can move
     * @param range             : the range where can travels a drone
     * @param weightCapacity    : the max weight of the drone
     * @param maxPacket         : the number of packets can load the drone
     * @param sort              : the sort of the drone (terrestrial / aerial)
     */
    public Drone(double batteryMax, int speed, double range, double weightCapacity, int maxPacket, Sort sort) {
        this.batteryMax = batteryMax;
        this.speed = speed;
        this.range = range;
        this.weightCapacity = weightCapacity;
        this.maxPacket = maxPacket;
        this.sort = sort;
        this.battery = batteryMax;
        this.location = new Dot(0,0);
        loadedPackets = new ArrayList<Packet>();
        reloading = false;
        target = new Dot(0,0);
        weight = 0.0;
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

    /**
     * @param dot   : the final dot the drone have to reach
     */
    public void toTravel(Dot dot) {
        for(int i=1; i<=this.getSpeed(); i++){
            //Check if the drone has already reach the target point
            if(this.getLocation().equals(dot)){

            } else {
                //Check if the drone has enough energy to travel
                if(this.getBattery() >=1) {
                    this.location = this.location.shorterPath(dot);
                    this.setBattery(this.getBattery()-1.0);
                    for(Packet packet : loadedPackets){
                        packet.setLocation(location.shorterPath(dot));
                    }
                }
            }

        }
    }

    public void toLade(Packet packet) {
        //Check if we have the capacity and the place to carry the packet
        if(this.getWeight()+packet.getWeight() <= this.getWeightCapacity()) {
            if(this.getMaxPacket()>= this.getLoadedPackets().size()+1){
                loadedPackets.add(packet);
                weight = weight + packet.getWeight();
                packet.setLoaded(true);
            } else {
                System.out.println("Max packets capacity reached !");
            }
        } else {
            System.out.println("Weight capacity reached !");
        }
    }

    public void toDump() {
        if(location.equals(loadedPackets.get(0).getTarget())){
            loadedPackets.get(0).setLoaded(false);
        }
    }
}
