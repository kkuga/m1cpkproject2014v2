package vehicule;

import environnement.Maillon;
import java.lang.String;
import java.util.Random;

/**
 * Created by clément on 13/10/2014.
 */
public class Vehicule {

    private Maillon position;
    private String nom;
    private int vitesse;


    public Vehicule(Maillon position, String nom) {

        this.position = position;
        this.nom = nom;

        Random r = new Random();
        this.vitesse = 500+r.nextInt(2000-500);
    }

    public void avancer(Maillon maillon)
    {

        Maillon tmp = position;
        maillon.ready();

        this.position = maillon;
        tmp.voitureOut();

    }

    public String getNom() {
        return nom;
    }

    public Maillon getPositionSuivante() {
        return position.getMaillon(this.nom);
    }

    @Override
    public String toString() {
        return "Vehicule{" + this.getNom()+
                "\t position=" + position.getNumeroMaillon() +
                "\t" + position.getNumeroRoute()+
                "\t vitesse"+this.vitesse+
                '}';
    }

    public int getVitesse() {
        return vitesse;
    }
}
