package Aufgabe_4;

public class MaxSort implements SortAlgorithm {

	public void sort(Comparable[] a) {
		int idx;
		Comparable swap;
		for (int i = a.length - 1; i > 0; i--) {
			idx = max(a, i + 1);

			swap = a[i];
			a[i] = a[idx];
			a[idx] = swap;
		}
	}

	private static int max(Comparable[] a, int maxSearchIndex) {
		int idxMax = 0;
		for (int i = 1; i < maxSearchIndex; i++) {
			if (a[idxMax].compareTo(a[i]) < 0) {
				idxMax = i;
			}
		}
		return idxMax;
	}
	
	public String toString() {
		return "MaxSort";
	}
}
