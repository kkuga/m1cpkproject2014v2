package environnement;

import Thread.*;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by kukugath on 09/10/2014.
 */
public class Route {

    private LinkedList<Maillon> maillons;
    private int longueur;
    private Carrefour carrefour;
    private String nom;
    private Signalisation signalisation;

    public Route(int longueur, Direction direction, String nom, Signalisation signalisation) {
        Direction direction1 = direction;
        this.signalisation = signalisation;
        this.longueur = longueur;
        this.maillons = new LinkedList();
        for(int i=0;i<this.longueur;i++) {
            this.maillons.add(new Maillon(this));
        }

        this.nom = nom;

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

    public boolean estDernierMaillon(Maillon maillon)
    {
        return maillons.getLast() == maillon;
    }

    public Maillon getDernierMaillon()
    {
        return maillons.getLast();
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

    public int numeroMaillon(Maillon maillon)
    {
       return maillons.indexOf(maillon);
    }

    @Override
    public String toString() {
        return "\t Route{" +
                "nom='" + nom + '\'' +
                '}';
    }

    public Feux getCouleurSignalisation()
    {
        return signalisation.getCouleur();
    }

    public Signalisation getSignalisation() {
        return signalisation;
    }
}
