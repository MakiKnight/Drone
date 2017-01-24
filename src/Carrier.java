/**
 * Created by makiknight on 24/01/17.
 */
public class Carrier extends Drone {

    public Carrier() {
        super(200,2,100,500,10,new Terrestrial());
        this.setSpeed((int)(Math.floor(getSpeed()*getSort().getSpeedCoef())));
        this.setRange(Math.floor(getRange()*getSort().getRangeCoef()));
        this.setWeightCapacity(Math.floor(getWeightCapacity()*getSort().getWeightCoef()));
        this.setMaxPacket((int)(Math.floor(getMaxPacket()*getSort().getPacketCoef())));
    }


}
