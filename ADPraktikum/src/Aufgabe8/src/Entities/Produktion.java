package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patricklanger on 17.11.16.
 */
public class Produktion {
    private NonTerminal kopf;
    private List<List<AbstractSymbol>> rumpf;

    public Produktion(NonTerminal kopf){
        this.kopf = kopf;
        rumpf = new ArrayList<>();
    }

    public NonTerminal getKopf() {
        return kopf;
    }

    public List<List<AbstractSymbol>> getRumpf() {
        return rumpf;
    }

    public void addToRumpf(List<AbstractSymbol> zeichenreihe){
        rumpf.add(zeichenreihe);
    }

    public void addToEpsilonRumpf(){
        List<AbstractSymbol> epsilon = new ArrayList<>();
        rumpf.add(epsilon);
    }

    public void printProduduktion(){
        String rumpfString = "";
        for(List<AbstractSymbol> ls : rumpf){
            for(AbstractSymbol s : ls){
                rumpfString = rumpfString + s.getSymbol();
            }
            rumpfString = rumpfString + " | ";
        }
        System.out.println(kopf.getSymbol() + " -> " + rumpfString);
    }
}
