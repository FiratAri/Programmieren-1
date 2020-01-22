/**
*Lösung der Pflichtaufgabe 5
*
*@author Firat Ari
*@version 1.0
*/
import java.util.Scanner;
public class TreeTest {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);                                        //Spielereingabe
        int eingabe;                                                                //Eingabezwischenspeicher
        int c;                                                                      //Eingabezwischenspeicher
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
            /**
            *Baum und Eingabetext werden erschaffen
            */
            String text1 = "";
            Tree t = new Tree(7);                                                    //Baum mit Wurzelknoten 7
            int [] numbers = {4,3,1,13,14,16};                                       //Werte im Baum
            for (int a = 0; a < numbers.length; a++) {                               //Schleife für das Einsetzen der Werte
                try {
                    t.insert(numbers[a]);                                            //Werte werden in Baum eingesetzt
                } catch (Exception e) {                                              //Fehlerbehandlung
                    if (e instanceof ValueAlreadyPresentException) {                 //Wert existiert bereits im Baum,
                                                                                     //also nichts machen
                    } else {
                        System.out.println ("Unbekannter Fehler");
                    }
                }
            }        
            System.out.println (t);                                                  //Baum wird gedruckt
            for (int g = 0; g < 20; g++) {
                text1 += "_";                                                        //Für mehr Übersichtlichkeit
            }
            text1 += "\n";                                                           //Eingabetext
            text1 += "1=[insert und drucken] || 2=[isDegenerate]" + "\n";            //Eingabetext
            text1 += "3=[exists] || 4=[min]" + "\n" + "5=[max] || 6=[heigth]" + "\n";//Eingabetext
            text1 += "7=[Beenden] || 8=[SindAlleWerte < 20 ?]" + "\n" + "Eingabe: "; //Eingabetext
            while(true) {
                System.out.print (text1);                                            //Eingabetext wird gedruckt
                switch (sc.nextInt()) {
                    /**
                    *Insert und toString Methoden Test
                    */
                    case 1:
                        System.out.print ("Einzusetzender Wert: ");
                        int a = sc.nextInt();
                        System.out.print ("Iterativ(1) oder rekursiv(2): ");
                        int b = sc.nextInt();
                        if (b == 1) {
                            t.insertIterative(a);
                        } else if (b == 2) {
                            try {                                                    //Wenn der Wert bereits vorhanden ist,
                                t.insert(a);                                         //wird eine Exception geworfen,
                            } catch (Exception e) {                                  //die hier gefangen wird,
                                if (e instanceof ValueAlreadyPresentException) {
                                    System.out.println ("Wert bereits vorhanden.");  //um die entsprechende Meldung auszugeben
                                } else {
                                    System.out.println ("Unbekannter Fehler");
                                    break;
                                }
                            }
                        } else {                                                     //Fehlerbehandlung bei falscher Eingabe  
                            System.out.println ("Falsche Eingabe");
                            break;
                        }
                        System.out.println ("*** " + t + " ***");
                        break;
                    /**
                    *isDegenerate Methode Test
                    */
                    case 2:
                        System.out.print ("***Baum ist ");
                        if (t.isDegenerate()) {
                            System.out.println ("entartet***");
                        } else {
                            System.out.println ("nicht entartet***");
                        }
                        break;
                    /**
                    *exists Methode Test
                    */
                    case 3:
                        System.out.print ("***Zu Suchende Nummer: ");
                        if (t.exists(sc.nextInt())) {
                            System.out.println ("Nummer existiert im Baum***");
                        } else {
                            System.out.println ("Nummer existiert nicht im Baum***");
                        }
                        break;
                    /**
                    *min Methode Test
                    */
                    case 4:
                        System.out.println ("***Kleinste Zahl ist " + t.min() + "***");
                        break;
                    /**
                    *max Methode Test
                    */
                    case 5:
                        System.out.println ("***Größte Zahl ist " + t.max() + "***");
                        break;
                    /**
                    *height Methode Test
                    */
                    case 6:
                        System.out.println ("***Höhe ist " + t.heigth() + "***");
                        break;
                    /**
                    *Programm beenden
                    */
                    case 7:
                        System.exit(0);
                    /**
                    *forAll Methode Test
                    */
                    case 8:
                        if (t.forAll ((v) -> v < 20)) {                                          //Lambda-Ausdruck
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
                text2 += "_";                                                                    //Für mehr Übersichtlichkeit
            }
            text2 += "\n";
            text2 += "1=[Menge 2 erschaffen/setzen] || 2=[insert]" + "\n";
            text2 += "3=[contains] || 4=[union]" + "\n";
            text2 += "5=[intersection] || 6=[equals]" + "\n";
            text2 += "7=[drucken] || 8=[Beenden]" + "\n" + "Aktion: ";
            while (true) {
                System.out.print (text2);
                switch(sc.nextInt()) {
                    /**
                    *Menge 2 setzen Test
                    */
                    case 1:
                        while (true) {                                                          //Menge 2 leer oder nicht
                            System.out.print ("1=[Leerer Menge] || 2=[vorgegebene Menge]: ");
                            d = sc.nextInt();
                            if (d == 1 || d == 2) {
                                break;
                            }
                        }
                        if (d == 1) {                                                           //Menge 2 leer
                            set2 = new IntSet();
                            System.out.println ("Menge 2 ist nun eine leere Menge");
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
                            System.out.println ("Menge zwei wurde nicht leer erschaffen/gesetzt");
                        }
                        break;
                    /**
                    *insert Methode Test
                    */
                    case 2:
                        System.out.print ("Einzufügende Zahl: ");
                        d = sc.nextInt();
                        do {
                            System.out.print ("1=[Menge 1] || 2=[Menge 2]: ");
                            f = sc.nextInt();
                            if (f != 1 && f != 2) {
                                System.out.println ("Falsche Eingabe");
                            }
                        } while (f != 1 && f != 2);
                        try {                                                                   //Mögliche von insert geworfene
                            if (f == 1) {                                                       //wird gefangen
                                set1.insert(d);
                                System.out.println ("Zahl wurde eingesetzt.");
                            } else if (set2 == null) {
                                System.out.println ("Menge 2 wurde noch nicht erschaffen");
                            } else {
                                set2.insert(d);
                                System.out.println ("Zahl wurde eingesetzt.");
                            }
                        } catch (Exception e) {
                            if (e instanceof ValueAlreadyPresentException) {                    //Wert bereits vorhanden
                                System.out.println ("Der Wert ist bereits vorhanden");
                            } else {                                                            //Andere Exception
                                System.out.println ("Es ist ein unbekannter Fehler aufgetreten");
                            }
                        }
                        break;
                    /**
                    *contains Methode Test
                    */
                    case 3:
                        System.out.print ("Zu suchende Zahl: ");
                        d = sc.nextInt();
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
                    /**
                    *union Methode Test
                    */
                    case 4:
                        try {
                            set1 = set1.union(set2);
                        } catch (Exception e) {                                          
                            if (e instanceof NoSetException) {
                                System.out.println ("Menge 2 wurde noch nicht erschaffen");
                                System.out.println ("Für diese Operation ist Menge 2 die leere Menge");                        
                            } else {
                                System.out.println ("Es ist ein unbekannter Fehler aufgetreten");
                            }
                        }
                        System.out.print ("Menge 1 ist nun die Vereinigung von Menge 2");
                        System.out.println (" und der alten Menge 1");
                        break;
                    /**
                    *intersection Methode Test
                    */
                    case 5:
                        try {
                            set1 = set1.intersection(set2);
                        } catch (Exception e) {
                            if (e instanceof NoSetException) {
                                System.out.println ("Menge 2 wurde noch nicht erschaffen");
                                System.out.println ("Für diese Operation ist Menge 2 die leere Menge");
                            } else {
                                System.out.println ("Es ist ein unbekannter Fehler aufgetreten");
                            }
                        }
                        System.out.print ("Menge 1 ist nun der Schnitt von Menge 2");
                        System.out.println (" und der alten Menge 1");
                        break;
                    /**
                    *equals Methode Test
                    */
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
                    /**
                    *toString Methode Test
                    */
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
                    /**
                    *Programm beenden
                    */
                    case 8:
                        System.exit(0);
                    default:
                        System.out.println ("Falsche Eingabe");
                }
            }
        }
    }
}
