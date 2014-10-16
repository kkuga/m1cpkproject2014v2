package environnement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by clément on 13/10/2014.
 */
public class Carrefour {

    private List<Route> routesSortantes;

    public Carrefour(Route route) {
        routesSortantes = new ArrayList<Route>();
        routesSortantes.add(route);
    }

    public Carrefour(ArrayList<Route> routes) {
        routesSortantes = new ArrayList<Route>(routes);
    }

    public Carrefour(List<Route> routesSortantes) {
        this.routesSortantes = routesSortantes;
    }

    public int nbRoutesSortantes() {
        return routesSortantes.size();
    }

    public Route getRouteAleatoire() {
        Random r = new Random();
        return routesSortantes.get(r.nextInt(nbRoutesSortantes()));
    }

    public void addRoute(Route route)
    {
        routesSortantes.add(route);
    }
}
