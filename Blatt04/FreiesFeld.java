/**
*Lösung der Pflichtaufgabe 4
*
*@author Firat Ari
*@version 1.0
*/
public class FreiesFeld extends Zelle {
    protected boolean betreten = false;    //Boolean ist nicht private, um casting zu nutzen
    
    public FreiesFeld(int koordinate1, int koordinate2) {
        this.koordinate1 = koordinate1;
        this.koordinate2 = koordinate2;
    }
    public void zelleEntschaerfen() {
    }
    public void zelleBetreten() {
        betreten = true;
    }
    public void zelleDrucken() {
        if (!betreten) {
            System.out.print ("|   |");
        } else {
            System.out.print ("| " + umgebungsminen + " |"); 
        }
    }
}
