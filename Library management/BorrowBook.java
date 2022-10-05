package library;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;
public class BorrowBook {
    private Borrower borrower;
    private Book book;
    private Person receiver;
    private Date issuedDate;
    private Date dateReturned;
    private boolean finePaid;
    public BorrowBook(Borrower bor, Book b, Person i, Date iDate, Date rDate, boolean fPaid)
    {
        borrower = bor;
        book = b;
        receiver = i;
        issuedDate = iDate;
        dateReturned = rDate;

        finePaid = fPaid;
    }
    public Book getBook()       //Returns the book
    {
        return book;
    }
    public Date getIssuedDate()
    {
        return issuedDate;
    }

    public Date getReturnDate()
    {
        return dateReturned;
    }
    public Person getReceiver()
    {
        return receiver;
    }

    public Borrower getBorrower()
    {
        return borrower;
    }

    public boolean getFineStatus()
    {
        return finePaid;
    }
    public void setReturnedDate(Date dReturned)
    {
        dateReturned = dReturned;
    }

    public void setFineStatus(boolean fStatus)
    {
        finePaid = fStatus;
    }

    public double computeFine1()
    {
        double totalFine = 0;

        if (!finePaid)
        {
            Date issueDate = issuedDate;
            Date returnDate = new Date();

            long days =  ChronoUnit.DAYS.between(returnDate.toInstant(), issueDate.toInstant());
            days=0-days;

            days = days - Library.getInstance().book_return_deadline;

            if(days>0)
                totalFine = days * Library.getInstance().per_day_fine;
            else
                totalFine=0;
        }
        return totalFine;
    }


    public void payFine()
    {
        double totalFine = computeFine1();

        if (totalFine > 0)
        {
            System.out.println("\nTotal Fine generated: Rs " + totalFine);

            System.out.println("Do you want to pay? (y/n)");

            Scanner input = new Scanner(System.in);

            String choice = input.next();

            if(choice.equals("y") || choice.equals("Y"))
                finePaid = true;

            if(choice.equals("n") || choice.equals("N"))
                finePaid = false;
        }
        else
        {
            System.out.println("\nNo fine is generated.");
            finePaid = true;
        }
    }


    // Extending issued Date
    public void renewIssuedBook(Date iDate)
    {
        issuedDate = iDate;

        System.out.println("\nThe deadline of the book " + getBook().getTitle() + " has been extended.");
        System.out.println("Issued Book is successfully renewed!\n");
    }

}
