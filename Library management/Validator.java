package library;

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

import static library.Borrower.RED;
import static library.Borrower.RESET;

public class Validator {
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern AuthorTitle_Pattern=Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern mobileNo_Pattern = Pattern.compile("^[6-9][0-9]{9}$");
    Scanner sc = new Scanner(System.in);
    public String validateId() {
        String bookid;
        while (true) {
            System.out.println("Enter Book ID ");
            bookid = sc.nextLine();
            if (!ID_PATTERN.matcher(bookid).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID BOOK ID "+RESET);
            } else {
                break;
            }
        }
        return bookid;
    }

    public String validateAuthorTitle(String input) {
        String result;
        while (true) {
            if (input.equalsIgnoreCase( "Title") ){
                System.out.println("Enter Title");
            } else {
                System.out.println("Enter Author");
            }
            result = sc.nextLine();
            if (!AuthorTitle_Pattern.matcher(result).matches()) {
                System.out.println(RED + "Please Enter Valid " + input + RESET);
            } else {
                break;
            }
        }
        return result;
    }
    public String validatemobile() {
        String mobno;
        while (true) {
            System.out.println("Enter Mobile Number ");
            mobno = sc.nextLine();
            if (!mobileNo_Pattern.matcher(mobno).matches()) {
                System.out.println(RED+"SORRY ! PLEASE ENTER VALID Mobile Number "+RESET);
            } else {
                break;
            }
        }
        return mobno;
    }
}
