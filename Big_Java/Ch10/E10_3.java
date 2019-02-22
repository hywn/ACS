public class E10_3 {

	public static void main (String[] args) {


		Person sue = new Person ("Sue", 75);
		Person bob = new Person ("Bob", 100);
		Person joe = new Person ("Joe", 50);

		Data.processPeople (sue, bob, joe);

	}

	public static class Person implements Measurable {

		private String name;
		private int height;

		public Person (String name, int height) { this.name = name; this.height = height; }

		public String getName () { return name; }

		@Override
		public double getMeasure () {
			return height;
		}

	}

	interface Measurable {
		double getMeasure ();
	}

	public static class Data {

		public static double average (Measurable[] objects) {
			double sum = 0;

			for (Measurable obj : objects) sum += obj.getMeasure ();

			return (objects.length > 0) ? sum / objects.length : 0;
		}

		public static Measurable max (Measurable[] measures) {

			Measurable max = null;
			double measMax = Double.MIN_VALUE;

			for (Measurable meas : measures)
				if (meas.getMeasure () > measMax) {

					measMax = meas.getMeasure ();
					max = meas;

				}

			return max;
		}

		public static void processPeople (Person... people) {

			System.out.printf ("Tallest person: %s%n", ((Person) max (people)).getName ());
			System.out.printf ("Average height: %f cm%n", average (people));

		}

	}

}
