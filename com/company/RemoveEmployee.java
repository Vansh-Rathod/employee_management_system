package com.company;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpId;
    JButton search, remove, cancel;

    boolean flag;

    JLabel lblEmployeeId, lblname, lblsalary, lbladdress, lblphone, lblemail, lbldesignation;

    RemoveEmployee() {
        flag = false;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        // emp-id label
        JLabel labelempId = new JLabel("Emp-Id : ");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);

        // making choice scroll down
        cEmpId = new Choice();
        cEmpId.setBounds(150, 50, 150, 30);
        add(cEmpId);


        // fetching empId from the database
        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // -------------------------------------------------------------------------------

        // search button

        search = new JButton("Search");
        search.setBounds(350, 50, 100, 30);
        search.addActionListener(this);
        add(search);

        // -------------------------------------------------------------------------------


        // employee-id label
        JLabel labelEmployeeId = new JLabel("Employee-Id : ");
        labelEmployeeId.setBounds(50, 100, 100, 30);
        add(labelEmployeeId);

        lblEmployeeId = new JLabel();
        lblEmployeeId.setBounds(150, 100, 100, 30);
        add(lblEmployeeId);


        // -------------------------------------------------------------------------------

        // label name
        JLabel labelname = new JLabel("Name : ");
        labelname.setBounds(50, 150, 100, 30);
        add(labelname);

        lblname = new JLabel();
        lblname.setBounds(150, 150, 100, 30);
        add(lblname);

        // -------------------------------------------------------------------------------

        // label salary
        JLabel labelsalary = new JLabel("Salary : ");
        labelsalary.setBounds(350, 150, 100, 30);
        add(labelsalary);

        lblsalary = new JLabel();
        lblsalary.setBounds(450, 150, 100, 30);
        add(lblsalary);

        // -------------------------------------------------------------------------------

        // label address
        JLabel labeladdress = new JLabel("Address : ");
        labeladdress.setBounds(50, 200, 100, 30);
        add(labeladdress);

        lbladdress = new JLabel();
        lbladdress.setBounds(150, 200, 100, 30);
        add(lbladdress);

        // -------------------------------------------------------------------------------

        // label phone
        JLabel labelphone = new JLabel("Phone : ");
        labelphone.setBounds(350, 200, 100, 30);
        add(labelphone);

        lblphone = new JLabel();
        lblphone.setBounds(450, 200, 100, 30);
        add(lblphone);

        // -------------------------------------------------------------------------------

        // label email
        JLabel labelemail = new JLabel("Email : ");
        labelemail.setBounds(50, 250, 100, 30);
        add(labelemail);

        lblemail = new JLabel();
        lblemail.setBounds(150, 250, 100, 30);
        add(lblemail);

        // -------------------------------------------------------------------------------

        // label designation
        JLabel labeldesignation = new JLabel("Designation : ");
        labeldesignation.setBounds(350, 250, 100, 30);
        add(labeldesignation);

        lbldesignation = new JLabel();
        lbldesignation.setBounds(450, 250, 100, 30);
        add(lbldesignation);

        // -------------------------------------------------------------------------------


        // remove button
        remove = new JButton("Remove");
        remove.setBounds(100, 300, 100, 30);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.WHITE);
        remove.addActionListener(this);
        add(remove);

        // -------------------------------------------------------------------------------


        // cancel button
        cancel = new JButton("Cancel");
        cancel.setBounds(250, 300, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        // -------------------------------------------------------------------------------

        // setting image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // converted i2 into imageIcon i3 because you can't directly pass image object into JLabel converted to imageIcon object and passed it to JLabel
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 350, 250);
        add(image);

        // -------------------------------------------------------------------------------


        setSize(1000, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            try {
                flag = true;
                Conn c = new Conn();
                String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "'";
                ResultSet rs = c.s.executeQuery(query);
                // it will fetch all the details from the database table and show it here
                while (rs.next()) {
                    lblEmployeeId.setText(rs.getString("empId"));
                    lblname.setText(rs.getString("name"));
                    lblsalary.setText(rs.getString("salary"));
                    lbladdress.setText(rs.getString("address"));
                    lblphone.setText(rs.getString("phone"));
                    lblemail.setText(rs.getString("email"));
                    lbldesignation.setText(rs.getString("designation"));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == remove) {
            try {
                if (flag) {
                    Conn c = new Conn();
                    String query = "delete from employee where empId = '" + cEmpId.getSelectedItem() + "'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Employee Removed Successfully");
                    setVisible(false);
                    new Home();
                } else {
                    JOptionPane.showMessageDialog(null, "Please Select Employee");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
