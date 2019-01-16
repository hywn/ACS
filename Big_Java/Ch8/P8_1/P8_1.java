public class P8_1 {

	public static void main (String[] args) {

		ComboLock c = new ComboLock (35, 10, 5);

		System.out.println ("Lock open: " + c.open ());

		c.turnRight (35);
		c.turnLeft (2);
		c.turnLeft (3);
		c.turnLeft (5);
		c.turnLeft (15);
		c.turnRight (35);

		System.out.println ("Lock open: " + c.open ());

		c.reset ();

		System.out.println ("Lock open: " + c.open ());

	}

}
