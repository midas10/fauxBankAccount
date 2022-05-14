/**
* SavingsAccount is an extension of the BankAccount superclass which checks for certain requirements before performing actions.
* @author Karen Pedri
*/
public class SavingsAccount extends BankAccount {
	/**
	* accountStatus tracks the account status of the user, true for active and false for inactive
	*/
	public boolean accountStatus = true;

	/**
	* Constructor that calls the superclass constructor and makes the account inactive if the starting balance is below $25.
	* @param balance The starting balance
	* @param interestRate The account interest rate
	*/
	public SavingsAccount(double balance, double interestRate) {
		super(balance, interestRate);

		if (super.balance < 25) {
			this.accountStatus = false;
			System.out.println("Account inactive. Balance is below 25 dollars.");
		}
	}

	/**
	* Checks if the user's account is active before calling superclass withdraw
	* @param withdrawalAmount amount user wishes to withdraw
	*/
	public void withdraw (double withdrawalAmount) {
		if (this.accountStatus == false) {
			System.out.println("Account inactive, withdrawal not allowed. Current balance: $" + String.format("%.2f", super.balance));
		} else {
			super.withdraw(withdrawalAmount);
			System.out.println("Withdrawal completed. Current balance: $" + String.format("%.2f", super.balance));
			if (super.balance < 25) {
				this.accountStatus = false;
				System.out.println("Account balance now below 25 dollars, account made inactive. Current balance: $" + String.format("%.2f", super.balance));
			}
		}
	}

	/**
	* Checks if the user's account is active before calling superclass deposit
	* @param depositAmount amount user wishes to deposit
	*/
	public void deposit (double depositAmount) {
		if (this.accountStatus == false) {
			if ((super.balance + depositAmount) >= 25) {
				accountStatus = true;
				super.deposit(depositAmount);
				System.out.println("Account no longer inactive. Deposit completed. Current balance: $" + String.format("%.2f", super.balance));
			} else {
				System.out.println("Account inactive, deposit not allowed. Current balance: $" + String.format("%.2f", super.balance));
			}
		} else {
			super.deposit(depositAmount);
			System.out.println("Deposit completed. Current balance: $" + String.format("%.2f", super.balance));
		}
	}

	/**
	* Checks if the user's account is active before calling superclass monthlyProcess and calculates the month's service charge
	*/
	public void monthlyProcess () {
		if (super.numOfWithdrawals > 4) {
			super.monthlyServiceCharges = (numOfWithdrawals - 4);
			System.out.println("Your total service charges for the month are $" + (numOfWithdrawals - 4));
		}

		super.monthlyProcess();
		System.out.println("Monthly processes completed. Current balance: $" + String.format("%.2f", super.balance));

		if (balance < 25) {
			this.accountStatus = false;
			System.out.println("Account made inactive. Balance below 25. Current balance: $" + String.format("%.2f", super.balance));
		}
	}
}
