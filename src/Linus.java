/**
 * FIFO Puffer
 */
public interface Linus {

	/**
	 * Maximale Puffer groesse
	 */
	public final static int MAX_PUFFER = 10;

	/**
	 * Fuegt einen neuen Wert am Ende des Puffers hinzu
	 * @require value.length > 0
	 * @require size() < 10
	 * @ensure contains(String value) == true
	 * @ensure !isEmpty()
	 * @ensure Festhalten, dass sich die groesse des Puffers aendert?
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn erfolgreich. false, wenn erfolglos.
	 */
	public abstract boolean push(String value);

	/**
	 * Entnimmt erstes Objekt aus Puffer
	 * @require size() > 0
	 * @ensure String != null
	 * @return 			Der naechste gepufferte Prozess.
	 */
	public abstract String pop();

	//TODO brauchen wir noch eine Funktion wie pop ohne dass der Wert verschwindet?

	/**
	 * Entfernt einen Werten von der angegeben Position des Puffers
	 * TODO Wie sollen wir an die pos kommen?? Wird die Funktion benoetigt??
	 * @param pos 		Die Position des zu loeschenden Wertes
	 * @return 			true, wenn erfolgreich. false, wenn erfolglos.
	 */
	public abstract boolean remove(int pos);

	/**
	 * Prueft ob ein Wert im Puffer vorhanden ist.
	 * @ensure contains(String value) != null
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn vorhanden. false, wenn nicht vorhanden.
	 */
	public abstract boolean contains(String value);

	/**
	 * Gibt die aktuelle Groesse des Puffers zurueck
	 * @ensure size() <= 10
	 * @ensure size() >= 0
	 * @return 			Die aktuelle Groesse des Puffers.
	 */
	public abstract int size();

	/**
	 * Prueft ob der Puffer leer ist
	 * @ensure isEmpty() != null
	 * @return    		true, wenn Puffer leer, also size()=0. false, wenn size()>0.
	 */
	public abstract boolean isEmpty();
	
}
