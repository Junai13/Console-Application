package mainfunction;

import operation.Booking;
import operation.Validator;

public class GetInput {
    Validator validator = new Validator();
    Booking book = new Booking();
    public void startingProcess(){
        System.out.println("***************************************************************************");
        System.out.println("\t\t\t\t\t Welcome to JJ Towers");
        System.out.println("***************************************************************************");
        System.out.println("\n\n WE ARE PROVIDING BUS SERVICE FOR FOLLOWING CITIES ONLY. OTHERS WILL BE STARTED SOON" +
                "\nAND YOU CAN BOOK TICKET FOR TODAY TRAVEL ONLY. " +
                "\nIF YOU WANT TO BOOK TICKET FOR ANY OTHER DAY PLEASE COME BACK ON THAT DAY." +
                " ");
        System.out.println("""
                1.Chennai
                2.Madurai
                3.Tirchy
                4.Coimbatore
                5.Thoothukudi
                """);
        boolean flag = true;
        do {
            System.out.println("Please choose the option to continue");
            System.out.println("""
                    1. To check the availability of the buss
                    2. To book ticket
                    3. To cancel ticket
                    4. To exit
                    """);
            int choice = validator.validateChoice();
            switch (choice) {
                case 1:
                    book.showAvailablity();
                    break;
                case 2:
                    book.bookTicket();
                    break;
                case 3:
                    book.cancelTicket();
                    break;
                case 4:
                    System.out.println("!!!! THANK YOU FOR CHOOSING US !!!!");
                    flag= false;
                    break;
            }
        }while(flag);
    }
}
