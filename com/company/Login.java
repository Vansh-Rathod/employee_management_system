package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField tfUsername;
    JPasswordField tfPassword;

    Login() { // constructor

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //--------------------------------------------------------------------

        // username label
        JLabel lblUsername = new JLabel("Username : ");
        lblUsername.setBounds(40, 20, 100, 30);
        lblUsername.setFont(new Font("sans serif", Font.BOLD, 15));
        add(lblUsername);

        // username textfield
        tfUsername = new JTextField();
        tfUsername.setBounds(130, 20, 150, 30);
        tfUsername.setFont(new Font("serif", Font.BOLD, 15));
        add(tfUsername);

        //--------------------------------------------------------------------

        // password label
        JLabel lblPassword = new JLabel("Password : ");
        lblPassword.setBounds(40, 50, 100, 30);
        lblPassword.setFont(new Font("sans serif", Font.BOLD, 15));
        add(lblPassword);

        // password textfield
        tfPassword = new JPasswordField();
        tfPassword.setBounds(130, 50, 150, 30);
        tfPassword.setFont(new Font("serif", Font.BOLD, 15));
        add(tfPassword);

        //--------------------------------------------------------------------

        // adding login button
        JButton login = new JButton("LOGIN");
        login.setBounds(130, 140, 150, 30);
        login.setFont(new Font("serif", Font.PLAIN, 20));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //--------------------------------------------------------------------

        // adding image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        //--------------------------------------------------------------------

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfUsername.getText();
            String password = tfPassword.getText();

            Conn c = new Conn();

            // creating query
            String query = "select * from login where username = '" + username + "' and password = '" + password + "'";


            // 4) executing mysql query by creating the statement from Conn Class
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                tfUsername.setText("");
                tfPassword.setText("");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
