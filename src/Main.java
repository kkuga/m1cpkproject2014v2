import Thread.ThreadVehicule;
import environnement.Map;
import exception.VehiculeException;
import vehicule.Vehicule;

import java.util.Scanner;

/**
 * Created by philprat on 09/10/2014.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        Map map = new Map();

        Vehicule vehicule = new Vehicule(map.getMaillonAleatoireFromRouteAleatoire());

        ThreadVehicule threadVehicule = new ThreadVehicule(vehicule);

        threadVehicule.start();

        sc.next();

        threadVehicule.interrupt();
        threadVehicule.join();

    }
}
