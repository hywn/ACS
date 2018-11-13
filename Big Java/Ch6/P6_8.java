import java.util.Scanner;

public class P6_8 {

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter seed: ");
		
		RGen r = new RGen (32310901, 1729, scan.nextInt ());
		
		for (int i=0; i < 100; i++)
			System.out.println (r.nextInt ());
	
	}
	
	static class RGen {
	
		private int a, b, rOld;
	
		public RGen (int a, int b, int seed) {
		
			this.a = a;
			this.b = b;
			this.rOld = seed;
		
		}
		
		private int nextInt () {
		
			rOld = a * rOld + b;
			
			return rOld;
		
		}
	
	}

}