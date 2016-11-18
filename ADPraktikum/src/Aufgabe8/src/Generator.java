import Entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patricklanger on 17.11.16.
 */
public class Generator {

    public KFG generateLambdaFreeKFG(KFG externKfg){
        //In Chomsky-Normalform sind keine Epsilone... Max beim Startsymbol um das leere Wort zu erzeugen.
        //Das laesst sich auch nicht umgehen...

        KFG kfg = externKfg;
        //Ausnahme S -> Epsilon behandeln
        KFG newKFG = null;
        Produktion startProduktion = kfg.getStartProduktion();
        for (AbstractSymbol[] symbolFolge : startProduktion.getRumpf()){
            if (symbolFolge!=null && symbolFolge[0].getSymbol().equals("Epsilon")){
                Produktion newStartProduktion = new Produktion(new NonTerminal("S\'"));
                newStartProduktion.addToRumpf(new AbstractSymbol[]{startProduktion.getKopf()});
                newStartProduktion.addToEpsilonRumpf();
                newKFG = new KFG(kfg.getName()+" in LambdaFree: ", newStartProduktion);
                //und um damit weiter zu arbeiten
                kfg.addProduktion(kfg.getStartProduktion());
            }
        }

        //Falls Ausnahme nicht vorhanden, erstelle startProduktion
        if (newKFG == null){
            Produktion newStartProduktion = new Produktion(new NonTerminal("S\'"));
            newStartProduktion.addToRumpf(new AbstractSymbol[]{startProduktion.getKopf()});
            newKFG = new KFG(kfg.getName()+" in LambdaFree: ", newStartProduktion);
            //newKFG.addProduktion(kfg.getStartProduktion());
            //und um damit weiter zu arbeiten
            kfg.addProduktion(kfg.getStartProduktion());
        }

        //Ersetze Produktionen die nach Epsilon abbilden, dafuer...
        //... finde Nonterminale die nach Epsilon abbilden und entferne das Epsilon
        List<NonTerminal> ntMitEpsilon = new ArrayList<>(); //speichere hier falls mehrere Abbildungen
        List<NonTerminal> ntNurEpsilon = new ArrayList<>(); //speichere hier falls NUR nach Epsilon abgebildet wird

        for(Produktion produktion : kfg.getProduktionen()){
            for(AbstractSymbol[] symbolFolge : produktion.getRumpf()){
                if (symbolFolge != null && symbolFolge[0].getSymbol().equals("Epsilon")){
                    if (produktion.getRumpf().length == 1){
                        ntNurEpsilon.add(produktion.getKopf());
                    } else {
                        ntMitEpsilon.add(produktion.getKopf());
                        symbolFolge[0] = null;
                        if (symbolFolge.length<1 && symbolFolge[1]!=null){
                            for(int i = 1; symbolFolge[i] != null; i++){
                                symbolFolge[i-1] = symbolFolge[i];
                            }
                        }
                    }
                }
            }
        }
        //... entferne aus allen Produktionen alle Nonterminale die nur nach Epsilon abbilden bzw.
        //... erzeuge eine zweite Abbildung ohne das Nonterminal das u.a. nach Epsilon abbildet
        for(Produktion produktion : kfg.getProduktionen()){
            for(AbstractSymbol[] symbolFolge : produktion.getRumpf()){
                int symbolIndex = 0;
                if (symbolFolge!=null){
                    for(AbstractSymbol symbol : symbolFolge){
                        //falls Symbol nur auf Epsilon abbildet
                        if (ntNurEpsilon.contains(symbol)){
                            symbol = null;
                            //falls symbol nicht nur auf Epsilon abbildet
                        } else if (ntMitEpsilon.contains(symbol)){
                            //pruefe welches nt es ist
                            for(NonTerminal nt : ntMitEpsilon){
                                if (nt.equals(symbol)){
                                    //erzeuge neue Abbildung ohne Symbol
                                    AbstractSymbol[] newAbbildung = new AbstractSymbol[symbolFolge.length];
                                    int i = 0;
                                    int j = 0;
                                    for(AbstractSymbol s : symbolFolge){
                                        if(symbolIndex != j){
                                            newAbbildung[i] = s;
                                            i++;
                                        }
                                        j++;
                                    }
                                    produktion.addToRumpf(newAbbildung);
                                }
                            }
                        }
                        symbolIndex++;
                    }
                }

            }
        }

        //kopiere alle Produktionen zu newKFG
        for(Produktion produktion : kfg.getProduktionen()){
            newKFG.addProduktion(produktion);
        }


        return newKFG;
    }

    public KFG generateChomskyKFG(KFG externKfg){
        KFG kfg = externKfg;
        //Ausnahme S -> Epsilon behandeln
        KFG newKFG = null;
        Produktion startProduktion = kfg.getStartProduktion();
        for (AbstractSymbol[] symbolFolge : startProduktion.getRumpf()){
            if (symbolFolge!=null && symbolFolge[0].getSymbol().equals("Epsilon")){
                Produktion newStartProduktion = new Produktion(new NonTerminal("S\'"));
                newStartProduktion.addToRumpf(new AbstractSymbol[]{startProduktion.getKopf()});
                newStartProduktion.addToEpsilonRumpf();
                newKFG = new KFG(kfg.getName()+" in Chomsky-Normalform", newStartProduktion);
                //und um damit weiter zu arbeiten
                kfg.addProduktion(kfg.getStartProduktion());
            }
        }

        //Falls Ausnahme nicht vorhanden, erstelle startProduktion
        if (newKFG == null){
            Produktion newStartProduktion = new Produktion(new NonTerminal("S\'"));
            newStartProduktion.addToRumpf(new AbstractSymbol[]{startProduktion.getKopf()});
            newKFG = new KFG(kfg.getName()+" in Chomsky-Normalform", newStartProduktion);
            //newKFG.addProduktion(kfg.getStartProduktion());
            //und um damit weiter zu arbeiten
            kfg.addProduktion(kfg.getStartProduktion());
        }

        //Ersetze Produktionen die nach Epsilon abbilden, dafuer...
        //... finde Nonterminale die nach Epsilon abbilden und entferne das Epsilon
        List<NonTerminal> ntMitEpsilon = new ArrayList<>(); //speichere hier falls mehrere Abbildungen
        List<NonTerminal> ntNurEpsilon = new ArrayList<>(); //speichere hier falls NUR nach Epsilon abgebildet wird

        for(Produktion produktion : kfg.getProduktionen()){
            for(AbstractSymbol[] symbolFolge : produktion.getRumpf()){
                if (symbolFolge!=null && symbolFolge[0].getSymbol().equals("Epsilon")){
                    if (produktion.getRumpf().length == 1){
                        ntNurEpsilon.add(produktion.getKopf());
                    } else {
                        ntMitEpsilon.add(produktion.getKopf());
                        symbolFolge[0] = null;
                        if (symbolFolge.length<1 && symbolFolge[1]!=null){
                            for(int i = 1; symbolFolge[i] != null; i++){
                                symbolFolge[i-1] = symbolFolge[i];
                            }
                        }
                    }
                }
            }
        }
        //... entferne aus allen Produktionen alle Nonterminale die nur nach Epsilon abbilden bzw.
        //... erzeuge eine zweite Abbildung ohne das Nonterminal das u.a. nach Epsilon abbildet
        for(Produktion produktion : kfg.getProduktionen()){
            for(AbstractSymbol[] symbolFolge : produktion.getRumpf()){
                int symbolIndex = 0;
                if (symbolFolge!=null){
                    for(AbstractSymbol symbol : symbolFolge){
                        //falls Symbol nur auf Epsilon abbildet
                        if (ntNurEpsilon.contains(symbol)){
                            symbol = null;
                            //falls symbol nicht nur auf Epsilon abbildet
                        } else if (ntMitEpsilon.contains(symbol)){
                            //pruefe welches nt es ist
                            for(NonTerminal nt : ntMitEpsilon){
                                if (nt.equals(symbol)){
                                    //erzeuge neue Abbildung ohne Symbol
                                    AbstractSymbol[] newAbbildung = new AbstractSymbol[symbolFolge.length];
                                    int i = 0;
                                    int j = 0;
                                    for(AbstractSymbol s : symbolFolge){
                                        if(symbolIndex != j){
                                            newAbbildung[i] = s;
                                            i++;
                                        }
                                        j++;
                                    }
                                    produktion.addToRumpf(newAbbildung);
                                }
                            }
                        }
                        symbolIndex++;
                    }
                }

            }
        }

        //Entferne Kettenregen (zB: A -> B), dafuer...
        //... suche Nonterminale die auf ein einzelnes Nonterminal abbilden
        for(Produktion produktion : kfg.getProduktionen()){
            for(AbstractSymbol[] symbolFolge : produktion.getRumpf()){
                if (symbolFolge!=null && symbolFolge[0] instanceof NonTerminal && symbolFolge.length == 1){
                    //suche Produktion von B
                    Produktion bProduktion = null;
                    for(Produktion p : kfg.getProduktionen()){
                        if (p.getKopf().equals(symbolFolge[0])){
                            bProduktion = p;
                        }
                    }
                    //Fuege alle Abbildungen von B zu A hinzu
                    for(AbstractSymbol[] bSymbolFolge : bProduktion.getRumpf()){
                        produktion.addToRumpf(bSymbolFolge);
                    }
                }
            }
        }

        //Wenn im Rumpf mehr als 1 Symbol ist, lagere terminale aus
        //erzeuge dafuer eine neue Variable, also
        //aus s -> bAb wird s -> NAM, N -> b, M -> b
        for(int index = 0; index < kfg.getProduktionen().size(); index++){
            Produktion produktion = kfg.getProduktionen().get(index);
            for(AbstractSymbol[] symbolFolge : produktion.getRumpf()){
                if (symbolFolge != null && symbolFolge.length > 1){
                    int i = 0;
                    for(AbstractSymbol s : symbolFolge){
                        if (s instanceof Terminal){
                            Produktion newProduktion = null;
                            for(Produktion p : kfg.getProduktionen()){
                                if (p.getKopf().getSymbol().equals("NN"+s.getSymbol())){
                                    newProduktion = p;
                                }
                            }
                            if (newProduktion == null){
                                newProduktion = new Produktion(new NonTerminal("NN"+s.getSymbol()));
                                newProduktion.addToRumpf(new AbstractSymbol[]{s});
                                kfg.addProduktion(newProduktion);
                            }
                            symbolFolge[i] = newProduktion.getKopf();
                        }

                        i++;
                    }
                }
            }
        }


        //Es duerfen nur noch max zwei Variablen in einem Regelrupf stehen
        //Also aus S -> ABCDE wird S -> MMAB MMCDE, MMAB -> AB, MMCDE -> C MMDE, MMDE -> DE
        for(int index = 0; index < kfg.getProduktionen().size(); index++){
            Produktion produktion = kfg.getProduktionen().get(index);
            int symbolFolgeIndex = 0;
            for(AbstractSymbol[] symbolFolge : produktion.getRumpf()){
                int symbolFolgeSize = 0;
                if (symbolFolge != null){
                    for (int c = 0; c < symbolFolge.length; c++){
                        if (symbolFolge[c] != null){
                            symbolFolgeSize++;
                        }
                    }
                    if (symbolFolgeSize > 2){
                        int j = 0;
                        for(int i = 0; i < symbolFolge.length; i++){
                            if (i-j >= 1 && symbolFolge.length - i >= 2){
                                AbstractSymbol[] newRumpf = new AbstractSymbol[symbolFolge.length];
                                String newRumpfString = "";
                                int r = 0;
                                while (j<=i){
                                    newRumpf[r] = symbolFolge[j];
                                    newRumpfString = newRumpfString + symbolFolge[j].getSymbol();
                                    r++;
                                    j++;
                                }
                                j++;
                                i++;

                                Produktion newProduktion = null;
                                for (Produktion p : kfg.getProduktionen()){
                                    if (p.getKopf().getSymbol().equals("MM"+newRumpfString)){
                                        newProduktion = p;
                                    }
                                }
                                if (newProduktion == null){
                                    newProduktion = new Produktion(new NonTerminal("MM"+newRumpfString));
                                    newProduktion.addToRumpf(newRumpf);
                                    kfg.addProduktion(newProduktion);
                                }
                                AbstractSymbol[] newSymbolfolge = new AbstractSymbol[symbolFolge.length-i+1];
                                newSymbolfolge[0] = newProduktion.getKopf();
                                int l = 1;
                                for (int k = i; k < symbolFolge.length; k++){
                                    newSymbolfolge[l] = symbolFolge[k];
                                    l++;
                                }
                                produktion.getRumpf()[symbolFolgeIndex] = newSymbolfolge;
                            }
                        }
                    }
                }

                symbolFolgeIndex++;
            }
        }

        //kopiere alle Produktionen zu newKFG
        for(Produktion produktion : kfg.getProduktionen()){
            newKFG.addProduktion(produktion);
        }


        return newKFG;
    }
}
