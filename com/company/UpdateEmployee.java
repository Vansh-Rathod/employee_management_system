package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JTextField tfsalary, tfaddress, tfphone, tfemail;
    JComboBox cbeducation, cbdesignation;
    JButton update, back;
    JLabel lblempId;

    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //--------------------------------------------------------------------

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);


        //--------------------------------------------------------------------

        // name label
        JLabel labelname = new JLabel("Name : ");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        // printing permanent name label
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        //--------------------------------------------------------------------


        // father name label
        JLabel labelsname = new JLabel("Surname : ");
        labelsname.setBounds(400, 150, 150, 30);
        labelsname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsname);

        // printing permanent father name label
        JLabel lblsname = new JLabel();
        lblsname.setBounds(600, 150, 150, 30);
        add(lblsname);

        //--------------------------------------------------------------------


        // date of birth label
        JLabel labeldob = new JLabel("Date Of Birth : ");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        // permanent date of birth label
        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);


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
        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);

        //--------------------------------------------------------------------

        // employee-id label
        JLabel lablempId = new JLabel("Employee ID : ");
        lablempId.setBounds(50, 400, 150, 30);
        lablempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lablempId);

        // printing random employee-id
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        //--------------------------------------------------------------------

        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '" + empId + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblsname.setText(rs.getString("sname"));
                lbldob.setText(rs.getString("dob"));
                tfsalary.setText(rs.getString("salary"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                cbeducation.setSelectedItem(rs.getString("education"));
                cbdesignation.setSelectedItem(rs.getString("designation"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempId.setText(rs.getString("empId"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //--------------------------------------------------------------------

        // update employee button
        update = new JButton("Update Employee Details");
        update.setBounds(250, 550, 150, 40);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);


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
        if (ae.getSource() == update) {
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = (String) cbdesignation.getSelectedItem();

            if(salary.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Fill All the Details");
            }
            else {


                try {
                    Conn c = new Conn();

                    String query = "update employee set salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "', education = '" + education + "', designation = '" + designation + "' where empId = '" + empId + "'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Details Updated Successfully!");
                    setVisible(false);
                    new Home();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } else {
            setVisible(false);
            new ViewEmployee();
        }
    }

    public static void main(String[] args) {

        new UpdateEmployee("");

    }
}
