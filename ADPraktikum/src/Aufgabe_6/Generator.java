package Aufgabe_6;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Random;

public class Generator {

	private Generator() {
	}

	public static Dictionary<Integer, String> createDictionary(int keyLimit, double p, double q) {
		Dictionary<Integer, String> d = new Hashtable<Integer, String>();
		Random random = new Random();
		LinkedList<Integer> keys = new LinkedList<Integer>();
		Integer key;
		int i;

		boolean added = true;
		key = random.nextInt(keyLimit) + 1;
		d.put(key, Integer.toString(key));
		keys.add(key);

		while (added) {
			added = false;

			if (Math.random() <= p) {
				key = random.nextInt(keyLimit) + 1;
				d.put(key, Integer.toString(key));
				keys.add(key);
				added = true;
			} else {
				if (!d.isEmpty()) {
					i = random.nextInt(keys.size());
					d.remove(keys.get(i));
					keys.remove(i);
				}
				if (Math.random() <= q) {
					if (!d.isEmpty()) {
						i = random.nextInt(keys.size());
						d.remove(keys.get(i));
						keys.remove(i);
					}
				} else {
					key = random.nextInt(keyLimit) + 1;
					d.put(key, Integer.toString(key));
					keys.add(key);
					added = true;
				}
			}
		}
		return d;
	}

	public static STree createSTree(double p, double q) {
		STree t = new STree();
		boolean added = true;
		int size = 0;

		while (added) {
			added = false;

			if (Math.random() <= p) {
				t.randomAdd(new STree());
				size++;
				added = true;

			} else {
				if (size > 0) {
					t.randomRemove();
					size--;

				}
				if (Math.random() <= q) {
					if (size > 0) {
						t.randomRemove();
						size--;

					}
				} else {
					t.randomAdd(new STree());
					size++;

				}
			}
		}
		// System.out.println(size);
		return t;
	}
}
