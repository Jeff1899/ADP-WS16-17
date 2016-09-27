/*
 * FIFO Puffer
 */
public interface Linus {

	/*
	 * Maximale Puffer gr��e
	 */
	public final static int MAX_PUFFER = 10;
	
	/*
	 * F�gt einen neuen Wert am Ende des Puffers hinzu
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
	 * Pr�ft ob ein Wert im Puffer vorhanden ist. 
	 */
	public boolean contains(String value);
	
	/*
	 * Gibt die aktuelle Gr��e des Puffers zur�ck
	 */
	public int size();
	
	/*
	 * Pr�ft ob der Puffer leer ist
	 */
	public boolean isEmpty();
	
}
