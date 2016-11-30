package ADTs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Jeffrey, Patrick & Soenke
 *
 */
public abstract class AbstractNEA {
	/**
	 * Der StartNode f�r den Nea wird hier abgelegt.
	 */
	protected List<AbstractNode> startNode = new ArrayList<AbstractNode>();
	
	/**
	 * Alle Nodes des NEA's werden hier gespeichert
	 */
	protected List<AbstractNode> nodeList = new ArrayList<AbstractNode>();
	
	/**
	 * 
	 */
	protected List<AbstractNode> active = new ArrayList<AbstractNode>();

	public List<AbstractNode> getStartNode() {
		return startNode;
	}

	public List<AbstractNode> getNodeList() {
		return nodeList;
	}

	public List<AbstractNode> getActive() {
		return active;
	}

	public List<String> getAlphabet() {
		return alphabet;
	}

	protected List<String> alphabet = new ArrayList<>();

	/**
	 * Hier werden die Nodes aus der TerminateList zurueckgegben
	 */
	public abstract List<AbstractNode> getEndNodes();
	
	/**
	 *  Gibt den startNode zurueck
	 */
	public abstract List<AbstractNode> getStartNodes();
	
	/**
	 * Hier wird der StartNode fuer den NEA initialisiert
	 * @param node Node an dem der Nea starten soll
	 * @return True, wenn startNode noch nicht belegt ist sonst false
	 */
	public abstract boolean addStartNode(AbstractNode node);
	
	/**
	 * Hier werden die Nodes bei den der NEA terminiert zur terminateList hinzugefuegt.
	 * @param node Nodes bei dem der NEA termineren kann
	 * @return True, wenn Node hinzugefuegt wurde
	 */
	public abstract boolean addEndNode(AbstractNode node);
	
	/**
	 * Laeuft mit den Input durch den NEA und guckt ob er terminiert oder nicht.
	 * @param input Das Wort welches uebergeben wurde
	 * @return True, wenn er auf einem terminateNode zum Ende kommt sonst false.
	 */
	public abstract List<AbstractNode> getActiveNodesForNewInput(String input);
	
	/**
	 * Erstellt einen neuen Node fuer den NEA
	 * @param name Bezeichnung des NEA
	 * @return Gibt den Node zurueck, sofern der Name nicht belegt ist sonst null
	 */
	public abstract AbstractNode createNode(String name);
	
	/**
	 * Fuegt ein einzelnes Literal zum Alphabet des NEA hinzu.
	 * @param node Startknoten
	 * @param targetNode Zielknoten
	 * @param lit Einzelnes Literal
	 */
	public abstract AbstractEdge createEdge(String node, String targetNode, String lit);
}
