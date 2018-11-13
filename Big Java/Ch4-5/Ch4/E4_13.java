import java.util.Scanner;

public class E4_13 {

	public static void main (String[] args) {
	
		Scanner scan = new Scanner (System.in);
	
		System.out.print ("Enter your number with commas: ");
	
		String str = scan.next ();
		
		System.out.println (str.replaceAll (",", ""));
	
	}

}