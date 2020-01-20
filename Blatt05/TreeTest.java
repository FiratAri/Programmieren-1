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
        int eingabe;                                                             //Eingabezwischenspeicher
        int c;                                                                   //Eingabezwischenspeicher
        int [] numbers = {4,3,1,13,14,16};                                       //Werte im Baum
        /**
        *Wahl der Klasse die getestet werden soll
        */
        while (true) {
            System.out.print ("Soll Tree[1] oder IntSet[2] getestet werden?: ");
            c = sc.nextInt();
            if (c == 1 || c == 2) {
                break;
            } else {
                System.out.println ("Ungültige Eingabe");
            }
        }
        /**
        *Test für die Tree Klasse
        */
        if (c == 1) {
            String text1 = "";
            for (int a = 0; a < numbers.length; a++) {
                t.insert(numbers[a]);                                                //Werte werden in Baum eingesetzt
            }        
            System.out.println (t);
            for (int g = 0; g < 20; g++) {
                text1 += "_";                                                        //Für mehr Übersichtlichkeit
            }
            text1 += "\n";
            text1 += "1=[insert und drucken] || 2=[isDegenerate]" + "\n";
            text1 += "3=[exists] || 4=[min]" + "\n" + "5=[max] || 6=[heigth]" + "\n";
            text1 += "7=[Beenden] || 8=[SindAlleWerte < 20 ?]" + "\n" + "Eingabe: ";
            while(true) {
                System.out.print (text1);
                switch (sc.nextInt()) {
                    case 1:
                        System.out.print ("Einzusetzender Wert: ");
                        int a = sc.nextInt();
                        System.out.print ("Iterativ(1) oder rekursiv(2): ");
                        int b = sc.nextInt();
                        if (b == 1) {
                            t.insertIterative(a);
                        } else if (b == 2) {
                            t.insert(a);
                        } else {
                            System.out.println ("Falsche Eingabe");
                            break;
                        }
                        System.out.println ("*** " + t + " ***");
                        break;
                    case 2:
                        System.out.print ("***Baum ist ");
                        if (t.isDegenerate()) {
                            System.out.println ("entartet***");
                        } else {
                            System.out.println ("nicht entartet***");
                        }
                        break;
                    case 3:
                        System.out.print ("***Zu Suchende Nummer: ");
                        if (t.exists(sc.nextInt())) {
                            System.out.println ("Nummer existiert im Baum***");
                        } else {
                            System.out.println ("Nummer existiert nicht im Baum***");
                        }
                        break;
                    case 4:
                        System.out.println ("***Kleinste Zahl ist " + t.min() + "***");
                        break;
                    case 5:
                        System.out.println ("***Größte Zahl ist " + t.max() + "***");
                        break;
                    case 6:
                        System.out.println ("***Höhe ist " + t.heigth() + "***");
                        break;
                    case 7:
                        System.exit(0);
                    case 8:
                        if (t.forAll ((v) -> v < 20)) {
                            System.out.println ("***Alle Werte sind kleiner als 20***");
                            break;
                        } else {
                            System.out.println ("***Nicht alle Werte sind kleiner als 20***");
                            break;
                        }
                    default:
                        System.out.println ("Falsche Eingabe");
                }
            }
        }
        /**
        *Test für die IntSet Klasse
        */
        if (c == 2) {
            String text2 = "";
            int d;                                                                               //Zahlenzwischenspeicher
            int f;                                                                               //Mengenauswahl
            IntSet set1 = new IntSet();
            IntSet set2 = null;
            text2 += "Es gibt zwei Mengen. Menge 1 und Menge 2. Menge 1 ist leer und Menge 2 ";
            text2 += "ist noch nicht erschaffen" + "\n" + "Mögliche Aktionen:" + "\n";
            System.out.print (text2);
            text2 = "";
            for (int g = 0; g < 20; g++) {
                text2 += "_";                                                        //Für mehr Übersichtlichkeit
            }
            text2 += "\n";
            text2 += "1=[Menge 2 erschaffen] || 2=[insert]" + "\n";
            text2 += "3=[contains] || 4=[union]" + "\n";
            text2 += "5=[intersection] || 6=[equals]" + "\n";
            text2 += "7=[drucken] || 8=[Beenden]" + "\n" + "Aktion: ";
            while (true) {
                System.out.print (text2);
                switch(sc.nextInt()) {
                    /**
                    *Menge 2 setzen
                    */
                    case 1:
                        while (true) {                                                           //Menge 2 leer oder nicht
                            System.out.print ("1=[Leerer Menge] || 2=[vorgegebene Menge]: ");
                            d = sc.nextInt();
                            if (d == 1 || d == 2) {
                                break;
                            }
                        }
                        if (d == 1) {                                                           //Menge 2 leer
                            set2 = new IntSet();
                            System.out.println ("Menge 2 wurde (neu) leer erschaffen");
                        } else {                                                                //Menge 2 nicht leer
                            do {                                                                //Eingabe mit Fehlerbehandlung
                                System.out.print ("Bitte Größe der Menge eingeben: ");
                                d = sc.nextInt();
                                if (d < 1) {
                                    System.out.println ("Falsche Eingabe");
                                }
                            } while (d < 1);
                            int [] set = new int [d];
                            for (int a = 0; a < d; a++) {
                                System.out.print ("Zahl Nr." + (a + 1) + " : ");
                                set [a] = sc.nextInt();                                         //Zahlen werden in Array verpackt
                            }
                            set2 = new IntSet (set);
                            System.out.println ("Menge zwei wurde (neu) nicht leer erschaffen");
                        }
                        break;
                    case 2:
                        do {
                            System.out.print ("Einzufügende Zahl: ");
                            d = sc.nextInt();
                            if (d < 0) {
                                System.out.println ("Falsche Eingabe:");
                            }
                        } while (d < 0);
                        do {
                            System.out.print ("1=[Menge 1] || 2=[Menge 2]: ");
                            f = sc.nextInt();
                            if (f != 1 && f != 2) {
                                System.out.println ("Falsche Eingabe");
                            }
                        } while (f != 1 && f != 2);
                        if (f == 1) {
                            set1.insert(d);
                            System.out.println ("Zahl wurde eingesetzt.");
                        } else if (set2 == null) {
                            System.out.println ("Menge 2 wurde noch nicht erschaffen");
                        } else {
                            set2.insert(d);
                            System.out.println ("Zahl wurde eingesetzt.");
                        }
                        break;
                    case 3:
                        do {
                            System.out.print ("Zu suchende Zahl: ");
                            d = sc.nextInt();
                            if (d < 0) {
                                System.out.println ("Falsche Eingabe:");
                            }
                        } while (d < 0);
                        do {
                            System.out.print ("1=[Menge 1] || 2=[Menge 2]: ");
                            f = sc.nextInt();
                            if (f != 1 && f != 2) {
                                System.out.println ("Falsche Eingabe");
                            }
                        } while (f != 1 && f != 2);
                        if (f == 1) {
                            if (set1.contains(d)) {
                                System.out.println ("Menge 1 enthält diese Zahl");
                            } else {
                                System.out.println ("Menge 1 enthält diese Zahl nicht");
                            }
                        } else if (set2 == null) {
                            System.out.println ("Menge 2 wurde noch nicht erschaffen");
                        } else {
                            if (set2.contains(d)) {
                                System.out.println ("Menge 2 enthält diese Zahl");
                            } else {
                                System.out.println ("Menge 2 enthält diese Zahl nicht");
                            }
                        }
                        break;
                    case 4:
                        if (set2 == null) {
                            System.out.println ("Menge 2 wurde noch nicht erschaffen");
                            break;
                        }
                        set1 = set1.union(set2);
                        System.out.print ("Menge 1 ist nun die Vereinigung von Menge 2");
                        System.out.println (" und der alten Menge 1");
                        break;
                    case 5:
                        if (set2 == null) {
                            System.out.println ("Menge 2 wurde noch nicht erschaffen");
                            break;
                        }
                        set1 = set1.intersection(set2);
                        System.out.print ("Menge 1 ist nun der Schnitt von Menge 2");
                        System.out.println (" und der alten Menge 1");
                        break;
                    case 6:
                        if (set2 == null) {
                            System.out.println ("Menge 2 wurde noch nicht erschaffen");
                            break;
                        }
                        if (set1.equals(set2)) {
                            System.out.println ("Menge 1 und Menge 2 sind identisch");
                        } else {
                            System.out.println ("Menge 1 und Menge 2 sind unterschiedlich");
                        }
                        break;
                    case 7:
                        do {
                            System.out.print ("Zu druckende Menge: ");
                            f = sc.nextInt();
                            if (f != 1 && f != 2) {
                                System.out.println ("Ungültige Eingabe");
                            }
                        } while (f != 1 && f != 2);
                        if (f == 1) {
                            System.out.println ("Menge 1 wird streng monoton steigend gedruckt");
                            System.out.print (set1);
                        } else if (set2 == null) {
                            System.out.println ("Menge 2 wurde noch nicht erschaffen");
                        } else {
                            System.out.println ("Menge 2 wird streng monoton steigend gedruckt");
                            System.out.print (set2);
                        }
                        break;
                    case 8:
                        System.exit(0);
                }
            }
        }
    }
}
