import java.util.Scanner;

public class P4_10 {

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
		
		double bal, interest;
		
		System.out.print ("Initial balance: ");
		bal = scan.nextDouble ();
		
		System.out.print ("Annual interest rate in percent: ");
		interest = scan.nextDouble () / 100 / 12;
		
		final String[] ORDINALS = {"first", "second", "third"};
		
		for (int i=0; i<3; i++) {
			
			bal += bal*interest;
			
			System.out.printf ("After %s month:\t%.2f%n", ORDINALS[i], bal);
		
		}
	
	}

}