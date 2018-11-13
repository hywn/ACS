import java.util.Scanner;

public class GenEval2darraylol {

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
		
		System.out.println ("int[][] values = {");
		
		String sepq = "\t{ ";
		
		for (String part : parts){

			if (part.trim().isEmpty ()) continue;
			
			System.out.print (sepq);

			String sep = "";
			
			String fmt = "%s";
			
			for (String num : part.split (" ")) {
			
				if (num.replaceAll("\n", "").trim().isEmpty ()) continue;
				
				System.out.print (sep + String.format (fmt, num));
				
				//System.out.println ("\t`" + num + "`");
				
				fmt = "%3s";
				sep = ", ";
			
			}
			
			System.out.print (" }");
			
			sepq = ",\n\t{ ";
		
		}
		
		System.out.println ("};");
	}
	
	// gets the order thing without period
	public static String getOrder (String total, String part) {
	
		int indexPart = total.indexOf (part);
		
		// will be "a. Part"
		return total.substring (indexPart-3, indexPart-2);
	
	}

}