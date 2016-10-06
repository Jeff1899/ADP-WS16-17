package Puffer;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import Puffer.Implementations.ArrayPuffer;
import Puffer.Implementations.LinkedListPuffer;
import Puffer.Implementations.OwnLinkedListImpl.OwnLinkedListPuffer;

/**
 *
 * @author Jeffrey, Patrick & Soenke
 *
 * Misst die geschwindigkeit der Puffer.
 */
public class benchmark {

	public static void main(String[] args) {
		int maxPufferSize = 100000;
		Puffer testPuffer;

		testPuffer = new ArrayPuffer(maxPufferSize);
		benchmarkPuffer(testPuffer, maxPufferSize);

		testPuffer = new LinkedListPuffer(maxPufferSize);
		benchmarkPuffer(testPuffer, maxPufferSize);

		testPuffer = new OwnLinkedListPuffer(maxPufferSize);
		benchmarkPuffer(testPuffer, maxPufferSize);

	}

	private static void benchmarkPuffer(Puffer puffer, int maxPufferSize) {
		long start = System.nanoTime();

		for (int i = 0; i < maxPufferSize; i++)
			puffer.push("" + i);

		for (int i = 0; i < maxPufferSize; i++) {
			puffer.pop();
		}

		long end = System.nanoTime();
		long runningTime = end - start;

		String pufferType = "";
		if (puffer instanceof ArrayPuffer){
			pufferType = "ArrayPuffer";
		} else if (puffer instanceof LinkedListPuffer) {
			pufferType = "LinkedListPuffer";
		} else if (puffer instanceof OwnLinkedListPuffer) {
			pufferType = "OwnLinkedListPuffer";
		}
		System.out.println(pufferType + ": " + TimeUnit.MILLISECONDS.convert(runningTime, TimeUnit.NANOSECONDS));
	}

}
