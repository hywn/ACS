package Testing;

import java.util.Arrays;

public class Test2 {

	public static void main (String[] args) {

		double[] values = { 8, 7, 8.5, 9.5, 7, 4, 10 };

		Arrays.sort (values);
		double sum = 0;
		for (int i = 1; i < values.length; i++) sum += values[i];

		System.out.println (sum);


	}

}