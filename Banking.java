import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Banking {
	public static void main(String[] args) {
		System.out.println("..... Welcome to Banking Application System.....");
		System.out.println("\n");
		System.out.println("Do you Want to Open Any Bank Account 1.Yes 2.No");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		if (choice.equals("Yes")) {
			OpenAccount obj = new OpenAccount();
			obj.CreateAccount();
		}
		if (choice.equals("No")) {
			BankAccount obj1 = new BankAccount();
			obj1.showMenu();
		}
	}
}

class OpenAccount {
	String name;
	int accountnum;
	String accountType;
	String Dob;
	String Bank;

	void CreateAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("In Which Bank Do you Want to Create an Account: 1.GUJARAT_BANK 2.ICICI 3.BANGLURU_BANK");
		int choiceBank = sc.nextInt();
		if (choiceBank == 1) {
			Bank = "SBI";
		}
		if (choiceBank == 2) {
			Bank = "Axis Bank";
		}
		if (choiceBank == 3) {
			Bank = "HDFC Bank";
		}
		System.out.println("Pleae Enter Your Name");
		sc.nextLine();
		name = sc.nextLine();
		System.out.println("Please Enter Your Date of Birth");
		Dob = sc.nextLine();
		System.out.println("What Type Of Account Do You Want to Open 1.Savings 2.Current");
		int choiceAcc = sc.nextInt();
		if (choiceAcc == 1) {
			accountType = "Savings";
		}
		if (choiceAcc == 2) {
			accountType = "Current";
		}
		System.out.println("Your Account has Opened With below details");
		System.out.println("Bank :" + Bank);
		System.out.println("Name :" + name);
		System.out.println("DOB :" + Dob);
		System.out.println("Account No : " + Math.random());
		System.out.println("Type of Account :" + accountType);
		System.out.println("\n");
		BankAccount obj1 = new BankAccount();
		obj1.showMenu();
		sc.close();
	}
}

class BankAccount {
	int Balance;
	int previousTransaction;
	String customerName;
	String customerID;
	String accountType;
	double totalInterest;

	void CalculateIntrest(double balance) {
		System.out.println("What type of account you have 1.Savings 2.Current");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		if (choice == 1) {
			accountType = "Savings";
			double r = 0.05;
			int t;
			System.out.println("Enter No of Years to Calculate the Intrest of deposited amount");
			t = sc.nextInt();
			double finalAmount = Balance * (1 + (r * t));
			totalInterest = (finalAmount - Balance);
			System.out.println("Interest amount for your balance is: " + totalInterest);
		}
		if (choice == 2) {
			accountType = "Current";
			double r = 0.08;
			int t;
			System.out.println("Enter No of Years to Calculate the Intrest of deposited amount");
			t = sc.nextInt();
			double finalAmount = Balance * (1 + (r * t));
			totalInterest = (finalAmount - Balance);
			System.out.println("Interest amount for your balance is: " + totalInterest);
		}
	}

	void deposit(int amount) {
		if (amount != 0);
		{
			Balance = Balance + amount;
			System.out.println("Balnce amount after Depositing the money " + Balance);
			previousTransaction = Balance;
		}
	}

	void withdraw(int amount) {
		if (amount != 0)
			;
		{
			Balance = Balance - amount;
			System.out.println("Balnce amount after Withdrawing money " + Balance);
			previousTransaction = 0 - amount;
		}
	}

	void getpreviousTransaction() {
		FileOutputStream out;
		PrintStream p;
		System.out.println("Your Last Transaction is ");
		try {
			out = new FileOutputStream("C:\\Users\\PUNIT\\eclipse-workspace\\Project_2\\Punit_tran.txt");
			p = new PrintStream(out);
			if (previousTransaction > 0) {
				p.append("Deposited: " + previousTransaction);
				System.out.println("Deposited :" + previousTransaction);
			} else if (previousTransaction < 0) {
				p.append("Withdrawn: " + previousTransaction);
				System.out.println("Withdrawn: " + previousTransaction);
			} else {
				System.out.println("No Transaction occured");
			}
			p.close();
		} catch (Exception e) {
			System.out.println("Error in the Printing the Data" + e);
		}
	}

	void showMenu() {
		char options = '\0';
		Scanner sc = new Scanner(System.in);
		System.out.println("***** Welcome to Banking Menu *******");
		System.out.println("\n");
		System.out.println("A. Check Balance of the Account");
		System.out.println("B. Deposit Money into the Account");
		System.out.println("C. Withdraw amount from the account");
		System.out.println("D. See Previous Transaction of the Account");
		System.out.println("E. Calculate the Rate of Intrest for Deposited Amount");
		System.out.println("F. Exit ");
		boolean exit = false;
		do {
			System.out.println("******************************************");
			System.out.println("Plese Choose the above Options");
			System.out.println("******************************************");
			options = sc.next().charAt(0);
			System.out.println("\n");
			switch (options) {
			case 'A':
				System.out.println("---------------------------------------");
				System.out.println("Account Balance is = " + Balance);
				System.out.println("\n");
				break;
			case 'B':
				System.out.println("---------------------------------------");
				System.out.println("Enter the amount of Money for Deposit");
				int amountA = sc.nextInt();
				deposit(amountA);
				break;
			case 'C':
				System.out.println("----------------------------------------");
				System.out.println("How much Money Do You Want to Withdraw");
				int amountB = sc.nextInt();
				withdraw(amountB);
				break;
			case 'D':
				System.out.println("----------------------------------------");
				getpreviousTransaction();
				System.out.println("\n");
				break;
			case 'E':
				System.out.println("----------------------------------------");
				CalculateIntrest(Balance);
				System.out.println("\n");
				break;
			case 'F':
				System.out.println("----------------------------------------");
				System.out.println("Thanks to choosing our Bank .. Happy Diwali..");
				exit = true;
				break;
			}
		} while (!exit);
	}
}