package Aufgabe_6;

public class main {
	private static int akkuPathlengths;
	private static int maxPathlength;
	private static int minPathlength;
	private static int leaves;

	public static void main(String[] args) {
		int numberOfExpiriments = 100;
		int akkumulatorSizes = 0;

		double p = 0.9;
		double q = 0.1;

		STree t;
		for (int i = 0; i < numberOfExpiriments; i++) {
			t = Generator.createSTree(0.9, 0.1);
			akkuPathlengths = 0;
			maxPathlength = 0;
			minPathlength = -1;
			leaves = 0;
			checkSTree(t);
			System.out.println(
					"average path length = " + ((double) akkuPathlengths / (double) leaves) + "   max path length = "
							+ maxPathlength + "   min path length = " + minPathlength + "   number leaves = " + leaves);
			System.out.println();
		}

		numberOfExpiriments = 0; // TODO Schleifendurchlaeufe wieder hochsetzen
		for (int i = 0; i < numberOfExpiriments; i++) {
			akkumulatorSizes += Generator.createDictionary(100000, 0.9, 0.1).size();
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
