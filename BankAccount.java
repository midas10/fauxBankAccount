/**
* The BankAccount class is an abstract class that contains the basic banking methods and fields
* @author Karen Pedri
*/

public abstract class BankAccount {
	/**
	* Account's balance
	*/
	public double balance = 0;

	/**
	* The number of deposits made this month
	*/
	public int numOfDeposits = 0;

	/**
	* The number of withdrawals made this month
	*/
	public int numOfWithdrawals = 0;

	/**
	* The account's interest rate
	*/
	public double annualInterestRate = 0;

	/**
	* The service charge for this month
	*/
	public double monthlyServiceCharges = 0;

	/**
	* A constructor that takes in the starting balance and interest rate of the account
	* @param balance The starting balance
	* @param interestRate The account's interest rate
	*/
	public BankAccount (double balance, double interestRate) {
		this.balance = balance;
		this.annualInterestRate = interestRate;
	}

	/**
	* Deposits money into the bank account
	* @param depositAmount The amount of money to be deposited
	*/
	public void deposit (double depositAmount) {
		this.balance += depositAmount;
		this.numOfWithdrawals += 1;
	}

	/**
	* Withdraws money from the bank account
	* @param withdrawalAmount The amount of money to be withdrawn
	*/
	public void withdraw (double withdrawalAmount) {
		this.balance -= withdrawalAmount;
		this.numOfWithdrawals += 1;
	}

	/**
	* Calculates the interest for the month
	*/
	public void calcInterest () {
		double monthlyInterestRate = annualInterestRate / 12;
		this.balance = (balance + (balance*monthlyInterestRate));
	}

	/**
	* Performs all monthly processes including deducting service charges, adding interest, and resetting the number of withdrawals/deposits/service charges
	*/
	public void monthlyProcess () {
		this.balance -= this.monthlyServiceCharges;
		calcInterest();
		this.numOfWithdrawals = 0;
		this.numOfDeposits = 0;
		this.monthlyServiceCharges = 0;
	}
}

