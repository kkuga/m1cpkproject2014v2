package environnement;

/**
 * Created by philprat on 09/10/2014.
 */
public class Maillon {

    private boolean isEmpty;
    private Route route;

    public Maillon(Route route)
    {
        this.route = route;
        isEmpty = true;
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
            /*QUand les deux voitures sont à 9 en position et que le feux est rouge, aucune voiture ne repart */

            while(route.getCouleurSignalisation() == Feux.rouge)/*probleme2!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
            {

            }
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