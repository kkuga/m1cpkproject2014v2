import java.util.LinkedList;

/**
 * Created by kukugath on 09/10/2014.
 */
public class Route {

    private LinkedList<Maillon> maillons;
    private int x;
    private int y;
    private int longueur;

    /*
       Constructeur de la classe projet1.Route
       @param maillons
       @param x
       @param y
       @param longueur
    */
    public Route(int x, int y, int longueur) {
        this.maillons = maillons;
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.maillons = new LinkedList();
        for(int i=0;i<this.longueur;i++) {
        this.maillons.add(new Maillon());
        }
    }

    public LinkedList<Maillon> getMaillons() {
        return maillons;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLongueur() {
        return longueur;
    }

    @Override
    public String toString() {
        return "projet1.Route{" +
                "maillons=" + maillons +
                ", x=" + x +
                ", y=" + y +
                ", longueur=" + longueur +
                '}';
    }

}
