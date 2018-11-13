public class E6_17 {

	public static void main (String[] args) {
		
		final int SIZE = 20;
		final int WIDTH = String.valueOf (SIZE * SIZE).length () + 1;
		
		for (int y=1; y <= SIZE; y++) {
		
			for (int x=1; x <= SIZE; x++) {
			
				System.out.printf ("%" + WIDTH + "d", x * y);
				
			}
			
			System.out.println ();
		
		}
		
	}

}