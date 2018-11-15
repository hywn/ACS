import java.util.Random;

public class E7_1 {

	public static void main (String[] args) {

		int SIZE = 10;

		int[] values = new Random ().ints (SIZE).toArray ();

		for (int i = 0; i < SIZE; i++) if (i % 2 == 0) System.out.print (values[i] + " ");

		System.out.println ();

		for (int v : values) if (v % 2 == 0) System.out.print (v + " ");

		System.out.println ();

		for (int i = SIZE - 1; i >= 0; i--) System.out.print (values[i] + " ");

		System.out.println ();

		System.out.println (values[0] + " " + values[SIZE - 1]);

	}

}
