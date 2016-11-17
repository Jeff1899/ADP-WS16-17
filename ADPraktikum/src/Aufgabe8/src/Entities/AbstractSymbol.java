package Entities;

/**
 * Created by patricklanger on 17.11.16.
 */
public abstract class AbstractSymbol {
    private String symbol;

    public AbstractSymbol(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
