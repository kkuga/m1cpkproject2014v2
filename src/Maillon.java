/**
 * Created by philprat on 09/10/2014.
 */
public class Maillon {

    private boolean isEmpty;

    public Maillon() {
        isEmpty = true;
    }

    public void voitureIn() {
        isEmpty = false;
    }

    public void voitureOut() {
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
