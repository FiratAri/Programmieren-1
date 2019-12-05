/**
*Lösung der Pflichtaufgabe 3
*
*@author Firat Ari
*@version 1.0
*/
public class Zelle {
    int[][] spielfeld;
    int breitenStelle;
    int höhenStelle;
    int kontrollwert = 0;
    public Zelle (int a, int b) {
        spielfeld = new int [(a+1)] [(b+1)];                    //Erster Wert ist die Breite; Zweiter die Höhe
        breitenStelle = a;
        höhenStelle = b;
        for (b = höhenStelle; b >= 1; b--) {                    //Beginnt an Höhe höhenStelle;Arbeitet Breiten von 1 bis breitenStelle
            for (a = 1; a <= breitenStelle; a++) {              //durch, dann weiter bei Höhe höhenStelle-1 usw.
                spielfeld [a] [b] = 0;                          //0 steht für leere Zelle
            }
        }
    }
    public void zelleAendern (int a, int b, boolean c) {
        if (c && spielfeld [a] [b] == 0) {               
            spielfeld [a] [b] = 1;                              //Spieler 1
        } else if (c == false && spielfeld [a] [b] == 0){
            spielfeld [a] [b] = 2;                              //Spieler 2
        } else {
            System.out.println ("Fehler: Feld bereits besetzt");
        }
    }
    public void spielfeldDrucken () {
        for (int b = höhenStelle; b >= 1; b--) {                //Beginnt an Höhe höhenStelle;Arbeitet Breiten von 1 bis breitenStelle
            for (int a = 1; a <= breitenStelle; a++) {          //durch, dann weiter bei Höhe höhenStelle-1 usw.
                switch (spielfeld [a] [b]) {                    //Wenn man bei der Höhe mit 1 anfängt dreht man die Reihenachse um
                    case 0:                                     //Also Reihe 1 würde dann oben und nicht unten beginnen
                        System.out.print ("| |");
                        break;
                    case 1:
                        System.out.print ("|O|");
                        break;
                    case 2:
                        System.out.print ("|X|");
                }
            }
            System.out.println ();
        }
    }
    /**
    *Die Werte in den einzelnen Zellen werden zusammenaddiert für jede Reihe,
    *Spalte und Diagonale. Es sind also immer fünf Werte
    *die zum Kontrollwert addiert werden. Wenn der Kontrollwert
    *die Werte 5 (Spieler 1) oder 10 (Spieler 2) annimmt, ist
    *das Spiel beendet. Jedes Feld muss besetzt sein. Um das
    *zu überprüfen, setzen wir den Kontrollwert -20, wenn
    *eine Zelle den Wert 0 hat (so kann der Kontrollwert nicht
    *mehr zu 5 oder 10 werden).
    *Für die Nutzung verschiedener Spielfeldgrößen ist eine eigene
    *Klasse für die einzelnen Kontrolldurchgänge angebracht (was hier
    *nicht gemacht wurde, da die Spielfeldgröße fest ist)
    */
    public boolean spielfeldPruefen () {                          //Wenn Methode true rausgibt, Spiel beenden
        /**
        *Hier wird eine Übereinstimmung innerhalb einer Reihe gesucht
        */
        for (int b = höhenStelle; b >= 1; b--) {                   
            for (int a = 1; a <= breitenStelle; a++) {            
                kontrollwert = kontrollwert + spielfeld [a] [b];
                if (spielfeld [a] [b] == 0) {
                    kontrollwert = -20;
                }                                   
            }
            if (kontrollwert == 5 || kontrollwert == 10) {
                return true;
            } else {
                kontrollwert = 0;
            }
        }
        /**
        *Hier wird eine Übereinstimmung innerhalb einer Spalte gesucht
        */
        for (int a = 1; a <= breitenStelle; a++) {
            for (int b = höhenStelle; b >= 1; b--) {
                kontrollwert = kontrollwert + spielfeld [a] [b];
                if (spielfeld [a] [b] == 0) {
                    kontrollwert = -20;
                }
            }
            if (kontrollwert == 5 || kontrollwert == 10) {
                return true;
            } else {
                kontrollwert = 0;
            }
        }
        /**
        *Hier wird eine Übereinstimmung innerhalb einer Diagonalen gesucht
        */
        for (int a = 1, b = höhenStelle; a <= höhenStelle && b >=1; a++, b--) {
            kontrollwert = kontrollwert + spielfeld [a] [b];
            if (spielfeld [a] [b] == 0) {
                kontrollwert = -20;
            }
        }
        if (kontrollwert == 5 || kontrollwert == 10) {
                return true;
            } else {
                kontrollwert = 0;
        }
        for (int a = 1; a <= höhenStelle; a++) {
            kontrollwert = kontrollwert + spielfeld [a] [a];
            if (spielfeld [a] [a] == 0) {
                kontrollwert = -20;
            }
        }
        if (kontrollwert == 5 || kontrollwert == 10) {
                return true;
            } else {
                kontrollwert = 0;
        }  
        return false;                                  
    }
    /**
    *Bei Unentschieden hat keine Zelle den Wert 0
    */
    public boolean unentschiedenPruefen () {
        for (int b = höhenStelle; b >= 1; b--) {                   
            for (int a = 1; a <= breitenStelle; a++) {            
                if (spielfeld [a] [b] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
