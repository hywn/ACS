import java.util.Scanner;

public class P4_1 {

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
	
		double costNewCar, milesYearly, priceGallon, mpg, priceResale;
		
		costNewCar = getInput (scan, "Cost of new car:");
		milesYearly = getInput (scan, "Miles travelled per year:");
		priceGallon = getInput (scan, "Gas price:");
		mpg = getInput (scan, "Car's MPG:");
		priceResale = getInput (scan, "Resale value of car after 5 years:");
		
		System.out.printf ("The total cost of owning this car for 5 years is $%.2f.",
		
			costNewCar - priceResale + ((milesYearly / mpg) * priceGallon)
		
		);
		
	
	}
	
	public static double getInput (Scanner scan, String prompt) {
		
		System.out.println (prompt);
		
		return scan.nextDouble ();
	
	}

}