package sql;

import java.sql.*;

public class dynamic {

    public static void main(String[] args) {
        String name = "shyam";
        String post = "General Manager";
        int salary = 10000;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
            String qry="INSERT INTO `teacher`(`name`,`post`,`salary`) VALUES (?,?,?)";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.setString(1, name);
            pst.setString(2, post);
            pst.setInt(3, salary);
            pst.executeUpdate();
            System.out.println(qry);
            System.out.println("data inserted");
        }catch(SQLException ex){
            System.out.println("exception caught"+ex.getMessage());
        }

    }
}
