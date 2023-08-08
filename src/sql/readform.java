
package sql;

import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.*;


public class readform {
    public static void main(String[] args) {
        int id=1;
        try{
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
            String sql="SELECT * FROM student";
            PreparedStatement statement=con.prepareStatement(sql);
            ResultSet rs=statement.execute.Query();
            
        }
    }
    
    
    
    
}
