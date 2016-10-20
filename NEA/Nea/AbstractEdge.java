package Nea;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEdge {
	
	/**
	 * Ziel Node dieser Edge
	 */
	private AbstractNode targetNode;
	
	/**
	 * Enthält alle Literale dieser Edge
	 */
	protected List<String> literalList = new ArrayList<String>();
	
	/**
	 * Erstellt eine Edge mit dem Ziel und einem literal
	 * @param nodeB Node zu dem die Kante verläuft 
	 * @param string Litereal für diese Kante
	 */
	public AbstractEdge(NeaNode nodeB, String string) {
	}
	
	/**
	 * Fügt weitere Literale zur literalList hinzu.
	 */
	public abstract void addLiteral();
	
	


}
