public class E10_8 {

	public static void main (String[] args) {

		System.out.println ("Max: " +
					Data.max (new String[] { "medium", "longest string", "short" },
						obj -> ((String) obj).length ()));

	}

	interface Measurable {
		double getMeasure ();
	}

	interface Measurer {
		double getMeasure (Object obj);
	}

	public static class Data {

		public static double average (Measurable[] objects) {
			double sum = 0;

			for (Measurable obj : objects) sum += obj.getMeasure ();

			return (objects.length > 0) ? sum / objects.length : 0;
		}

		public static Object max (Object[] objects, Measurer m) {

			Object max = null;
			double measMax = Double.MIN_VALUE;

			for (Object obj : objects)
				if (m.getMeasure (obj) > measMax) {

					measMax = m.getMeasure (obj);
					max = obj;

				}

			return max;

		}

	}

}
