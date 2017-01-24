import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by makiknight on 24/01/17.
 */
public class main {

    public static void main(String[] args){
        Scout scout1 = new Scout(new Aerial());
        //System.out.println(scout1.toString());

        scout1.setTarget(new Dot(456,-47));
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
        }
    }
}
