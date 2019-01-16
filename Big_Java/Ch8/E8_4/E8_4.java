public class E8_4 {

	public static void main (String[] args) {

		BankAccount b = new BankAccount ();

		b = b.deposit (25); // $25, 1st transaction

		System.out.println (b);

		b = b.withdraw (5);// $20, 2nd transaction
		b.deposit (10); // still $20, 2nd transaction because BankAccount is immutable

		System.out.println (b);

	}

}
