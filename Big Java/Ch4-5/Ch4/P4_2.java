import java.util.Scanner;

public class P4_2 {

	private final static String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Year: ");
		int y = scan.nextInt ();
		
		int a, b, c, d, e, g, h, j, k, r, m, n, p;
		
		a = y % 19;
		b = y / 100;
		c = y % 100;
		d = b / 4;
		e = b % 4;
		g = (8 * b + 13) / 25;
		h = (19 * a + b - d - g + 15) % 30;
		
		j = c / 4;
		k = c % 4;
		m = (a + 11 * h) / 319;
		r = (2 * e + 2 * j - k - h + m + 32) % 7;
		n = (h - m + r + 90) / 25;
		p = (h - m + r + n + 19) % 32;
		
		// System.out.printf ("%d %d %d %d %d %d %d %d %d %d %d %d\n",
		//                      a, b, c, d, e, g, h, j, k, m, n, p);
	
		System.out.printf ("Easter falls on %s %d.", months[n-1], p);
	
	}

}