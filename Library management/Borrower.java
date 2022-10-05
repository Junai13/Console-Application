package library;
import java.util.ArrayList;
public class Borrower extends Person {
    public static final String RED="\u001B[31m";
    public static final String RESET="\u001B[0m";
    public static final String PURPLE="\u001B[35m";
    public static final String GREEN="\u001B[32m";
    public static final String CYAN="\u001B[36m";
    private ArrayList<BorrowBook> borrowedBooks;
    public Borrower(int id, String name, String address, String phoneNum)
    {
        super(id,name,address, phoneNum);
        borrowedBooks = new ArrayList();
    }
    // Printing Borrower's Info
    @Override
    public void printInfo() {
        super.printInfo();
        printBorrowedBooks();
    }
    // Printing Book's Info Borrowed by Borrower
    public void printBorrowedBooks()
    {
        if (!borrowedBooks.isEmpty())
        {
            System.out.println(CYAN+"\nBorrowed Books are: "+RESET);

            System.out.println("------------------------------------------------------------------------------");
            System.out.println(PURPLE+"No.\t\tTitle\t\t\tAuthor\t\t\tSubject"+RESET);
            System.out.println("------------------------------------------------------------------------------");

            for (int i = 0; i < borrowedBooks.size(); i++)
            {
                System.out.print(i + "-" + "\t\t");
                borrowedBooks.get(i).getBook().printInfo();
                System.out.print("\n");
            }
        }
        else
            System.out.println(RED+"\nNo borrowed books."+RESET);
    }
    public void addBorrowedBook(BorrowBook iBook)
    {
        borrowedBooks.add(iBook);
    }

    public void removeBorrowedBook(BorrowBook iBook)
    {
        borrowedBooks.remove(iBook);
    }
    public ArrayList<BorrowBook> getBorrowedBooks()
    {
        return borrowedBooks;
    }
}
