/**
 * Created by philprat on 09/10/2014.
 */

import java.util.Arrays;
import   java.util.LinkedList;

public class Map {

    public Route[][] routes;


    public Map(int [][]Passage, int LongeurRoute[][])
    {
        int longueur = Passage.length;
        int largeur = Passage[0].length;

        routes = new Route[longueur][largeur];

        for(int i = 0; i < longueur; i++)
        {
            for(int j = 0; j < largeur; j++)
                if (Passage[i][j] != 0) {
                    Route route = new Route(i, j, LongeurRoute[i][j]);
                    routes[i][j] = route;
                }
        }
    }

    @Override
    public String toString() {
        return "Map{" +
                "routes=" + Arrays.toString(routes) +
                '}';
    }
}
