package bankapp;

import java.util.Scanner;

import static java.lang.Long.parseLong;

public class BankAction {
    static Validator validator = new Validator();
    public static Account getAccountAndValidate() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Account Number to proceed the transaction");
        long accno = parseLong(validator.validateAcNo());
        return getAccount(accno);
    }

    public static Account getAccount(long accno) {

        for (Account acc : Account.accounts) {

            if (acc.getAccountNumber() == accno)
                return acc;
        }
        System.out.println("No such account exists. Please check your account number!!");
        return null;
    }

    public static boolean validatePin(Account acc) {

        Scanner sc = new Scanner(System.in);
        int count = 1;
        do {
            System.out.println("Please Enter the Pin number to proceed the transaction");
            int pin = sc.nextInt();
            if (acc.getPin() != pin) {
                System.out.println("Incorrent Pin Number!");
                count++;
            } else {
                return true;
            }

        }
        while (count <= 5);
        System.out.println("Reached Maximum try....Transaction Aborted!!!!");
        return false;

    }

    public static void deposit(Account acc, long amount) {
        long bal = acc.getBalance() + amount;
        acc.setBalance(bal);
        Transaction trans = new Transaction(amount, Transaction.Status.SUCCESS, Transaction.Type.DEPOSIT, acc.getBalance());
        acc.addTransaction(trans);
        System.out.println("Transaction for Deposit of Rs." + amount + " is successful !!");
        System.out.println(" to Account Number: " + acc.getAccountNumber()
                + "\nAccount holder: "+acc.getName());

    }

    public static void withdraw(Account acc, long amount) {


        Transaction trans = new Transaction(amount, Transaction.Status.SUCCESS, Transaction.Type.WITHDRAWAL, acc.getBalance());

        if (acc.getBalance() < amount) {

            System.out.println("Account " + acc.getAccountNumber() + " has lower balance than requested. Current Available balance is  " + acc.getBalance());
            trans.setStatus(Transaction.Status.FAILURE);
            acc.addTransaction(trans);
            return;
        }

        long bal = acc.getBalance() - amount;
        trans.setCurrentBalance(bal);
        acc.setBalance(bal);
        acc.addTransaction(trans);
        System.out.println("Transaction for Withdrawal of " + amount + " from " + acc.getAccountNumber() + " is successful !!");
    }

    public static void getStatement(Account acc) {

        if (acc.getStatement().size() < 1) {

            System.out.println("NO TRANSACTIONS FOR THE ACCOUNT");
            return;
        }
        System.out.println("TRANSACTION STATEMENT FOR ACCOUNT - " + acc.getAccountNumber());
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("TYPE \t\t\t   AMOUNT  \t\t\t STATUS  \t\t\t CURRENTBALANCE");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Transaction t : acc.getStatement()) {

            System.out.println(t.getType() + "\t\t\t " + t.getAmount() + "\t\t\t " + t.getStatus() + "\t\t\t " + t.getCurrentBalance());
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }

    public static void moneyTransfer(Account acc1, Account acc2, long amount) {

        if (acc1.getBalance() < amount) {
            System.out.println("Money transfer is failure");
            System.out.println("Account " + acc1.getAccountNumber() + " has lower balance than requested. Current Available balance is  " + acc1.getBalance());

        } else {
            withdraw(acc1, amount);
            deposit(acc2, amount);
            System.out.println("Money transfer is success");
        }
    }

}
