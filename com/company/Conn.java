package com.company;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            // 1) Registering the Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2) Creating the Connection String
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "your-database-username", "your-database-password");

            // 3) Creating Statement
            s=c.createStatement();

            // 4th step in the login Class


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
--> 5 Steps of JDBC Connectivity

1) Register the Driver Class
2) Creating the Connection String
3) Creating Statement
4) Executing MySQL Queries
5) Closing the Connections
 */
