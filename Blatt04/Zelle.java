/**
*Lösung der Pflichtaufgabe 4
*
*@author Firat Ari
*@version 1.0
*/
public abstract class Zelle {
    public int koordinate1;
    public int koordinate2;
    public int umgebungsminen = 0;
    
    public abstract void zelleEntschaerfen();
    public abstract void zelleBetreten();
    public abstract void zelleDrucken();
}
