package thirukkural;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcConnection {
    public Statement jdbcConnetion(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" +
                    "thirukuralall","root","JunaiJ@13");
            return connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
