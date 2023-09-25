package firstproject;

import java.util.*;

public class ATM {
	
	 private static  String currect_pin ="1432";
	 private static double balance = 1000.0;
	 private static Scanner scanner = new Scanner(System.in);
	 private static boolean login =false;
	

	public static void main(String[] args) {
		while(true) {
			if(!login) {
				System.out.println("enter your PIN:");
				String enteredPIN = scanner.nextLine();
			
				if(verifyPIN(enteredPIN)) {
					login = true;
					System.out.println("PIN accepted.you are log in.");
				}
				else {
					System.out.println("incorrect PIN. Please try again");
				}
			}else {
				displayMenu();
				int choice = scanner.nextInt();
				processchoice(choice);
			}
		}
		}
	
	private static boolean verifyPIN(String enteredPIN) {
		return enteredPIN.equals(currect_pin);
	}
	private static void displayMenu(){
		 System.out.println("Welcome to the ATM!");
         System.out.println("MR SAIRAM");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. logout");
         System.out.print("Choose an option: ");
	}

        private static void processchoice(int choice) {
         switch (choice) {
             case 1:
                 checkBalance();
                 break;
             case 2:
                 deposit();
                 break;
             case 3:
                 withdraw();
                 break;
             case 4:
                 login = false;
                 System.out.println("Thank you for using the ATM!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
                 break;
         }
     }

 private static void checkBalance() {
     System.out.println("Your balance is: " + balance);
 }

 private static void deposit() {
     System.out.print("Enter the amount to deposit: ");
     double amount = scanner.nextDouble();
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited " + amount);
     } else {
         System.out.println("Invalid amount. Please try again.");
     }
 }

 private static void withdraw() {
     System.out.print("Enter the amount to withdraw: ");
     double amount = scanner.nextDouble();
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn " + amount);
     } else {
         System.out.println("Invalid amount or insufficient balance. Please try again.");
     }
   }
}


