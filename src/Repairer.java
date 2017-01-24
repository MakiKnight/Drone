/**
 * Created by makiknight on 24/01/17.
 */
public class Repairer extends Drone {

    private double rechargingPower; // for 0.5 energy, recharge 2.00

    public Repairer(double rechargingPower, Sort sort) {
        super(150,3,150,100,2,sort);
        this.rechargingPower = 2.0;
        this.setSpeed((int)(Math.floor(getSpeed()*getSort().getSpeedCoef())));
        this.setRange(Math.floor(getRange()*getSort().getRangeCoef()));
        this.setWeightCapacity(Math.floor(getWeightCapacity()*getSort().getWeightCoef()));
        this.setMaxPacket((int)(Math.floor(getMaxPacket()*getSort().getPacketCoef())));
    }

    public void toRecharge(Drone drone){
        /*  We have to prevent the case of a Repairer have to recharge another Repairer etc
            Need to verifiy that the Repairer have enough energy to come back at a distance of 75 from the headquarter
         */
        double energyToSave = this.getLocation().forecastEnergy(new Dot(0,0));
        if(energyToSave<this.getBattery()-0.5) {
            drone.setReloading(true);
            //Check if do not esceed the capacity of the battery
            if(drone.getBattery()+2.0 <= drone.getBatteryMax()){
                drone.setBattery(drone.getBattery()+2.0);
            } else {
                drone.setBattery(drone.getBatteryMax());
            }
        } else {
            //We have to recharge at the base
            drone.setReloading(false);
            this.setTarget(new Dot(0,0));
        }


    }
}
