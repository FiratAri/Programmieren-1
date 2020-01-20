/**
*Lösung der Pflichtaufgabe 5
*
*@author Firat Ari
*@version 1.0
*/
public class IntSet {
    private Tree items;

    public IntSet () {

    }
    public IntSet (int [] items) {
        if (items == null) {                              //Wurzelknoten existiert noch nicht
            this.items = new Tree (items[0]);             //Erster Wert ist Wurzelknoten 
            for (int a = 1; a < items.length; a++) {
                insert (items[a]);                        //Werte werden iterativ in den Baum eingefügt
            }
        } else {                                          //Wurzelknoten existiert schon
            for (int a = 0; a < items.length; a++) {
                insert (items[a]);
            }
        }
    }
    public void insert (int value) {
        if (items == null) {                               //Wenn es noch keinen Baum gibt, neuen Baum machen
            items = new Tree (value);                      //mit value als Wurzelknoten
        } else {
            items.insert(value);  
        }
    }
    public boolean contains (int value) {
        try {
            return items.exists(value);
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                return false;
            } else {
                System.out.println ("Es ist ein unbekannter Fehler aufgetreten");
                System.out.println ("Programm wird beendet");
                System.exit(0);
            }
            return false;
        }
    }
    /**
    *Wir nutzen die Methoden min() und max(),
    *um zu schauen für welchen Bereich wir mit exists
    *suchen und schließlich mit insert einfügen müssen.
    *Ich habe die vorgefertigten Exceptions genutzt, weil
    *diese ihre Aufgabe erfüllen und zudem weniger Arbeit machen
    */
    public IntSet union (IntSet other) {
        IntSet intsetUnion = new IntSet ();
        try {
            for (int a = other.items.min(); a <= other.items.max(); a++) {
                if (other.contains(a)) {                                            //Enthält der Baum diesen Wert?
                    intsetUnion.insert(a);                                          //Enthält diesen Wert, also in Baum einfügen
                }
            }
        } catch (Exception e) {                                                         //Fehler ist aufgetreten
            if (e instanceof NullPointerException) {                                    //other ist eine leere Menge
                System.out.println ("Es wurde eine nicht vorhandene Menge übergeben.");
            } else {                                                                    //anderer Fehler
                System.out.println ("Es ist ein unbekannter Fehler aufgetreten");
            }            
            System.out.println ("Die Vereinigung erfolgt mit der leeren Menge.");
        } finally {
            if (items != null) {                                                    //Wenn die Menge nicht leer ist
                for (int b = items.min(); b <= items.max(); b++) {                  //Elemente der anderen Menge hinzufügen
                    if (contains(b)) {                                              //Enthält der Baum diesen Wert
                        intsetUnion.insert(b);                                      //Wenn ja, Wert in den Baum einfügen
                    }
                }
            }
        }
        return intsetUnion;
    }
    /**
    *Ähnlich wie in union sammeln wir die Elemente der anderen Menge.
    *Wenn beide ein gleiches Element haben wird das in ein Array zwischen-
    *gespeichert und dann eine neue Menge zu erschaffen
    */
    public IntSet intersection (IntSet other) {
        IntSet intsetIntersection = new IntSet ();
        try {
            for (int a = other.items.min(); a <= other.items.max(); a++) {
                if (other.contains(a) && contains(a)) {                     //Enthalten bei dieses Element?
                    intsetIntersection.insert(a);                           //Wenn ja, einsetzen
                }                                                           //Wenn nein, nichts machen
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {                                    //Fehler ist aufgetreten
                System.out.println ("Es wurde eine nicht vorhandene Menge übergeben."); //other ist eine leere Menge
            } else {                                                                    //anderer Fehler
                System.out.println ("Es ist ein unbekannter Fehler aufgetreten");
            }
            System.out.println ("Der Schnitt erfolgt mit der leeren Menge.");
            intsetIntersection.items = null;
        }
        return intsetIntersection;
    }
    /**
    *Diese Methode vergleicht, ob zwei Mengen
    *identisch sind. Da Bäume trotz identischer
    *Elemente unterschiedlich aussehen können,
    *nutzen wir die toString Methode, um die 
    *Menge genormt auszugeben. Wenn beide Strings
    *gleich sind, sind die Mengen identisch.
    */
    public boolean equals (Object x) {
        if (x instanceof IntSet) {                                            //Ist das Objekt eine Integer Menge?
            if (toString().equals(((IntSet) x).toString())) {                   //Wenn ja, sind die Mengen identisch?
                return true;                                                  //Wenn ja, wahr ausgeben
            } else {                                                          //Wenn nein,
                return false;                                                 //falsch ausgeben
            }
        } else {                                                              //Wenn nein,
            return false;                                                     //falsch ausgeben
        }
    }
    /**
    *Diese Methode gibt die Elemente der Menge
    *als streng monoton steigende Folge aus.
    *Die Baumstruktur ist also nicht erkennbar.
    *Wie grenzen den Suchbereich mit min() und max()
    *ein und kontrollieren dann mit contains, 
    *welcher Wert zur Menge gehört
    */
    public String toString () {
        String set = "";
        if (items != null) {
            for (int value = items.min(); value <= items.max(); value++) {        //Suchbereich eingrenzen
                if (contains (value)) {                                           //Wenn value im Baum ist,
                    if (set == "") {
                        set += value;                                             //value zu set hinzufügen
                    } else {
                        set += "," + value;                                       //value zu set hinzufügen
                    }
                }
            }
        } else {
            set = "(/)";                                                          //Leere Menge
        }
        return "{" + set + "}" + "\n";
    }
}
