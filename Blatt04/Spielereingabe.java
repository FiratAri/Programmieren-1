/**
*Lösung der Pflichtaufgabe 4
*
*@author Firat Ari
*@version 1.0
*/
import java.util.Scanner;
public class Spielereingabe {
    public int groesse;
    public int minenAnzahl;
    public int initialeFelder;
    public int aktion;
    public int koordinate1;
    public int koordinate2;
    
    Scanner eingabe = new Scanner(System.in);
    Spielfeld spielfeld;
    /**
    *Es folgen die Eingabemethoden.
    *Zu große Felder und unlogische Eingaben, 
    *wie z.B. groesse = 7,aber verminte Felder = 100,
    *werden auch erkannt
    */
    public void eingabeGroesse() {                 //Ausnahmebehandlung noch mal überarbeiten
        boolean kontrollwert = true;                         //Darf nicht null sein, weil beim Compilieren eine Fehlermeldung kommt,
        do {                                                 //obwohl es eigentlich nicht nötig ist
            try {
                groesse = eingabe.nextInt();
                kontrollwert = false;
            } catch (Exception e) {
                groesse = 24;                                            //Triggert untere Fehlermeldung
            }
            if (groesse > 24 || groesse == 0) {                          //Maximalgröße nur 24, weil nur 24 Buchstaben benutzt werden
                System.out.print ("Ungültige Eingabe. Erneuter Versuch: ");
                kontrollwert = true;
            }
        } while (kontrollwert);    
    }
    public void eingabeMinenAnzahl() {                 
        boolean kontrollwert = true;
        do {
            try {
                minenAnzahl = eingabe.nextInt();
                kontrollwert = false;
            } catch (Exception e) {
                minenAnzahl = groesse * groesse;                          //Triggert untere Fehlermeldung
            }
            if (minenAnzahl > (groesse * groesse)) {                                      
                System.out.print ("Ungültige Eingabe. Erneuter Versuch: ");
                kontrollwert = true;
            }
        } while (kontrollwert);    
    }
    public void eingabeInitialeFelder() {                 
        boolean kontrollwert = true;
        do {
            try {
                initialeFelder = eingabe.nextInt();
                kontrollwert = false;
            } catch (Exception e) {
                initialeFelder = groesse * groesse;                         //Triggert untere Fehlermeldung
            }
            if (initialeFelder > (groesse * groesse - minenAnzahl)) {                                      
                System.out.print ("Ungültige Eingabe. Erneuter Versuch: ");
                kontrollwert = true;
            }
        } while (kontrollwert);   
    }
    /**
    *Aktionseingabe mit Fehlerbehandlung
    */
    public void eingabeAktion() {
        boolean kontrollwert;
        do {
            try {
                aktion = eingabe.nextInt();
            } catch (Exception e) {
                aktion = 3;                                                 //aktion wird 3 gesetzt, damit die untere
            }                                                               //Fehlermeldung eintritt
            if (aktion != 1 && aktion != 2) {
                System.out.print ("Ungültige Eingabe. Erneuter Versuch: ");
                kontrollwert = true;
            } else {
                kontrollwert = false;
            }
        } while (kontrollwert);
    }
    /**
    *Spielfeldinitialisierungsmethode
    */
    public void spielfeldInitialisieren() {
        spielfeld = new Spielfeld(groesse, minenAnzahl, initialeFelder);
    }
    /**
    *Koordinateneingabe lesen wie aus dem Aufgabenblatt 4
    *ACHTUNG: WENN DIE EINGABE FEHLERHAFT IST WIRD DIE NÄCHSTE
    *EINGABE AUFGRUND VON ZEILE 102 VERWORFEN. MAN MUSS ALSO
    *NACH DER FEHLERMELDUNG EINMAL ENTER DRÜCKEN UND KANN DANN 
    *ERST DIE KOORDINATEN EINGEBEN
    */
    public boolean koordinatenEingabe() {
        eingabe.nextLine();// \n, welches bei Eingabe der Aktion entsteht (beim Enter drücken) wird verbraucht
        String b = eingabe.nextLine();
        koordinate2 = b.charAt(0) - 65;                                      //Siehe ASCII-Tabelle
        koordinate1 = b.charAt(1) - 48;
        if (koordinate2 < 0 || koordinate2 >= groesse || koordinate1 < 0 || koordinate1 >= groesse) {
            System.out.println ("Ungültige Eingabe. Erneuter Versuch");
            return true;
        }
        return false;
    }
    public boolean zellenAktion() {
        if (spielfeld.zellenAktion(koordinate1, koordinate2, aktion)) {
            return true;
        } else {
            return false;
        }
    }
}
