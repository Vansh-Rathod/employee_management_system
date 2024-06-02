package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import net.proteanit.sql.DbUtils;


public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice cEmpId;
    JButton search, print, update, home, showall;

    ViewEmployee() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //--------------------------------------------------------------------

        // search by employee-id label
        JLabel searchlbl = new JLabel("Search by Employee-ID : ");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);

        // choice option scroll down
        cEmpId = new Choice();
        cEmpId.setBounds(180, 20, 150, 20);
        add(cEmpId);


        // try-catch for showing the only all the employee-id's in the scroll down choice
        try {
            Conn c = new Conn();

            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                // it will fetch all the values from that particular column mentioned as "empId"
                cEmpId.add(rs.getString("empId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------

        // creating the table so that the resultset rs can add all the values in the table
        table = new JTable();

        // try-catch to add the values and show all the employees with their details
        try {
            Conn c = new Conn();

            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            // it will fetch all the details from the database table and show it here
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        //--------------------------------------------------------------------


        // scroll pane for displaying table if it has so many employees
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 600);
        add(jsp);

        //--------------------------------------------------------------------

        // search button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);


        //--------------------------------------------------------------------

        // print button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);


        //--------------------------------------------------------------------

        // update button
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20);
        update.addActionListener(this);
        add(update);


        //--------------------------------------------------------------------

        // back button
        home = new JButton("Home");
        home.setBounds(320, 70, 80, 20);
        home.addActionListener(this);
        add(home);

        //--------------------------------------------------------------------

        // all employee button
        showall = new JButton("Show All");
        showall.setBounds(420, 70, 80, 20);
        showall.addActionListener(this);
        add(showall);

        //--------------------------------------------------------------------


        setSize(900, 700);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // search
        if (ae.getSource() == search) {
            try {
                Conn c = new Conn();
                String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "'";
                ResultSet rs = c.s.executeQuery(query);
                // it will fetch all the details from the database table and show it here
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // print
        else if (ae.getSource() == print) {
            try {
                table.print();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        // update
        else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee((String) cEmpId.getSelectedItem());

        }
        // back
        else if (ae.getSource() == home) {
            setVisible(false);
            new Home();
        }
        // show all
        else {
            try {
                table = new JTable();

                Conn c = new Conn();
                String query = "select * from employee";
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

                JScrollPane jsp1 = new JScrollPane(table);
                jsp1.setBounds(0, 100, 900, 600);
                add(jsp1);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String[] args) {
        new ViewEmployee();
    }
}
