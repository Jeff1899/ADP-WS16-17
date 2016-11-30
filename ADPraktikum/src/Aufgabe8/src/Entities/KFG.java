package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patricklanger on 17.11.16.
 */
public class KFG {
    private String name;
    private Produktion startProduktion;
    private List<Produktion> produktionen;

    public KFG(String name, Produktion startProduktion){
        this.name = name;
        this.startProduktion = startProduktion;
        produktionen = new ArrayList<>();
    }

    public void addProduktion(Produktion p){
        produktionen.add(p);
    }

    public boolean checkZeichenkette(String check){
        //TODO implementieren bzw. brauchen wir nicht!!!
        return false;
    }

    public void printKFG(){
        System.out.println(name);
        startProduktion.printProduduktion();
        for(Produktion p : produktionen){
            p.printProduduktion();
        }
    }

    public String getName() {
        return name;
    }

    public Produktion getStartProduktion() {
        return startProduktion;
    }

    public List<Produktion> getProduktionen() {
        return produktionen;
    }
}
