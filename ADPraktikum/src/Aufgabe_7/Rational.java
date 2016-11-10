package Aufgabe_7;

public class Rational {
	public long zaehler;
	public long nenner;

	public Rational(long zaehler, long nenner) {
		long gcd = gcd(zaehler, nenner);
		this.zaehler = zaehler / gcd;
		this.nenner = nenner / gcd;
		if (this.nenner < 0) {
			this.zaehler = -this.zaehler;
			this.nenner = -this.nenner;
		}
	}

	public Rational(int zaehler) {
		this.zaehler = zaehler;
		this.nenner = 1;
	}

	public Rational add(Rational n) {
		long neuerZaehler = (zaehler * n.nenner) + (n.zaehler * nenner);
		if (neuerZaehler == 0)
			return new Rational(0, 1);
		else
			return new Rational(neuerZaehler, nenner * n.nenner);
	}

	public Rational sub(Rational n) {
		long neuerZaehler = (zaehler * n.nenner) - (n.zaehler * nenner);
		if (neuerZaehler == 0)
			return new Rational(0, 1);
		else
			return new Rational(neuerZaehler, nenner * n.nenner);
	}

	public Rational mul(Rational n) {
		long neuerZaehler = zaehler * n.zaehler;
		if (neuerZaehler == 0)
			return new Rational(0, 1);
		else
			return new Rational(zaehler * n.zaehler, nenner * n.nenner);
	}

	public Rational div(Rational n) {
		if (n.nenner == 0) {
			System.out.println("Division by Zero");
			System.exit(1);
		}
		long neuerZaehler = zaehler * n.nenner;
		if (neuerZaehler == 0)
			return new Rational(0, 1);
		else
			return new Rational(neuerZaehler, nenner * n.zaehler);
	}

	public boolean naught() {
		if (zaehler == 0)
			return true;
		else
			return false;
	}

	public String toString() {
		if (nenner != 1)
			return zaehler + "/" + nenner;
		else
			return "" + zaehler;

	}

	public long gcd(long n, long m) {
		if (m == 0)
			return n;
		else
			return gcd(m, n % m);
	}
}
