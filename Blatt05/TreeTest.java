/**
*Lösung der Pflichtaufgabe 5
*
*@author Firat Ari
*@version 1.0
*/
import java.util.Scanner;
public class TreeTest {
    public static void main (String[] args) {
        Tree t = new Tree(7);
        Scanner sc = new Scanner(System.in);
        int eingabe;
        String text;
        int [] numbers = {4,3,1};

        for (int a = 0; a < numbers.length; a++) {
            t.insert(numbers[a]);
        }
        System.out.println (t);
        text = "Aktion (1: insert und drucken;2: isDegenerate;";
        text += "3: exists;4: min;5: max;6: heigth;7: Beenden): ";
        while(true) {
            System.out.print (text);
            switch (sc.nextInt()) {
                case 1:
                System.out.print ("Einzusetzender Wert: ");
                t.insert(sc.nextInt());
                System.out.println (t);
                break;
                case 2:
                System.out.print ("Baum ist ");
                if (t.isDegenerate()) {
                    System.out.println ("entartet");
                } else {
                    System.out.println ("nicht entartet");
                }
                break;
                case 3:
                System.out.print ("Zu Suchende Nummer: ");
                if (t.exists(sc.nextInt())) {
                    System.out.println ("Nummer existiert im Baum");
                } else {
                    System.out.println ("Nummer existiert nicht im Baum");
                }
                break;
                case 4:
                System.out.println ("Kleinste Zahl ist " + t.min());
                break;
                case 5:
                System.out.println ("Größte Zahl ist " + t.max());
                break;
                case 6:
                System.out.println ("Höhe ist " + t.heigth());
                break;
                case 7:
                System.exit(0);
                default:
                System.out.println ("Falsche Eingabe");
            }
        }
    }
}
