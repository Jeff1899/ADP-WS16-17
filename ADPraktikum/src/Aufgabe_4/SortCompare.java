package Aufgabe_4;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SortCompare {

	public static void main(String[] args) {

		int[] quantities = { 10, 30, 50, 100, 1000, 5000, 10000, 50000, 100000 };

		SortAlgorithm bubble = new BubbleSort();
		SortAlgorithm insert = new InsertionX();
		SortAlgorithm max = new MaxSort();
		SortAlgorithm merge = new MergeX();

		for (int u = 0; u < quantities.length; u++) {

			testAlgorithm(bubble, quantities[u]);
			testAlgorithm(insert, quantities[u]);
			testAlgorithm(max, quantities[u]);
			testAlgorithm(merge, quantities[u]);

			System.out.println("--------------------");

		}
	}

	private static void testAlgorithm(SortAlgorithm algorithm, int quantity) {
		Integer[] a = new Integer[quantity];

		long start;
		long end;
		long runningTime;

		Random random = new Random();
		for (int v = 0; v < quantity; v++)
			a[v] = random.nextInt(Integer.MAX_VALUE);

		start = System.nanoTime();
		algorithm.sort(a);
		end = System.nanoTime();
		runningTime = end - start;
		System.out.println(algorithm.toString() + " @ " + quantity + " : "
				+ TimeUnit.MICROSECONDS.convert(runningTime, TimeUnit.NANOSECONDS));

		// System.out.println();
		// for (int x = 0; x < a.length; x++)
		// System.out.println(a[x]);
		// System.out.println();
	}
}
