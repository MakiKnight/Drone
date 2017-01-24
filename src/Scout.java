/**
 * Created by makiknight on 24/01/17.
 */
public class Scout extends Drone {

    public Scout(Sort sort) {
        super(100, 4, 200, 50, 1, sort, new Task(Task.TaskTypes.MOVE, new Dot(-300 + (int) (Math.random() * 600), -300 + (int) (Math.random() * 600)), null));
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


}
