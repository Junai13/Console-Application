package view;

import controller.LogInControl;
import controller.Validator;
import model.DataBase;
import model.Traveller;

import java.util.Scanner;

public class Main {
    private GetInput getInput = new GetInput();
    private Scanner scanner = new Scanner(System.in);
    private Validator validator = new Validator();
    private Traveller person = new Traveller();
    DataBase dataBase = new DataBase();

    public static void main(String[] args) {
        Main start = new Main();
        start.logIn();
    }
    private void logIn(){
        System.out.println("""
                ***************************************************************************
                                     Welcome to JJ Towers
                ***************************************************************************
                
                
                If you are new customer enter 1
                If you are registered customer enter 2
                """);
        String option = scanner.next();
        while (true) {
            if ((option.equals(1)) || (option.equals(2))) {
                System.out.println("PLEASE PROVIDE VALID INPUT TO PROCESS!!");
                logIn();
            }else
                break;
        }
        switch (option){
                case "1":
                    createNewUser();
                    break;
                case "2":
                    checkForLogin();
                    break;
                default:
                    System.out.println("Please provide valid information");
            }

    }
    private void createNewUser(){
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        long mobileNo = validator.validateMobileNo();
        long aadharNo = validator.validateAadhaar();
        System.out.println("Enter your address");
        String address = scanner.nextLine();
        person.setName(name);
        person.setAadharNumber(aadharNo);
        person.setAddress(address);
        person.setMobileNumber(mobileNo);
        System.out.println("Enter the user name");
        String userName= scanner.next();
        scanner.nextLine();
        String password = validator.validatePassword();
        dataBase.registerUser(person,userName,password);
        checkForLogin();
    }
    private void checkForLogin() {
        LogInControl logInControl = new LogInControl();

        System.out.println("Enter User Name");
        String userName = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        if (logInControl.checkCredentials(userName, password)) {
            System.out.println("\n-->Welcome " + userName + "<--\n");
            getInput.startingProcess();
        } else {
            System.out.println("\nInvalid Credentials. Please try again!\n");
            checkForLogin();
        }
    }
}