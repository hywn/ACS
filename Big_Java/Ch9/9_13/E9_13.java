public class E9_13 {

	public static void main (String[] args) {

		BetterRectangle r = new BetterRectangle (10, 20, 5, 10);

		test ("Area: " + r.getArea (), "Area: 50.0");
		test ("Perimeter: " + r.getPerimeter (), "Perimeter: 30.0");

	}

	public static void test (Object obj, String expected) {

		System.out.println (obj);
		System.out.println ("Expected: " + expected);
		System.out.println ("Match: " + obj.toString ().equals (expected));
		System.out.println ();

	}

}
