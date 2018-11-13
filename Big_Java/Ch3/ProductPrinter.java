public class ProductPrinter {

	public static void main (String[] args) {
		
		Product p1 = new Product ("Toaster", 29.95);
		Product p2 = new Product ("Cabinet", 15.00);
		
		System.out.println (p1);
		System.out.println (p2);
		
		p1.reducePrice (5);
		p2.reducePrice (5);
		
		System.out.println (p1);
		System.out.println (p2);
	
	
	}

}