/**
*Lösung der Pflichtaufgabe 3
*
*@author Firat Ari
*@version 1.0
*/
import java.util.Scanner;
public class TicTacToe {
    public static void main (String[] args) {
        Scanner eingabe = new Scanner(System.in);
        Zelle spielfeld1 = new Zelle(5,5);
        int reihe;
        int spalte;
        boolean spieler = true;
        System.out.println ("___Tic-Tac-Toe___");
        while (1 == 1) {
            /**
            *Spieleraufforderung
            */
            System.out.print ("Spieler ");
            if (spieler) {
                System.out.println ("1 an der Reihe");
            } else {
                System.out.println ("2 an der Reihe");
            }
            /**
            *Spielfeld drucken
            */
            spielfeld1.spielfeldDrucken();
            /**
            *Spielereingabe mit simpler Fehlerbehandlung
            */
            do {
                System.out.print ("Reihe (1 bis 5) : ");          
                reihe = eingabe.nextInt();
                if (reihe <= 0 || reihe >= 6) {
                    System.out.println ("Falsche Eingabe");
                }
            } while (reihe <= 0 || reihe >= 6);
            do {
                System.out.print ("Spalte (1 bis 5): ");
                spalte = eingabe.nextInt();
                if (spalte <= 0 || spalte >= 6) {
                    System.out.println ("Falsche Eingabe");
                }
            } while (spalte <= 0 || spalte >= 6);
            /**
            *Zellenänderung
            */
            spielfeld1.zelleAendern (spalte, reihe, spieler);
            /**
            *Spielfeld überprüfen und Ausgabe bei Spielende
            */
            if (spielfeld1.spielfeldPruefen()) {                  
                spielfeld1.spielfeldDrucken();
                System.out.print ("Spieler ");
                if (spieler) {
                    System.out.println ("1 hat gewonnen");
                    return;
                } else {
                    System.out.println ("2 hat gewonnen");
                    return;
                }
            }
            if (spielfeld1.unentschiedenPruefen()) {
                System.out.println ("Unentschieden");
                spielfeld1.spielfeldDrucken();
                return;
            }
            /**
            *Spielerwechsel
            */
            spieler = !spieler;           
        }
    }
}
