/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 */

package Puffer.Implementations.OwnLinkedListImpl;

import Puffer.PufferAbstract;

public class LinkedListPuffer extends PufferAbstract {
	private int maxSize;
	private int size = 0;
	private ConsZelle head = new ConsZelle(null, null, null);

	{
		head.next = head;
		head.prev = head;
	}

	public LinkedListPuffer() {
		this.maxSize = MAX_PUFFER;

	}

	public LinkedListPuffer(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	protected boolean private_push(String value) {
		if (size + 1 > maxSize)
			return false;
		size++;
		head.next.prev = new ConsZelle(value, head.next, head);
		head.next = head.next.prev;
		return true;
	}

	@Override
	protected String private_pop() {
		if (isEmpty())
			return null;
		size--;
		String val = head.prev.getValue();
		head.prev = head.prev.prev;
		head.prev.next = head;
		return val;
	}

	@Override
	protected String private_peek() {
		if (isEmpty())
			return null;
		return head.prev.getValue();
	}

	@Override
	protected boolean private_contains(String value) {
		ConsZelle cursor = head.next;
		for (int i = 0; i < size; i++) {
			if (cursor.getValue().equals(value))
				return true;
			cursor = cursor.next;
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
