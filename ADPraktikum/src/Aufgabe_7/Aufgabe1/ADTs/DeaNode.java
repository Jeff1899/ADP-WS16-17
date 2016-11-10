package ADTs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patricklanger on 10.11.16.
 */
public class DeaNode extends AbstractNode {

    private List<AbstractNode> zustandsmenge;

    public DeaNode(String name) {
        super(name);
        zustandsmenge = new ArrayList<AbstractNode>();
    }

    public void addNodeToZustandsmenge(AbstractNode n){
        zustandsmenge.add(n);
    }

    public List<AbstractNode> getZustandsmenge(){
        return zustandsmenge;
    }
}
