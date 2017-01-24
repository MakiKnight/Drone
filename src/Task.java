/**
 * Created by makiknight on 24/01/17.
 */
public class Task {


    private final TaskTypes type;
    private Dot location;
    private Drone drone;

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
