import java.util.Scanner;

public class E6_10 {

	public static void main (String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.print ("Enter your word: ");
		
		char[] chars = scan.next ().toCharArray ();
		
		for (int i=0; i<chars.length/2; i++) {
			
			int j = chars.length-1 - i;
			
			char charI = chars[i];
			
			chars[i] = chars[j];
			chars[j] = charI;
		
		}
		
		System.out.println (new String (chars));
	
	}

}