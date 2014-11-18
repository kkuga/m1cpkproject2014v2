package Thread;

import environnement.Feux;

/**
 * Created by kuga on 12/11/2014.
 */
public class Signalisation extends Thread{
    private Feux couleur;


    public Signalisation() {
        this.couleur = Feux.vert;

    }

  public void setCouleur()
  {
      if(this.couleur == Feux.rouge)
      {
          this.couleur = Feux.vert;
      }
      else
      {
          this.couleur = Feux.rouge;
      }
  }

  public void run()
  {
        while(!isInterrupted())
        {
            this.setCouleur();
            System.out.println(this.toString());
            try {
                sleep(7000);
            } catch (Exception e) {
                System.out.println(e+"programme interrompu");
            }
        }
  }

    @Override
    public String toString() {
        return "Signalisation{" +
                "couleur=" + couleur +
                '}';
    }

    public Feux getCouleur() {
        return couleur;
    }
}
