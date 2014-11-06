package vehicule;

import environnement.Maillon;

/**
 * Created by clément on 13/10/2014.
 */
public class Vehicule {

    private Maillon position;
    private Maillon positionSuivante;

    public Vehicule(Maillon position) {

        this.position = position;
        this.positionSuivante = position.getMaillon();
    }

    public synchronized void avancer(Maillon maillon)
    {
        while(!positionSuivante.isEmpty())
        {
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Maillon tmp = position;

        this.position = maillon;
        this.positionSuivante.voitureIn();

        tmp.voitureOut();

        notifyAll();

    }

    public Maillon getPositionSuivante() {
        return position.getMaillon();
    }
}
