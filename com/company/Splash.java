package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {
    Splash() { // constructor

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //--------------------------------------------------------------------

        // labeling
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60));
        heading.setForeground(Color.RED);
        add(heading);

        //--------------------------------------------------------------------

        // adding & manipulating image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        // converted i2 into imageIcon i3 because you can't directly pass image object into JLabel converted to imageIcon object and passed it to JLabel
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1050, 500);
        add(image);

        //--------------------------------------------------------------------

        // adding & manipulating button
        JButton clickHere = new JButton("GET STARTED");
        clickHere.setBounds(400, 400, 300, 70);
        clickHere.setFont(new Font("serif", Font.PLAIN, 20));
        clickHere.setBackground(Color.WHITE);
        clickHere.setForeground(Color.BLACK);
        clickHere.addActionListener(this);
        image.add(clickHere);

        //--------------------------------------------------------------------

        // setting visibility and layout size
        setSize(1200, 650);
        setLocation(120, 50);
        setVisible(true);

        System.out.println("Working Perfectly!");


        //--------------------------------------------------------------------

        // blinking of "EMPLOYEE MANAGEMENT SYSTEM"
        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }

            heading.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }
    }

    //--------------------------------------------------------------------

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
         new Login();
    }

    public static void main(String[] args) {
        new Splash();
    }
}
