public class P7_19 {

	static final String
		FULL = "@@",
		EMPTY = "  ",
		HALF_BOT = "..",
		HALF_TOP = "''";


	public static void main (String[] args) {

		Function f = x -> 2.4 * Math.sin (x); // this is the book's function

		/* this program can graph other functions. here are some examples: */
		//f = x -> 1 / x;
		//f = x -> Math.sqrt (x);
		//f = x -> Math.pow (x, 2) / (x - 6);
		//f = x -> { if (x < 1) return x; else return 0.1 * Math.pow (Math.E, x); };

		int plotSizeX = 100; // plot size in terms of character things, not the actual numeric value
		int plotSizeY = 50;
		double scale = 0.1; // how much one character thing is

		graph (f, scale, plotSizeX, plotSizeY);

	}

	interface Function {
		double eval (double x);
	}

	// scale is width per pixel
	public static void graph (Function f, double scale, int width, int height) {

		int halfHeight = height / 2;
		int halfWidth = width / 2;

		for (int h = halfHeight; h > -halfHeight; h--) {

			System.out.println (getRow (f, scale, -halfWidth * scale, halfWidth * scale, h * scale));

		}
	}

	// graphs function from x=a to x=b and y=a to y=b
	public static String getRow (Function f, double scale, double a, double b, double c) {

		StringBuilder row = new StringBuilder ();

		double halfScale = scale / 2;

		for (double x = a; x < b; x += scale) {

			double y;

			try { y = f.eval (x - halfScale); }

			catch (ArithmeticException e) { row.append (EMPTY); continue; }

			if (Double.isNaN (y)) { row.append (EMPTY); continue; }

			// not abs
			double dif = (y > 0) ? y - c : c - y;

			if (dif >= halfScale && dif <= Math.abs (y)) row.append (FULL);
			else if (dif <= 0 || dif >= Math.abs (y)) row.append (EMPTY);
			else row.append ((y > 0) ? HALF_BOT : HALF_TOP);

		}

		return row.toString ();

	}

}
