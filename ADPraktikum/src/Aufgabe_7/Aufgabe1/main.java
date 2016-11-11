import ADTs.Dea;
import ADTs.Edge;
import ADTs.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

	public static void main(String[] args) {

		Map<ADTs.Edge, String> edges = new HashMap<Edge, String>();
		List<ADTs.Node> nodes = new ArrayList<Node>();
		List<ADTs.Node> targets = new ArrayList<ADTs.Node>();
		List<String> alphabet = new ArrayList<>();
		alphabet.add("0");
		alphabet.add("1");
		nodes.add(new ADTs.Node("A"));
		nodes.add(new ADTs.Node("B"));
		nodes.add(new ADTs.Node("C"));
		nodes.add(new ADTs.Node("D"));
		edges.put(new ADTs.Edge(nodes.get(1), "0"), "A");
		edges.put(new ADTs.Edge(nodes.get(2), "0"), "B");
		edges.put(new ADTs.Edge(nodes.get(3), "0"), "C");
		edges.put(new ADTs.Edge(nodes.get(0), "1"), "D");
		targets.add(nodes.get(3));
		Creator c = new Creator();
		ADTs.Nea s = c.createNea(edges, nodes, nodes.get(0), targets, alphabet);
		s.addStartNode(nodes.get(0));
		ADTs.Nea p = c.createNea(edges, nodes, nodes.get(0), targets, alphabet);
		p.addStartNode(nodes.get(0));

		Dea dea = c.generateDea(s);
		Dea deaKomplement = c.generateDeaKomplement(dea);
		Dea produktautomat = c.generateProduktautomat(p, deaKomplement);


		System.out.println("L(As) ist die Obermenge von L(Ap) : " + c.isATargetReachable(produktautomat));
	}


}
