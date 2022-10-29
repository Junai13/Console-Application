package model;
import controller.JdbcConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class DataBase {
    JdbcConnection conn = new JdbcConnection();
    private List<Traveller> travellerList;
    private List<Bus> buses;
    Traveller traveller = new Traveller();
//    private List<BookTicket> bookTicketList;
    Statement statement = conn.jdbcConnetion();
    public DataBase() {
        buses = new ArrayList<>();
        travellerList = new ArrayList<>();
//        bookTicketList = new ArrayList<>();
    }

//   public void addTravellerList(List<Traveller> travellerList) {
//      this.travellerList.addAll(travellerList);
//   }

    public void addTraveller(Traveller traveller,int busNum) {
        this.travellerList.add(traveller);
        System.out.println();
        try{
            String query = "insert into traveller_details(traveller_name,Mobile_num,Aadhar_num,Address,Bus_No) value  ('" +
                    traveller.getName()+"',"+
                    traveller.getMobileNumber()+","+
                    traveller.getAadharNumber()+",'"+
                    traveller.getAddress()+"',"
                    +busNum +" )";
            int resultSet = statement.executeUpdate(query);
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
    public void registerUser(Traveller traveller,String userName,String password) {
        this.travellerList.add(traveller);
        try {
            String query = "insert into user_details(userName,mobileNumber,AadharNumber,Address,logname,Password)" +
                    " value  ('" +
                    traveller.getName() + "'," +
                    traveller.getMobileNumber() + "," +
                    traveller.getAadharNumber() + ",'" +
                    traveller.getAddress() + "','" +userName +"','" +password
                    + "' )";
            int resultSet = statement.executeUpdate(query);
            int result = statement.executeUpdate("insert into logindetails( UserName, Password) values ('"
            +userName +"','"+password+"')");
            System.out.println("Registerd Successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public void removeTraveller(int ticketno){
        try {
            int result = statement.executeUpdate("delete from traveller_details where Ticket_no =" + ticketno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cancel(String name,int no) {
        int ticketNum = 0;
        String travelerName = "";
        try {
            ResultSet result = statement.executeQuery("select * from traveller_details where Ticket_No = " + no);
            while (result.next()) {
                ticketNum = result.getInt(1);
                travelerName = result.getString(2);
            }
            if (name.equalsIgnoreCase(travelerName) && no == ticketNum) {
                for (int i = 0; i < travellerList.size(); i++) {
                    if (no == travellerList.get(i).getTicketNo())
                        travellerList.remove(i);
                }
                removeTraveller(no);
                System.out.println("Your Ticket was cancelled Succesfully!!!!");
            } else
                System.out.println("SORRY. YOU HAD ENTERED WRONG DETAIL.THERE IS NO ENTRY IN THIS DETAIL. PLEASE ENTER CORRECT DETAIL");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void addBus(Bus bus) {
        this.buses.add(bus);
    }

    public void viewBusDetails() {
        try {
            ResultSet result = statement.executeQuery("select * from bus_details");
            while (result.next()) {
                Bus b1 = new Bus(result.getInt(1), result.getBoolean(2),
                        result.getInt(3), result.getString(4),result.getInt(5));
                addBus(b1);
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
}
