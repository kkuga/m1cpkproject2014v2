package Thread;

import environnement.Feux;

import java.util.Random;

/**
 * Created by kuga on 12/11/2014.
 */
public class Signalisation extends Thread{
    private Feux couleur;


    public Signalisation() {

        Random r = new Random();
        int i = r.nextInt();

        if(i%2 == 0)
        {
            this.couleur = Feux.rouge;
        }
        else
        {
            this.couleur = Feux.vert;
        }

    }

  public synchronized void setCouleur()
  {
      if(this.couleur == Feux.rouge)
      {
          this.couleur = Feux.vert;

          notifyAll();
      }
      else
      {
          this.couleur = Feux.rouge;
      }
  }

  public synchronized void feuxVert(String nomVoiture, String numeroRoute)
  {
      while(this.getCouleur() == Feux.rouge)
      {
          System.out.println("Feux rouge sur la route : "+numeroRoute+"\tla voiture : "+nomVoiture+" \t ne peux pas avancer");
          try{
              wait();
          }catch(InterruptedException e)
          {
              System.out.println(e);
          }
      }
      System.out.println("Feux vert sur la route : "+numeroRoute+"\tla voiture : "+nomVoiture+"\t peux avancer");
  }

  public void run()
  {
        while(!isInterrupted())
        {
            this.setCouleur();

            try {
                sleep(7000);
            } catch (Exception e) {
                System.out.println(e+"programme interrompue ");
            }
        }
  }

    @Override
    public String toString() {
        return "Signalisation{"+
                "Feu rouge la voiture ne peut pas avancer"+
                '}';
    }

    public Feux getCouleur() {
        return couleur;
    }
}
