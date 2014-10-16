import javafx.scene.control.Tab;

/**
 * Created by philprat on 09/10/2014.
 */
public class Main {

    public static void main(String[] args) {

        int A[][] = new int [100][50];
        int B[][] = new int [100][50];
        System.out.println("teetest");
        Tableau a = new Tableau(A);
        Tableau b = new Tableau(B);

        a.initialisationPassage();
        b.initialisationLongueurRoute();

        Map map = new Map(A, B);



    }
}
