package Puffer;

import static org.junit.Assert.*;
import Puffer.Implementations.ArrayPuffer;
import org.junit.Test;
/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 */
public class PufferTest {

	Puffer puffer = new ArrayPuffer();
	private static String TEST_PUFFER_1 = "TEST_1";
	private static String TEST_PUFFER_2 = "TEST_2";
	private static String TEST_PUFFER_3 = "TEST_3";
	
	/**
	 * Testet ob Objekte bis zur Pufferbeschraenkung hinzugefuegt werden.
	 */
	@Test
	public void testPrivate_Push(){
		
		for(int i = 0; i < 10; i++){
			assertTrue(puffer.push("" + i));
		}
		assertFalse(puffer.push("11"));
	}
	/**
	 * Testet das Entfernen von Objekten aus dem Puffer, sofern Objekte vorhanden sind.
	 */
	@Test
	public void testPrivate_Pop(){
		assertTrue(puffer.pop() == null);

		puffer.push(TEST_PUFFER_1);
		puffer.push(TEST_PUFFER_2);
		puffer.push(TEST_PUFFER_3);
		
		assertTrue(puffer.pop().equals(TEST_PUFFER_1));
		assertTrue(puffer.pop().equals(TEST_PUFFER_2));
		assertTrue(puffer.pop().equals(TEST_PUFFER_3));
		
		assertTrue(puffer.pop() == null);
	}
	
	/**
	 * Testet das Entnehmen von Objekten aus dem Puffer ohne sie aus ihm zu entfernen.
	 */
	@Test
	public void testPrivate_Peek(){
		assertTrue(puffer.peek() == null);
		puffer.push(TEST_PUFFER_1);
		puffer.push(TEST_PUFFER_2);
		puffer.push(TEST_PUFFER_3);
		
		assertTrue(puffer.peek().equals(TEST_PUFFER_1));
		assertTrue(puffer.peek().equals(TEST_PUFFER_1));
		
		assertTrue(puffer.size() == 3);	
	}
	
	/**
	 * Testet ob hinzugefuegte Objekte auch wirklich im Puffer sind
	 */
	@Test
	public void testPrivate_Contains(){		
		assertFalse(puffer.contains(TEST_PUFFER_1));
		puffer.push(TEST_PUFFER_1);
		assertTrue(puffer.contains(TEST_PUFFER_1));
	}

	/**
	 * Testet die Groesse des Puffers
	 */
	@Test
	public void testPrivate_Size(){		
		assertTrue(puffer.size() == 0);
		for(int i = 0; i < 11; i++){
			puffer.push("" + i);
		}
		assertTrue(puffer.size() == 10);
		
		for(int i = 10; i > 5 ; i--){
			puffer.pop();
		}
		assertTrue(puffer.size() == 5);
		
		
	}
	
	/**
	 * Testet ob der Puffer leer ist bzw. nicht leer ist.
	 */
	@Test
	public void testPrivate_isEmpty(){		
		assertTrue(puffer.isEmpty());
		puffer.push(TEST_PUFFER_1);
		assertFalse(puffer.isEmpty());
		}
}
