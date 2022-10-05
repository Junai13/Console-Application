package library;

import java.util.Date;

public class Book {
    private int bookID;
    private String title;
    private String subject;
    private String author;
    private boolean isIssued;
    static int currentIdNumber = 0;
    public Book(int id, String t, String s, String a, boolean issued)
    {
        currentIdNumber++;
        if (id == -1) {
            bookID = currentIdNumber;
        } else
            bookID = id;
        title = t;
        subject = s;
        author = a;
        isIssued = issued;
    }

    public void printInfo() {
        System.out.println(title + "\t\t\t" + author + "\t\t\t" + subject);
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getAuthor() {
        return author;
    }

    public boolean getIssuedStatus() {
        return isIssued;
    }

    public void setIssuedStatus(boolean s) {
        isIssued = s;
    }

    public int getID() {
        return bookID;
    }

    public static void setIDCount(int n) {
        currentIdNumber = n;
    }

    public void issueBook(Borrower borrower) {
        setIssuedStatus(true);

        BorrowBook iHistory = new BorrowBook(borrower, this,null,new Date(),null,false);

        Library.getInstance().addLoan(iHistory);
        borrower.addBorrowedBook(iHistory);

        System.out.println("\nThe book " + title + " is successfully issued to " + borrower.getName() + ".");
    }

    // Returning a Book
    public void returnBook(Borrower borrower, BorrowBook l) {
        l.getBook().setIssuedStatus(false);
        l.setReturnedDate(new Date());


        borrower.removeBorrowedBook(l);

        l.payFine();

        System.out.println("\nThe book " + l.getBook().getTitle() + " is successfully returned by " + borrower.getName() + ".");
    }
}
