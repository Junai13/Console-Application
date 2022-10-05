package contactmanagement;

import java.sql.*;

public class SqlConnection {

        public Statement jdbcConnetion(){
            try{
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                        "contacts","root","JunaiJ@13");
                return connection.createStatement();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
    }
}
