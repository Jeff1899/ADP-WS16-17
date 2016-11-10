package Aufgabe_7;

public class Gauss {

	private Gauss() {
	}

	public static void solve(double[][] m) {
		// Stufenform
		for (int i = 0; i < m.length; i++) {
			prepare(i, m);
			eliminate(i, m);
		}

		// Ruecksubstitution
		for (int i = m.length - 1; i > -1; i--)
			reSub(i, m);

		// Ergebnisse ausgeben
		norm(m);
		printRes(m);
	}

	private static void reSub(int diagonalIndex, double[][] m) {
		int indexB = m[0].length - 1;

		// nomalisieren
		m[diagonalIndex][indexB] /= m[diagonalIndex][diagonalIndex];
		m[diagonalIndex][diagonalIndex] = 1;

		int i = diagonalIndex - 1;
		while (i > -1) {

			m[i][indexB] -= m[diagonalIndex][indexB] * m[i][diagonalIndex];
			m[i][diagonalIndex] = 0;
			i--;
		}
	}

	private static void prepare(int diagonalIndex, double[][] m) {
		int indexTop = diagonalIndex;
		int indexBot = m.length - 1;

		while (indexTop < indexBot) {
			while (indexTop < m.length && m[indexTop][diagonalIndex] != 0.0)
				indexTop++;
			while (indexBot > indexTop && m[indexBot][diagonalIndex] == 0.0)
				indexBot--;
			if (indexTop < indexBot) {
				MatrixOps.swapRows(indexTop, indexBot, m);
				indexTop++;
				indexBot--;
			}
		}
	}

	private static void eliminate(int diagonalIndex, double[][] m) {
		for (int i = diagonalIndex + 1; i < m.length; i++)
			if (m[i][diagonalIndex] != 0) {
				MatrixOps.addRows(i, diagonalIndex, -(m[i][diagonalIndex] / m[diagonalIndex][diagonalIndex]), m);
			}
	}

	private static void norm(double[][] m) {
		int indexB = m[0].length - 1;
		for (int i = 0; i < m.length; i++) {
			m[i][indexB] /= m[i][i];
			m[i][i] = 1;
		}
	}

	private static void printRes(double[][] m) {
		int indexB = m[0].length - 1;
		for (int i = 0; i < m.length; i++)
			System.out.println("X" + i + " = " + m[i][indexB]);
	}

}
