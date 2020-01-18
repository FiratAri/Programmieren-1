public class Tree {
    private int value;
    private Tree lch;   //Left child
    private Tree rch;   //Right child

    Tree (int value) {
		this.value = value;
    }
    public void insert (int insertion) {
		if (value != insertion) {
			if (insertion < value) {						//Wert kleiner als Knoten also nach links gehen
				if (lch.value <= 0 || lch.value > 0) {      //links bereits besetzt
					lch.insert (insertion);					//insert beim linken Knoten durchführen (Rekursion)
				} else {									//Knoten unbesetzt
					lch = new Tree (insertion);				//Neuen Knoten schaffen
				}
			} else {                                        //Wert größer als Knoten also nach rechts gehen
				if (rch.value <= 0 || rch.value > 0) {      //rechts bereits besetzt
					rch.insert (insertion);					//insert beim rechten Knoten durchführen (Rekursion)
				} else {									//Knoten unbesetzt
					rch = new Tree (insertion);				//Neuen Knoten schaffen
				}
			}
		} else {
			System.out.println ("Wert bereits vorhanden");
		}
    }
    public void insertIterative (int insertion) {
		
    }
    public int height () {
		
    }
    public boolean exists (int value) {
		if (this.value < value) {							//Gesuchter Wert ist kleiner als Knotenwert
			if (lch.value <= 0 || lch.value > 0) {			//Wenn ein linker Knoten existiert,
				return lch.exists (value);					//dann den linken Knoten kontrollieren (Rekursion)
			} else {										//Wenn kein linker Knoten existiert,
				return false;								//dann kann der Wert nicht im Baum sein
			}
		} else if (this.value > value) {
			if (rch.value <= 0 || rch.value > 0) {			//Wenn ein rechter Knoten existiert,
				return rch.exists (value);					//dann den rechten Knoten kontrollieren (Rekursion)
			} else {										//Wenn kein rechter Knoten existiert,
				return false;								//dann kann der Wert nicht im Baum sein
			}
		}													//Wenn der Wert nicht größer oder kleiner als
		return true;                                        //der Knotenwert ist, dann existiert er im Knotenwert
    }
    public int min () {
		if (lch.value <= 0 || lch.value > 0) {      //Wenn ein linker Knoten existiert
			return lch.min();                       //gibt das min() vom linken Knoten aus (Rekursion)
		}											//Wenn kein linker Knoten (kleinerer Wert) existiert,
		return value;                         	    //gib den Wert des aktuellen Knoten aus
    }
    public int max () {
		if (rch.value <= 0 || rch.value > 0) {      //Wenn ein rechter Knoten existiert
			return rch.min();                       //gibt das max() vom rechten Knoten aus (Rekursion)
		}											//Wenn kein rechter Knoten (größerer Wert) existiert,
		return value;                         	    //gib den Wert des aktuellen Knoten aus
    }
    public String toString () {
		
    }
    public boolean isDegenerate () {
		if (value <= 0 || value > 0) {
        	if ((lch.value <= 0 || lch.value > 0) && (rch.value <= 0 || rch.value > 0)) {    //Knoten hat zwei Pfade
        		return false;															     //also Baum ist nicht entartet
        	} else if (rch.value <= 0 || rch.value > 0) {                                    //Nur rechter Pfad vorhanden
        		return rch.isDegenerate ();													 //rechten Knoten prüfen (Rekursion)
        	} else if (lch.value <= 0 || lch.value > 0) {									 //Nur linker Pfad vorhande
        		return lch.isDegenerate ();													 //linken Knoten prüfen (Rekursion)
        	} else {																		 //Kein Pfad vorhanden
        		return true;																 //also Baum ist entartet
        	}
		}	    																			 //Kein Wurzelknoten vorhanden
		return true;																	     //also Baum ist entartet
    }
    
}
