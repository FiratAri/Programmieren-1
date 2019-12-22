/**
*Lösung der Pflichtaufgabe 4
*
*@author Firat Ari
*@version 1.0
*Ich habe mich für die Nutzung einer abstrakten Klasse
*und Vererbung entschieden. Das Ziel ist nämlich das Spielfeld
*als Zellenarray zu realisieren. Die Zellen reagieren auf die
*jeweiligen Aktionen, wie z.B. Zelle betreten unterschiedlich,
*was durch die abstrakten Methoden dargestellt werden kann, ohne
*jedoch die Einfachheit in der Implementierung dieser Aktionen
*einzuschränken. Man muss also im "Hauptrogramm" Mine und Freies Feld
*nicht immer getrennt betrachten, sondern kann sie mit Hilfe der
*abstrakten Methoden und des Zellenarrays zusammenfassen.
*/
public abstract class Zelle {
    public int koordinate1;
    public int koordinate2;
    public int umgebungsminen = 0;
    
    public abstract void zelleEntschaerfen();
    public abstract void zelleBetreten();
    public abstract void zelleDrucken();
}
