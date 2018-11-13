import java.util.Scanner;

public class P5_13 {

	private static String[] levels = {"Totally satisfied", "Satisfied", "Dissatisfied"};
	private static double[] tips = {0.2, 0.15, 0.1};

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter bill: ");
		double bill = scan.nextDouble ();
		
		System.out.print ("Enter rating: ");
		int rating = scan.nextInt ();
		
		int index = rating - 1;
		
		String tip = String.format ("%.2f", bill * tips[index]);
		String[] tip_parts = tip.split ("\\.");
		
		System.out.printf ("Level: %s%nTip: %s dollars and %s cents%n", levels[index], tip_parts[0], Integer.valueOf(tip_parts[1]));
	
	}

}