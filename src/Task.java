/**
 * Created by makiknight on 24/01/17.
 */
public class Task {

    private int kind;
    private Dot location;
    private Drone drone;

    public final static int RECHARGE_DRONE = 1;
    public final static int RECHARGE_BASE = 2;
    public final static int LADE = 3;
    public final static int DUMP = 4;
    public final static int  MOVE = 5;

    /**
     * @param kind      : 1 = recharge a Drone
     *                    2 = recharge at the base
     *                    3 = lade a packet
     *                    4 = dump a packet
     *                    5 = move somewhere
     * @param location  : where the task need to be execute
     */
    public Task(int kind, Dot location, Drone drone) {
        this.kind = kind;
        this.location = location;
        this.drone = drone;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public Dot getLocation() {
        return location;
    }

    public void setLocation(Dot location) {
        this.location = location;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }
}
