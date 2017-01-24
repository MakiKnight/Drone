/**
 * Created by makiknight on 24/01/17.
 */
public abstract class Sort {

    private double speedCoef;
    private double rangeCoef;
    private double weightCoef;
    private double packetCoef;

    /**
     * @param speedCoef     : coeff for the speed
     * @param rangeCoef     : coeff for the range
     * @param weightCoef    : coeff for the weight
     * @param packetCoef    : coeff for the number of packets
     */
    public Sort(double speedCoef, double rangeCoef, double weightCoef, double packetCoef) {
        this.speedCoef = speedCoef;
        this.rangeCoef = rangeCoef;
        this.weightCoef = weightCoef;
        this.packetCoef = packetCoef;
    }

    public double getSpeedCoef() {
        return speedCoef;
    }

    public void setSpeedCoef(double speedCoef) {
        this.speedCoef = speedCoef;
    }

    public double getRangeCoef() {
        return rangeCoef;
    }

    public void setRangeCoef(double rangeCoef) {
        this.rangeCoef = rangeCoef;
    }

    public double getWeightCoef() {
        return weightCoef;
    }

    public void setWeightCoef(double weightCoef) {
        this.weightCoef = weightCoef;
    }

    public double getPacketCoef() {
        return packetCoef;
    }

    public void setPacketCoef(double packetCoef) {
        this.packetCoef = packetCoef;
    }
}
