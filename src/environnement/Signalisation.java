package environnement;

/**
 * Created by kuga on 12/11/2014.
 */
public class Signalisation {
    private Feux feuxGD;
    private Feux feuxHB;

    public Signalisation(Feux feuxGD, Feux feuxHB) {
        this.feuxGD = Feux.vert;
        this.feuxHB = Feux.rouge;
    }
}
