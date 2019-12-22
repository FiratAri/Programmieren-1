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
        //REFERENZEN BENUTZEN UND NICHT ALLES ÜBER SPIELEREINGABE MACHEN
        System.out.println ("___Minesweeper___");
        System.out.print ("Bitte geben Sie die Größe des Feldes ein: ");
        spielereingabe.eingabeGroesse();
        System.out.print ("Bitte geben Sie die Anzahl der verminten Felder ein: ");
        spielereingabe.eingabeMinenAnzahl();
        System.out.print ("Bitte geben Sie die Anzahl der Initialfelder ein: ");
        spielereingabe.eingabeInitialeFelder();
        spielereingabe.spielfeldInitialisieren();       
        spielereingabe.spielfeldFelderSetzen();
        /**
        *Spielbeginn
        */
        spielereingabe.zellenEinmalOffenDrucken();                  //Zellen werden einmal offen gedruckt und wieder geschlossen
        while (true) {
            spielereingabe.spielfeldDrucken();
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
            if (spielereingabe.zellenAktion()) {                    //Wenn true dann wurde auf Mine getreten
                spielereingabe.zellenOeffnen();                     //Diese Methode ist redundant, wegen zellenEinmalOffenDrucken()
                spielereingabe.spielfeldDrucken();
                System.out.println ("Es wurde auf eine unentschärfte Mine getreten. Das Spiel ist verloren");
                return;
            }
            if (spielereingabe.spielGewonnenPruefen()) {            //Bei gewonnenem Spiel ist das Spielfeld schon offen
                spielereingabe.spielfeldDrucken();
                System.out.println ("Das Spiel ist gewonnen");
                return;
            }
        }
    }
}
