public class E8_4 {

	public static void main (String[] args) {

		BankAccount b = new BankAccount ();

		b = b.deposit (25); // $25

		System.out.println (b);

		b = b.withdraw (5);// $20
		b.deposit (10); // still $20 because BankAccount is immutable

		System.out.println (b);

	}

}
