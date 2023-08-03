package sql;

import com.mysql.jdbc.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Form implements ActionListener {

    JTextField lname, lid, lpost, lsalary;
    JRadioButton male, female;
    JComboBox province;

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

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30, 180, 50, 20);
        frame.add(gender);
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        male.setBounds(90, 180, 60, 20);
        female.setBounds(150, 180, 90, 20);
        frame.add(male);
        frame.add(female);
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        String[] provinces = {"Select your province", "Province 1", "Province 2", "Province 3", "Province 4", "Province 5", "Province 6", "Province 7"};
        province = new JComboBox(provinces);
        province.setBounds(30, 210, 150, 20);
        frame.add(province);

        JButton submit = new JButton("Submit");
        submit.setBounds(30, 250, 200, 20);
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
        int conSalary=0,conID=0;
        String name = lname.getText();
        String post = lpost.getText();
        String id = lid.getText();
        if (id.equals("")) {
            JOptionPane.showMessageDialog(null, "Insert salary");
        } else {
            conID = Integer.parseInt(id);
        }
        String salary = lsalary.getText();
        if (salary.equals("")) {
            JOptionPane.showMessageDialog(null, "Insert salary");
        } else {
            conSalary = Integer.parseInt(salary);
        }
        String genders = "";
        if (male.isSelected()) {
            genders = "Male";
        } else {
            genders = "Female";
        }
        String provinces = (String) province.getSelectedItem();

        if (name.equals("") || post.equals("") || provinces.equalsIgnoreCase("Select your province")) {
            JOptionPane.showMessageDialog(null, "Please insert data properly");
        } else {
            try {
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java", "root", "");
                System.out.println("Connected");
                Scanner sc = new Scanner(System.in);
                String qry = "INSERT INTO student (id,name,post,salary,gender,province) VALUES (?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(qry);
                pst.setInt(1, conID);
                pst.setString(2, name);
                pst.setString(3, post);
                pst.setInt(4, conSalary);
                pst.setString(5, genders);
                pst.setString(6, provinces);
                pst.executeUpdate();

            } catch (SQLException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }
}
