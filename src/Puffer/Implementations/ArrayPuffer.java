package Puffer.Implementations;

import Puffer.PufferAbstract;


/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 */
public class ArrayPuffer extends PufferAbstract {
	private String[] puffer;
	private int indexFirst = 1;
	private int indexLast = 0;
	private int size = 0;
	private int maxSize;

	/**
	 * Erzeugt einen Puffer mit einem Array.
	 */
	public ArrayPuffer() {
		this.maxSize = MAX_PUFFER;
		puffer = new String[maxSize];
	}

	public ArrayPuffer(int maxPufferSize) {
		this.maxSize = maxPufferSize;
		puffer = new String[maxSize];
	}

	@Override
	protected boolean private_push(String value) {
		if (size + 1 > maxSize)
			return false;
		size++;
		indexLast++;
		if (indexLast > maxSize - 1)
			indexLast -= maxSize;
		puffer[indexLast] = value;
		return true;
	}

	@Override
	protected String private_pop() {
		if (isEmpty())
			return null;
		String val = puffer[indexFirst];
		indexFirst++;
		if (indexFirst > maxSize - 1)
			indexFirst -= maxSize;
		size--;
		return val;
	}

	@Override
	protected String private_peek() {
		if (size > 0)
			return puffer[indexFirst];
		return null;
	}

	@Override
	protected boolean private_contains(String value) {
		for (int i = 0; i < size; i++) {
			if (puffer[indexFirst + i > maxSize - 1 ? indexFirst + i - maxSize : indexFirst + i].equals(value))
				return true;
		}
		return false;
	}

	@Override
	protected int private_size() {
		return size;
	}

	@Override
	protected boolean private_isEmpty() {
		return size == 0 ? true : false;
	}

}
