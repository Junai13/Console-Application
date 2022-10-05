package model;
import operation.JdbcConnection;
import java.sql.Statement;

public class Traveller {
    private String name;
    private long mobileNumber;
    private long aadharNumber;
    private String address;
    private int ticketNo;
    JdbcConnection conn = new JdbcConnection();

    /*public Traveller(String name, long mobileNumber, long aadharNumber, String address){
        this.name = name;
        this.mobileNumber=mobileNumber;
        this.aadharNumber = aadharNumber;
        this.address = address;
        this.ticketNo = ticketNo++;
    }*/
    public int getTicketNo() {
        return ticketNo;
    }
    public String getName(){
        return name;
    }
    public long getMobileNumber(){
        return mobileNumber;
    }
    public long getAadharNumber(){
        return aadharNumber;
    }
    public String getAddress(){
        return address;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMobileNumber(long number){
        mobileNumber = number;
    }
    public void setTicketNo(int ticketNo){
        this.ticketNo = ticketNo;
    }
    public void setAadharNumber(long aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
