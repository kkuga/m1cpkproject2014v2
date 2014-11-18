package environnement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Thread.*;



public class MaillonTest {

    Maillon m1;
    private Route[] routes = new Route[3];
    private Carrefour[] carrefours = new Carrefour[4];
    private Signalisation signalisation;

    @BeforeTest
    public void create(){
        routes[0] = new Route(1, Direction.DROITE, "Route1", signalisation);
        m1=new Maillon(routes[0]);
        routes[1] = new Route(1, Direction.DROITE, "Route2", signalisation);
        routes[2] = new Route(1, Direction.BAS, "Route3", signalisation);

        carrefours[0] = new Carrefour(routes[0]);
        carrefours[1] = new Carrefour(routes[1]);
        carrefours[2] = new Carrefour(routes[2]);


        routes[0].setCarrefour(carrefours[0]);
        routes[1].setCarrefour(carrefours[1]);
        routes[2].setCarrefour(carrefours[2]);

        carrefours[4].addRoute(routes[5]);
        System.out.println(routes[1].getLongueur());

    }

    //Test si on arrive a la fin de la route
    @Test
    public void testRouteFin(){
      // System.out.println(routes[0].estDernierMaillon(m1));
       Assert.assertEquals(true,routes[0].estDernierMaillon(m1));
    }

    //Tester si la route suivante a une direction Bas
    //à completer
    @Test
    public void testDirection(){
        System.out.println(routes[0].estDernierMaillon(m1));
        Assert.assertEquals(Direction.BAS,routes[2]);
    }



}