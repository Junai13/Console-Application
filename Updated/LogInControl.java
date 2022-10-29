package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogInControl {
    JdbcConnection connection = new JdbcConnection();
    public boolean checkCredentials(String userName,String  password){
        Statement statement = connection.jdbcConnetion();
        try{
            ResultSet result = statement.executeQuery("select * from logindetails");
            while(result.next()){
                if(userName.equals(result.getString(1))&&(password.equals(result.getString(2)))){
                    return true;
                }
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return false;
    }
}
