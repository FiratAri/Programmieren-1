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
        if (items == null) {                                       //Wurzelknoten existiert noch nicht
            this.items = new Tree (items[0]);                      //Erster Wert ist Wurzelknoten 
            for (int a = 1; a < items.length; a++) {
                insert (items[a]);                                 //Werte werden iterativ in den Baum eingefügt
            }
        } else {                                                   //Wurzelknoten existiert schon
            for (int a = 0; a < items.length; a++) {
                insert (items[a]);
            }
        }
    }
    public void insert (int value) {
        if (items == null) {                                       //Wenn es noch keinen Baum gibt, neuen Baum machen
            items = new Tree (value);                              //mit value als Wurzelknoten
        } else {
            try {
                items.insert(value);
            } catch (Exception e) {                                //e ist bei korrekter Eingabe die ValueAlreadyPresentException
                throw e;
            }  
        }
    }
    /**
    *Wenn Tree (also die Menge) leer ist,
    *wird eine NullPointerException geworfen,
    *die wir hier fangen
    */
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
    *Ich habe teilweise vorgefertigte Exceptions genutzt, weil
    *diese ihre Aufgabe erfüllen und zudem weniger Arbeit machen.
    *Die von mir geschriebenen Exception werden lediglich zur 
    *Fallunterscheidung des entsprechenden Fehlers benötigt.
    */
    public IntSet union (IntSet other) {
        IntSet intsetUnion = new IntSet ();
        if (other == null) {                                                        //Other wurde noch nicht erschaffen
            throw new NoSetException();                                             //Exception dafür werfen
        }
        for (int a = other.items.min(); a <= other.items.max(); a++) {              //Eingrenzung des Suchbereichs
            try {            
                if (other.contains(a)) {                                            //Enthält der Baum diesen Wert
                    intsetUnion.insert(a);                                          //Wenn ja, einsetzen
                }                                        
            } catch (Exception e) {
                if (e instanceof ValueAlreadyPresentException) {                    //Wenn Wert bereits vorhanden,
                                                                                    //nichts gesondertes machen
                } else if (e instanceof NullPointerException) {                     //Wenn Menge other leer,
                                                                                    //nichts gesondertes machen
                } else {                                                            //Ansonsten ist es
                    throw new RuntimeException();                                          //ein unbekannter Fehler
                }
            }
        }
        if (items != null) {                                                        //Wenn die Menge nicht leer ist
            for (int b = items.min(); b <= items.max(); b++) {                      //Elemente der anderen Menge hinzufügen
                if (contains(b)) {                                                  //Enthält der Baum diesen Wert
                    try {
                        intsetUnion.insert(b);                                      //Wenn ja, Wert in den Baum einfügen
                    } catch (Exception e) {                                         //Bei bereits vorhandenem Wert keine
                        if (e instanceof ValueAlreadyPresentException) {            //Fehlermeldung senden
                            
                        } else {
                            System.out.println ("Unbekannter Fehler");
                        }
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
        if (other == null) {                                                //Other wurde noch nicht erschaffen
            throw new NoSetException();                                     //Exception dafür werfen
        }
        for (int a = other.items.min(); a <= other.items.max(); a++) {
            try {            
                if (other.contains(a) && contains(a)) {                     //Enthalten bei dieses Element?
                    intsetIntersection.insert(a);                           //Wenn ja, einsetzen
                }                                                           //Wenn nein, nichts machen
            } catch (Exception e) {
                if (e instanceof ValueAlreadyPresentException) {                //Wenn Wert bereits vorhanden,
                                                                                //nichts gesondertes machen
                } else if (e instanceof NullPointerException) {                 //Wenn other die leere Menge ist,
                    intsetIntersection.items = null;                            //ist der Schnitt = (/)
                } else {
                    throw new RuntimeException();                           //Runtime um das "checking" zu vermeiden
                }
            }
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
