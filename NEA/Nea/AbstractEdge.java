package Nea;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractEdge {
	
	/**
	 * Ziel Node dieser Edge
	 */
	private AbstractNode targetNode;
	
	/**
	 * Enthaelt alle Literale dieser Edge
	 */
	protected String literal;
	
	/**
	 * Erstellt eine Edge mit dem Ziel und einem literal
	 * @param nodeB Node zu dem die Kante verl�uft 
	 * @param literal Litereal f�r diese Kante
	 */
	public AbstractEdge(NeaNode nodeB, String literal) {
		this.literal = literal;
		this.targetNode = nodeB;
	}

	/**
	 * getter fuer Zielknoten
	 * @return Zielknoten
	 */
	public AbstractNode getTargetNode() {
		return targetNode;
	}

	/**
	 * getter fuer literal
	 * @return literal
	 */
	public String getLiteral() {
		return literal;
	}
}
