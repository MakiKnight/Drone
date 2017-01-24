import java.util.ArrayList;

/**
 * Created by makiknight on 24/01/17.
 */
public class Base {

    private ArrayList<Drone> listDrone;
    private ArrayList<Packet> listPacket;
    private ArrayList<Packet> dropedPacket;

    public Base(ArrayList<Drone> listDrone, ArrayList<Packet> listPacket) {
        this.listDrone = listDrone;
        this.listPacket = listPacket;
        dropedPacket = new ArrayList<Packet>();
    }

    public ArrayList<Drone> getListDrone() {
        return listDrone;
    }

    public void setListDrone(ArrayList<Drone> listDrone) {
        this.listDrone = listDrone;
    }

    public ArrayList<Packet> getListPacket() {
        return listPacket;
    }

    public void setListPacket(ArrayList<Packet> listPacket) {
        this.listPacket = listPacket;
    }

    public ArrayList<Packet> getDropedPacket() {
        return dropedPacket;
    }

    public void setDropedPacket(ArrayList<Packet> dropedPacket) {
        this.dropedPacket = dropedPacket;
    }
}
