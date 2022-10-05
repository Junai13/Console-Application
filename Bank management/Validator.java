package bankapp;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String PURPLE="\u001B[35m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";
    static Scanner sc = new Scanner(System.in);
    private static Pattern AC_NO_PATTERN = Pattern.compile("^\\d{13}$");
    private static Pattern PIN_PATTERN = Pattern.compile("^\\d{4}$");
    private static Pattern AMOUNT_PATTERN = Pattern.compile("^[1-9][0-9]*");
    public String validatepin() {
        String pin;
        while (true) {
            System.out.println("Enter your PIN ");
            pin = sc.nextLine();
            if (!PIN_PATTERN.matcher(pin).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER PIN "+RESET);
            } else {
                break;
            }
        }
        return pin;
    }
    public boolean amountCheck(String amount)
    {
       return Pattern.matches("[0-9]+",amount);
    }

    public String validateAcNo() {
        String acno;
        while (true) {
            System.out.println("Enter your Account Number ");
            acno = sc.nextLine();
            if (!AC_NO_PATTERN.matcher(acno).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID ACCOUNT NUMBER "+RESET);
            } else {
                break;
            }
        }
        return acno;
    }
    public String validateAmount() {
        String amount;
        while (true) {
            System.out.println("Enter amount to be deposit ");
            amount = sc.nextLine();
            if (!AC_NO_PATTERN.matcher(amount).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID AMOUNT "+RESET);
            } else {
                break;
            }
        }
        return amount;
    }
}
