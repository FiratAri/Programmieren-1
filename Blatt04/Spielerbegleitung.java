/**
*Lösung der Pflichtaufgabe 4
*
*@author Firat Ari
*@version 1.0
*/
public class Spielerbegleitung {  
    public static void main (String[] args) {
        Spielereingabe spielereingabe = new Spielereingabe(); 
        /**                                                      
        *Spielfeldparametereingabe und Spielfeldinitialisierung
        */
        System.out.println ("___Minesweeper___");
        System.out.print ("Bitte geben Sie die Größe des Feldes ein: ");
        spielereingabe.eingabeGroesse();
        System.out.print ("Bitte geben Sie die Anzahl der verminten Felder ein: ");
        spielereingabe.eingabeMinenAnzahl();
        System.out.print ("Bitte geben Sie die Anzahl der Initialfelder ein: ");
        spielereingabe.eingabeInitialeFelder();
        spielereingabe.spielfeldInitialisieren();       
        /**
        *Wir erschaffen eine Referenz auf das Objekt Spielfeld,
        *um auf die Methoden der Klasse Spielfeld zuzugreifen. Die
        *Referenz ist aber die Gleiche wie die des Objektes Spielfeld,
        *welches von Spielereingabe erschaffen wurde, sodass die Veränderungen,
        *die Spielereingabe an diesem Objekt vornimmt direkt 
        *genutzt werden. Spielereingabe und Spielerbegleitung nutzen
        *also das selbe Objekt Spielfeld.
        */
        Spielfeld spielfeld = spielereingabe.spielfeld;       
        spielfeld.felderSetzen();   
        /**
        *Spielbeginn
        */
        spielfeld.zellenEinmalOffenDrucken();                      //Zellen werden einmal offen gedruckt und wieder geschlossen
        while (true) {
            spielfeld.spielfeldDrucken();   
            System.out.print ("Welche Aktion soll durchgeführt werden (1 Feld betreten;2 entschärfen): ");
            spielereingabe.eingabeAktion();
            do {
                System.out.print ("Welches Feld möchten Sie ");
                switch(spielereingabe.aktion) {
                    case 1:
                        System.out.print ("betreten?: ");
                        break;
                    default:
                        System.out.print ("entschärfen?: ");
                }
            } while (spielereingabe.koordinatenEingabe());
            if (spielereingabe.zellenAktion()) {                    //Wenn true, dann wurde auf Mine getreten
                spielfeld.zellenEinmalOffenDrucken();
                System.out.println ("Es wurde auf eine unentschärfte Mine getreten. Das Spiel ist verloren");
                return;
            }
            if (spielfeld.spielGewonnenPruefen()) {                 //Bei gewonnenem Spiel ist das Spielfeld schon offen
                spielfeld.spielfeldDrucken();
                System.out.println ("Das Spiel ist gewonnen");
                return;
            }
        }
    }
}
