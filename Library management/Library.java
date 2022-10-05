package library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import static library.Borrower.*;
import static library.InputOperation.validator;

public class Library {

    private String name;
    public static ArrayList <Person> persons;
    private ArrayList<Book> booksInLibrary;

    private ArrayList <BorrowBook> borrowBooks;

    public int book_return_deadline;
    public double per_day_fine;

    private static Library obj;
    public static Library getInstance()
    {
        if(obj==null)
        {
            obj = new Library();
        }

        return obj;
    }
    private Library()
    {
        name = null;
        persons = new ArrayList();
        booksInLibrary = new ArrayList();
        borrowBooks = new ArrayList();
    }
    public void setReturnDeadline(int deadline)
    {
        book_return_deadline = deadline;
    }

    public void setFine(double perDayFine)
    {
        per_day_fine = perDayFine;
    }
    public void setName(String n)
    {
        name = n;
    }
    public ArrayList<Person> getPersons()
    {
        return persons;
    }
    public String getLibraryName()
    {
        return name;
    }
    public ArrayList<Book> getBooks()
    {
        return booksInLibrary;
    }
    public void addBorrower(Borrower b)
    {
        persons.add(b);
    }
    public void defaultBook(){
        Book book1 = new Book(001,"Head First Java","Programming","Kathy Sierra & Bert Bates",false);
        Book book2 = new Book(002,"Clean Code","Programming","Robert C. Martin Series",false);
        Book book3 = new Book(003,"JAVA","Programming","James Gossiling",false);
        Book book4 = new Book(004,"Thanneer Thesam","Noval","Vaira muthu",false);
        Book book5 = new Book(005,"Ponniyin Selvan part 1","Historical Noval","Kalki Krishnarayan",false);
        Book book6 = new Book(006,"Wings of Fire","Auto Biography","Dr.A.P.J.Abdul Kalam",false);
        booksInLibrary.add(book1);
        booksInLibrary.add(book2);booksInLibrary.add(book3);
        booksInLibrary.add(book4);
        booksInLibrary.add(book5);
        booksInLibrary.add(book6);
    }


    public void addLoan(BorrowBook l)
    {
        borrowBooks.add(l);
    }
    public Borrower findBorrower()
    {
        System.out.println("\nEnter Borrower's ID: ");
        int id = 0;
        Scanner scanner = new Scanner(System.in);
        try{
            id = scanner.nextInt();
        }
        catch (java.util.InputMismatchException e)
        {
            System.out.println("\nInvalid Input");
        }
        for (int i = 0; i < persons.size(); i++)
        {
            if (persons.get(i).getID() == id && persons.get(i).getClass().getSimpleName().equals("Borrower"))
                return (Borrower)(persons.get(i));
        }
        System.out.println(RED+"\nSorry this ID didn't match any Borrower's ID."+RESET);
        return null;
    }
    public void addBookinLibrary(Book b)
    {
        booksInLibrary.add(b);
    }
    public void removeBookfromLibrary(Book b) {
        boolean delete = true;
        //Checking if this book is currently borrowed by some borrower
        for (int i = 0; i < persons.size() && delete; i++) {
            if (persons.get(i).getClass().getSimpleName().equals("Borrower")) {
                ArrayList<BorrowBook> borBooks = ((Borrower) (persons.get(i))).getBorrowedBooks();

                for (int j = 0; j < borBooks.size() && delete; j++) {
                    if (borBooks.get(j).getBook() == b) {
                        delete = false;
                        System.out.println(RED+"This particular book is currently borrowed by some borrower."+RESET);
                    }
                }
            }
        }
        if (delete) {
            System.out.println(GREEN+ "\nCurrently this book is not borrowed by anyone.");
            booksInLibrary.remove(b);
            System.out.println("The book is successfully removed."+RESET);
        } else
            System.out.println(RED+"\nDelete Unsuccessful."+RESET);
    }

    public ArrayList<Book> searchForBooks() throws IOException
    {
        String choice;
        String title = "", subject = "", author = "";

        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            System.out.println("""
                    Please Enter the Choice to continue by which option you want to search.
                    1. Title
                    2. Subject
                    3. Author""");
            choice = sc.next();

            if (choice.equals("1") || choice.equals("2") || choice.equals("3"))
                break;
            else
                System.out.println(RED+"\nWrong Input!"+RESET);
        }

        if (choice.equals("1"))
        {
            System.out.println("\nEnter the Title of the Book: ");
            title = reader.readLine();
        }

        else if (choice.equals("2"))
        {
            System.out.println("\nEnter the Subject of the Book: ");
            subject = reader.readLine();
        }

        else
        {
            System.out.println("\nEnter the Author of the Book: ");
            author = reader.readLine();
        }

        ArrayList<Book> matchedBooks = new ArrayList();
        for(int i = 0; i < booksInLibrary.size(); i++)
        {
            Book b = booksInLibrary.get(i);

            if (choice.equals("1"))
            {
                if (b.getTitle().equalsIgnoreCase(title))
                    matchedBooks.add(b);
            }
            else if (choice.equals("2"))
            {
                if (b.getSubject().equalsIgnoreCase(subject))
                    matchedBooks.add(b);
            }
            else
            {
                if (b.getAuthor().equalsIgnoreCase(author))
                    matchedBooks.add(b);
            }
        }

        //Printing all the matched Books
        if (!matchedBooks.isEmpty())
        {
            System.out.println(GREEN+"\nThese books are found: \n"+RESET);

            System.out.println("------------------------------------------------------------------------------");
            System.out.println("No.\t\tTitle\t\t\tAuthor\t\t\tSubject");
            System.out.println("------------------------------------------------------------------------------");

            for (int i = 0; i < matchedBooks.size(); i++)
            {
                System.out.print(i + "-" + "\t\t");
                matchedBooks.get(i).printInfo();
                System.out.print("\n");
            }

            return matchedBooks;
        }
        else
        {
            System.out.println(RED+"\nSorry. No Books were found related to your query."+RESET);
            return null;
        }
    }
    // View Info of all Books in Library
    public void viewAllBooks()
    {
        if (!booksInLibrary.isEmpty())
        {
            System.out.println(GREEN+"\nBooks are: "+RESET);

            System.out.println("------------------------------------------------------------------------------");
            System.out.println("No.\t\tTitle\t\t\t\tAuthor\t\t\tSubject");
            System.out.println("------------------------------------------------------------------------------");

            for (int i = 0; i < booksInLibrary.size(); i++)
            {
                System.out.print(i + "-" + "\t\t");
                booksInLibrary.get(i).printInfo();
                System.out.print("\n");
            }
        }
        else
            System.out.println(RED+"\nCurrently, Library has no books."+RESET);
    }
    //Computes total fine for all loans of a borrower
    public double computeFine2(Borrower borrower)
    {
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("No.\t\tBook's Title\t\tBorrower's Name\t\t\t\t\t\t\tIssued Date\t\t\t\t\tReturned Date\t\t\t\tFine(Rs)");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        double totalFine = 0;
        double per_loan_fine = 0;

        for (int i = 0; i < borrowBooks.size(); i++)
        {
            BorrowBook l = borrowBooks.get(i);

            if ((l.getBorrower() == borrower))
            {
                per_loan_fine = l.computeFine1();
                System.out.print(i + "-" + "\t\t" + borrowBooks.get(i).getBook().getTitle() + "\t\t\t" + borrowBooks.get(i).getBorrower().getName() + "\t\t" + borrowBooks.get(i).getIssuedDate() +  "\t\t\t" + borrowBooks.get(i).getReturnDate() + "\t\t\t\t" + per_loan_fine  + "\n");

                totalFine += per_loan_fine;
            }
        }

        return totalFine;
    }
    public void createPerson()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String n = sc.nextLine();
        System.out.println("Enter your address:");
        String address = sc.nextLine();
        String phone = validator.validatemobile();
        Borrower b = new Borrower(-1,n,address, phone);
        addBorrower(b);
        System.out.println("\nBorrower with name " + n + " created successfully.");

        System.out.println("\nYour ID is : " + b.getID());
    }
    public void createBook(String title, String subject, String author)
    {
        Book b = new Book(-1,title,subject,author,false);

        addBookinLibrary(b);

        System.out.println("\nBook with Title " + b.getTitle() + " is successfully created.");
    }
}