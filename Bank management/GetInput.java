package bankapp;
import java.util.InputMismatchException;
import java.util.Scanner;

import static bankapp.Validator.*;
import static java.lang.Integer.parseInt;
public class GetInput {
    public void getinput(){
        Scanner sc = new Scanner(System.in);
        Validator validator = new Validator();
        Account acc;
        String choice;
        do{
            System.out.println("            Welcome to Bank System             ");
            System.out.println("""
                    Choose which one do you want to do.......
                    1. Create Account
                    2. Deposit Money
                    3. Withdraw Money
                    4. Check Balance
                    5. Get Statement of Transactions
                    6. Money transfer from one account to another account
                    7. Exit
                    Enter Your Choice""");
            choice = sc.next();
            Account acc1;
            switch(choice){
                case "1":
                    System.out.println("Enter the name");
                    String name = sc.next();
                    System.out.println("Enter the age");
                    int age = sc.nextInt();
                    acc = new Account(name,age);
                    System.out.println("Your account number is "+acc.getAccountNumber());
                    System.out.println(CYAN+ "..Please add the four digit pin for your account" + RESET);
                    int pin = parseInt(validator.validatepin());
                    if(pin < 0){
                        System.out.println(RED+ "Account creation Failed due to wrong pin. Please try again" + RESET);
                        Account.accounts.remove(acc);
                    }
                    else{
                        acc.setPin(pin);
                        System.out.println("Account Created Successfully !!");
                    }
                    break;

                case "2":
                    long amount = 0;
                    acc = BankAction.getAccountAndValidate();
                    if(acc != null){
                        System.out.println("Enter the amount to deposit");
                        try {
                          amount = sc.nextLong();
                        }catch (InputMismatchException e){
                            e.printStackTrace();
                            System.out.println(RED+" You had entered wrong input. Please input numberic only"+RESET);
                        }
                        BankAction.deposit(acc,amount);
                    }
                    break;
                case "3":
                    acc = BankAction.getAccountAndValidate();
                    if(acc != null && BankAction.validatePin(acc)){
                        System.out.println("Enter the amount to withdraw");
                        long withdrawAmount = sc.nextLong();
                        BankAction.withdraw(acc,withdrawAmount);
                    }
                    break;
                case "4":
                    acc = BankAction.getAccountAndValidate();
                    if(acc != null && BankAction.validatePin(acc)){
                        System.out.println("Hi, Your current balance for the account "+acc.getAccountNumber()+" is "+acc.getBalance());
                    }
                    break;
                case "5":
                    acc = BankAction.getAccountAndValidate();
                    if(acc != null && BankAction.validatePin(acc)){

                        BankAction.getStatement(acc);
                    }
                    break;
                case "6":
                    acc = BankAction.getAccountAndValidate();
                    acc1= BankAction.getAccountAndValidate();
                    System.out.println("Enter the amount to transfer from your account ");
                    long tranferAmount=sc.nextLong();
                    BankAction.moneyTransfer(acc, acc1, tranferAmount);
                    break;
                case "7":
                    System.out.println(" THANK YOU !!!");
                    System.exit(0);
                default :
                    System.out.println("Enter a valid choice ");
                    break;
            }

        }while(choice != "7");
        sc.close();
    }
}