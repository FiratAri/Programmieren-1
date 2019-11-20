// Übung 4.6.1
import java.util.Scanner;  
public class RechnerTest {
    public static void main (String[] args) {
        Scanner eingabe=new Scanner(System.in);
        int a=1;

        System.out.println ("___Rechner___");
        System.out.println ("_Steuerung_"+"\n"+"1 entspricht +"+"\n"+"2 entspricht -"+"\n"+"3 entspricht *"+"\n"+"4 entspricht /");
        System.out.println ("5 zum Starten des Zinseszinsrechners");
        System.out.println ("0 zum Schließen des Rechners");
        while (a!=0) {
            System.out.print ("Steuerung: ");
            a=eingabe.nextInt();
            //Beginn Rechner
            if (a<5 && a>0) {
                System.out.println ("Format: [Zahl1] [Rechenoperation] [Zahl2]");
                switch (a) {
                case 1: System.out.println ("Rechenoperation: +"); break;
                case 2: System.out.println ("Rechenoperation: -"); break;
                case 3: System.out.println ("Rechenoperation: *"); break;
                case 4: System.out.println ("Rechenoperation: /");
                }
                if (a>0 && a<=4) {
                    System.out.print ("Zahl1: ");
                    int c=eingabe.nextInt();
                    System.out.print ("Zahl2: ");
                    int b=eingabe.nextInt();
                    Rechner R1=new Rechner(c,b);
                    System.out.print ("Ergebnis: ");
                    switch (a) {
                        case 1: System.out.println (R1.Add()); break;
                        case 2: System.out.println (R1.Subtract()); break;
                        case 3: System.out.println (R1.Multiply()); break;
                        case 4: if (b!=0) {
                                    System.out.println (R1.Divide());
                                } else {
                                    System.out.println ("Durch 0 teilen mathematisch nicht definiert");
                                } 
                    }
                }
            } //Ende Rechner
            //Beginn Zinsrechner
            if (a==5) {
                System.out.println ("Format: K*(1+p/100)^n");
                System.out.println ("K=Startkapital;p=Zinssatz in % pro Jahr;n=ganze Jahre");
                System.out.print ("K= ");
                float b=eingabe.nextFloat();
                System.out.print ("p= ");
                float d=eingabe.nextFloat();
                System.out.print ("n= ");
                int c=eingabe.nextInt();
                Zinseszins z=new Zinseszins();
                System.out.println ("Endkapital: "+z.ZinseszinsRechner(d,c,b));
            } //Ende Zinsrechner
            if (a>5) {
                System.out.println ("Ungültige Eingabe");
            }   
        }
    }
}
