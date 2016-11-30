package Aufgabe_7;

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

		double[][] n = { { 1, 1, 0, 30 }, { 0, 1, 0, 20 }, { 2, 0, 1, 50 } };

		Rational[][] r = { { new Rational(1, 1), new Rational(0, 1), new Rational(0, 1), new Rational(10, 1) },
				{ new Rational(0, 1), new Rational(1, 1), new Rational(0, 1), new Rational(20, 1) },
				{ new Rational(0, 1), new Rational(0, 1), new Rational(1, 1), new Rational(30, 1) } };

		Gauss.solve(r);
		MatrixOps.p(r);
	}

}
