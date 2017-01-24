/**
 * Created by makiknight on 24/01/17.
 */
public class Repairer extends Drone {

    private double rechargingPower; // for 0.5 energy, recharge 2.00

    public Repairer(double rechargingPower, Sort sort) {
        super(150, 3, 150, 100, 2, sort, new Task(Task.TaskTypes.MOVE, new Dot(0, 0), null));
        this.rechargingPower = 2.0;
        this.setSpeed((int) (Math.floor(getSpeed() * getSort().getSpeedCoef())));
        this.setRange(Math.floor(getRange() * getSort().getRangeCoef()));
        this.setWeightCapacity(Math.floor(getWeightCapacity() * getSort().getWeightCoef()));
        this.setMaxPacket((int) (Math.floor(getMaxPacket() * getSort().getPacketCoef())));
    }

    /**
     * @param dot : the final dot the drone have to reach
     */
    public void toDo(Dot dot) {
        for (int i = 1; i <= this.getSpeed(); i++) {
            //Check if the drone has already reach the target point
            if (this.getLocation().equals(dot)) {
                switch (this.getTask().getType()) {
                    case RECHARGE_DRONE:
                        toRecharge(this.getTask().getDrone());
                        break;
                    case RECHARGE_BASE:
                        this.setBattery(this.getBatteryMax());
                        break;
                    case LADE:
                        this.toLade(this.getBase());
                        break;
                    case DUMP:
                        this.toDump();
                        break;
                    case MOVE:

                        break;
                }
            } else {
                //Check if the drone has enough energy to travel
                if (this.getBattery() >= 1) {
                    this.setLocation(this.getLocation().shorterPath(dot));
                    this.setBattery(this.getBattery() - 1.0);
                    for (Packet packet : this.getLoadedPackets()) {
                        packet.setLocation(this.getLocation().shorterPath(dot));
                    }
                }
            }

        }
    }

    public void toRecharge(Drone drone) {
        /*  We have to prevent the case of a Repairer have to recharge another Repairer etc
            Need to verifiy that the Repairer have enough energy to come back at a distance of 75 from the headquarter
         */
        double energyToSave = this.getLocation().forecastEnergy(new Dot(0, 0));
        if (energyToSave < this.getBattery() - 0.5) {
            drone.setReloading(true);
            //Check if do not esceed the capacity of the battery
            if (drone.getBattery() + 2.0 <= drone.getBatteryMax()) {
                drone.setBattery(drone.getBattery() + 2.0);
            } else {
                drone.setBattery(drone.getBatteryMax());
            }
        } else {
            //We have to recharge at the base
            drone.setReloading(false);
            this.setTarget(new Dot(0, 0));
        }


    }
}
