package Aufgabe_4;

public class rek {

	public static void main(String[] args) {
		long x = 2;
		System.out.println(x + " - ");
		for (int i = 1; i < 20; i++) {
			x = (3 * x) + 2;
			System.out.println(x + " - " + (pow(2 + 1, i) - 1));
		}

	}

	private static long pow(long b, long e) {
		long res = b;
		for (int i = 0; i < e; i++)
			res *= b;
		return res;
	}

	private static long qs(long n) {

		long quersumme = 0;
		while (n > 0) {
			quersumme = quersumme + n % 10;
			n = n / 10;
		}
		return quersumme;
	}

}
