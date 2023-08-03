package sql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deleteform implements ActionListener {

    JTextField lid;

    public deleteform() {
        JFrame frame = new JFrame("Data Deletion");

        JLabel id = new JLabel("ID");
        id.setBounds(30, 60, 50, 20);
        frame.add(id);
        lid = new JTextField();
        lid.setBounds(80, 60, 150, 20);
        frame.add(lid);

        JButton submit = new JButton("Delete");
        submit.setBounds(30, 100, 200, 20);
        frame.add(submit);
        submit.addActionListener(this);

        frame.setSize(300, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new deleteform();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int conID = 0;
        String id = lid.getText();
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Insert salary");
        } else {
            conID = Integer.parseInt(id);
        }
        try{
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
                System.out.println("Connected");
                Scanner sc = new Scanner(System.in);
                String qry = "DELETE FROM student WHERE id=?";
                PreparedStatement pst = con.prepareStatement(qry);
                pst.setInt(1, conID);
                pst.executeUpdate();
                pst.close();
        }catch(SQLException ex){
            System.out.println("Exception "+ex.getMessage());
            
        }
    }

}
