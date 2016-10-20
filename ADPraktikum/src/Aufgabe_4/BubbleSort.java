package Aufgabe_4;

public class BubbleSort implements SortAlgorithm {

	public void sort(Comparable[] a) {
		int n = a.length;
		boolean bSwap;
		Comparable swap;
		do {
			bSwap = false;

			for (int i = 0; i < n - 1; i++) {
				if (a[i + 1].compareTo(a[i]) < 0) {
					swap = a[i];
					a[i] = a[i + 1];
					a[i + 1] = swap;

					bSwap = true;
				}
			}
			n--;
		} while (bSwap && n > 1);
	}
	
	public String toString() {
		return "Bubble";
	}

}
