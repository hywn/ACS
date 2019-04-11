import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Reverse {

	public static void main (String[] args) {

		PrintStream o = System.out;
		Scanner s = new Scanner (System.in);

		o.print ("Enter integer: ");
		int size = s.nextInt ();

		int[] array = new int[size];

		for (int i = 0; i < size; i++) {
			o.printf ("Enter integer #%d: ", i + 1);
			array[i] = s.nextInt ();
		}

		for (int i = 0; i < size / 2; i++) {
			int temp = array[i];
			array[i] = array[size - 1 - i];
			array[size - 1 - i] = temp;
		}

		o.print (Arrays.toString (array));

	}

}