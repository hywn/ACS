import java.util.Scanner;

public class P6_5 {

	public static void main (String[] args) {
		
		PrimePrinter.main ();
	
	}
	
	public static class PrimePrinter {
	
		public static void main () {
		
			Scanner scan = new Scanner (System.in);
			
			System.out.print ("Enter your number: ");
			
			PrimeGenerator p = new PrimeGenerator (scan.nextLong ());
			
			long n;
			
			while ((n = p.nextPrime ()) != -1) {
			
				if (n == 1) continue; // poor 1
				
				System.out.println (n);
				
			}
		
		}
	
	}
	
	public static class PrimeGenerator {
	
		long myNum;
		
		public PrimeGenerator (long myNum) { this.myNum = myNum; }
		
		
		int n = 0;
		
		public long nextPrime () {
			
			while (!isPrime (++n)) { if (n > myNum) return -1; };
			
			return n;
		
		}
		
		public boolean isPrime (long n) {
		
			for (long i=2; i < n; i++) {
			
				if (n % i == 0) return false;
			
			}
			
			return true;
		
		}
	
	}

}