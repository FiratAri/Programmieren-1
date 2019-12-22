/**
*Lösung der Pflichtaufgabe 4
*
*@author Firat Ari
*@version 1.0
*/
public class Mine extends Zelle {
    protected boolean entschaerft = false;
    
    public Mine (int koordinate1, int koordinate2) { 
        this.koordinate1 = koordinate1;
        this.koordinate2 = koordinate2;
    }
    public void zelleEntschaerfen() {
        entschaerft = true;
    }
    public void zelleBetreten() {
    }
    public void zelleDrucken() {
        if (entschaerft) {
            System.out.print ("|/**|");
        } else {
            System.out.print ("|   |");
        }
    }
}
