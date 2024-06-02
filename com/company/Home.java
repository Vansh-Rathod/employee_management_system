package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton add, view, update, remove, logout;

    Home() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //--------------------------------------------------------------------

        // image setting
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // converted i2 into imageIcon i3 because you can't directly pass image object into JLabel converted to imageIcon object and passed it to JLabel
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);

        //--------------------------------------------------------------------

        // employee management system label
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);

        //--------------------------------------------------------------------

        // add employee button
        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40);
        add.addActionListener(this);
        image.add(add);

        //--------------------------------------------------------------------

        // View Employee Details button
        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40);
        view.addActionListener(this);
        image.add(view);

        //--------------------------------------------------------------------

        // Update Employee Details button
        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40);
        update.addActionListener(this);
        image.add(update);

        //--------------------------------------------------------------------

        // Remove Employee button
        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40);
        remove.addActionListener(this);
        image.add(remove);

        //--------------------------------------------------------------------

        logout = new JButton("Log Out");
        logout.setBounds(730, 200, 150, 40);
        logout.addActionListener(this);
        image.add(logout);

        //--------------------------------------------------------------------


        setSize(1120, 630);
        setLocation(150, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();

        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();

        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();
        } else if(ae.getSource()==remove){
            setVisible(false);
            new RemoveEmployee();
        }
        else if(ae.getSource()==logout){

            setVisible(false);
            JOptionPane.showMessageDialog(null, "Log Out Successfully");
            System.out.println("Successfully LOGOUT!");

//            below commented code require some modifications, if you want to debug it then, just comment the above two lines and uncomment the below commented lines
//            JOptionPane.showMessageDialog(null, "Are You Sure You Want to Log Out");
//            if(JOptionPane.OK_OPTION==0){
//                setVisible(false);
//                JOptionPane.showMessageDialog(null, "Log Out Successfully");
//            }
//            else{
//                setVisible(true);
//            }
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
