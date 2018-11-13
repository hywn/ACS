import java.util.Random;
import java.util.Scanner;

public class E6_8 {

	public static void main (String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter your word: ");
		
		char[] chars = scan.next ().toCharArray ();
		
		Random rand = new Random ();
		
		for (int count=0; count < chars.length; count++) {
		
			int i, j;
			
			i = rand.nextInt (chars.length - 1);
			
			// in the most extreme case, i = length - 2 and j must be length - 1
			// length - (length - 2) - 1 = 2 - 1 = 1, and rand.nextInt (1) is always 0.
			// i + 1 + 0 = i + 1 = (length - 2) + 1 = length - 1 = j
			j = i + 1 + rand.nextInt (chars.length - i - 1);
			
			char charI = chars[i];
			
			chars[i] = chars[j];
			chars[j] = charI;
		
		}
		
		System.out.println (String.valueOf (chars));
	
	}

}