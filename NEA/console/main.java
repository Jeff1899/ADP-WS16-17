package console;

import Nea.Nea;
import Nea.NeaEdge;
import Nea.NeaNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		Map<NeaEdge, String> edges = new HashMap<NeaEdge, String>();
		List<NeaNode> nodes = new ArrayList<NeaNode>();
		List<NeaNode> targets = new ArrayList<NeaNode>();
		nodes.add(new NeaNode("A"));
		nodes.add(new NeaNode("B"));
		nodes.add(new NeaNode("C"));
		nodes.add(new NeaNode("D"));
		edges.put(new NeaEdge(nodes.get(1), "0"), "A");
		edges.put(new NeaEdge(nodes.get(2), "0"), "B");
		edges.put(new NeaEdge(nodes.get(3), "0"), "C");
		edges.put(new NeaEdge(nodes.get(0), "1"), "D");
		targets.add(nodes.get(3));
		Nea s = createNEA(edges, nodes, nodes.get(0), targets);
		Nea p = createNEA(edges, nodes, nodes.get(0), targets);

		List<List<String>> lAs = getAplhabet(s);
		List<List<String>> lAp = getAplhabet(p);

		boolean b = istUntermenge(lAs, lAp);

		System.out.println("L(As) ist die Obermenge von L(Ap) : " + b);
	}

	/**
	 * Prüft ob alle Unterlisten von lAp in lAs enthalten sind.
	 * @param lAs
	 * @param lAp
	 * @return true wenn lAp eine Untermenge von lAs ist.
	 */
	private static boolean istUntermenge(List<List<String>> lAs, List<List<String>> lAp) {
		return false;
	}

	/**
	 * Erzeugt eine Liste, die eine Liste von Strings hält.
	 * Jeder Eintrag in der Gesamtliste beschreibt eine mögliche Kombinationsfolgen von Literalen,
	 * die zu einem Target führen.
	 * @param s
	 * @return das Alphabet von dem übergebenen Nea.
	 */
	private static List<List<String>> getAplhabet(Nea s) {
		return null;
	}

	/**
	 * erzeugt einen Nea
	 * @param edges
	 * @param nodes
	 * @param start
	 * @param targets
	 * @return
	 */
	private static Nea createNEA(Map<NeaEdge, String> edges, List<NeaNode> nodes, NeaNode start, List<NeaNode> targets) {
		Nea nea = new Nea();
		for (NeaNode n : nodes) {
			nea.createNode(n.getName());
		}
		nea.setStartNode(start);
		for (NeaNode n:targets) {
			nea.setEndNode(n);
		}
		for (Map.Entry<NeaEdge, String> entry: edges.entrySet()) {
			nea.createEdge(entry.getValue(), entry.getKey().getTargetNode().getName(), entry.getKey().getLiteral());
		}
		return nea;
	}

}
