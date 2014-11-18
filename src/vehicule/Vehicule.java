package vehicule;

import environnement.Maillon;
import java.lang.String;

/**
 * Created by clément on 13/10/2014.
 */
public class Vehicule {

    private Maillon position;
    private String nom;


    public Vehicule(Maillon position, String nom) {

        this.position = position;
        this.nom = nom;
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

    public  Maillon getPositionSuivante() {
        return position.getMaillon();
    }

    @Override
    public String toString() {
        return "Vehicule{" + this.getNom()+
                "\t position=" + position.getNumeroMaillon() +
                "\t" + position.getNumeroRoute()+
                '}';
    }
}
