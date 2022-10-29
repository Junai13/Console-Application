package controller;
import model.Bus;
import model.DataBase;
import model.Traveller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Booking {
    private final DataBase dataBase = new DataBase();
    private Validator validator = new Validator();
    private JdbcConnection conn = new JdbcConnection();
    private List<Bus> buses = buses = new ArrayList<>();
    private Traveller person = new Traveller();
    private Scanner sc = new Scanner(System.in);
    private Statement statement = conn.jdbcConnetion();
    public void showAvailablity(){
        try {
            ResultSet result = statement.executeQuery("select * from bus_details where Availability>0");
            while(result.next()){
                Bus b1 = new Bus(result.getInt(1),result.getBoolean(2),
                        result.getInt(3),result.getString(4),result.getInt(5));
                buses.add(b1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Bus No \t\t    Has AC \t\t Capacity \t\t\t Route \t\t\t Available Seat");
        for (int i = 0; i < buses.size(); i++) {
            System.out.print(buses.get(i).getBusNo());
            System.out.print("\t\t\t\t" + buses.get(i).isAc());
            System.out.print("\t\t\t" + buses.get(i).getCapacity());
            System.out.printf("\t\t\t" +"%10s", buses.get(i).getRoute());
            System.out.printf("\t\t\t\t"+"%02d%n", buses.get(i).getAvailabilty());
            System.out.println();
        }
    }
    public void bookTicket(){
        dataBase.viewBusDetails();
        int busNo;
        int availableSeat=0;
        while(true) {
            busNo = validator.validateBusno();
            if (busNo < 101 || busNo > 111)
                System.out.println("Please enter valid bus no");
            else break;
        }
        try {
            ResultSet result = statement.executeQuery("select * from bus_details where busNo= " + busNo);
            while (result.next()) {
                availableSeat = result.getInt(5);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(availableSeat>0) {
            int ticketNo =0;
            System.out.println("Enter your name: ");
            String name = sc.nextLine();
            long mobileNo = validator.validateMobileNo();
            long aadharNo = validator.validateAadhaar();
            System.out.println("Enter your address");
            String address = sc.nextLine();
            person.setName(name);
            person.setAadharNumber(aadharNo);
            person.setAddress(address);
            person.setMobileNumber(mobileNo);
            dataBase.addTraveller(person,busNo);
//            dataBase.setTraveller();
            availableSeat--;
            try {
                String query ="update bus_details set Availability = " + availableSeat +" where busNo = " + busNo;
                int result = statement.executeUpdate(query);
                ResultSet resultSet = statement.executeQuery("select * from traveller_details where " +
                        "traveller_name = '"
                +name+"'");
                while(resultSet.next()){
                    ticketNo = resultSet.getInt(1);
                    person.setTicketNo(ticketNo);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("TICKET BOOKED FOR " + name + " ON " + busNo + " SUCCESSFULLY!!!" +
                    "\nYOUR TICKT NUMBER: "+ticketNo);
        }
        else
            System.out.println("SORRY!! ALL THE SEAT IN THE BUS IS CURRENTLY FILLED. PLEASE CHOOSE ANOTHER BUS OR WAIT UNTILL TOMORROW!!");
    }

    public void cancelTicket(){
        System.out.println("Enter the ticket number which you want to cancel: ");
        int ticketNo = validator.validateTicket();
        System.out.println("Enter the name of the traveller: ");
        String name = sc.next();
        dataBase.cancel(name,ticketNo);
    }
}
