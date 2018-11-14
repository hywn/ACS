import java.util.Random;

public class P7_1 {

	public static void main (String[] args) {
		
		int[] values = new Random ().ints (20, 1, 7).toArray ();
		
		boolean inRun = false;
		
		for (int i=0; i < values.length; i++) {
		
			if (inRun) {
			
				if (values[i] != values[i-1]) {
					
					System.out.print (")");
					inRun = false;
				
				}
				
			}
			
			else if (i+1 < values.length) {
			
				if (values[i] == values[i+1]) {
					
					System.out.print ("(");
					inRun = true;
				
				}
							
			}
			
			System.out.print (values[i]);
		
		}
		
		if (inRun) System.out.println (")");
		
	}

}