import java.util.Random;

public class StartUp {

	public static void main(String[] args) {
		int rows = 10;
		int columns = 11;

		Random ran = new Random();

		double[][] m = new double[rows][columns];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
				m[r][c] = r + c + ran.nextInt(10);

		double[][] n = { { 1, 1, 0, 30 }, { 0, 1, 0, 20 }, { 0, 0, 1, 30 } };
		Gauss.solve(n);
		// MatrixOps.p(m);
	}

}
