/**
* In dieser Klasse definieren wir die Methode, die
* die Blöcke druckt
*@author Firat Ari
*@version 1.0
*/
public class Block {
    public String blockDrucken (int a) {
        if (a == 0) {
            return "X";
        } else if (a == 1){
            return "~";
        } else {
            return " ";
        }
    }
}
