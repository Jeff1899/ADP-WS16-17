
public class Gauss {

	private Gauss() {
	}

	public static void solve(double[][] m) {
		eliminate(1, m);
		// MatrixOps.p(m);
		// System.out.println();
		// MatrixOps.addRows(1, 0, 1, m);
	}

	private static void eliminate(int diagonalIndex, double[][] m) {
		for (int i = diagonalIndex; i < m.length; i++)
			if (m[i][diagonalIndex] != 0) {
				MatrixOps.addRows(i, diagonalIndex, -m[diagonalIndex][diagonalIndex], m);
			}
	}

	private static double getPivot(double[] row) {
		for (int i = 0; i < row.length - 1; i++)
			if (row[i] != 0)
				return row[i];
		return 0;
	}

}
