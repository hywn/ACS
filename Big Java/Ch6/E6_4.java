import java.util.Scanner;

public class E6_4 {
	
	public static void main (String[] args) {
		
		final String EMPTY = "";
		
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter your input: ");
		String input = scan.nextLine ();
		
		// a
		System.out.print ("Loop a: ");
		for (char c : input.toCharArray ()) {
		
			if (Character.isUpperCase (c)) System.out.print (c);
			
		}
		
		//b
		System.out.print ("\nLoop b: ");
		for (int i=0; i<input.length (); i++) {
		
			if (i%2 != 0) System.out.print (input.charAt (i));
		
		}
		
		// c
		System.out.print ("\nLoop c: ");
		for (char c : input.toCharArray ()) {
		
			if (isVowel (c)) System.out.print ('_');
			else System.out.print (c);
			
		}
		
		// d
		System.out.print ("\nLoop d: ");
		int count = 0;
		for (char c : input.toCharArray ()) if (isVowel (c)) count++;
		System.out.print (count);
		
		// e
		System.out.print ("\nLoop e:\n");
		for (int i=0; i<input.length (); i++) {
		
			char c = input.charAt (i);
		
			if (isVowel (c)) System.out.printf ("The position of %c is at index %d.%n", c, i);
			
		}
	
	}
	
	private static final char[] VOWELS = {'a', 'i', 'u', 'e', 'o'};

	public static boolean isVowel (char c) {

		for (char vowel : VOWELS) if (Character.toLowerCase (c) == vowel) return true;
		return false;
		
	}

}