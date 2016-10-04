import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
/**
 * 
 * @author Patrick & Jeffrey
 *
 */
public class PufferTest {
	
	PufferLinkedList puffer = new PufferLinkedList();
	private static String TEST_PUFFER_1 = "TEST_1";
	private static String TEST_PUFFER_2 = "TEST_2";
	private static String TEST_PUFFER_3 = "TEST_3";
	
	/**
	 * Testet ob Objekte bis zur Pufferbeschraenkung hinzugefuegt werden.
	 */
	@Test
	public void testPrivate_Push(){
		
		for(int i = 0; i < 10; i++){
			assertTrue(puffer.private_push("" + i));
		}
		assertFalse(puffer.private_push("11"));
	}
	/**
	 * Testet das Entfernen von Objekten aus dem Puffer, sofern Objekte vorhanden sind.
	 */
	@Test
	public void testPrivate_Pop(){
		System.out.println(puffer.private_pop());
		assertTrue(puffer.private_pop() == null);
		puffer.push(TEST_PUFFER_1);
		puffer.push(TEST_PUFFER_2);
		puffer.push(TEST_PUFFER_3);
		
		assertTrue(puffer.private_pop().equals(TEST_PUFFER_1));
		assertTrue(puffer.private_pop().equals(TEST_PUFFER_2));
		assertTrue(puffer.private_pop().equals(TEST_PUFFER_3));
		
		assertTrue(puffer.private_pop() == null);	
	}
	
	/**
	 * Testet das Entnehmen von Objekten aus dem Puffer ohne sie aus ihm zu entfernen.
	 */
	@Test
	public void testPrivate_Peek(){
		assertTrue(puffer.private_peek() == null);
		puffer.push(TEST_PUFFER_1);
		puffer.push(TEST_PUFFER_2);
		puffer.push(TEST_PUFFER_3);
		
		assertTrue(puffer.private_peek().equals(TEST_PUFFER_1));
		assertTrue(puffer.private_peek().equals(TEST_PUFFER_1));
		
		assertTrue(puffer.size() == 3);	
	}
	
	/**
	 * Testet ob hinzugef�gte Objekte auch wirklich im Puffer sind
	 */
	@Test
	public void testPrivate_Contains(){	
		assertFalse(puffer.private_contains(TEST_PUFFER_1));
		puffer.push(TEST_PUFFER_1);
		assertTrue(puffer.private_contains(TEST_PUFFER_1));
	}

	/**
	 * Testet die Gr��e des Puffers
	 */
	@Test
	public void testPrivate_Size(){		
		assertTrue(puffer.private_size() == 0);
		for(int i = 0; i < 11; i++){
			puffer.private_push("" + i);
		}
		assertTrue(puffer.private_size() == 10);
		
		for(int i = 10; i > 5 ; i--){
			puffer.private_pop();
		}
		assertTrue(puffer.private_size() == 5);
		
		
	}
	
	/**
	 * Testet ob der Puffer leer ist bzw. nicht leer ist.
	 */
	@Test
	public void testPrivate_isEmpty(){		
		assertTrue(puffer.private_isEmpty());
		puffer.push(TEST_PUFFER_1);
		assertFalse(puffer.private_isEmpty());
		}
}
