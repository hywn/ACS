class CashRegister {

	private double total;

	CashRegister () { total = 0; }

	void recordPurchase (double price) { total += price; }

	void receivePayment (double value) { total -= value; }
	void receivePayment (CurrencyUnit unit, int quantity) { receivePayment (unit.getValue () * quantity); }

	double giveChange () { double change = -total; total = 0; return change; }

}