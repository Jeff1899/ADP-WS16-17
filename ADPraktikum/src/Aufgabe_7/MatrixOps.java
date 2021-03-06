package Aufgabe_7;

public class MatrixOps {

	private MatrixOps() {
	}

	// Operationen fuer rationale Zahlen

	// m[i][x] = m[i][x] + c * m[j][x] | x = 0 .. m.length
	public static void addRows(int i, int j, Rational c, Rational[][] matrix) {
		for (int x = 0; x < matrix[0].length; x++)
			matrix[i][x] = matrix[i][x].add(matrix[j][x].mul(c));
	}

	// m[x][i] = m[x][i] + c * m[x][j] | x = 0 .. m.length
	public static void addColumns(int i, int j, Rational c, Rational[][] matrix) {
		for (int x = 0; x < matrix.length; x++)
			matrix[x][i] = matrix[x][i].add(matrix[x][j].mul(c));
	}

	public static void swapRows(int i, int j, Rational[][] matrix) {
		Rational val;
		for (int x = 0; x < matrix[0].length; x++) {
			val = matrix[i][x];
			matrix[i][x] = matrix[j][x];
			matrix[j][x] = val;
		}
	}

	public static void p(Rational[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++)
				System.out.printf(matrix[r][c] + " ");
			System.out.println();
		}
	}

	// Operationen fuer Gleitkommazahlen

	// m[i][x] = m[i][x] + c * m[j][x] | x = 0 .. m.length
	public static void addRows(int i, int j, double c, double[][] matrix) {
		for (int x = 0; x < matrix[0].length; x++)
			matrix[i][x] += matrix[j][x] * c;
	}

	// m[x][i] = m[x][i] + c * m[x][j] | x = 0 .. m.length
	public static void addColumns(int i, int j, double c, double[][] matrix) {
		for (int x = 0; x < matrix.length; x++)
			matrix[x][i] += matrix[x][j] * c;
	}

	public static void swapRows(int i, int j, double[][] matrix) {
		double val;
		for (int x = 0; x < matrix[0].length; x++) {
			val = matrix[i][x];
			matrix[i][x] = matrix[j][x];
			matrix[j][x] = val;
		}
	}

	public static void p(double[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++)
				System.out.printf("%7.2f ", matrix[r][c]);
			System.out.println();
		}
	}

}
