import java.util.Scanner;

public class P6_3 {

	public static void main (String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter n (above 2): ");
		int n = scan.nextInt ();
		
		System.out.printf ("The nth Fibonacci number is %d.%n", fib (n));
	
	}
	
	public static int fib (int n) {
	
		int f1 = 1;
		int f2 = 1;
		
		int fnew = f1 + f2;
		
		// already at n=3
		for (int i=3; i<n; i++) {
		
			f2 = f1;
			f1 = fnew;
			fnew = f1 + f2;
		
		}
		
		return fnew;
	
	}
	
	public static int fibr (int n) {
	
		if (n == 1 || n == 2) return 1;
		
		return fibr (n-1) + fibr (n-2);
	
	}

}