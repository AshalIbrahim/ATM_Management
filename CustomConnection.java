package BankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CustomConnection {
    //Connecting our project with MySQL
    //ESTABLISHING JDBC CONNECTIVITY, 5 steps required for the connectivity
    /*
    1. Register the driver
    2. Create Connection
    3. Create Statement
    4. Execute Query
    5. Close connection
     */
    Connection c;
    Statement s;
    public CustomConnection() {
//we are adding a try and catch because MySQL is an external entity
//this means there will be errors during runtime and not during compile time



        try {
c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","ferarri-enzo");
s=c.createStatement();

        }catch (Exception e){
            System.out.println("error occured: "+e);
        }
/*
The code you provided appears to be a Java class constructor for establishing a database connection using JDBC (Java Database Connectivity). Let's break down what this code does:

Connection c; and Statement s;

These lines declare two instance variables: c and s. c is a reference to a Connection object, which represents a connection to a database. s is a reference to a Statement object, which is typically used for executing SQL queries.
public CustomConnection() {

This is the constructor for the CustomConnection class. It's a special method that gets called when an instance of this class is created.
try {

This begins a try block, indicating that the code inside it might throw exceptions, and it's used to handle any potential exceptions that occur during database connection setup.
c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","abcd123");

This line attempts to establish a connection to a MySQL database named "bankmanagementsystem" running on the local machine.
The DriverManager.getConnection method is used to create a database connection. It takes three parameters:
"jdbc:mysql:///bankmanagementsystem": This is the JDBC URL for the MySQL database. It specifies the database type (MySQL), the hostname (localhost, as indicated by the three slashes ///), and the database name ("bankmanagementsystem").
"root": This is the username used to authenticate with the database.
"abcd123": This is the password used to authenticate with the database.
s = c.createStatement();

Assuming the connection is successfully established, this line creates a Statement object (s) associated with the database connection (c). The Statement object is used to execute SQL queries on the database.
} catch (Exception e) {

This catch block is used to handle any exceptions that might occur during the database connection setup. If an exception occurs, it prints an error message to the console.
System.out.println("error occurred: " + e);

If an exception occurs, this line prints an error message along with the exception information to the console.
In summary, this code is a constructor for a class named CustomConnection that establishes a connection to a MySQL database when an instance of this class is created. It also creates a Statement object for executing SQL queries. If any exceptions occur during this process, it catches them and prints an error message to the console.
 */
    }
}
