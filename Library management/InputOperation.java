package library;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import static library.Borrower.CYAN;
import static library.Borrower.RESET;

public class InputOperation {
    static Validator validator = new Validator();
    public static int takeInput(int min, int max)
    {
        String choice;
        Scanner input = new Scanner(System.in);
        while(true)
        {
            System.out.println("\nEnter Choice: ");
            choice = input.next();
            if((!choice.matches(".*[a-zA-Z]+.*")) && (Integer.parseInt(choice) > min && Integer.parseInt(choice) < max))
            {
                return Integer.parseInt(choice);
            }
            else
                System.out.println("\nInvalid Input.");
        }
    }
    public static void allFunctionalities(int choice) throws IOException {
        Library lib = Library.getInstance();
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        //Search Book
        if (choice == 4) {
            lib.searchForBooks();
        }
        else if (choice == 10)
        {
                Borrower bor = lib.findBorrower();
                if(bor!=null)
                    bor.printInfo();
        }
        //Compute Fine of a Borrower
        else if (choice == 8)
        {
                Borrower bor = lib.findBorrower();
                if(bor!=null)
                {
                    double totalFine = lib.computeFine2(bor);
                    System.out.println("\nYour Total Fine is : Rs " + totalFine );
                }
        }
        //Return a Book
        else if (choice == 6)
        {
            Borrower bor = lib.findBorrower();
            if(bor!=null)
            {
                bor.printBorrowedBooks();
                ArrayList<BorrowBook> borrowBooks = bor.getBorrowedBooks();
                if (!borrowBooks.isEmpty())
                {
                    input = takeInput(-1, borrowBooks.size());
                    BorrowBook l = borrowBooks.get(input);

                    l.getBook().returnBook(bor, l);
                }
                else
                    System.out.println("\nThis borrower " + bor.getName() + " has no book to return.");
            }
        }
        else if (choice == 5)
        {
            ArrayList<Book> books = lib.searchForBooks();
            if (books != null)
            {
                input = takeInput(-1,books.size());
                Book b = books.get(input);
                Borrower bor = lib.findBorrower();
                if(bor!=null)
                {
                    b.issueBook(bor);
                }
            }
        }
//Add new Borrower
        else if (choice == 2)
        {
            lib.createPerson();
        }
        //Add new Book
        else if (choice == 1)
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String title = validator.validateAuthorTitle("title");
            System.out.println(CYAN+"\nEnter Journal:"+RESET);
            String subject = reader.readLine();
            String author = validator.validateAuthorTitle("author");
            lib.createBook(title, subject, author);
        }
        //Remove a Book
        else if (choice == 9)
        {
            ArrayList<Book> books = lib.searchForBooks();
            if (books != null)
            {
                input = takeInput(-1,books.size());
                lib.removeBookfromLibrary(books.get(input));
            }
        }
//Renew a Book
        else if (choice == 7)
        {
            Borrower bor = lib.findBorrower();
            if(bor!=null)
            {
                bor.printBorrowedBooks();
                ArrayList<BorrowBook> borrowBooks = bor.getBorrowedBooks();
                if (!borrowBooks.isEmpty())
                {
                    input = takeInput(-1, borrowBooks.size());
                    borrowBooks.get(input).renewIssuedBook(new java.util.Date());
                }
                else
                    System.out.println("\nThis borrower " + bor.getName() + " has no issued book which can be renewed.");
            }
        } else if (choice == 3) {
            lib.viewAllBooks();
        }
    }
}
