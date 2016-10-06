package Puffer.Implementations;

import Puffer.PufferAbstract;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 * Ein Puffer mit einer LinkedList.
 */
public class LinkedListPuffer extends PufferAbstract {

    LinkedList<String> pufferList = new LinkedList<String>();
    private int maxSize;

    public LinkedListPuffer(int maxPufferSize) {
        this.maxSize = maxPufferSize;
    }

    public LinkedListPuffer() {
        this.maxSize = MAX_PUFFER;
    }

    @Override
    protected boolean private_push(String value) {
        if(pufferList.size() < maxSize){
            pufferList.add(value);
            return true;
        }
        return false;
    }

    @Override
    protected String private_pop() {
        if(pufferList.isEmpty()){
            return null;
        }
        String value = pufferList.getFirst();
        pufferList.removeFirst();
        return value;
    }

    @Override
    protected String private_peek() {
        if(pufferList.isEmpty()){
            return null;
        }
        return pufferList.getFirst();
    }

    @Override
    protected boolean private_contains(String value) {
        return pufferList.contains(value);
    }

    @Override
    protected int private_size() {
        return pufferList.size();
    }

    @Override
    protected boolean private_isEmpty() {
        return pufferList.isEmpty();
    }


}
