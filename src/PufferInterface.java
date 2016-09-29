/**
 * FIFO Puffer
 * 
 * Ein zyklischer, beschränkter Puffer nach dem FIFO-Prinzip!
 * 
 *  @author Patrick & Jeffrey
 */
public interface PufferInterface {

	/**
	 * Maximale Puffer groesse
	 */
	public final static int MAX_PUFFER = 10;

	/**
	 * Fuegt einen neuen Wert am Ende des Puffers hinzu
	 * @require !value.isEmpty()
	 * @require size() < MAX_PUFFER
	 * @ensure contains(String value) == true
	 * @ensure !isEmpty()
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn erfolgreich. false, wenn erfolglos.
	 */
	public boolean push(String value);

	/**
	 * Entnimmt erstes Objekt aus Puffer
	 * @require size() > 0
	 * @ensure String != null
	 * @return 			Der naechste gepufferte Prozess.
	 */
	public String pop();

	/**
	 * Entnimmt eine Kopie des ersten Objekt aus dem Puffer
	 * @require size() > 0
	 * @ensure String != null
	 * @return Gibt eine Kopie des ersten Objekts aus dem Puffer zurück
	 */
	public String peek();


	/**
	 * Prueft ob ein Wert im Puffer vorhanden ist.
	 * @param value 	Der Prozess, der gepuffert werden soll.
	 * @return    		true, wenn vorhanden. false, wenn nicht vorhanden.
	 */
	public boolean contains(String value);

	/**
	 * Gibt die aktuelle Groesse des Puffers zurueck
	 * @ensure size() <= 10
	 * @ensure size() >= 0
	 * @return 			Die aktuelle Groesse des Puffers.
	 */
	public int size();

	/**
	 * Prueft ob der Puffer leer ist
	 * @return    		true, wenn Puffer leer, also size()=0. false, wenn size()>0.
	 */
	public boolean isEmpty();
	
}
