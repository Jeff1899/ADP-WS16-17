package Aufgabe_6;

public class STree {
	public STree left;
	public STree right;

	public int level;
	public int size;
	
	public STree() {
		this.level = 0;
	}

	public void randomAdd(STree t) {
		t.level++;
		if (Math.random() < 0.5) {
			if (left != null) {
				left.randomAdd(t);
			} else {
				left = t;
			}
		} else {
			if (right != null) {
				right.randomAdd(t);
			} else {
				right = t;
			}
		}
	}

	public boolean randomRemove() {
		// 1. Fall: Der Baum hat nur ein linkes Kind
		if (left != null && right == null) {
			if (left.hasChild()) {
				return left.randomRemove();
			} else {
				left = null;
				return true;
			}
		}

		// 2. Fall: Der Baum hat nur ein rechtes Kind
		if (left == null && right != null) {
			if (right.hasChild()) {
				return right.randomRemove();
			} else {
				right = null;
				return true;
			}
		}

		// 3. Fall: beide Kinder gleich null darf nicht vorkommen
		if (left == null && right == null) {
			System.out.println("FEHLER 1 !!!!");
			return false;
		}

		// 4. Fall: beide Kinder haben mindestens ein Kind
		if (left.hasChild() && right.hasChild()) {
			if (Math.random() < 0.5) {
				return left.randomRemove();
			} else {
				return right.randomRemove();
			}
		}

		// 5. Fall: nur das linke Kind hat mindestens ein Kind
		if (left.hasChild() && !right.hasChild()) {
			if (Math.random() < 0.5) {
				return left.randomRemove();
			} else {
				right = null;
				return true;
			}
		}

		// 6. Fall: nur das rechte Kind hat mindestens ein Kind
		if (!left.hasChild() && right.hasChild()) {
			if (Math.random() < 0.5) {
				left = null;
				return true;
			} else {
				return right.randomRemove();
			}
		}

		// 7. Fall: kein Kind hat selber Kinder
		if (!left.hasChild() && !right.hasChild()) {
			if (Math.random() < 0.5) {
				left = null;
				return true;
			} else {
				right = null;
				return true;
			}
		}

		// Darf nicht erreicht werden!
		System.out.println("FEHLER 2 !!!!");
		return false;

	}

	public boolean hasChild() {
		return (left != null || right != null);
	}

}
