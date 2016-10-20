package Nea;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEdge {
	
	/**
	 * Ziel Node dieser Edge
	 */
	private AbstractNode targetNode;
	
	/**
	 * Enth�lt alle Literale dieser Edge
	 */
	protected List<String> literalList = new ArrayList<String>();
	
	/**
	 * Erstellt eine Edge mit dem Ziel und einem literal
	 * @param nodeB Node zu dem die Kante verl�uft 
	 * @param string Litereal f�r diese Kante
	 */
	public AbstractEdge(NeaNode nodeB, String string) {
	}
	
	/**
	 * F�gt weitere Literale zur literalList hinzu.
	 */
	public abstract void addLiteral();
	
	


}
