package Nea;

import java.nio.charset.Charset;
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
	private AbstractNode startNode = null;
	
	/**
	 * Alle Nodes des NEA's werden hier gespeichert
	 */
	protected List<AbstractNode> nodeList = new ArrayList<AbstractNode>();
	
	/**
	 * 
	 */
	protected List<AbstractNode> active = new ArrayList<AbstractNode>();
	
	/**
	 *  Gibt den startNode zurueck
	 */
	public abstract AbstractNode getStartNode();
	
	/**
	 * Hier werden die Nodes aus der TerminateList zurueckgegben
	 */
	public abstract AbstractNode getEndNode();
	
	/**
	 * Hier wird der StartNode fuer den NEA initialisiert
	 * @param node Node an dem der Nea starten soll
	 * @return True, wenn startNode noch nicht belegt ist sonst false
	 */
	public abstract boolean setStartNode(AbstractNode node);
	
	/**
	 * Hier werden die Nodes bei den der NEA terminiert zur terminateList hinzugefuegt.
	 * @param node Nodes bei dem der NEA termineren kann
	 * @return True, wenn Node hinzugefuegt wurde
	 */
	public abstract boolean setEndNode(AbstractNode node);
	
	/**
	 * Laeuft mit den Input durch den NEA und guckt ob er terminiert oder nicht.
	 * @param input Das Wort welches uebergeben wurde
	 * @return True, wenn er auf einem terminateNode zum Ende kommt sonst false.
	 */
	public abstract boolean checkInput(String input);
	
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
