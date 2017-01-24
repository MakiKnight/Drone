/**
 * Created by makiknight on 24/01/17.
 */
public class Task {

    public final static int RECHARGE_DRONE = 1;
    public final static int RECHARGE_BASE = 2;
    public final static int LADE = 3;
    public final static int DUMP = 4;
    public final static int MOVE = 5;
    private final TaskTypes type;
    private Dot location;
    private Drone drone;
    /**
     * @param type     : 1 = recharge a Drone
     *                 2 = recharge at the base
     *                 3 = lade a packet
     *                 4 = dump a packet
     *                 5 = move somewhere
     * @param location : where the task need to be execute
     */
    public Task(TaskTypes type, Dot location, Drone drone) {
        this.type = type;
        this.location = location;
        this.drone = drone;
    }

    public TaskTypes getType() {
        return type;
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

    public enum TaskTypes {
        RECHARGE_DRONE,
        RECHARGE_BASE,
        LADE,
        DUMP,
        MOVE
    }
}
