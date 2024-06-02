# Employee Management System

---> Prerequisites:

(1) You must have below Software to use EMS :-

- MySQL Workbench
- MySQL Server
- MySQL Shell

Above Software must be installed to use EMS.

(2) Make sure that you have downloaded the JAR files provided in the folder named as "Important Jar Files for Employee Management Project" in your computer system.

(3) Make sure that you are using IntelliJ IDEA IDE for using EMS.


---> Follow the below steps to setup the EMS:

STEP-1: First of all open the IntelliJ IDEA IDE and add the JAR files for your EMS as a external library/dependencies

To do this follow the below steps :-

- Go to Project Structure [Ctrl + Alt + Shift + S]
- Go to the Libraries section
- then Add the JAR files from your system

STEP-2: Open "Conn.java" file and follow the below steps

- Change your Database Localhost [default is "3306"]
- Change your Database Username [default is "root"]
- Change your Database Password.

Below modifications must be done in connection string declared as "s" which is in "Conn.java" file.

STEP-3: Execute the below Queries in MySQL Workbench installed in your system

query1 : create database employeemanagementsystem;

query2 : use employeemanagementsystem;

query3 : create table login(username varchar(20), password varchar(20));

query4 : insert into login values('admin', '12345');

query5 : create table employee(name varchar(20), sname varchar(20), dob varchar(30), salary varchar(20), address varchar(100), phone varchar(20), email varchar(20), education varchar(20), designation varchar(30), aadhar varchar(25), empId varchar(15));

Above Queries must be executed in a sequence.

You can change the values in the "login" table or can add more values as admins for your EMS.

---> To Run the EMS on your system just Run the "Splash.java" file on IntelliJ IDEA IDE.
 