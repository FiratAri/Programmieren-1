// Übung 4.6.1
import java.util.Scanner;  
public class RechnerTest {
    public static void main (String[] args) {
        Scanner eingabe=new Scanner(System.in);
        int a=1;

        System.out.println ("___Rechner___");
        System.out.println ("Format: [Zahl1] [Rechenoperation] [Zahl2]");
        System.out.println ("_Steuerung_"+"\n"+"1 entspricht +"+"\n"+"2 entspricht -"+"\n"+"3 entspricht *"+"\n"+"4 entspricht /");
        System.out.println ("0 zum Schließen des Rechners");
        while (a!=0) {
            System.out.print ("Steuerung: ");
            a=eingabe.nextInt();
            if (a==1) {
                System.out.println ("Rechenoperation: +");
            }
            if (a==2) {
                System.out.println ("Rechenoperation: -");
            }
            if (a==3) {
                System.out.println ("Rechenoperation: *");
            }
            if (a==4) {
                System.out.println ("Rechenoperation: /");
            }
            if (a!=0) {
                System.out.print ("Zahl1: ");
                int c=eingabe.nextInt();
                System.out.print ("Zahl2: ");
                int b=eingabe.nextInt();
                Rechner R1=new Rechner(c,b);
                System.out.print ("Ergebnis: ");
                if (a==1) {
                    System.out.println (R1.Add());
                }
                if (a==2) {
                    System.out.println (R1.Subtract());
                }
                if (a==3) {
                    System.out.println (R1.Multiply());
                }
                if (a==4) {
                    if (b!=0) {
                        System.out.println (R1.Divide());
                    } else {
                        System.out.println ("Durch 0 teilen mathematisch nicht definiert");
                    } 
                }
            }
        }
    }
}
