public class P10_2 {

	public static void main (String[] args) {


		PrimeSequence s = new PrimeSequence ();

		for (int i = 0; i < 10; i++)
			System.out.println (s.next ());


	}

	interface Sequence {
		long next ();
	}

	public static class PrimeSequence implements Sequence {

		long n = 1;

		public long next () {

			// not sure if this is very good
			while (!isPrime (++n)) {}

			return n;

		}

		private boolean isPrime (long n) {

			for (long i = 2; i < n; i++) {

				if (n % i == 0) return false;

			}

			return true;

		}

	}

}
