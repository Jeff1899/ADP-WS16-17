package Aufgabe_7;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class TestGauss {

	@Test
	public void testRational() {
		Random random = new Random();
		int rows = 10;// random.nextInt(1000) + 1;
		int colums = rows + 1;

		Rational[] res = new Rational[rows];

		Rational[][] matrix = new Rational[rows][colums];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < colums; c++)
				matrix[r][c] = new Rational(0);

		int zaehler;
		int nenner;
		for (int r = 0; r < rows; r++) {
			matrix[r][r] = new Rational(1);

			zaehler = (random.nextInt(10) + 1) * (random.nextInt(1) == 1 ? 1 : -1);
			nenner = random.nextInt(10) + 1;

			matrix[r][colums - 1] = new Rational(zaehler, nenner);
			res[r] = new Rational(zaehler, nenner);
		}

		MatrixOps.p(matrix);
		System.out.println();

		for (int i = 0; i < 25; i++) {
			MatrixOps.addRows(random.nextInt(rows), random.nextInt(rows),
					new Rational((random.nextInt(5) + 1) * (random.nextInt(1) == 1 ? 1 : -1), random.nextInt(5) + 1),
					matrix);
		}

		MatrixOps.p(matrix);

		Gauss.solve(matrix);

		for (int r = 0; r < rows; r++) {
			assertTrue(matrix[r][colums - 1].sub(res[r]).naught());
		}
	}

	@Test
	public void testDouble() {
		Random random = new Random();
		int rows = 10;// random.nextInt(1000) + 1;
		int colums = rows + 1;

		double[] res = new double[rows];

		double[][] matrix = new double[rows][colums];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < colums; c++)
				matrix[r][c] = 0;

		double n;
		for (int r = 0; r < rows; r++) {
			matrix[r][r] = 1;

			n = ((double) random.nextInt(100) / 10.0) * (random.nextInt(1) == 1 ? 1 : -1);

			matrix[r][colums - 1] = n;
			res[r] = n;
		}

		// MatrixOps.p(matrix);
		System.out.println();

		for (int i = 0; i < 5; i++) {
			MatrixOps.addRows(random.nextInt(rows), random.nextInt(rows),
					((double) random.nextInt(10) + 1) * (random.nextInt(1) == 1 ? 1 : -1), matrix);
		}

		// MatrixOps.p(matrix);

//		Gauss.solve(matrix);

		for (int r = 0; r < rows; r++) {
			assertTrue(matrix[r][colums - 1] == res[r]);
		}
	}
}
