package Thread;

import environnement.Maillon;
import vehicule.Vehicule;

/**
 * Created by philprat on 23/10/2014.
 */
public class ThreadVehicule extends Thread {

    private Vehicule vehicule;



    public ThreadVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;


    }

    public void run()
    {
        while(!isInterrupted())
        {
            Maillon maillonSuivant = vehicule.getPositionSuivante();
            vehicule.avancer(maillonSuivant);

            try {
                sleep(100);
            } catch (Exception e) {
                System.out.println(e+"programme interrompu");
            }
        }
    }
}
