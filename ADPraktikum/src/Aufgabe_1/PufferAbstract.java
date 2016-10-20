/**
 * 
 * @author Patrick & Jeffrey
 *
 */
package Aufgabe_1;

public abstract class PufferAbstract implements Puffer {
	
	/**
	 * Maximale Puffer groesse
	 */
	public final static int MAX_PUFFER = 10;
	
	public boolean push(String value) {
		assert ! (!value.isEmpty()): "Kein Wert uebergeben";
		assert ! (size() < MAX_PUFFER) : "Max-Puffer wurde erreicht"; 
		boolean push = private_push(value);
		assert ! (contains(value) == true): "Uebergebener Wert ist nicht im Puffer";
		assert !(!isEmpty()):"Puffer ist leer";
		return push;
	}

	public String pop() {
		assert ! (size() > 0) :"Puffer ist leer!";
		String value = private_pop();
		assert ! (value == null) :"Kein Wert aus Puffer ermittelt";
		return value;
	}

	public String peek() {
		assert ! (size() > 0) :"Puffer ist leer!";
		String value = private_peek();
		assert ! (value == null) :"Kein Wert aus Puffer ermittelt";
		assert ! (size() > 0) :"Puffer ist leer";
		return value;
	}

	public boolean contains(String value) {
		assert ! (value.isEmpty()): "Kein Wert uebergeben";
		boolean contains = private_contains(value);
		return contains;
	}

	public int size() {
		int size = private_size();
		assert ! (size >= 0) :"Wert ist kleiner 0";
		assert ! (size <= MAX_PUFFER) :"Wert ist groesser MAX_PUFFER";
		return size;
	}

	public boolean isEmpty() {
		boolean empty = private_isEmpty();
		return empty;
	}

	
	protected abstract boolean private_push(String value);
	protected abstract String private_pop();
	protected abstract String private_peek();
	protected abstract boolean private_contains(String value);
	protected abstract int private_size();
	protected abstract boolean private_isEmpty();

}
