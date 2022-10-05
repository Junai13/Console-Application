package library;
import java.io.IOException;
import java.util.Scanner;
import static library.Borrower.*;
import static library.Borrower.RESET;
import static library.InputOperation.allFunctionalities;

public class Input {
    Library lib = Library.getInstance();
    public void addFirstBook(){
        lib.defaultBook();
    }
    public void getIn() throws IOException {
        lib.setFine(20);
        lib.setReturnDeadline(5);
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println(PURPLE+"\t\u200B\uD83D\uDE4F Welcome to Library Portal \u200B\uD83D\uDE4F"+RESET);
        do {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println(GREEN+ "We are Providing following features. Please enter which feature do you want: \n"+RESET);
            System.out.println("""
                    1- Add a Book
                    2- Add a new Borrower
                    3- View all books in library
                    4- Search the book
                    5- Borrow a Book
                    6- Return Book
                    7- Renew book
                    8- To view the fine for borrower
                    9- Delete Book
                    10- Check the personal info of the borrower
                    11- Logout""");
            System.out.println("--------------------------------------------------------------------------------------");
            int choice = sc.nextInt();
            if(choice==11){
                System.out.println("~~~\u200B\uD83D\uDE4F Thank you for choosing us \u200B\uD83D\uDE4F~~~");
                flag = false;
            }else {
                allFunctionalities(choice);
            }
        }while(flag);
    }
}
