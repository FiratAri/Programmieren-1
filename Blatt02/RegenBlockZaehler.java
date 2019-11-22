/**
*Lösung der Pflichtaufgabe auf Blatt 2
*
*@author Firat Ari
*@version 1.0
*/
import java.util.Scanner;

public class RegenBlockZähler {
    public static void main (String[] args) {
        Scanner eingabe = new Scanner(System.in);
        Block block = new Block();
        System.out.println ("___Regenblockzähler___");
        int[] a;                                              //Dieses Array hält die Höhen zu den jeweiligen Breitenstellen
        int b;                                                //Breite
        int h = 0;                                            //Summe aller Wasserblöcke        
        System.out.print ("Feldbreite (von 1 bis ....): ");
        b = eingabe.nextInt();
        /**
        *Fehlerbehandlung bei falscher Eingabe
        */
        if (b < 1) {
            System.out.println ("Ungültig");
            return;
        }
        a=new int[(b + 1)];
        int [] [] c = new int [11] [(b + 1)];               //Die Höhe ist der erste Wert;Die Breite der Zweite
        /**
        *Nun werden an den einzelnen Breitenstellen die Höhen ermittelt
        */
        for (int e = 1; e <= b; e++) {
            System.out.print ("Bitte Höhe (von 1 bis 10) an der Stelle " + e + " eingeben: ");
            a[e] = eingabe.nextInt();
            /**
            *Fehlerbehandlung bei falscher Eingabe
            */
            if (a[e] < 1 || a[e] > 10) {
                System.out.println ("Ungültig");
                return;                
            }       
            /**
            *Zum Drucken der entsprechenden Blöcke
            *werden nun den int im int array 
            *die Werte 0(ErdBlock) oder 2(LuftBlock)
            *zugeordnet
            */
            for (int d = 1; d <= a[e]; d++) {
                c[d][e] = 0;                           //z.B. Block in der Höhe d und Breitenstelle e ist 0 (also ein Erdblock)
            }
            for (int d = (a[e]+1); d <= 10; d++) {
                c[d][e] = 2;                           //Hier werden Luftblöcke gemacht
            }                  
        }
        /**
        *Drucken der Blöcke ohne Wasser
        */
        for (int d = 10; d > 0; d--) {
            for (int e = 1; e <= b; e++) {
                System.out.print (block.blockDrucken(c[d][e]));
            }            
            System.out.println ();
        }
        /**
        *Als nächstes gehen wir alle Blöcke durch. Wenn wir einen
        *Luftblock finden, dann gehen wir auf der Höhe des Luftblocks
        *solange nach links, bis wir einen Erdblock finden. Wenn wir
        *einen Erdblock finden, dann gehen wir auf der Höhe des Luftblocks
        *solange nach rechts, bis wir einen Erdblock finden. Wenn wir 
        *wieder einen Erdblock finden, dann machen wir aus dem Luftblock
        *einen Wasserblock
        */
        for (int d = 10; d > 0; d--) {
            for (int e = 1; e <= b; e++) {
                if (c[d][e] == 2) {                         //Luftblock gefunden
                    for (int f = e; f >= 1; f--) {          //Nach links gehen bis Erdblock gefunden wird
                        if (c[d][f] == 0) {                 //Erdblock gefunden
                            for (int g = e; g <= b; g++) {  //Nach rechts gehen bis Erdblock gefunden wird
                                if (c[d][g] == 0) {         //Erdblock gefunden
                                    c[d][e] = 1;            //Luftblock zu Wasserblock machen
                                }
                            }
                        }                    
                    }
                }
            }            
        }        
        /**
        *Wir drucken die Blöcke wieder wie von Zeile 57-62
        */
        System.out.println ();           //Abstandhalter
        for (int d = 10; d > 0; d--) {
            for (int e = 1; e <= b; e++) {
                System.out.print (block.blockDrucken(c[d][e]));
            }            
            System.out.println ();
        }
        /**
        *Jetzt zählen wir die Wasserblöcke.
        *Wir durchlaufen wie oben einmal jeden Wert
        *und für jeden Wasserblock addieren wir 1 zu
        *unserer Variable
        */
        System.out.println ();           //Abstandhalter
        for (int d = 10; d > 0; d--) {
            for (int e = 1; e <= b; e++) {
                if (c[d][e] == 1) {
                    h = h + 1;
                }
            }                        
        }
        System.out.println ("Summe aller Wasserblöcke: " + h);       
    }
}
