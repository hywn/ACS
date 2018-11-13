import java.util.Scanner;

public class E6_2 {
	
	// this actually doesn't have to static
	static interface Loop {	public int evaluate (int i); }
	
	static int doLoopInclusive (Loop loop, int a, int b) {
		
		int sum = 0;
		
		for (int i=a; i <= b; i++) sum += loop.evaluate (i);
		
		System.out.println (sum);
		
		return sum;
	
	}
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		int a, b, n;
		
		System.out.print ("Enter a: "); a = scan.nextInt ();
		System.out.print ("Enter b: "); b = scan.nextInt ();
		System.out.print ("Enter n: "); n = scan.nextInt ();
		
		String[] nSplit = String.valueOf (n).split ("");
		
		// a
		System.out.print ("Loop a: ");
		doLoopInclusive (i -> { return (i%2 == 0)? i : 0; }, 2, 100);
		// b
		System.out.print ("Loop b: ");
		doLoopInclusive (i -> { return i*i; }, 1, 100);
		// c
		System.out.print ("Loop c: ");
		doLoopInclusive (i -> { return (int) Math.pow (2, i); }, 0, 20);
		// d
		System.out.print ("Loop d: ");
		doLoopInclusive (i -> { return (i%2 != 0)? i : 0; }, a, b);
		// e
		System.out.print ("Loop e: ");
		doLoopInclusive (i -> {
		
			int d = Integer.parseInt (nSplit[i]);
			
			return (d%2 != 0)? d : 0;
			
		}, 0, nSplit.length - 1);
	
	}

}