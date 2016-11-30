package ADTs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patricklanger on 10.11.16.
 */
public class Dea {
    private DeaNode startNode;
    private List<DeaNode> endNodes;
    private DeaNode activeNode;
    private List<DeaNode> nodes;

    public DeaNode getActiveNode() {
        return activeNode;
    }

    public List<String> getAlphabet() {
        return alphabet;
    }

    private List<String> alphabet;


    public Dea(List<String> alphabet){
        endNodes = new ArrayList<DeaNode>();
        nodes = new ArrayList<DeaNode>();
        this.alphabet = alphabet;
    }

    public
    DeaNode getStartNode() {
        return startNode;
    }

    public List<DeaNode> getEndNodes() {
        return endNodes;
    }

    public boolean setStartNode(DeaNode node) {
        startNode = node;
        return true;
    }

    public boolean addEndNode(DeaNode node) {
        endNodes.add(node);
        return true;
    }

    public void resetEndNodes(List<DeaNode> nodes){
        endNodes.clear();
        endNodes.addAll(nodes);
    }

    public DeaNode getActiveNodeForNewInput(String input) {
        for (AbstractEdge e : activeNode.getEdges()) {
            if (e.getLiteral().equals(input)){
                activeNode = (DeaNode) e.getTargetNode();
                return activeNode;
            }
        }
        return activeNode;
    }

    public void addNode(DeaNode node){
        nodes.add(node);
    }

    public DeaNode createNode(String name) {
        for (DeaNode n: nodes) {
            if (n.getName().equals(name)){
                return null;
            }
        }
        nodes.add(new DeaNode(name));
        return nodes.get(nodes.size()-1);
    }

    public AbstractEdge createEdge(String node, String targetNode, String lit) {
        for (DeaNode n: nodes) {
            for (DeaNode target: nodes) {
                if (target.getName().equals(targetNode)){
                    if (n.getName().equals(node)){
                        Edge e = new Edge(target,lit);
                        return e;
                    }
                }
            }
        }
        return null;
    }

    public List<DeaNode> getNodes(){
        return nodes;
    }
}
