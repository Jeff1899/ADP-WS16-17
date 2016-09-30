/**
 * FIFO Puffer -
 *
 * Ein zyklischer, beschraenkter Puffer nach dem FIFO-Prinzip!
 * Die Vorbedingungenen (@require) und Nachbedingungen (@ensure) werden leider nicht unterstuetzt und sind
 * deshalb direkt im Quellcode nachzugucken.
 *
 *  @author Patrick & Jeffrey
 */
public interface PufferInterface {

	/**
	 * Maximale Puffer-Groesse.
	 */
	public final static int MAX_PUFFER = 10;

	/**
	 * Fuegt einen neuen Wert am Ende des Puffers hinzu.
	 * Laufzeitanforderung: O(1)
	 * @require !value.isEmpty()
	 * @require size() < MAX_PUFFER
	 * @ensure contains(String value) == true
	 * @ensure !isEmpty()
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn erfolgreich. false, wenn erfolglos.
	 */
	public boolean push(String value);

	/**
	 * Entnimmt erstes Objekt aus Puffer.
	 * Laufzeitanforderung: O(1)
	 * @require size() > 0
	 * @ensure String != null
	 * @return 			Der naechste gepufferte Prozess.
	 */
	public String pop();

	/**
	 * Entnimmt eine Kopie des ersten Objekt aus dem Puffer.
	 * Laufzeitanforderung: O(1)
	 * @require size() > 0
	 * @ensure String != null
	 * @return Gibt eine Kopie des ersten Objekts aus dem Puffer zur�ck
	 */
	public String peek();


	/**
	 * Prueft ob ein Wert im Puffer vorhanden ist.
	 * Laufzeitanforderung: O(n)
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn vorhanden. false, wenn nicht vorhanden.
	 */
	public boolean contains(String value);

	/**
	 * Gibt die aktuelle Groesse des Puffers zurueck.
	 * Laufzeitanforderung: O(log(n))
	 * @ensure size() <= 10
	 * @ensure size() >= 0
	 * @return 			Die aktuelle Groesse des Puffers.
	 */
	public int size();

	/**
	 * Prueft ob der Puffer leer ist.
	 * Laufzeitanforderung: O(1)
	 * @return    		true, wenn Puffer leer, also size()=0. false, wenn size()>0.
	 */
	public boolean isEmpty();

}
