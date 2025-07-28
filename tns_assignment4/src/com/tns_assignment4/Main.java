package com.tns_assignment4;
 class Bank {
    private static int totalAccounts = 0;

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void incrementAccounts() {
        totalAccounts++;
    }
}
 abstract class Account {
	    protected String accountNumber;
	    protected String accountHolderName;
	    protected double balance;

	    public Account(String accountNumber, String accountHolderName) {
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.balance = 0.0;
	        Bank.incrementAccounts();
	    }

	    public abstract void deposit(double amount);
	    public abstract void withdraw(double amount);
	    public abstract double getBalance();

	    public void displayInfo() {
	        System.out.println("Account No: " + accountNumber + ", Holder: " + accountHolderName + ", Balance: " + balance);
	    }
	}
 
class SavingsAccount extends Account {
	    private double interestRate = 0.03; // 3%

	    public SavingsAccount(String accNo, String name) {
	        super(accNo, name);
	    }

	    @Override
	    public void deposit(double amount) {
	        balance += amount + (amount * interestRate); // adds interest
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	        } else {
	            System.out.println("Insufficient funds in Savings Account.");
	        }
	    }

	    @Override
	    public double getBalance() {
	        return balance;
	    }
	}
class CheckingAccount extends Account {
    private double overdraftLimit = 500.0;

    public CheckingAccount(String accNo, String name) {
        super(accNo, name);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
class Transaction {
    public final double transactionFee = 10.0;

    public final void performTransaction(Account acc, String type, double amount) {
        System.out.println("\nProcessing transaction: " + type + " of " + amount);

        if (type.equalsIgnoreCase("deposit")) {
            acc.deposit(amount - transactionFee);
        } else if (type.equalsIgnoreCase("withdraw")) {
            acc.withdraw(amount + transactionFee);
        } else {
            System.out.println("Invalid transaction type.");
            return;
        }

        System.out.println("Transaction complete. Current Balance: " + acc.getBalance());
    }
}
public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA001", "Alice");
        CheckingAccount ca = new CheckingAccount("CA001", "Bob");

        Transaction txn = new Transaction();

        sa.displayInfo();
        ca.displayInfo();

        txn.performTransaction(sa, "deposit", 1000);
        txn.performTransaction(ca, "deposit", 500);
        txn.performTransaction(sa, "withdraw", 300);
        txn.performTransaction(ca, "withdraw", 700);

        sa.displayInfo();
        ca.displayInfo();

        System.out.println("\nTotal Bank Accounts Created: " + Bank.getTotalAccounts());
    }
}