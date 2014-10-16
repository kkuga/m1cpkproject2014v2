/**
 * Created by philprat on 09/10/2014.
 */

public class Map {


    private Route[] routes;
    private Carrefour[] carrefours;

    public Map()
    {
        //on instancie les routes

        for(int i = 1; i <= 7; i++)
        {
            Route route = new Route(10);
            routes[i] = route;
        }

        //on instancie les carrefours
        for(int i = 1; i <= 5; i++)
        {
            Carrefour carrefour = new Carrefour(1);
            carrefours[i] = carrefour;
        }

        Carrefour carrefour = new Carrefour(2);
        carrefours[6] = carrefour;


        //on alloue les carrefours aux routes
        for(int i = 1; i <= 4; i++)
        {
            routes[i].setCarrefour(carrefours[i]);
        }

        routes[5].setCarrefour(carrefours[6]);
        routes[6].setCarrefour(carrefours[5]);

        //on précise les routes suivant en fonction du carrefour

        for(int i = 1; 1 <= 4; i++)
        {
            carrefours[i].addRoute(routes[i+1]);
        }

        carrefours[5].addRoute(routes[1]);


    }

}
