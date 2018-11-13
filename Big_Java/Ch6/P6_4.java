import java.util.Scanner;

public class P6_4 {

	public static void main (String[] args) {
		
		FactoryPrinter.main ();
	
	}
	
	public static class FactoryPrinter {
	
		public static void main () {
		
			Scanner scan = new Scanner (System.in);
			
			System.out.print ("Enter your number: ");
			
			printRepeatedFactorsExcluding1 (scan.nextLong ());
		
		}
		
		public static void printRepeatedFactorsExcluding1 (long num) {
			
			FactorGenerator g = new FactorGenerator (num);
			
			long factor;
			
			while ((factor = g.nextFactor ()) != -1) {
				
				if (factor == 1) continue;
			
				do {
				
					System.out.println (factor);
					num /= factor;
				
				} while (num % factor == 0);
			
			}
		
		}
	
	}
	
	public static class FactorGenerator {
	
		long myNum;
		
		public FactorGenerator (long myNum) { this.myNum = myNum; }
		
		long n = 0;
		
		// this returns each factor only once and includes 1. it needs FactorPrinter to print factors repeatedly.
		public long nextFactor () {
			
			long factor;
			
			// not sure if this is very good
			while ((factor = nextFactorRepeatable ()) == -2) {};
			
			return factor;
		
		}
		
		public long nextFactorRepeatable () {
		
			n++;
			
			if (n > myNum) return -1;
		
			if (!isPrime (n)) return -2;
			
			if (myNum % n == 0) return n;
		
			return -2;
		
		}
		
		// never use this
		public boolean hasMoreFactors () {
			
			long nTemp = n;
			
			long nextFactor = nextFactor ();
			
			n = nTemp;
			
			if (nextFactor == -1) return false;
			
			return true;
		
		}
		
		private boolean isPrime (long n) {
		
			for (long i=2; i < n; i++) {
			
				if (n % i == 0) return false;
			
			}
			
			return true;
		
		}
	
	}

}