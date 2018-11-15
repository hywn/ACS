import java.util.Arrays;

public class E7_6 {

	public static void main (String[] args) {

		Integer[] myArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.println (Arrays.toString (reverse (myArray)));

	}

	public static <T> T[] reverse (T[] array) {

		for (int i = 0; i < array.length / 2; i++) {

			T temp = array[i];

			array[i] = array[array.length - 1 - i];

			array[array.length - 1 - i] = temp;

		}

		return array;

	}

}
