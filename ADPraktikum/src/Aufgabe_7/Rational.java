

public class Rational {
	public int zaehler;
	public int nenner;

	public Rational(int zaehler, int nenner) {
		int gcd = gcd(zaehler, nenner);
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
		int neuerZaehler = (zaehler * n.nenner) + (n.zaehler * nenner);
		if (neuerZaehler == 0)
			return new Rational(0, 1);
		else
			return new Rational(neuerZaehler, nenner * n.nenner);
	}

	public Rational sub(Rational n) {
		int neuerZaehler = (zaehler * n.nenner) - (n.zaehler * nenner);
		if (neuerZaehler == 0)
			return new Rational(0, 1);
		else
			return new Rational(neuerZaehler, nenner * n.nenner);
	}

	public Rational mul(Rational n) {
		int neuerZaehler = zaehler * n.zaehler;
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
		int neuerZaehler = zaehler * n.nenner;
		if (neuerZaehler == 0)
			return new Rational(0, 1);
		else
			return new Rational(neuerZaehler, nenner * n.zaehler);
	}

	public String toString() {
		if (nenner != 1)
			return zaehler + "/" + nenner;
		else
			return "" + zaehler;

	}

	public int gcd(int n, int m) {
		if (m == 0)
			return n;
		else
			return gcd(m, n % m);
	}
}
