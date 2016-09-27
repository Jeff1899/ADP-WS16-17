/*
 * FIFO Puffer
 */
public interface Linus {

	/*
	 * Maximale Puffer größe
	 */
	public final static int MAX_PUFFER = 10;
	
	/*
	 * Fügt einen neuen Wert am Ende des Puffers hinzu
	 */
	public boolean push(String value);
	
	/*
	 * Entnimmt erstes Objekt aus Puffer
	 */
	public String pop();
	
	/*
	 * Entfernt einen Werten von der angegeben Position des Puffers
	 */
	public boolean remove(int pos);
	
	/*
	 * Prüft ob ein Wert im Puffer vorhanden ist. 
	 */
	public boolean contains(String value);
	
	/*
	 * Gibt die aktuelle Größe des Puffers zurück
	 */
	public int size();
	
	/*
	 * Prüft ob der Puffer leer ist
	 */
	public boolean isEmpty();
	
}
