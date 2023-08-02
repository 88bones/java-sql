
package sql;
import java.sql.*;

public class delete {
     public static void main(String[] args) {
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
            String qry ="DELETE FROM `teacher` WHERE id =1";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.executeUpdate();
            System.out.println(qry);
            System.out.println("Data deleted");
        }catch(SQLException ex){
            System.out.println("Execution caught"+ex.getMessage());
        }
    }
    
    
}
