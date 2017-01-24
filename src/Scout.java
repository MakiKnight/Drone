/**
 * Created by makiknight on 24/01/17.
 */
public class Scout extends Drone{

    public Scout(Sort sort) {
        super(100,4,200,50,1,sort);
        this.setSpeed((int)(Math.floor(getSpeed()*getSort().getSpeedCoef())));
        this.setRange(Math.floor(getRange()*getSort().getRangeCoef()));
        this.setWeightCapacity(Math.floor(getWeightCapacity()*getSort().getWeightCoef()));
        this.setMaxPacket((int)(Math.floor(getMaxPacket()*getSort().getPacketCoef())));
    }


}
