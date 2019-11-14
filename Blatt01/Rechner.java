// Übung 4.6.1         
public class Rechner {
    private int a;
    private int b;

    public Rechner(int u,int i) {
        a=u;
        b=i;
    }
    public int Add() {
        return (a+b);
    }
    public int Subtract() {
        return (a-b);
    }
    public int Multiply() {
        return (a*b);
    }
    public float Divide() {
        return (a/b);
    }
}
