import java.util.LinkedList;
import java.util.Random;

/**
 * Created by kukugath on 09/10/2014.
 */
public class Route {

    private LinkedList<Maillon> maillons;
    private int longueur;
    private Carrefour carrefour;

    public Route(int longueur) {

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
        return "projet1.Route{" +
                "maillons=" + maillons +
                ", longueur=" + longueur +
                '}';
    }

    public boolean estDernierePortion(Maillon maillon)
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
}
