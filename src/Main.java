import Thread.*;
import environnement.Map;
import vehicule.Vehicule;

import java.util.Scanner;

/**
 * Created by philprat on 09/10/2014.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        Map map = new Map();

        Vehicule vehicule = new Vehicule(map.getMaillonAleatoireFromRouteAleatoire(), "Peugeot");
        Vehicule vehicule2 = new Vehicule(map.getMaillonAleatoireFromRouteAleatoire(), "Citroen");
        Signalisation signalisation = new Signalisation(map.getRouteAleatoire());

        ThreadVehicule threadVehicule = new ThreadVehicule(vehicule);
        ThreadVehicule threadVehicule2 = new ThreadVehicule(vehicule2);


        threadVehicule.start();
        threadVehicule2.start();
        signalisation.start();

        sc.next();

        threadVehicule.interrupt();
        threadVehicule2.interrupt();
        signalisation.isInterrupted();

        threadVehicule.join();
        threadVehicule2.join();
        signalisation.join();
    }
}
