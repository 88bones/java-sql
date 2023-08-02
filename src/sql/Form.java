package sql;

import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Form implements ActionListener {

    JTextField lname, lid, lpost, lsalary;
    JRadioButton lmale, lfemale;

    public Form() {
        JFrame frame = new JFrame("Form");
        JLabel label = new JLabel();

        JLabel title = new JLabel("Form");
        title.setBounds(30, 20, 0100, 20);
        frame.add(title);

        JLabel name = new JLabel("Name");
        name.setBounds(30, 60, 50, 20);
        frame.add(name);
        lname = new JTextField();
        lname.setBounds(80, 60, 150, 20);
        frame.add(lname);

        JLabel id = new JLabel("ID");
        id.setBounds(30, 90, 50, 20);
        frame.add(id);
        lid = new JTextField();
        lid.setBounds(80, 90, 150, 20);
        frame.add(lid);

        JLabel post = new JLabel("Post");
        post.setBounds(30, 120, 50, 20);
        frame.add(post);
        lpost = new JTextField();
        lpost.setBounds(80, 120, 150, 20);
        frame.add(lpost);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(30, 150, 50, 20);
        frame.add(salary);
        lsalary = new JTextField();
        lsalary.setBounds(80, 150, 150, 20);
        frame.add(lsalary);
        
        JLabel gender=new JLabel("Gender");
        gender.setBounds(30,180, 50, 20);
        frame.add(gender);
        JRadioButton male=new JRadioButton();
        male.setBounds(80, 180, 10, 20);
        frame.add(male);
        JLabel rmale=new JLabel("Male");
        rmale.setBounds(110, 180, 30, 20);
        frame.add(rmale);
        

        JButton submit = new JButton("Submit");
        submit.setBounds(80, 210, 80, 20);
        frame.add(submit);
        submit.addActionListener(this);

        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Form();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = lname.getText();
        String post = lpost.getText();
        String id = lid.getText();
        int conID = Integer.parseInt(id);
        String salary = lsalary.getText();
        int conSalary = Integer.parseInt(salary);

        try {
            java.sql.Connection con =  DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
            System.out.println("Connected");
            Scanner sc = new Scanner(System.in);
            String qry = "INSERT INTO student (id,name, post, salary) VALUES (?, ?, ?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setInt(1, conID);
            pst.setString(2, name);
            pst.setString(3, post);
            pst.setInt(4, conSalary);
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Exception: "+ex.getMessage());
        }
    }
}
