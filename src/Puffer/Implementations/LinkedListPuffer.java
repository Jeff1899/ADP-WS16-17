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

    List<String> pufferList = new LinkedList<String>();

    @Override
    protected boolean private_push(String value) {
        if(pufferList.size() < MAX_PUFFER){
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
        String value = pufferList.get(0);
        pufferList.remove(0);
        return value;
    }

    @Override
    protected String private_peek() {
        if(pufferList.isEmpty()){
            return null;
        }
        return pufferList.get(0);
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
