public class C {

	public static void main (String[] args) {
	
		String str = "abcde";
	
		// first in char form
		System.out.println (str.toCharArray ()[0]);
		
		// last in char form
		System.out.println (str.toCharArray ()[str.length () - 1]);
		
		// first
		System.out.println (str.substring (0, 1));
		
		// last
		System.out.println (str.substring (str.length () - 1, str.length ()));
		
		// remove first
		System.out.println (str.substring (1, str.length ()));
		
		// remove last
		System.out.println (str.substring (0, str.length () - 1));
		
		
	
	}

}