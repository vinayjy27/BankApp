package com.vinay;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Bank {
	private static Scanner sc;

	public static void main(String[] args) {
		Bank atm = new Bank();
		int option;
		double balance = 100.0;
		atm.showMenu();
		System.out.println("Enter an option number to proceed: ");
		
		try {
			do {
				sc = new Scanner(System.in);
				option = sc.nextInt();
//				char[] pass = new char[] {'v','1','2','3'};
				String pass = "123";
				switch (option) {
				case 1:
					System.out.println("Current balance: $" + balance);
					break;
				case 2:
					System.out.println("Enter the Deposit Amount: ");
					double depositAmt = sc.nextDouble();
					if (depositAmt <= 0) {
						System.out.println("Deposit amount must be greater than zero!");
						break;
					} else {
						double tempBalDeposit = balance;
						balance += depositAmt;
						System.out.println("Successfully deposited amount: $" + depositAmt);
						System.out
								.println("Current balance: $" + balance + " (" + tempBalDeposit + " + " + depositAmt + ")");
						break;
					}
				case 3:
					System.out.println("Enter the Withdrawal Amount: ");
					double withdrawalAmt = sc.nextDouble();
					if (withdrawalAmt <= 0) {
						System.out.println("Withdrawal amount must be greater than zero");
						break;
					} else {
						if (balance >= withdrawalAmt) {
							double tempBalWithdrawal = balance;
							balance -= withdrawalAmt;
							System.out.println("Successfully withdrew amount: $" + withdrawalAmt);
							System.out.println("Current balance: $" + balance + " (" + tempBalWithdrawal + " - "
									+ withdrawalAmt + ")");
						} else {
							System.out.println("Insufficient funds!");
							System.out.println("Withdrawal amount: $" + withdrawalAmt);
							System.out.println("Current balance: $" + balance);
						}
						break;
					}
				case 4:
					if (balance == 0) {
						System.out.println("No funds available!");
						System.out.println("Current balance: $" + balance);
						break;
					} else {
						System.out.println("Are you sure you want to withdraw the whole amount: $" + balance + "?");
						System.out.println("+------------------+");
						System.out.println("| [Y]es | [C]ancel |");
						System.out.println("+------------------+");
						char yesOrNoChar = sc.next().charAt(0);
						if ((yesOrNoChar == 'Y' || yesOrNoChar == 'y')) {
							System.out.println("Enter the account password to proceed...");
							String tempPass = sc.next();
							if (tempPass.equals(pass)) {
								System.out.println("Successfully withdrew the whole amount: $" + balance);
								balance -= balance;
								System.out.println("Current balance: $" + balance);
								break;
							} else {
								System.out.println("Incorrect password, try again!");
								atm.showMenu();
								break;
							}
							
						} else if ((yesOrNoChar == 'C' || yesOrNoChar == 'c')) {
							System.out.println("Operation cancelled!");
							atm.showMenu();
							break;
						} else {
							System.out.println("(" + (yesOrNoChar) + ") is an invalid option!");
							break;
						}
					}
				case 5: {
					atm.showMenu();
					break;				
				}
				case 6: {
					System.out.println("+--------------------+");
					System.out.println("| Rest Password Menu |");
					System.out.println("+--------------------+");
					System.out.println("This feature is not implemented yet! ;)");
					break;
//					System.out.println("Enter the current account password to proceed...");
//					String currentPass = sc.next();
//					if (currentPass.equals(pass)) {
//						System.out.println("Enter new account password...");
//						String newPass = sc.next();
//						pass = newPass;						
//						System.out.println("New password has been updated successfully!");
//						atm.showMenu();
//						break;
//					} else {
//						System.out.println("Incorrect password, try again!");
//						atm.showMenu();
//						break;
//					}					
					
				}
				default:
					if (option == 7) {
						System.out.println("+------------------------------+");
						System.out.println("| See you! Made by Vinay Yadav |");
						System.out.println("+------------------------------+");
						break;
					} else {
						System.out.println("(" + option + ") is an invalid option!");
					}
				}
			} while (option != 7);
						
		} catch (InputMismatchException e) {
			System.out.printf("Invalid input, try again! (%s)", e);
		} finally {
			sc.close();
		}

		
	}

	void showMenu() {
		System.out.println("+-----------------------+");
		System.out.println("| 1. Balance Enquiry    |");
		System.out.println("| 2. Deposit Amount     |");
		System.out.println("| 3. Withdraw Amount    |");
		System.out.println("| 4. Withdraw All       |");
		System.out.println("+-----------------------+");
		System.out.println("| 5. Show Menu          |");
		System.out.println("| 6. Reset Password     |");
		System.out.println("| 7. Quit               |");
		System.out.println("+-----------------------+");
	}
	

}
