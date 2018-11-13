public class Product {

	private String name;
	private double price;
	
	public Product (String name, double price) {
	
		this.name = name;
		this.price = price;
	
	}
	
	public void reducePrice (double reduction) { price -= reduction; }
	
	public String getName () { return name; }
	public double getPrice () { return price; }

	public String toString () {
	
		return String.format ("%s - %s", getName (), getPrice ());
	
	}

}