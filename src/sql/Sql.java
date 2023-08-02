
package sql;
import java.sql.*;

public class Sql {

 
    public static void main(String[] args) {
      try{
          DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
          System.out.println("connected to database");
      } catch(SQLException ex){
          System.out.println("exception caught"+ex.getMessage());
      }
    }
    
}
