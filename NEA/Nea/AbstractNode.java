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
	 * F�gt ausgehende Edges zu dieser Node hinzu.
	 * @param edge
	 */
	public abstract void addEdge(AbstractEdge edge);


	/**
	 * Gibt den Namen zurueck
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	
}
