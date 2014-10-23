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

    public synchronized void avancer(Maillon maillon)
    {
        while(!position.isEmpty())
        {
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Maillon tmp = position;

        this.position = maillon;
        this.position.voitureIn();

        tmp.voitureOut();

        notifyAll();

    }

    public Maillon getPosition() {
        return position;
    }
}
