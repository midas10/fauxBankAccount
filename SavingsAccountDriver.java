// This program tests the SavingsAccount class and allows the user to make changes to a fake savings account.
// By Karen Pedri
import java.util.Scanner;

public class SavingsAccountDriver {
	public static void main (String[] args) {
		// Creates exit variable
		int exit = 1;

		Scanner input = new Scanner(System.in);

		// Take in user's starting balance and interest rate
		System.out.println("Enter your starting balance for your savings account: ");
		double userBalance = input.nextDouble();

		System.out.println("Enter your account's annual interest rate: ");
		double userInterest = input.nextDouble();

		// Create SavingsAccount object
		SavingsAccount userAccount = new SavingsAccount(userBalance, userInterest);

		// Repeat until user wants to exit command
		while (exit != 0) {
			// Ask for command from user
			System.out.printf("\nPlease enter a command to perform on your account. They are as follows. \nEnter \"deposit\" to perform a depost. \nEnter \"withdraw\" to perform a withdrawal. \nEnter \"month\" to trigger monthly processes. \nEnter \"0\" to exit program.\n");

			// Get user's answer
			String userAnswer = input.next();

			// Use methods based on the user's response
			if (userAnswer.equals("deposit")) {
				System.out.printf("\nEnter deposit amount: ");
				userAccount.deposit(input.nextDouble());
			} else if (userAnswer.equals("withdraw")) {
				System.out.printf("\nEnter withdraw amount: ");
				userAccount.withdraw(input.nextDouble());
			} else if (userAnswer.equals("month")) {
				userAccount.monthlyProcess();
			} else {
				exit = 0;
			}
		}
	}
}

/*
Output:
Enter your starting balance for your savings account:
500
Enter your account's interest rate:
.02

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
withdraw

Enter withdraw amount: 10
Withdrawal completed. Current balance: $490.00

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
withdraw

Enter withdraw amount: 10
Withdrawal completed. Current balance: $480.00

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
withdraw

Enter withdraw amount: 10
Withdrawal completed. Current balance: $470.00

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
withdraw

Enter withdraw amount: 10
Withdrawal completed. Current balance: $460.00

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
withdraw

Enter withdraw amount: 10
Withdrawal completed. Current balance: $450.00

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
withdraw

Enter withdraw amount: 10
Withdrawal completed. Current balance: $440.00

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
deposit

Enter deposit amount: 500
Deposit completed. Current balance: $940.00

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
month
Your total service charges for the month are $3
Monthly processes completed. Current balance: $938.56

Please enter a command to perform on your account. They are as follows.
Enter "deposit" to perform a depost.
Enter "withdraw" to perform a withdrawal.
Enter "month" to trigger monthly processes.
Enter "0" to exit program.
0
*/
