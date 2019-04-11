// ****************************************************************
// Sales.java
//
// Reads in and stores sales for each of 5 salespeople.  Displays
// sales entered by salesperson id and total sales for all salespeople.
//
// ****************************************************************

import java.util.Scanner;

public class Sales {
	public static void main (String[] args) {


		System.out.print ("How many salespeople?: ");

		Scanner keyboard = new Scanner (System.in);
		final int SALESPEOPLE = keyboard.nextInt ();
		int sum = 0;

		int[] sales = new int[SALESPEOPLE];

		for (int i = 0; i < sales.length; i++) {
			System.out.print ("Enter sales for salesperson " + (i + 1) + ": ");
			sales[i] = keyboard.nextInt ();
		}

		System.out.println ("\nSalesperson   Sales");
		System.out.println ("--------------------");

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int max_index = -1, min_index = -1;

		for (int i = 0; i < sales.length; i++) {

			int sale = sales[i];

			System.out.println ("     " + (i + 1) + "         " + sale);

			sum += sale;

			if ((max = Math.max (max, sale)) == sale) max_index = i;
			if ((min = Math.min (min, sale)) == sale) min_index = i;

		}

		System.out.println ("\nTotal sales: $" + sum);
		System.out.printf ("Average sale: $%.2f\n", (double) sum / sales.length);
		System.out.printf ("Max sale: Salesperson %d, $%d\n", max_index + 1, max);
		System.out.printf ("Min sale: Salesperson %d, $%d\n", min_index + 1, min);

	}
}



