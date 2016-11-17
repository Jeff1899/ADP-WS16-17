import Entities.*;

import java.util.ArrayList;

/**
 * Created by patricklanger on 17.11.16.
 */
public class Main {
    public static void main (String[] args){
        NonTerminal s = new NonTerminal("S");
        NonTerminal a = new NonTerminal("A");
        NonTerminal b = new NonTerminal("B");
        Terminal zero = new Terminal("0");
        Terminal one = new Terminal("1");

        Produktion sp = new Produktion(s);
        sp.addToRumpf(new AbstractSymbol[]{a,one,b});

        Produktion ap = new Produktion(a);
        ap.addToRumpf(new AbstractSymbol[]{zero, a});
        ap.addToEpsilonRumpf();

        Produktion bp = new Produktion(b);
        bp.addToRumpf(new AbstractSymbol[]{zero, b});
        bp.addToRumpf(new AbstractSymbol[]{one, b});
        bp.addToEpsilonRumpf();

        KFG kfg = new KFG("test", sp);
        kfg.addProduktion(ap);
        kfg.addProduktion(bp);

        kfg.printKFG();
    }
}
