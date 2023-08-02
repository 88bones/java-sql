package sql;
import java.sql.*;

public class table {
    public static void main(String[] args) {
        try{
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
           String qry ="CREATE TABLE teacher(id int PRIMARY KEY AUTO_INCREMENTname varchar(50),post varchar(50),salary int)";
            PreparedStatement pst=con.prepareStatement(qry);
            int value=pst.executeUpdate();
            System.out.println(qry);
            System.out.println("table created");
        }catch(SQLException ex){
            System.out.println("execption caught "+ex.getMessage());
        }
    }
}
