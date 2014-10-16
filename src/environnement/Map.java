package environnement;

import environnement.Carrefour;

/**
 * Created by philprat on 09/10/2014.
 */

/*
*             Circuit représenté:
*
*           c0 → r0 → c1 → r1 → c2
*           ↑           ↑          ↓
*           r6         r4         r2
*           ↑           ↑          ↓
*           c5 ← r5 ← c4 ← r3 ← c3
*
*/

public class Map {
    private static int NBROUTES = 7;
    private static int NBCARREFOUR = 6;
    private Route[] routes;
    private Carrefour[] carrefours;

    public Map() {
        //on instancie les routes
        routes[0] = new Route(10, Direction.DROITE);
        routes[1] = new Route(10, Direction.DROITE);
        routes[2] = new Route(10, Direction.BAS);
        routes[3] = new Route(10, Direction.GAUCHE);
        routes[4] = new Route(10, Direction.HAUT);
        routes[5] = new Route(10, Direction.GAUCHE);
        routes[6] = new Route(10, Direction.HAUT);

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
    }
}