import javafx.scene.control.Tab;

import java.net.SocketPermission;

/**
 * Created by philprat on 09/10/2014.
 */
public class Main {

    public static void main(String[] args) {

        int A[][] = new int [100][50];
        int B[][] = new int [100][50];
        System.out.println("teetest");
        System.out.println("kuga reply");
        System.out.println("test");

        Tableau a = new Tableau(A);
        Tableau b = new Tableau(B);

        a.initialisationPassage();
        b.initialisationLongueurRoute();

        Map map = new Map(A, B);



    }
}
