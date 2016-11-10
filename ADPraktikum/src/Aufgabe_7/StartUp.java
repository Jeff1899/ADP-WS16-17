
public class StartUp {

	public static void main(String[] args) {
		int rows = 10;
		int columns = 11;

		double[][] m = new double[rows][columns];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
				m[r][c] = r + c;

		Gauss.solve(m);
		MatrixOps.p(m);
	}

}
