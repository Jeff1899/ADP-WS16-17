package Puffer;

import java.util.concurrent.TimeUnit;

import Puffer.Implementations.ArrayPuffer;
import Puffer.Implementations.OwnLinkedListImpl.LinkedListPuffer;

/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 */
public class benchmark {

	public static void main(String[] args) {
		int maxPufferSize = 100000;
		Puffer testPuffer;

		testPuffer = new ArrayPuffer(maxPufferSize);
		benchmarkPuffer(testPuffer, maxPufferSize);

		testPuffer = new LinkedListPuffer(maxPufferSize);
		benchmarkPuffer(testPuffer, maxPufferSize);

	}

	private static void benchmarkPuffer(Puffer puffer, int maxPufferSize) {
		long start = System.nanoTime();

		for (int j = 0; j < 1; j++) {
			for (int i = 0; i < maxPufferSize; i++)
				puffer.push("" + i);
			
			for (int i = 0; i < maxPufferSize; i++)
				if (!puffer.contains("" + i))
					System.out.println("Fehler!");
			
			// String val;
			for (int i = 0; i < maxPufferSize; i++) {
				puffer.pop();
				// val = puffer.pop();
				// if (!val.equals("" + i))
				// System.out.println(val + " - " + i);
			}

		}

		long end = System.nanoTime();
		long runningTime = end - start;

		System.out.println(TimeUnit.MILLISECONDS.convert(runningTime, TimeUnit.NANOSECONDS));
	}

}
