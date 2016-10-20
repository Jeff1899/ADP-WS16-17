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
	 * Der StartNode für den Nea wird hier abgelegt.
	 */
	private AbstractNode startNode = null;
	
	/**
	 * Alle Nodes des NEA's werden hier gespeichert
	 */
	protected List<AbstractNode> nodeList = new ArrayList<>();
	
	/**
	 * 
	 */
	protected List<String> alphabet = new ArrayList<>();
	
	/**
	 *  Gibt den startNode zurück
	 */
	public abstract AbstractNode getStartNode();
	
	/**
	 * Hier werden die Nodes aus der TerminateList zurückgegben
	 */
	public abstract AbstractNode getEndNode();
	
	/**
	 * Hier wird der StartNode für den NEA initialisiert
	 * @param node Node an dem der Nea starten soll
	 * @return True, wenn startNode noch nicht belegt ist sonst false
	 */
	public abstract boolean setStartNode(AbstractNode node);
	
	/**
	 * Hier werden die Nodes bei den der NEA terminiert zur terminateList hinzugefügt.
	 * @param node Nodes bei dem der NEA termineren kann
	 * @return True, wenn Node hinzugefügt wurde
	 */
	public abstract boolean setEndNode(AbstractNode node);
	
	/**
	 * Läuft mit den Input durch den NEA und guckt ob er terminiert oder nicht.
	 * @param input Das Wort welches übergeben wurde
	 * @return True, wenn er auf einem terminateNode zum Ende kommt sonst false.
	 */
	public abstract boolean checkInput(String input);
	
	/**
	 * Erstellt einen neuen Node für den NEA
	 * @param name Bezeichnung des NEA
	 * @return Gibt den NEA zurück, sofern der Name nicht belegt ist sonst null
	 */
	public abstract AbstractNode createNode(String name);
	
	/**
	 * Fügt ein einzelnes Literal zum Alphabet des NEA hinzu.
	 * @param lit Einzelnes Literal
	 */
	public abstract void addLiteralToAlphabet(String lit);
	
	/**
	 * Fügt eine Liste von literalen zum Alphabet des NEA hinzu
	 * @param list Liste mit Literalen
	 */
	public abstract void addListToAlphabet(List<String> list);
	
}
