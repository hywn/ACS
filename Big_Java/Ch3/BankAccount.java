public class BankAccount {

	public static final double FEE = 12.3;
	public static final int NUM_FREE_TRANSACTIONS = 5;

	private double balance;

	private int transactions;

	// TODO: comment

	public BankAccount (double initialBalance) {

		balance = initialBalance;
		transactions = 0;

	}

	public BankAccount () { this (0); }

	public void deposit (double amount) {

		balance += amount;

		transactions++;

	}

	public void withdraw (double amount) {

		balance -= amount;

		transactions++;

	}

	public void deductMonthlyCharge () {

		if (transactions >= NUM_FREE_TRANSACTIONS) balance -= ((transactions - NUM_FREE_TRANSACTIONS) * FEE);

		transactions = 0;

	}

	public void addInterest (double rate) { balance *= (1 + rate / 100); }

	public double getBalance () { return balance; }
	public int getTransactions () { return transactions; }

	public String toString () { return String.format ("balance: %s, transactions: %s", getBalance (), getTransactions ()); }

}