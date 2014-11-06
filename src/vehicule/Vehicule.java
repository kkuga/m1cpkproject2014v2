package vehicule;

import environnement.Maillon;

/**
 * Created by clément on 13/10/2014.
 */
public class Vehicule {

    private Maillon position;


    public Vehicule(Maillon position) {

        this.position = position;
    }

    public void avancer(Maillon maillon)
    {

        Maillon tmp = position;
        maillon.ready();

        this.position = maillon;
        tmp.voitureOut();

    }

    public Maillon getPositionSuivante() {
        return position.getMaillon();
    }

}
