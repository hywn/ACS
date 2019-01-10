public class BankAccount {

	private double balance;
	private int transactions;

	public BankAccount () { this (0); }

	public BankAccount (double initialBalance) {

		balance = initialBalance;
		transactions = 0;

	}

	public BankAccount (BankAccount prevAccount, double deltaAmount) {

		balance = prevAccount.balance + deltaAmount;
		transactions = prevAccount.transactions + 1;

	}

	public BankAccount deposit (double amount) {
		return new BankAccount (this, amount);
	}

	public BankAccount withdraw (double amount) {
		return new BankAccount (this, -amount);
	}

	public double getBalance () { return balance; }
	public int getTransactions () { return transactions; }

	public String toString () { return String.format ("balance: %s, transactions: %s", getBalance (), getTransactions ()); }

}