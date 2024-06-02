package com.company;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;


public class AddEmployee extends JFrame implements ActionListener {
    Random random = new Random();
    int number = random.nextInt(999999);

    JTextField tfname, tfsname, tfsalary, tfaddress, tfphone, tfemail, tfaadhar;
    JDateChooser dcdob;
    JComboBox cbeducation, cbdesignation;
    JButton add, back;
    JLabel lblempId;

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //--------------------------------------------------------------------

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);


        //--------------------------------------------------------------------

        // name label
        JLabel labelname = new JLabel("Name : ");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        // name textfield
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);

        //--------------------------------------------------------------------


        // surname label
        JLabel labelsname = new JLabel("Surname : ");
        labelsname.setBounds(400, 150, 150, 30);
        labelsname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsname);

        // surname textfield
        tfsname = new JTextField();
        tfsname.setBounds(600, 150, 150, 30);
        add(tfsname);

        //--------------------------------------------------------------------


        // date of birth label
        JLabel labeldob = new JLabel("Date Of Birth : ");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        // date of birth chooser
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 200, 150, 30);
        add(dcdob);


        //--------------------------------------------------------------------

        // salary label
        JLabel labelsalary = new JLabel("Salary : ");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        // salry textfield
        tfsalary = new JTextField();
        tfsalary.setBounds(600, 200, 150, 30);
        add(tfsalary);

        //--------------------------------------------------------------------

        // address label
        JLabel labeladdress = new JLabel("Address : ");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        // address textfield
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        //--------------------------------------------------------------------

        // phone label
        JLabel labelphone = new JLabel("Phone : ");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        // phone textfield
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        //--------------------------------------------------------------------

        // email label
        JLabel labelemail = new JLabel("Email : ");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        // email textfield
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        //--------------------------------------------------------------------

        // education label
        JLabel labeleducation = new JLabel("Education : ");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);

        // education dropdown
        String courses[] = {"BBA", "BCA", "BA", "BCom", "BTech", "BSC", "MBA", "BCA", "MCom", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBounds(600, 300, 150, 30);
        cbeducation.setBackground(Color.WHITE);
        add(cbeducation);

        //--------------------------------------------------------------------

        // designation label
        JLabel labeldesignation = new JLabel("Designation : ");
        labeldesignation.setBounds(50, 350, 150, 30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldesignation);

        // designation combobox
        String posts[] = {"SDE-1", "SDE-2", "Senior Developer", "System Analyst", "Business Analyst ", "Network Engineer ", "Database Administrator (DBA) ", "System Administrator", "Project Manager", "IT Security Specialist", "Data Scientist", "UX/UI Designer", "DevOps Engineer", "Data Analyst", "Technical Support Specialist", "Web Developer", "Machine Learning Engineer", "Full Stack Developer", "Mobile Application Developer", "Product Manager", "Cyber Security Analyst", "Blockchain Developer/Engineer", "Artificial Intelligence (AI) Engineer", "System Integrator", "Front End Developer", "Back End Developer", "Big Data Engineer/Architect", "IT Analyst", "IT Manager/Director"};
        cbdesignation = new JComboBox(posts);
        cbdesignation.setBounds(200, 350, 150, 30);
        cbdesignation.setBackground(Color.WHITE);
        add(cbdesignation);

        //--------------------------------------------------------------------

        // aadhar label
        JLabel labelaadhar = new JLabel("Aadhar Number: ");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        // aadhar textfield
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600, 350, 150, 30);
        add(tfaadhar);

        //--------------------------------------------------------------------

        // employee-id label
        JLabel lablempId = new JLabel("Employee ID : ");
        lablempId.setBounds(50, 400, 150, 30);
        lablempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lablempId);

        // printing random employee-id
        lblempId = new JLabel("" + number); // it will convert the number into string
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        //--------------------------------------------------------------------

        // add employee button
        add = new JButton("Add Employee");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);


        //--------------------------------------------------------------------

        // back button
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //--------------------------------------------------------------------

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String sname = tfsname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem(); // typecasting object into a string
            String designation = (String) cbdesignation.getSelectedItem();
            String aadhar = tfaadhar.getText();
            String empId = lblempId.getText();

            if (name.isEmpty() || sname.isEmpty() || dob.isEmpty() || salary.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || aadhar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Fill All the Details");
                tfname.setText("");
                tfsname.setText("");
                dcdob.setDate(null);
                tfsalary.setText("");
                tfaddress.setText("");
                tfphone.setText("");
                tfemail.setText("");
                tfaadhar.setText("");
            } else {


                try {
                    Conn c = new Conn();

                    String query = "insert into employee values('" + name + "', '" + sname + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "', '" + aadhar + "', '" + empId + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details Added Successfully!");
                    setVisible(false);
                    new Home();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {

        new AddEmployee();

    }
}
