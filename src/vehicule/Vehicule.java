package vehicule;

import environnement.Maillon;
import environnement.Route;

/**
 * Created by clément on 13/10/2014.
 */
public class Vehicule {
    private Route route;
    private Maillon position;

    public Vehicule(Route route) {
        this.route = route;
        position = route.getMallionAleatoire();
        position.voitureIn();
    }

    public void avancer() {
        position.voitureOut();
        if(route.estDernierMaillon(position)) {
            route = route.getCarrefour().getRouteAleatoire();
            position = route.getPremierMallion();
        } else {
            position = route.getNextMaillon(position);
        }
        position.voitureIn();
    }
}
