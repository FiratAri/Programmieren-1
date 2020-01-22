/**
*Lösung der Pflichtaufgabe 5
*
*@author Firat Ari
*@version 1.0
*
*Exception um zwischen nicht vorhandener
*Menge Fehler und leerer Menge Fehler zu
*unterscheiden.
*Die Exception ist eine RuntimeException, weil
*wir so vermeiden können im Methodenkopf die Exception
*anzugeben die geworfen wird. Wir behalten also
*die in der Hausaufgabe vorgegebene Struktur bei.
*Außerdem ist diese Exception eine Exception, die
*während der Ausführung des Programms entsteht.
*/
public class NoSetException extends RuntimeException {

}
