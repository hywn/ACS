import java.util.Arrays;

public class E7_10 {

	public static void main (String[] args) {

		int[] s5 = { 1, 2, 3, 4, 5 };

		// a
		test ("A", s5, a -> a.swapFirstAndLast (), 5, 2, 3, 4, 1);

		// b
		test ("B", s5, a -> a.shiftRight (), 5, 1, 2, 3, 4);

		// c
		test ("C", s5, a -> a.evensToZero (), 1, 0, 3, 0, 5);

		// d
		test ("D", s5, a -> a.neighbor (), 1, 3, 4, 5, 5);

		// e
		test ("E", s5, a -> a.removeMiddle (), 1, 2, 4, 5);
		test ("E", new int[] { 1, 2, 3, 4 }, a -> a.removeMiddle (), 1, 4);

		// f
		test ("F", s5, a -> a.moveEvensToFront (), 2, 4, 1, 3, 5);

		// g
		test ("G", s5, a -> System.out.println (a.getSecondMax ()), "4");

		// h
		test ("H", s5, a -> System.out.println (a.isSortedAscending ()), "true");
		test ("H", new int[] { 2, 1, 3, 4, 5 }, a -> System.out.println (a.isSortedAscending ()), "false");

		// i
		test ("I", s5, a -> System.out.println (a.hasAdjDuplicates ()), "false");
		test ("I", new int[] { 1, 2, 2, 4, 5 }, a -> System.out.println (a.hasAdjDuplicates ()), "true");

		// j
		test ("J", s5, a -> System.out.println (a.hasDuplicates ()), "false");
		test ("J", new int[] { 1, 2, 3, 4, 2 }, a -> System.out.println (a.hasDuplicates ()), "true");


	}

	interface Tester {
		void run (ArrayMethods a);
	}

	static void test (String name, int[] values, Tester test, String expected) {

		ArrayMethods a = test (name, values, test);
		System.out.printf ("Expected: %s%n%n", expected);

	}

	static void test (String name, int[] values, Tester test, int... expected) {

		ArrayMethods a = test (name, values, test); print (a);
		System.out.printf ("Expected: %s%n%n", Arrays.toString (expected));

	}

	static ArrayMethods test (String name, int[] values, Tester test) {

		System.out.printf ("Test %s with array %s%n", name, Arrays.toString (values));
		ArrayMethods a = new ArrayMethods (Arrays.copyOf (values, values.length));
		test.run (a);
		return a;

	}

	static void print (ArrayMethods a) { System.out.println (Arrays.toString (a.getArray ())); }

	static class ArrayMethods {

		private int[] values;

		public ArrayMethods (int[] values) { this.values = values; }

		void swapFirstAndLast () { swap (values.length - 1, 0); }

		void shiftRight () { move (values.length - 1, 0); }

		void evensToZero () { for (int i = 0; i < values.length; i++) if (values[i] % 2 == 0) values[i] = 0; }

		// order matters but book doesn't specify
		// should it do it once one way and once the other?
		// it wouldn't make much sense though since the final would depend on which way was chosen first
		void neighbor () {

			for (int i = 1; i < values.length - 1; i++) values[i] = Math.max (values[i - 1], values[i + 1]);

		}

		void removeMiddle () {

			int middle = (values.length - 1) / 2;
			int toRemove = 2 - values.length % 2; // 2 if even, 1 if odd

			for (int i = 0; i < toRemove; i++) remove (middle);

		}

		void moveEvensToFront () {

			int evens = 0;

			for (int i = 0; i < values.length; i++) {

				if (values[i] % 2 == 0) {

					move (i, evens);
					evens++;

				}

			}

		}

		int getSecondMax () {

			int[] sorted = getSorted ();

			int max = sorted[sorted.length - 1];

			for (int i = sorted.length - 1; i >= 0; i--) if (sorted[i] < max) return sorted[i];

			return max;

		}

		boolean isSortedAscending () {

			int[] sorted = getSorted ();

			for (int i = 0; i < values.length; i++) if (sorted[i] != values[i]) return false;

			return true;

		}

		boolean hasAdjDuplicates () { return hasAdjDuplicates (values); }

		boolean hasDuplicates () { return hasAdjDuplicates (getSorted ()); }

		boolean hasAdjDuplicates (int[] array) {

			for (int i = 1; i < array.length; i++) if (array[i] == array[i - 1]) return true;

			return false;

		}

		int[] getSorted () {
			int[] sorted = Arrays.copyOf (values, values.length);
			Arrays.sort (sorted);
			return sorted;
		}

		// move num at i to j
		void move (int i, int j) {

			int direction = (j - i) / Math.abs (j - i); // -1 or 1
			for (; direction * i < direction * j; i += direction) swap (i, i + direction);

		}

		void swap (int i, int j) {

			int temp = values[j];

			values[j] = values[i];
			values[i] = temp;

		}

		void remove (int i) {

			move (i, values.length - 1);
			values = Arrays.copyOf (values, values.length - 1);

		}

		int[] getArray () { return values; }

	}

}
