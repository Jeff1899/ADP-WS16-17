/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 */

package Puffer.Implementations.OwnLinkedListImpl;

public class ConsZelle {
	public ConsZelle next;
	public ConsZelle prev;
	private String value;

	public ConsZelle(String value) {
		this.value = value;
	}

	public ConsZelle(String value, ConsZelle next, ConsZelle prev) {
		this.next = next;
		this.prev = prev;
		this.value = value;
	}

	// public ConsZelle getNext() {
	// return next;
	// }
	//
	// public void setNext(ConsZelle newNext) {
	// next = newNext;
	// }
	//
	// public ConsZelle getPrev() {
	// return prev;
	// }
	//
	// public void setPrev(ConsZelle newPrev) {
	// prev = newPrev;
	// }

	public String getValue() {
		return value;
	}
}
