

/**
 * Created by philprat on 09/10/2014.
 */
public class Tableau {

    private int tab[][];

    public Tableau(int[][] tab) {
        this.tab = tab;
    }

    public void initialisationPassage()
    {
        int longueur = this.tab.length;
        int largeur = this.tab[0].length;

        for(int i = 0; i < longueur; i++)
        {
            for(int j = 0; j < largeur; j++)
            {
                tab[i][j] = (int) (Math.random()*(2-0));
            }
        }

    }

    public void initialisationLongueurRoute()
    {
        int longueur = this.tab.length;
        int largeur = this.tab[0].length;

        for(int i = 0; i < longueur; i++)
            for (int j = 0; j < largeur; j++)
            {
                tab[i][j] = (int) (Math.random() * (10 - 1)+1);
            }

    }



}
