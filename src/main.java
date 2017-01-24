import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.util.ArrayList;

/**
 * Created by makiknight on 24/01/17.
 */
public class main {



    public static void main(String[] args){


        Scout scout1 = new Scout(new Aerial());
        Carrier carrier1 = new Carrier();

        Packet packet1 = new Packet(60.0, new Dot(10,-8));

        /*scout1.setTarget(new Dot(456,-47));
        while(scout1.getBattery()>1 && !scout1.getLocation().equals(scout1.getTarget())) {
            System.out.println("* * * * * * * * * * * * * * * * * * *");
            System.out.println("Location : "+ scout1.getLocation().toString());
            System.out.println("Target   : "+ scout1.getTarget().toString());
            System.out.println("Forecast energy : "+ scout1.getLocation().forecastEnergy(scout1.getTarget()));
            System.out.println("Battery : "+scout1.getBattery()+"/"+scout1.getBatteryMax());
            System.out.println("");
            scout1.toTravel(scout1.getTarget());
            System.out.println("* * * * * * * * * * * * * * * * * * *");
            System.out.println("Location : "+ scout1.getLocation().toString());
            System.out.println("Target   : "+ scout1.getTarget().toString());
            System.out.println("Forecast energy : "+ scout1.getLocation().forecastEnergy(scout1.getTarget()));
            System.out.println("Battery : "+scout1.getBattery()+"/"+scout1.getBatteryMax());
            System.out.println("");
        }*/

        ArrayList<Drone> listDrone = new ArrayList<Drone>();
        listDrone.add(carrier1);
       // listDrone.add(scout1);
        ArrayList<Packet> listPacket = new ArrayList<Packet>();
        listPacket.add(packet1);

       Base base = new Base(listDrone,listPacket);
       /* for(Drone drone : base.getListDrone()) {
            drone.toLade(base);
        }*/

       /* while(true) {
            for(Drone drone: listDrone){
                drone.toDo(drone.getTarget());
                System.out.println("* * * * * * * * * * * * * * * * * * *");
                System.out.println("Location : "+ drone.getLocation().toString());
                System.out.println("Target   : "+ drone.getTarget().toString());
                System.out.println("Forecast energy : "+ drone.getLocation().forecastEnergy(drone.getTarget()));
                System.out.println("Battery : "+drone.getBattery()+"/"+drone.getBatteryMax());
                System.out.println("");
            }
        }*/

        System.out.println("* * * * * * * * * * * * * * * * * * *");
        System.out.println("Location : "+  carrier1.getLocation().toString());
        System.out.println("Target   : "+  carrier1.getTarget().toString());
        System.out.println("Forecast energy : "+  carrier1.getLocation().forecastEnergy( carrier1.getTarget()));
        System.out.println("Battery : "+ carrier1.getBattery()+"/"+ carrier1.getBatteryMax());
        System.out.println("Weight Max "+ carrier1.getWeightCapacity());
        System.out.println("");
       carrier1.toLade(base);
        System.out.println(carrier1.getWeight());

    }
}
