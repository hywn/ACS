import java.util.Scanner;

public class E4_19 {

	private static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
	
		System.out.print ("Enter your month as a number: ");
	
		int i = scan.nextInt ();
		
		System.out.println (MONTHS[i-1]);
	
	}

}