public class E8_3 {

	static final CurrencyUnit
		PENNY = new CurrencyUnit ("penny", 0.01),
		QUARTER = new CurrencyUnit ("quarter", 0.25),
		DOLLAR_BILL = new CurrencyUnit ("dollar bill", 1),
		TWENTY_DOLLAR_BILL = new CurrencyUnit ("twenty-dollar bill", 20);

	public static void main (String[] args) {

		CashRegister r = new CashRegister ();

		r.recordPurchase (24.99);

		r.receivePayment (TWENTY_DOLLAR_BILL, 1); // $20.00
		r.receivePayment (DOLLAR_BILL, 3); // $23.00
		r.receivePayment (QUARTER, 8); // $25.00
		r.receivePayment (PENNY, 9); // $25.09

		System.out.println ("Change: " + r.giveChange ()); // $0.10

	}


}
