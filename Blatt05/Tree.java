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
    public boolean exists () {
		
    }
    public int min () {
		
    }
    public int max () {
		
    }
    public String toString () {
		
    }
    public boolean isDegenerate () {
		
    }
    
}
