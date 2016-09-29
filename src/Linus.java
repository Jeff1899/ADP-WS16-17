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
	 * VB: value.length > 0
	 * VB: size() < 10
	 * NB: contains(String value) == true
	 * NB: !isEmpty()
	 * NB: Festhalten, dass sich die groesse des Puffers aendert?
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn erfolgreich. false, wenn erfolglos.
	 */
	public boolean push(String value);
	
	/**
	 * Entnimmt erstes Objekt aus Puffer
	 * VB: size() > 0
	 * NB: String != null
	 * @return 			Der naechste gepufferte Prozess.
	 */
	public String pop();

	//TODO brauchen wir noch eine Funktion wie pop ohne dass der Wert verschwindet?
	
	/**
	 * Entfernt einen Werten von der angegeben Position des Puffers
	 * TODO Wie sollen wir an die pos kommen?? Wird die Funktion benoetigt??
	 * @param pos 		Die Position des zu loeschenden Wertes
	 * @return 			true, wenn erfolgreich. false, wenn erfolglos.
	 */
	public boolean remove(int pos);
	
	/**
	 * Prueft ob ein Wert im Puffer vorhanden ist.
	 * NB: contains(String value) != null
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn vorhanden. false, wenn nicht vorhanden.
	 */
	public boolean contains(String value);
	
	/**
	 * Gibt die aktuelle Groesse des Puffers zurueck
	 * NB: size() <= 10
	 * NB: size() >= 0
	 * @return 			Die aktuelle Groesse des Puffers.
	 */
	public int size();
	
	/**
	 * Prueft ob der Puffer leer ist
	 * NB: isEmpty() != null
	 * @return    		true, wenn Puffer leer, also size()=0. false, wenn size()>0.
	 */
	public boolean isEmpty();
	
}
