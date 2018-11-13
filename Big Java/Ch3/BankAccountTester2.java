public class BankAccountTester2 {

	public static void main (String[] args) {
	
		BankAccount a = new BankAccount (1000);
		
		a.addInterest (10);
		
		System.out.println (a.getBalance ());
		System.out.println ("Expected: 1100.0");
	
	}

}