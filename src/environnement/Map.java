package environnement;
import Thread.*;
import vehicule.Vehicule;

import java.util.Random;
import java.util.Scanner;


/**
 * Created by philprat on 09/10/2014.
 */

/*
*             Circuit représenté:
*
*           c0 → r1 → c1 → r2 → c2
*           ↑           ↑          ↓
*           r7         r5         r3
*           ↑           ↑          ↓
*           c5 ← r6 ← c4 ← r4 ← c3
*
*/

public class Map {
    private static int NBROUTES = 7;
    private static int NBCARREFOUR = 6;
    private  static int NBSIGNALISATION = 7;
    private Route[] routes = new Route[NBROUTES];
    private Carrefour[] carrefours = new Carrefour[NBCARREFOUR];
    private Signalisation[] signalisations = new Signalisation[NBSIGNALISATION];

    public Map() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        /*On instancie les signalisations */

        signalisations[0] = new Signalisation();
        signalisations[1] = new Signalisation();
        signalisations[2] = new Signalisation();
        signalisations[3] = new Signalisation();
        signalisations[4] = new Signalisation();
        signalisations[5] = new Signalisation();
        signalisations[6] = new Signalisation();

        //on instancie les routes
        routes[0] = new Route(10, Direction.DROITE, "Route1", signalisations[0]);
        routes[1] = new Route(10, Direction.DROITE, "Route2", signalisations[1]);
        routes[2] = new Route(10, Direction.BAS, "Route3", signalisations[2]);
        routes[3] = new Route(10, Direction.GAUCHE, "Route4", signalisations[3]);
        routes[4] = new Route(10, Direction.HAUT, "Route5", signalisations[4]);
        routes[5] = new Route(10, Direction.GAUCHE, "Route6", signalisations[5]);
        routes[6] = new Route(10, Direction.HAUT, "Route7", signalisations[6]);

        //on instancie les carrefours
        carrefours[0] = new Carrefour(routes[0]);
        carrefours[1] = new Carrefour(routes[1]);
        carrefours[2] = new Carrefour(routes[2]);
        carrefours[3] = new Carrefour(routes[3]);
        carrefours[4] = new Carrefour(routes[4]);
        carrefours[4].addRoute(routes[5]);       // On ajoute une route au c4 puisque c'est un
                                                 //carrefour à 2 directions. (voir représentation)
        carrefours[5] = new Carrefour(routes[6]);

        // On "indique" à chaque route vers quel carrefour elle débouche selon la représentation
        //choisie
        routes[0].setCarrefour(carrefours[1]);
        routes[1].setCarrefour(carrefours[2]);
        routes[2].setCarrefour(carrefours[3]);
        routes[3].setCarrefour(carrefours[4]);
        routes[4].setCarrefour(carrefours[1]);
        routes[5].setCarrefour(carrefours[5]);
        routes[6].setCarrefour(carrefours[0]);

        //On créé les véhicules
        Vehicule vehicule = new Vehicule(this.getMaillonAleatoireFromRouteAleatoire(), "Peugeot");
        Vehicule vehicule2 = new Vehicule(this.getMaillonAleatoireFromRouteAleatoire(), "Citroen");


        ThreadVehicule threadVehicule = new ThreadVehicule(vehicule);
        ThreadVehicule threadVehicule2 = new ThreadVehicule(vehicule2);


        //Lancement des threads
        threadVehicule.start();
        threadVehicule2.start();
        for(int i = 0; i < 7; i++)
        {
            signalisations[i].start();
        }

        sc.next();

        threadVehicule.interrupt();
        threadVehicule2.interrupt();
        for(int i = 0; i < 7; i++)
        {
            signalisations[i].interrupt();
        }

        threadVehicule.join();
        threadVehicule2.join();
        for(int i = 0; i < 7; i++)
        {
            signalisations[i].join();
        }

    }

    public Maillon getMaillonAleatoireFromRouteAleatoire() {
        Random r = new Random();
        return routes[r.nextInt(NBROUTES)].getMallionAleatoire();
    }

    public Route getRouteAleatoire()
    {
        Random r = new Random();
        return routes[r.nextInt(NBROUTES)];
    }
}
