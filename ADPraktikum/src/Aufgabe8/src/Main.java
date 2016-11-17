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

        ArrayList<AbstractSymbol> symbolFolge = new ArrayList<>();
        Produktion sp = new Produktion(s);
        symbolFolge.add(a);
        symbolFolge.add(one);
        symbolFolge.add(b);
        sp.addToRumpf(symbolFolge);

        symbolFolge.clear();
        Produktion ap = new Produktion(a);
        symbolFolge.add(zero);
        symbolFolge.add(a);
        ap.addToRumpf(symbolFolge);

        ap.addToEpsilonRumpf();

        symbolFolge.clear();
        Produktion bp = new Produktion(b);
        symbolFolge.add(zero);
        symbolFolge.add(b);
        bp.addToRumpf(symbolFolge);

        symbolFolge.clear();
        symbolFolge.add(one);
        symbolFolge.add(b);
        bp.addToRumpf(symbolFolge);

        bp.addToEpsilonRumpf();

        KFG kfg = new KFG("test", sp);
        kfg.addProduktion(ap);
        kfg.addProduktion(bp);

        kfg.printKFG();
    }
}
