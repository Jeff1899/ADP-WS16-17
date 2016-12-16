package Aufgabe_12;

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

		// Double-Matrix des umgewandelten LGS aus der ausgearbeiteten Simuation: doc/urlaubsSimulation.doc
		double[][] n = { { 0, 0.3, 0.2 }, { 0.5, 0, 0.3 }, { 0.5, 0.7, 0.5 } };
		
		
		// Rationale-Matrix des umgewandelten LGS aus der ausgearbeiteten Simuation: doc/urlaubsSimulation.doc
//		Rational[][] r = { { new Rational(0), new Rational(3, 10), new Rational(2, 10) },
//				{ new Rational(1, 2), new Rational(0), new Rational(3, 10)},
//				{ new Rational(1, 2), new Rational(7, 10), new Rational(1, 2) } };

		Gauss.solve(r);
		MatrixOps.p(r);
	}

}
