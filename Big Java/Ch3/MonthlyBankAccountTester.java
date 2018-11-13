public class MonthlyBankAccountTester {

	public static void main (String[] args) {
	
		BankAccount a;
		
		// make sure limit works
		
		a = new BankAccount ();
		
		for (int i=0; i<BankAccount.NUM_FREE_TRANSACTIONS; i++) a.deposit (1);
		
		a.deductMonthlyCharge (); a.deductMonthlyCharge ();
		
		System.out.printf ("Expected: %s\n", new BankAccount (BankAccount.NUM_FREE_TRANSACTIONS));
		System.out.println (a);
		
		// new test
		
		a = new BankAccount ();
		
		int extra = 10;
		
		for (int i=0; i<BankAccount.NUM_FREE_TRANSACTIONS+extra; i++) a.deposit (1);
		
		a.deductMonthlyCharge ();
		
		System.out.printf ("Expected: %s\n", new BankAccount (BankAccount.NUM_FREE_TRANSACTIONS+extra - extra*BankAccount.FEE));
		System.out.println (a);
		
		// second month
		
		double currentBal = a.getBalance ();
		
		for (int i=0; i<BankAccount.NUM_FREE_TRANSACTIONS+extra; i++) a.deposit (1);
		
		a.deductMonthlyCharge ();
		
		System.out.printf ("Expected: %s\n", new BankAccount (BankAccount.NUM_FREE_TRANSACTIONS+extra - extra*BankAccount.FEE + currentBal));
		System.out.println (a);
	
	}

}