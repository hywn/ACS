public class BankAccountTester {

	public static void main (String[] args) {
	
		BankAccount a = new BankAccount ();
		
		a.deposit (1000);
		a.withdraw (500);
		a.withdraw (400);
		
		System.out.println (a.getBalance ());
		System.out.println ("Expected: 100.0");
	
	}

}