package ADTs;

import java.util.ArrayList;
import java.util.List;

public class Nea extends AbstractNEA {

	List<AbstractNode> startNodes;
	List<AbstractNode> endNodes;
	List<AbstractNode> activeNodes;
	List<AbstractNode> nodes;

	public Nea(List<String> alphabet){
		startNodes = new ArrayList<AbstractNode>();
		endNodes = new ArrayList<AbstractNode>();
		activeNodes = new ArrayList<AbstractNode>();
		nodes = new ArrayList<AbstractNode>();
		this.alphabet = alphabet;
	}

	public List<AbstractNode> getNodes() {
		return nodes;
	}

	@Override
	public List<AbstractNode> getStartNodes() {
		return startNodes;
	}

	@Override
	public List<AbstractNode> getEndNodes() {
		return endNodes;
	}

	@Override
	public boolean addStartNode(AbstractNode node) {
		startNodes.add(node);
		return true;
	}

	@Override
	public boolean addEndNode(AbstractNode node) {
		endNodes.add(node);
		return true;
	}

	@Override
	public List<AbstractNode> getActiveNodesForNewInput(String input) {
		List<AbstractNode> newActiveNodes = new ArrayList<AbstractNode>();
		for (AbstractNode n: activeNodes) {
			for (AbstractEdge e: n.getEdges()) {
				if (e.getLiteral().equals(input)){
					newActiveNodes.add(e.getTargetNode());
				}
			}
		}
		activeNodes = newActiveNodes;
		return activeNodes;
	}

	@Override
	public AbstractNode createNode(String name) {
		for (AbstractNode n: nodes) {
			if (n.getName().equals(name)){
				return null;
			}
		}
		nodes.add(new Node(name));
		return nodes.get(nodes.size()-1);
	}

	@Override
	public AbstractEdge createEdge(String node, String targetNode, String lit) {
		for (AbstractNode n: nodes) {
			for (AbstractNode target: nodes) {
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

}
