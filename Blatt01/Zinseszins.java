// Übung 4.6.1 4.6.2
public class Zinseszins {
    
    public float ZinseszinsRechner (float p, int n, float a) {
        float b=1;
        while (n>0) {
            b=b*(1+p/100);
            n=n-1;
        }
        return (a*b);
    }
}
