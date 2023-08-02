/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
class InsertSwing {
     public static void main(String[] args) {
        try{
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/java","root","");
            String qry ="INSERT INTO `student` (`id`,`name`, `post`, `salary`) VALUES ('?', '?', '?','?')";
            PreparedStatement pst=con.prepareStatement(qry);
            pst.executeUpdate();
            System.out.println(qry);
            System.out.println("Data inserted");
        }catch(SQLException ex){
            System.out.println("Execution caught"+ex.getMessage());
        }
    }
    
    
}
