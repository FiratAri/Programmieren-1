/**
*Lösung der Pflichtaufgabe 4
*
*@author Firat Ari
*@version 1.0
*
    b b b b
    = = = =
    0 1 2 3 .....
    ________
a=0|1 2 3 4
a=1|5 6 .. ...
a=2|
.
.
.
*/
import java.util.Random;
public class Spielfeld {
    final int groesse;
    final int minenAnzahl;
    final int initialeFelder;
    Zelle [] [] zelle;               //Das Array gibt die Zellenart an jeder Koordinate aus
    Random random = new Random();
    
    public Spielfeld (int groesse, int minenAnzahl, int initialeFelder) {
        this.groesse = groesse;
        this.minenAnzahl = minenAnzahl;
        this.initialeFelder = initialeFelder;
    }
    public void felderSetzen() {
        int c;                                                          //Zufallszahl
        int d = minenAnzahl;                                            //Rechenwert für Zuordnung
        int e = (groesse * groesse) - minenAnzahl - initialeFelder;     //Rechenwert für Zuordnung
        int f = initialeFelder;                                         //Rechenwert für Zuordnung
        boolean nichtZugeordnet = true;                                 //Zuordnungswert
        zelle = new Zelle [groesse] [groesse];                          //Hier wird das Zellenarray gesetzt     
        /**
        *Als nächstes werden den Zellen ihre Koordinaten
        *und ihre Zellenart zugeordnet
        */
        for (int a = 0; a < groesse; a++) {            
            for (int b = 0; b < groesse; b++) {                 
                while (nichtZugeordnet) {                               //Geht solange weiter bis Zellenart zugeordnet wurde
                    c = random.nextInt(4);                              //Drei Zufallszahlen                   
                    if (c == 0 && d > 0) {                              //solange bis alle Minen zugeordnet sind
                        zelle [a] [b] = new Mine (a, b);                //Die Zelle mit Koordinaten a und b ist eine Mine 
                        d--;                                            //nächste Mine
                        nichtZugeordnet = false;
                    }     
                    if (c >= 2 && e > 0) {
                        zelle [a] [b] = new FreiesFeld(a, b);           //Diese Zelle ist ein freies Feld
                        e--;                                            //nächstes Feld                       
                        nichtZugeordnet = false;
                    }
                    if (c == 1 && f > 0) {
                        zelle [a] [b] = new FreiesFeld(a, b); 
                        zelle [a] [b].zelleBetreten();                  //Diese Zelle ist also schon aufgedeckt(betreten)
                        f--;                       
                        nichtZugeordnet = false;
                    }
                }
                nichtZugeordnet = true;
            }
        }
        /**
        *Jetzt wird den freien Feldern ihre Umgebungsminenzahl zugeordnet
        */
        for (int a = (groesse - 1); a >= 0; a--) {
            for (int b = (groesse - 1); b >= 0; b--) {
                /**
                *Wenn dieses Feld eine Mine ist, dann inkrementiere
                *die umgebungsminen von jedem anliegendem Feld
                */
                if (zelle [a] [b] instanceof Mine) {
                    if (a < (groesse - 1)) {
                        zelle [(a + 1)] [b].umgebungsminen++;               //inkrementiere umgebungsmine der darunterliegenden Zelle
                        if (b < (groesse - 1)) {
                            zelle [(a + 1)] [(b + 1)].umgebungsminen++;     //inkrementiere umgebungsmine von Zelle unten rechts
                        }
                        if (b > 0) {
                            zelle [(a + 1)] [(b - 1)].umgebungsminen++;     //inkrementiere umgebungsmine von Zelle unten links
                        }
                    }
                    if (a > 0) {
                        zelle [(a - 1)] [b].umgebungsminen++;               //inkrementiere umgebungsmine der darüberliegenden Zelle
                        if (b < (groesse - 1)) {
                            zelle [(a - 1)] [(b + 1)].umgebungsminen++;     //inkrementiere umgebungsmine von Zelle oben rechts
                        }
                        if (b > 0) {
                            zelle [(a - 1)] [(b - 1)].umgebungsminen++;     //inkrementiere umgebungsmine von Zelle oben links
                        }
                    }
                    if (b < (groesse - 1)) {
                        zelle [a] [(b + 1)].umgebungsminen++;               //inkrementiere umgebungsmine von Zelle rechts
                    }
                    if (b > 0) {
                        zelle [a] [(b - 1)].umgebungsminen++;               //inkrementiere umgebungsmine von Zelle links
                    }
                }
            }
        }
    }
    public void spielfeldDrucken() {
        int c = 0;                                                          //Reihennummerierung
        String e = "      ";
        for (int d = 65; d < groesse + 65; d++) {                           //Spaltenbuchstaben
            e += Character.toString((char) d);
            e += "    ";
        }
        System.out.println (e);                                             //Spaltenbuchstaben werden gedruckt
        for (int a = 0; a < groesse; a++) {
            if (c < 10) {                                                   //Reihennummerierung wird gedruckt
                System.out.print (c + " | ");                               
            } else {
                System.out.print (c + "| ");
            }
            c++;
            for (int b = 0; b < groesse; b++) {
                zelle [a] [b].zelleDrucken();
            }
            System.out.println();
        }
    }
    /**
    *Zelle entschärfen oder betreten
    */
    public boolean zellenAktion(int koordinate1, int koordinate2, int aktion) {
        switch(aktion){
            case 1:
                zelle [koordinate1] [koordinate2].zelleBetreten();
                if (zelle [koordinate1] [koordinate2] instanceof Mine) {
                    Mine mine = (Mine) zelle [koordinate1] [koordinate2];     //Zelle wird gecasted
                    if (mine.entschaerft) {                                   //Ist die Mine die betreten wird entschaerft?
                        return false;                                                
                    } else {
                        return true;                                                    
                    } 
                }
                break;
            case 2:
                zelle [koordinate1] [koordinate2].zelleEntschaerfen();
                return false;                                             //Wenn boolean true, Spiel beenden
        }
        return false;                                                     //Dieser Fall tritt nicht ein, wird aber zum compilieren benötigt
    }
    /**
    *Das Spiel ist gewonnen, wenn alle
    *booleans betreten (für FreiesFeld) bzw.
    *entschärft (für Mine) == true sind.
    */
    public boolean spielGewonnenPruefen() {
        for (int a = 0; a < groesse; a++) {
            for (int b = 0; b < groesse; b++) {
            /**
            *Ist diese Zelle eine Mine oder ein FreiesFeld?
            *Die Zellen werden auch gecasted, das heißt 
            *das Programm behandelt das Objekt Zelle, welches
            *ein FreiesFeld oder eine Mine sein kann, wie ein 
            *FreiesFeld bzw. eine Mine, um auf die jeweiligen
            *Unterklassenvariablen zuzugreifen
            */
                if (zelle [a] [b] instanceof Mine) {
                    Mine mine = (Mine) zelle [a] [b];                   //Zelle wird als Mine gecasted, um auf die Minenvariable
                    if (mine.entschaerft == false) {                    //zuzugreifen.
                        return false;                                   //Wenn die Mine nicht entschärft ist, ist
                    }                                                   //das Spiel nicht gewonnen
                }
                if (zelle [a] [b] instanceof FreiesFeld) {
                    FreiesFeld freiesFeld = (FreiesFeld) zelle [a] [b]; //Zelle wird als FreiesFeld gecasted
                    if (freiesFeld.betreten == false) {
                        return false;                                   //Wenn das FreieFeld nicht betreten ist, ist
                    }                                                   //das Spiel nicht gewonnen
                }
            }
        }
        return true;
    }
    public void zellenEinmalOffenDrucken() {
        for (int a = 0; a < groesse; a++) {
            for (int b = 0; b < groesse; b++) {
                if (zelle [a] [b] instanceof Mine) {
                    Mine mine = (Mine) zelle [a] [b];                   //Zu Mine casten
                    mine.zelleEntschaerfen();                           //Zelle öffnen
                    mine.zelleDrucken();                                //Zelle offen drucken
                    mine.entschaerft = !mine.entschaerft;               //Zelle wieder schließen
                } else {
                    FreiesFeld freiesFeld = (FreiesFeld) zelle [a] [b];
                    if (freiesFeld.betreten == false) {                 //Wenn freiesFeld nicht initial offen war
                        freiesFeld.zelleBetreten();                     //dann Zelle öffnen
                        freiesFeld.zelleDrucken();                      //Zelle drucken
                        freiesFeld.betreten = !freiesFeld.betreten;     //Zelle wieder schließen
                    } else {
                        freiesFeld.zelleDrucken();                      //Wenn es initial offen ist, drucken und offen lassen
                    }
                }
            }
            System.out.println();
        }
    }
}
