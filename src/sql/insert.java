package sql;
import java.sql.*;
public class insert {
    public static void main(String[] args) {
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
            String qry ="INSERT INTO `teacher` (`name`, `post`, `salary`) VALUES ('ram', 'manager', '50000')";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.executeUpdate();
            System.out.println(qry);
            System.out.println("Data inserted");
        }catch(SQLException ex){
            System.out.println("Execution caught"+ex.getMessage());
        }
    }
    
}
