
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by clément on 13/10/2014.
 */
public class Carrefour {

    private List<Route> routesSortantes;

    public Carrefour(int nbRoutesSortantes) {
        routesSortantes = new ArrayList<Route>(nbRoutesSortantes);

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
