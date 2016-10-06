package Puffer.Implementations.OwnLinkedListImpl;

/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 */
public class ConsZelle {
	public ConsZelle next;
	public ConsZelle prev;
	private String value;

	/**
	 * Erzeugt eine neue Zelle der verketteten Liste mit folgenden Parametern:
	 * @param value Der zu speichernde Wert.
	 */
	public ConsZelle(String value) {
		this.value = value;
	}

	/**
	 * Erzeugt eine neue Zelle der verketteten Liste mit folgenden Parametern:
	 * @param value Der zu speichernde Wert.
	 * @param next Zelle dahinter.
	 * @param prev Zelle davor.
	 */
	public ConsZelle(String value, ConsZelle next, ConsZelle prev) {
		this.next = next;
		this.prev = prev;
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
