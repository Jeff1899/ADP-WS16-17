package console;

import Nea.Nea;
import Nea.NeaEdge;
import Nea.NeaNode;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create NEA
		Nea nea = new Nea();
		//Create Nodes
		NeaNode nodeA = (NeaNode) nea.createNode("A");
		NeaNode nodeB = (NeaNode) nea.createNode("B");
		NeaNode nodeC = (NeaNode) nea.createNode("C");
		
		// Init NEA
		nea.setStartNode(nodeA);
		nea.setEndNode(nodeC);
		
		// ADD EDGES
		nea.getStartNode().addEdge(new NeaEdge(nodeB,"1"));
		nodeB.addEdge( new NeaEdge(nodeC,"0"));
	}

}
