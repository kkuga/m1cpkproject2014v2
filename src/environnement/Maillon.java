package environnement;

import Thread.*;

/**
 * Created by philprat on 09/10/2014.
 */
public class Maillon {

    private boolean isEmpty;
    private Route route;
    private Signalisation signalisation;

    public Maillon(Route route)
    {
        this.route = route;
        isEmpty = true;
        signalisation = this.route.getSignalisation();
    }

    public void voitureIn() {
        isEmpty = false;
    }

    public synchronized void voitureOut()
    {
        isEmpty = true;

        notifyAll();
    }

    public synchronized void ready()
    {
        while(!isEmpty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
        voitureIn();
    }

    public Route getRoute() {
        return route;
    }

    public Maillon getMaillon() {

        if(getRoute().estDernierMaillon(this))
        {
            signalisation.feuxVert();

            return route.getCarrefour().getRouteAleatoire().getPremierMallion();
        } else {
            return route.getNextMaillon(this);
        }
    }



    public int getNumeroMaillon()
    {
        return route.numeroMaillon(this);
    }

    public String getNumeroRoute()
    {
        return route.toString();
    }
}