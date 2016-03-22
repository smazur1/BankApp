
import java.sql.Date;
import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String choice = "";
		
		int numberUpdated = 0;
		String author = "";
		String firstName = "";
		String lastName = "";
		int numberInserted = 0;
		long custid = 0;
		String accountNum = "";
		String accountType = "";
		String transType = "";
		double amount = 0;
		String checkdate = "";
		int checknum = 0;
		long accountId = 0;
		Date transdate;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter (1) to create new customer and account : ");
		System.out.println("Enter (2) to create new account for existing customer : ");
		System.out.println("Enter (3) to input transactions for an existing account : ");

		choice = keyboard.nextLine();

/*		if (choice.equalsIgnoreCase("3")) {
			// enter transactions
			System.out.println("Enter Transaction type (C)heck, (D)ebit , d(E)posit, "
					+ "(W)ithdrawal, " + "or -1 to finish");
			transType = keyboard.nextLine();

			while (!transType.equals("-1")) {

				System.out.println("Enter Account Number : ");
				accountNum = keyboard.nextLine();

				if (!transType.equalsIgnoreCase("C")) {
					
					System.out.println("Enter the transaction amount : ");
					amount = keyboard.nextDouble();
					
					try {
						

						AccountDB aDB = new AccountDB();
						accountid = aDB.getAccountId(accountNum);
						
						TransDB tDB = new TransDB();
						
						numberInserted = tDB.insertTrans(accountId, transType, amount, checknum, 
								checkdate, transdate );
						Trans t = new Trans();
			//			t = tDB.getTrans();
						System.out.println("Number of transactions inserted = " + numberInserted);
			//			numberUpdated = tDB.updateTrans();
			//			System.out.println("Number of transactions updated = " + numberUpdated);

						
						numberUpdated = aDB.updateBalance(accountId);
						System.out.println("Number of Balances updated = " + numberUpdated);

					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
				} else {
					// trans type = check

					try {
						
						TransDB tDB = new TransDB();
						numberInserted = tDB.insertTrans(accountId, transType, amount, checknum, 
								checkdate, transdate);
						System.out.println("Number of transactions inserted = " + numberInserted);

					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}

				} else {
					System.out.println("Enter the check number :");
					checknum = keyboard.nextInt();
				}
			}

		}  
		else */
		 if (choice.equalsIgnoreCase("2")) {
			// create a new account for existing customer

			System.out.println("Enter Customer First Name : ");
			firstName = keyboard.nextLine();
			System.out.println("Enter Customer Last Name : ");
			lastName = keyboard.nextLine();

			try {

				BankCustDB bcDB = new BankCustDB();
				BankCust bc = bcDB.getCust(firstName, lastName);
				custid = bc.getCustId();

				System.out.println("Enter a new Account Number (999AAA) : ");
				accountNum = keyboard.nextLine();
				System.out.println("Enter an Account Type - (C)hecking or (S)aving : ");
				accountType = keyboard.nextLine();

				AccountDB aDB = new AccountDB();
				numberInserted = aDB.insertAccount(accountNum, accountType, custid);
				System.out.println("Number of Accounts created = " + numberInserted);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();

			}

		} else if (choice.equalsIgnoreCase("1")) {


			System.out.println("Enter Customer First Name : ");
			firstName = keyboard.nextLine();
			System.out.println("Enter Customer Last Name : ");
			lastName = keyboard.nextLine();

			try {

				BankCustDB bcDB = new BankCustDB();
				numberInserted = bcDB.insertBankCust(firstName, lastName);

				BankCust bc = bcDB.getCust(firstName, lastName);
				custid = bc.getCustId();

				System.out.println("Number of Customers created = " + numberInserted);

				System.out.println("Enter a new Account Number (999AAA) : ");
				accountNum = keyboard.nextLine();
				System.out.println("Enter an Account Type - (C)hecking or (S)aving : ");
				accountType = keyboard.nextLine();

				AccountDB aDB = new AccountDB();
				numberInserted = aDB.insertAccount(accountNum, accountType, custid);
				System.out.println("Number of Accounts created = " + numberInserted);

			} catch (IllegalArgumentException e) {
				e.printStackTrace();

			}
		} else {

			System.out.println("Invalid Entry ");

		}
		keyboard.close();
	}
}
