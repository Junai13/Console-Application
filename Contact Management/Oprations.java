package contactmanagement;

import java.sql.ResultSet;
import java.util.Scanner;

public class Oprations {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    SqlConnection conn = new SqlConnection();
    Validator validator = new Validator();
    Scanner sc = new Scanner(System.in);
    Database database = new Database();

    public void addContact() {
        System.out.println("Enter Name");
        String name = sc.next();
        long mobileNo = validator.validatemobile();
        String type;
        while (true) {
            System.out.println("Enter the type of the contact(Personal or Professional): ");
            type = sc.next();
            if (type.equalsIgnoreCase("Personal") || type.equalsIgnoreCase("Professional")) {
                break;
            } else System.out.println(RED + "PLEASE ENTER A VALID DATA" + RESET);
        }
        System.out.println("If you want to enter DOB and Address of the contact enter 1 or enter 0");
        int option = validator.validateOption();
        sc.nextLine();
        if (option == 1) {
            String doB = validator.validateDoB();
            System.out.println("Enter Address: ");
            String address = sc.next();
            database.addContactInDB(name, mobileNo, type, doB, address);
            System.out.println(GREEN + "CONTACT ADDED SUCCESSFULLY" + RESET);
        } else if (option == 0) {
            database.addContactInDB(name, mobileNo, type);
            System.out.println(GREEN + "CONTACT ADDED SUCCESSFULLY" + RESET);
        } else
            System.out.println(RED + "PLEASE ENTER VALID CHOICE" + RESET);
    }

    public void deleteContact() {
        System.out.println("enter the name: ");
        String name = sc.next();
        database.delete(name);
    }

    public void updateContact() {
        System.out.println("Enter the name: ");
        String name = sc.next();
        database.update(name);

    }

    public void searchContact() {
        boolean flag = true;
        do {
            System.out.println("""
                    Enter 1 for search by name
                    Enter 2 for search by number""");
            String op = sc.next();
            switch (op) {
                case "1":
                    System.out.print("Enter the name: ");
                    String name = sc.next();
                    database.searchByName(name);
                    break;
                case "2":
                    boolean flag2 = true;
                    do {
                        System.out.println("if you want to search contact by first digits enter 1" +
                                "\n if you want to search contact by last digits enter 2");
                        String subOption = sc.next();
                        switch (subOption) {
                            case "1" -> {
                                System.out.println("Enter first number");
                                int first_number = sc.nextInt();
                                database.searchByFirstNum(first_number);
                            }
                            case "2" -> {
                                System.out.println("Enter last number");
                                int number = sc.nextInt();
                                database.searchByLastNum(number);
                            }
                            default -> {
                                System.out.println(RED + "PLEASE ENTER VALID CHOICE!!" + RESET);
                                flag2 = false;
                                break;
                            }
                        }
                    } while (!flag2);
                    break;
                default:
                    System.out.println(RED + "PLEASE ENTER VALID CHOICE!!" + RESET);
                    flag = false;
                    break;
            }
        } while (!flag);
    }

}
