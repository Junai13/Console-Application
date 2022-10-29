package controller;

import java.util.Scanner;
import java.util.regex.Pattern;
public class Validator {
    private static final Pattern choice_pattern = Pattern.compile("^[1-4]");
    private static final Pattern mobileNo_pattern = Pattern.compile("^[6-9][0-9]{9}$");
    private static final Pattern aadharNo_pattern = Pattern.compile("^[2-9][0-9]{11}$");
    private static final Pattern ticket_pattern = Pattern.compile("^[1][0-9]{3}$");
    private static final Pattern bus_pattern = Pattern.compile("[0-9]+");
    private static final Pattern password_pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$");
    private Scanner sc = new Scanner(System.in);
    public String validatePassword(){
        String password;
        while(true){
            System.out.println("Enter the password");
            password = sc.nextLine();
            if(!password_pattern.matcher(password).matches()){
                System.out.println("""
                       SORRY! YOU HAD ENTERED A WEAK PASSWORD.
                       A PASSWORD SHOULD CONTAINS
                       1 UPPERCASE LETTER
                       1 LOWERCASE LETTER
                       1 NUMERIC
                       1 SPECIAL CHARACTER
                       AND THE LENGTH OF PASSWORD SHOULD BETWEEN 8-20 
                       """);}
            else break;

        }
        return password;
    }

    public int validateChoice(){
        String choice;
        while(true){
            System.out.println("Enter the choice: ");
            choice = sc.next();
            if(!choice_pattern.matcher(choice).matches()){
                System.out.println("SORRY! YOU HAD ENTERED A WRONG CHOICE. PLEASE ENTER A VALID CHOICE");
            }else {
                break;
            }
        }
        return Integer.parseInt(choice);
    }
    public int validateTicket(){
        String ticket;
        while(true){
            ticket = sc.next();
            if(!ticket_pattern.matcher(ticket).matches()) {
                System.out.println("SORRY!! YOU HAD ENTERED WRONG NUMBER. PLEASE ENTER VALID TICKET.");
            }else{ break;}
        }
        return Integer.parseInt(ticket);
    }
    public int validateBusno(){
        String busNo;
        while(true){
            System.out.println("Enter the Bus No: ");
            busNo = sc.next();
            if(!bus_pattern.matcher(busNo).matches()){
                System.out.println("SORRY! YOU HAD ENTERED A WRONG BUS NO. PLEASE ENTER A VALID BUS NO");
            }else {
                break;
            }
        }
        return Integer.parseInt(busNo);
    }
    public long validateMobileNo(){
        String mobileNo;
        while(true){
            System.out.println("Enter the mobile number: ");
            mobileNo = sc.next();
            if(!mobileNo_pattern.matcher(mobileNo).matches()){
                System.out.println("!!!! SORRY! YOU HAD ENTER A WRONG MOBLE NUMBER. PLEASE ENTER VALID MOBILE NUMBER" +
                        "ONLY INDIAN NUMBER IS ALLOWED. PLEASE ENTER THE NUMBER WITHOUT COUNTRY CODE" +
                        "[EXAMPLE: 9876543210]");
            }
            else break;
        }
        return Long.parseLong(mobileNo);
    }
    public long validateAadhaar(){
        String aadhar;
        while(true){
            System.out.println("Enter the Aadhar ID number: ");
            aadhar = sc.next();
            if(!aadharNo_pattern.matcher(aadhar).matches()){
                System.out.println("! SORRY ! YOU HAD ENTERED WRONG AADHAR NUMBER. PLEASE ENTER THE NUMBER WITHOUT SPACE" +
                        "[EXAMPLE: 214671719870]");
            }else break;
        }
        return Long.parseLong(aadhar);
    }
}
