/**
*Lösung der Pflichtaufgabe 5
*
*@author Firat Ari
*@version 1.0
*/
public class Tree {
    private int value;
    private Tree lch;   //Left child
    private Tree rch;   //Right child

    Tree (int value) {
        this.value = value;
    }
    public void insert (int insertion) {
        if (value != insertion) {
            if (insertion < value) {                        //Wert kleiner als Knoten also nach links gehen
                if (lch != null) {                          //links bereits besetzt
                    lch.insert (insertion);                 //insert beim linken Knoten durchführen (Rekursion)
                } else {                                    //Knoten unbesetzt
                    lch = new Tree (insertion);             //Neuen Knoten schaffen
                }
            } else {                                        //Wert größer als Knoten also nach rechts gehen
                if (rch != null) {                          //rechts bereits besetzt
                    rch.insert (insertion);                 //insert beim rechten Knoten durchführen (Rekursion)
                } else {                                    //Knoten unbesetzt
                    rch = new Tree (insertion);             //Neuen Knoten schaffen
                }
            }
        } else {
            System.out.println ("Wert bereits vorhanden");
        }
    }
    /**
    *Antwort zu Frage, ob insert oder insertIterative
    *schwieriger zu implementieren war: Es war bei der
    *iterativen Methode wesentlich schwieriger den richtigen
    *Ansatz zu finden. Die rekursive Methode ist meiner Meinung
    *nach leichter zu verstehen und intuitiver als die iterative
    *Methode, daher finde ich die rekursive Methode eleganter.
    */
    public void insertIterative (int insertion) {
        Tree obj = rch;             //Rechte Seite
        Tree obje = lch;            //Linke Seite
        /**
        *Rechter Unterbaum wird kontrolliert
        */
        while (insertion > value) {
            if (obj == null) {
                obj = new Tree (insertion);                                     //Knoten unbesetzt => Wert einsetzen
                return;                                                        //Wert eingesetzt, also Schleife beenden
            }
            if (insertion > obj.value) {                                        //Wert ist größer als Knotenwert
                if (obj.value == value) {
                    obj = rch;             //Wenn Wurzelknote nur rch ohne .
                } else {
                    obj = obj.rch;                                                     //Rücke nach rechts
                }
            } else if (insertion < obj.value){                                                //insertion < d + value
                if (obj.value == value) {
                    obj = lch;
                } else {
                    obj = obj.lch;                                                       //also nach links gehen
                }
            } else {
                System.out.println ("Wert existiert bereits im Baum");
                return;                            
            }
        }
        /**
        *Linker Unterbaum wird kontrolliert
        */
        while (insertion < value) {
            if (obje == null) {
                obje = new Tree (insertion);                      //Knoten unbesetzt => Wert einsetzen
                return;                                            //Wert eingesetzt, also Schleife beenden
            }
            if (insertion > obje.value) {                                        //Wert ist größer als Knotenwert
                if (obje.value == value) {
                    obje = rch;             //Wenn Wurzelknote nur rch ohne .
                } else {
                    obje = obje.rch;                                                     //Rücke nach rechts
                }
            } else if (insertion < obje.value){                         //insertion < d + value
                if (obje.value == value) {
                    obje = lch;
                } else {
                    obje = obje.lch;                                       //also nach links gehen
                }
            } else {
                System.out.println ("Wert existiert bereits im Baum");
                return;                            
            }
        }
        if (insertion == value) {                                             
            System.out.println("Wert existiert bereits im Baum");
        }
    }   
    public int heigth () {
        int heigth = 1;
        if (lch != null && rch == null) {                                         //Nur linker Pfad existiert
            heigth += lch.heigth();                                               //addiere Höhe des Unterbaums zu Höhe 
        }
        if (rch != null && lch == null) {                                         //Nur rechter Pfad existiert
            heigth += rch.heigth();                                               //addiere Höhe des Unterbaums zu Höhe
        }
        if ((lch != null && rch != null) && rch.heigth() >= lch.heigth()) {       //Beide Pfade existieren; Rechts höher/gleich
            heigth += rch.heigth();                                               //addiere Höhe des rechten Unterbaums zu Höhe
        } else if ((lch != null && rch != null) && rch.heigth() < lch.heigth()) { //Beide Pfade existieren; Links höher
            heigth += lch.heigth();                                               //addiere Höhe des linken Unterbaums zu Höhe
        }
        return heigth;                                       
    }
    public boolean exists (int value) {
        if (this.value > value) {                            //Gesuchter Wert ist kleiner als Knotenwert
            if (lch != null) {                               //Wenn ein linker Knoten existiert,
                return lch.exists (value);                   //dann den linken Knoten kontrollieren (Rekursion)
            } else {                                         //Wenn kein linker Knoten existiert,
                return false;                                //dann kann der Wert nicht im Baum sein
            }
        } else if (this.value < value) {
            if (rch != null) {                               //Wenn ein rechter Knoten existiert,
                return rch.exists (value);                   //dann den rechten Knoten kontrollieren (Rekursion)
            } else {                                         //Wenn kein rechter Knoten existiert,
                return false;                                //dann kann der Wert nicht im Baum sein
            }
        }                                                    //Wenn der Wert nicht größer oder kleiner als
        return true;                                         //der Knotenwert ist, dann existiert er im Knotenwert
    }
    public int min () {
        if (lch != null) {                                   //Wenn ein linker Knoten existiert
            return lch.min();                                //gibt das min() vom linken Knoten aus (Rekursion)
        }                                                    //Wenn kein linker Knoten (kleinerer Wert) existiert,
        return value;                                        //gib den Wert des aktuellen Knoten aus
    }
    public int max () {
        if (rch != null) {                                   //Wenn ein rechter Knoten existiert
            return rch.max();                                //gibt das max() vom rechten Knoten aus (Rekursion)
        }                                                    //Wenn kein rechter Knoten (größerer Wert) existiert,
        return value;                                        //gib den Wert des aktuellen Knoten aus
    }
    /**
    *Wert drucken dann für rechten und linken Knoten toString anwenden (Rekursion)
    *Drucken Linker Knoten (Rekursiv, also linker Knoten.toString), Drucken value,
    *Drucken Rechter Knoten (Rekursiv, wie links)
    */
    public String toString () {
        String a = "";
        if (lch != null) {
            a += "(" + lch.toString() + ")";
        }
        a += " " + value + " ";
        if (rch != null) {
            a += "(" + rch.toString() + ")";
        }
        return a;
    }
    public boolean isDegenerate () {
        if (value <= 0 || value > 0) {
            if (lch != null && rch != null) {                //Knoten hat zwei Pfade
                return false;                                //also Baum ist nicht entartet
            } else if (rch != null) {                        //Nur rechter Pfad vorhanden
                return rch.isDegenerate ();                  //rechten Knoten prüfen (Rekursion)
            } else if (lch != null) {                        //Nur linker Pfad vorhanden
                return lch.isDegenerate ();                  //linken Knoten prüfen (Rekursion)
            } else {                                         //Kein Pfad vorhanden
                return true;                                 //also Baum ist entartet
            }
        }                                                    //Kein Wurzelknoten vorhanden
        return true;                                         //also Baum ist entartet
    }   
}
