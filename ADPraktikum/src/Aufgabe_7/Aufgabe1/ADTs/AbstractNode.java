package ADTs;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractNode {

	/**
	 * Bezeichnung des Nodes
	 */

	private String name;

	private List<AbstractEdge> edges;
	
	/**
	 * Initialisert das Node Objekt
	 * @param name Bezeichnung des Node Objekts
	 */
	public AbstractNode(String name){
		this.edges = new ArrayList<AbstractEdge>();
		this.name = name;
	}
	
	/**
	 * F�gt ausgehende Edges zu dieser Node hinzu.
	 * @param edge
	 */
	public void addEdge(AbstractEdge edge){ edges.add(edge); }


	/**
	 * Gibt den Namen zurueck
	 * @return name
	 */
	public String getName() {
		return name;
	}


    public List<AbstractEdge> getEdges(){return edges;}
}
