import java.util.Scanner;

public class E6_6 {

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter some numbers separated by a space: ");
		
		DataCounter d = new DataCounter ();
		
		for (String numString : scan.nextLine ().split (" ")) {
		
			d.add (Double.parseDouble (numString));
		
		}
		
		System.out.printf ("Average: %f%n", d.getAverage ());
		System.out.printf ("Smallest: %f%n", d.getSmallest ());
		System.out.printf ("Largest: %f%n", d.getLargest ());
		System.out.printf ("Range: %f%n", d.getRange ());
	
	}
	
	static class DataCounter {
	
		double sum, min, max;
		int count;
		
		public DataCounter () {
		
			sum = count = 0;
			min = Double.MAX_VALUE;
			max = Double.MIN_VALUE;
			
		}
		
		public void add (double data) {
		
			sum += data;
			count++;
			min = Math.min (data, min);
			max = Math.max (data, max);
		
		}
		
		public double getAverage () { return sum / count; }
		
		public double getRange () { return max - min; }
		
		public double getSmallest () { return min; }
		public double getLargest () { return max; }
	
	}

}