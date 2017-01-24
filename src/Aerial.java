/**
 * Created by makiknight on 24/01/17.
 */
public class Aerial extends Sort {

    private boolean inFlight;

    public Aerial() {
        super(2.0, 1.50, 0.50, 0.50);
        this.inFlight = false;
    }

    public void toLand() {
        //Check if the aerial drone is really in flight
        if (inFlight) {
            inFlight = false;
        }
    }

    public void toFlyOff() {
        //Check if the aerial drone is really on the ground
        if (!inFlight) {
            inFlight = true;
        }
    }
}
