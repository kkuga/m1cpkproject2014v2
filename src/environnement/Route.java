package environnement;

import environnement.Carrefour;
import environnement.Maillon;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by kukugath on 09/10/2014.
 */
public class Route {

    private LinkedList<Maillon> maillons;
    private int longueur;
    private Carrefour carrefour;
    private Direction direction;

    public Route(int longueur, Direction direction) {
        this.direction = direction;
        this.longueur = longueur;
        this.maillons = new LinkedList();
        for(int i=0;i<this.longueur;i++) {
            this.maillons.add(new Maillon());
        }
    }

    public LinkedList<Maillon> getMaillons() {
        return maillons;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLongueur() {
        return longueur;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean estDernierMaillon(Maillon maillon)
    {
        return maillons.getLast() == maillon;
    }

    public Maillon getPremierMallion()
    {
        return maillons.getFirst();
    }

    //Où la voiture commencera sa route

    public Maillon getMallionAleatoire()
    {
        Random r = new Random();
        return maillons.get(r.nextInt(getLongueur()));
    }

    public Maillon getNextMaillon(Maillon maillon)
    {
        return maillons.get(maillons.indexOf(maillon)+1);
    }

    public void setCarrefour(Carrefour carrefour) {
        this.carrefour = carrefour;
    }

    public Carrefour getCarrefour() {
        return carrefour;
    }
}
