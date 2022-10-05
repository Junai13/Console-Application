package contactmanagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static contactmanagement.Validator.*;


public class Database {
    SqlConnection connection = new SqlConnection();
    Statement statement = connection.jdbcConnetion();
    Validator valid = new Validator();
    public void addContactInDB(String name, long mob_no,String contact_type){
        try {
            int result = statement.executeUpdate("insert into contact_table(fname, Mob_num, Contact_type) value ( '"+name +"',"+mob_no
           +",'" + contact_type+"')" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addContactInDB(String name,long mob_no,String contact_type,String DoB,String Address){
        try {
            int result = statement.executeUpdate("insert into contact_table(fname, Mob_num,Contact_type, DOB,Address) value ( '"+name +"',"+mob_no
                    +",'" + contact_type+"','"+ DoB +"','"+Address+"')" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(String name){
        try {
            ResultSet resultSet = statement.executeQuery("select * from contact_table where fname = '" +name +"'");
            String contact_name = "";
            while(resultSet.next()) {
                contact_name = resultSet.getString(1);
            }
            if(contact_name.equalsIgnoreCase(name)){
                int del = statement.executeUpdate("delete from contact_table where fname = '"+ name + "'");
                System.out.println(GREEN+"CONTACTED DELETED SUCCESSFULLY!!!"+RESET);
            }else System.out.println(RED+"THERE IS NO CONTACT WITH THIS NAME"+RESET);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void searchByName(String name){
        try{
            ResultSet resultSet = statement.executeQuery("select * from contact_table where fname = '" +name +"'");
            while(resultSet.next()) {
                    System.out.println("Name: " + resultSet.getString(1)+
                            "\nMobile No: " + resultSet.getLong(3)+
                            "\nContact Type: " + resultSet.getString(6)+
                            "\nDoB: " + resultSet.getString(5)+
                            "\nAddress : " + resultSet.getString(4));
                }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void searchByLastNum(int num){
        try {
            ResultSet resultSet = statement.executeQuery("select * from contact_table where Mob_num like '%" + num + "'");
            if (resultSet.next()) {
                while (resultSet.next()) {
                    System.out.println("Name: " + resultSet.getString(1) +
                            "\nMobile No: " + resultSet.getLong(3) +
                            "\nContact Type: " + resultSet.getString(6) +
                            "\nDoB: " + resultSet.getString(5) +
                            "\nAddress : " + resultSet.getString(4));
                }
            } else
                System.out.println("NO CONTACT WITH THIS DETAIL");
        } catch (SQLException e) {
            System.out.println("There is no number like this");
        }
    }
    public void searchByFirstNum(int num){
        try {
            ResultSet resultSet = statement.executeQuery("select * from contact_table where Mob_num like '" +num +"%'");
            if(resultSet.next()) {
                while (resultSet.next()){
                    System.out.println("Name: " + resultSet.getString(1)+
                            "\nMobile No: " + resultSet.getLong(3)+
                            "\nContact Type: " + resultSet.getString(6)+
                            "\nDoB: " + resultSet.getString(5)+
                            "\nAddress : " + resultSet.getString(4));
                }
            }else
                System.out.println("NO CONTACT WITH THIS DETAIL");
        } catch (SQLException e) {
            System.out.println("There is no number like this");
        }
    }

    public void viewAllContact() {
        ResultSet result = null;
        try {
            result = statement.executeQuery("select * from contact_table");
            System.out.println("  Name  \t\t Mobile No \t\t Contact Type \t\t    DoB \t\t\t\t \tAddress");
            while (result.next()) {
                System.out.printf("%10s%15s%15s\t\t\t%10s%30s",result.getString(1),
                        result.getLong(3) ,
                         result.getString(6) ,
                         result.getString(5) ,
                         result.getString(4));
                System.out.println();
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String name) {
        try {
            ResultSet resultSet = statement.executeQuery("select * from contact_table where fname = '" + name + "'");
            String contact_name = "";
            while (resultSet.next()) {
                contact_name = resultSet.getString(1);
            }
            if (contact_name.equalsIgnoreCase(name)) {
                System.out.println("Enter name: ");
                String newName = sc.next();
                long newMobNo = valid.validatemobile();
                String newDoB = valid.validateDoB();
                System.out.println("Enter Address");
                String newAddress = sc.nextLine();
                String type;
                while (true) {
                    System.out.println("Enter the type of the contact(Personal or Professional): ");
                    type = sc.next();
                    if (type.equalsIgnoreCase("Personal") || type.equalsIgnoreCase("Professional")) {
                        break;
                    } else System.out.println(RED + "PLEASE ENTER A VALID DATA" + RESET);
                }
                int update = statement.executeUpdate("update contact_table set fname = '"+newName+
                        "',Mob_num = "+ newMobNo+",Address= '"+newAddress+"' ,DOB = '"+newDoB+
                        "',Contact_type = '"+type+"' where fname = '"+ name+"';");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
