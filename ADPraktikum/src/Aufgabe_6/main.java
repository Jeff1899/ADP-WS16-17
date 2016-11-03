package Aufgabe_6;

public class main {

	public static void main(String[] args) {
		int numberOfExpiriments = 100;
		int akkumulatorSizes = 0;

		double p = 0.9;
		double q = 0.1;

		for (int i = 0; i < numberOfExpiriments; i++) {
			Generator.createSTree(0.9, 0.1);
		}

		numberOfExpiriments = 0; // TODO Schleifendurchlaeufe wieder hochsetzen
		for (int i = 0; i < numberOfExpiriments; i++) {
			akkumulatorSizes += Generator.createDictionary(100000, 0.9, 0.1).size();
		}
		System.out.println("p = " + p + "   q = " + q + "   average size = "
				+ ((float) akkumulatorSizes / (float) numberOfExpiriments) + "   number of expiriments = "
				+ numberOfExpiriments);
	}

}
