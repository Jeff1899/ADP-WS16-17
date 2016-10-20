package Nea;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode {
	
	/**
	 * Bezeichnung des Nodes
	 */
	private String name;
	
	/**
	 * Alle Edges die von dieser Node ausgehen
	 */
	private List<AbstractEdge> egdeList = new ArrayList<AbstractEdge>();
	
	/**
	 * Initialisert das Node Objekt
	 * @param name Bezeichnung des Node Objekts
	 */
	public AbstractNode(String name){
		this.name = name;
	}
	
	/**
	 * Fügt ausgehende Edges zu dieser Node hinzu.
	 * @param edge
	 * @return
	 */
	public abstract AbstractNode addEdge(AbstractEdge edge);
	
	
}
