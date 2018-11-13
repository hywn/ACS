import java.util.Scanner;

public class P6_17 {

	public static void main (String[] args) {
	
		for (int i=0; i < 25; i++) {
		
			System.out.printf ("%d hours: %.2f%% remaining%n", i, getAmountRemaining (100, 6, i));
		
		}
	
	}
	
	public static double getAmountRemaining (double amountInitial, double half_life, double time) {
	
		return amountInitial * Math.pow (Math.E, -time * Math.log10 (2) / half_life);
	
	}

}