import java.util.Scanner;

public class GenEvalCode {

	// each case will start with some whitespace, a single lowercase letter, a period, and another whitespace.
	public static void main (String[] args) {
		
		Scanner scan = new Scanner (System.in);
		
		// starts with a whitespace to make the regex always correct
		StringBuilder b = new StringBuilder (" ");
		
		while (true){
		
			String line = scan.nextLine ();
		
			if (!line.equals ("done"))
			{
				b.append (line);
				b.append ('\n');
			}
			
			else { break; }
			
		}
		
		String total = b.toString ();
		
		String[] parts = total.split ("\\s[a-k][.]\\s");
		
		for (String part : parts){
			if (part.isEmpty ()) continue;
			System.out.printf ("System.out.printf (\"       %s. %%s%%n\", %s);%n", getOrder (total, part),  part);
		
		}
	}
	
	// gets the order thing without period
	public static String getOrder (String total, String part) {
	
		int indexPart = total.indexOf (part);
		
		// will be "a. Part"
		return total.substring (indexPart-3, indexPart-2);
	
	}

}