import Entities.*;

import java.util.ArrayList;

import static com.sun.tools.corba.se.idl.constExpr.Expression.one;
import static com.sun.tools.corba.se.idl.constExpr.Expression.zero;

/**
 * Created by patricklanger on 17.11.16.
 */
public class Main {
    public static void main (String[] args){

        test2();
    }

    private static void test1(){
        //Erzeuge einen KFG
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

        Generator g = new Generator();
        KFG chomskyKFG = g.generateChomskyKFG(kfg);
        chomskyKFG.printKFG();

    }

    private static void test2(){
        //Erzeuge einen KFG
        NonTerminal s = new NonTerminal("S");
        NonTerminal a = new NonTerminal("A");
        NonTerminal b = new NonTerminal("B");
        Terminal ey = new Terminal("a");
        Terminal be = new Terminal("b");

        Produktion sp = new Produktion(s);
        sp.addToRumpf(new AbstractSymbol[]{a, s, a});
        sp.addToRumpf(new AbstractSymbol[]{ey, b});

        Produktion ap = new Produktion(a);
        ap.addToRumpf(new AbstractSymbol[]{b});
        ap.addToRumpf(new AbstractSymbol[]{s});

        Produktion bp = new Produktion(b);
        bp.addToRumpf(new AbstractSymbol[]{be});
        bp.addToEpsilonRumpf();

        KFG kfg = new KFG("wikiTest", sp);
        kfg.addProduktion(ap);
        kfg.addProduktion(bp);

        kfg.printKFG();

        Generator g = new Generator();
        KFG chomskyKFG = g.generateChomskyKFG(kfg);
        chomskyKFG.printKFG();

    }
}
