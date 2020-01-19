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
        Intset intset = new IntSet();
        if (items == null) {                              //Wird für union Methode so gemacht
            this.items = new Tree (items[0]);             //Erster Wert ist Wurzelknoten 
            for (int a = 1; a < items.length; a++) {
                insert (items[a]);                        //Werte werden iterativ in den Baum eingefügt
            }
        } else {
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
        return items.exists(value);
    }
    /**
    *Wir nutzen die Methoden min() und max(),
    *um zu schauen für welchen Bereich wir mit exists
    *suchen und schließlich mit insert einfügen müssen
    */
    public IntSet union (IntSet other) {
        intsetUnion = new Intset ();
        try {
            for (int a = other.items.min(); a <= other.items.max(); a++) {
                if (other.contains(a)) {                        //Enthält der Baum diesen Wert zwischen min und max?
                    intsetUnion.insert(a);                      //Enthält diesen Wert, also in Baum einfügen
                }                                               //enthält Wert nicht, also nichts machen
            }
        } catch ()
        return intsetUnion;
    }
    /**
    *Ähnlich wie in union sammeln wir die Elemente der anderen Menge.
    *Wenn beide ein gleiches Element haben wird das in ein Array zwischen-
    *gespeichert und dann eine neue Menge zu erschaffen
    */
    public IntSet intersection (IntSet other) {
        intsetIntersection = new Intset ();
        try {
            for (int a = other.items.min(); a <= other.items.max(); a++) {
                if (other.contains(a) && contains(a)) {                     //Enthalten bei dieses Element?
                    intsetIntersection.insert(a);                           //Wenn ja, einsetzen
                }                                                           //Wenn nein, nichts machen
            }
        } catch (Exception e) {
            System.out.println ("F")
        }
        return intsetIntersection;
    }
    public boolean equals (Object x) {
        
    }
    public String toString () {
        
    }
}
