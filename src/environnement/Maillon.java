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

    public void voitureOut() {
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public Route getRoute() {
        return route;
    }

    public Maillon getMaillon() {

        if(getRoute().estDernierMaillon(this)) {
            return route.getCarrefour().getRouteAleatoire().getPremierMallion();
        } else {
            return route.getNextMaillon(this);
        }
    }
}