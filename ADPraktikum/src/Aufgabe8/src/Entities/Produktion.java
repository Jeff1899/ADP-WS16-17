package Entities;

/**
 * Created by patricklanger on 17.11.16.
 */
public class Produktion {
    private NonTerminal kopf;
    private AbstractSymbol[][] rumpf;
    private int rumpfIndex;

    public Produktion(NonTerminal kopf){
        this.kopf = kopf;
        this.rumpf = new AbstractSymbol[20][];
        rumpfIndex = 0;
    }

    public NonTerminal getKopf() {
        return kopf;
    }

    public AbstractSymbol[][] getRumpf() {
        return rumpf;
    }

    public void addToRumpf(AbstractSymbol[] zeichenreihe){
        rumpf[rumpfIndex] = zeichenreihe;
        rumpfIndex++;
    }

    public void addToEpsilonRumpf(){
        AbstractSymbol[] a = new AbstractSymbol[1];
        a[0] = new Terminal("Epsilon");
        rumpf[rumpfIndex] = a;
        rumpfIndex++;
    }

    public void printProduduktion(){
        String rumpfString = "";
        for(int i = 0; i < rumpfIndex; i++){
            for(AbstractSymbol s : rumpf[i]){
                rumpfString = rumpfString + s.getSymbol();
            }
            rumpfString = rumpfString + " | ";
        }
        System.out.println(kopf.getSymbol() + " -> " + rumpfString);
    }
}
