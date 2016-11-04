package Aufgabe_6;

public class main {
	private static int akkuPathlengths;
	private static int maxPathlength;
	private static int minPathlength;
	private static int leaves;

	public static void main(String[] args) {
		int numberOfExpiriments;

		double p = 0.99;
		double q = 0.01;

		double akku = 0.0;
		int akkuMaxLength = 0;
		int akkuMinLength = 0;
		// int akkuLeaves = 0;
		int akkumulatorSizes = 0;

		STree t;
		numberOfExpiriments = 10000;
		for (int i = 0; i < numberOfExpiriments; i++) {
			t = Generator.createSTree(p, q);
			akkuPathlengths = 0;
			maxPathlength = 0;
			minPathlength = -1;
			leaves = 0;
			checkSTree(t);
			// System.out.println(
			// "average path length = " + ((double) akkuPathlengths / (double)
			// leaves) + " max path length = "
			// + maxPathlength + " min path length = " + minPathlength + "
			// number leaves = " + leaves);
			// System.out.println();
			akkumulatorSizes += t.size;
			akku += (double) akkuPathlengths / (double) leaves;
			akkuMaxLength += maxPathlength;
			akkuMinLength += minPathlength;
			// akkuLeaves += leaves;

		}
		System.out.println("p = " + p + "    q = " + q + "   number of expiriments = " + numberOfExpiriments
				+ "    avrge size = " + ((double) akkumulatorSizes / (double) numberOfExpiriments));
		System.out.println("avrge p len = " + ((double) akku / (double) numberOfExpiriments) + " avrge max p len = "
				+ ((double) akkuMaxLength / (double) numberOfExpiriments) + " avrge min p len = "
				+ ((double) akkuMinLength / (double) numberOfExpiriments));
		System.out.println();

		numberOfExpiriments = 0; // TODO Schleifendurchlaeufe wieder hochsetzen
		akkumulatorSizes = 0;
		for (int i = 0; i < numberOfExpiriments; i++) {
			akkumulatorSizes += Generator.createDictionary(100000, p, q).size();
		}
		System.out.println("p = " + p + "   q = " + q + "   average size = "
				+ ((float) akkumulatorSizes / (float) numberOfExpiriments) + "   number of expiriments = "
				+ numberOfExpiriments);

	}

	public static void checkSTree(STree t) {
		if (t.left != null) {
			checkSTree(t.left);
		}
		if (t.right != null) {
			checkSTree(t.right);
		}
		if (t.left == null && t.right == null) {
			akkuPathlengths += t.level;
			leaves++;
			if (t.level > maxPathlength)
				maxPathlength = t.level;
			if (minPathlength == -1 || t.level < minPathlength)
				minPathlength = t.level;
		}
	}

}
