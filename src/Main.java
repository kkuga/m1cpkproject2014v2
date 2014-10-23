import environnement.Map;
import vehicule.Vehicule;
import Thread.ThreadVehicule;

/**
 * Created by philprat on 09/10/2014.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Map map = new Map();
        Vehicule vehicule = new Vehicule(map.getRouteAleatoire());
        ThreadVehicule threadVehicule = new ThreadVehicule(vehicule);

        threadVehicule.start();
        threadVehicule.isInterrupted();
        threadVehicule.join();

    }
}
