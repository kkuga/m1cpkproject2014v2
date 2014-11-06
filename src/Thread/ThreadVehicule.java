package Thread;

import environnement.Maillon;
import vehicule.Vehicule;

/**
 * Created by philprat on 23/10/2014.
 */
public class ThreadVehicule extends Thread {

    private Vehicule vehicule;
    private Maillon maillonSuivant;


    public ThreadVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
        this.maillonSuivant = this.vehicule.getPositionSuivante();

    }

    public void run()
    {
        while(!isInterrupted())
        {
            synchronized (this.maillonSuivant) {

                this.maillonSuivant.ready();

            }

            vehicule.avancer(this.maillonSuivant);
            try {
                sleep(100);
            } catch (Exception e) {
                System.out.println("programme interrompu");
                System.out.println(e);
            }
        }
    }
}
