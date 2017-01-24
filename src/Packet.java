/**
 * Created by makiknight on 24/01/17.
 */
public class Packet {

    private double weight;
    private Dot target;
    private Dot location;
    private boolean loaded;

    public Packet(double weight, Dot target) {
        this.weight = weight;
        this.target = target;
        location = new Dot(0,0);
        loaded = false;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "weight=" + weight +
                ", target=" + target +
                ", location=" + location +
                ", loaded=" + loaded +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Dot getTarget() {
        return target;
    }

    public void setTarget(Dot target) {
        this.target = target;
    }

    public Dot getLocation() {
        return location;
    }

    public void setLocation(Dot location) {
        this.location = location;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }
}
