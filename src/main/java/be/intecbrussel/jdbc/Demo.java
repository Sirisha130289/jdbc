package be.intecbrussel.jdbc;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        //Creating the connection
        String url = "jdbc:mysql://localhost:3306/movies_db";
        String user = "root";
        String password = "Sairam1*";

        //Entering the data
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter movie title");
        String name = keyboard.next();
        System.out.println("Enter roll no.");
        int rollNumber = keyboard.nextInt();
        System.out.println("Enter class");
        String className = keyboard.next();

        //Inserting data using SQL query
        String sql = ("Insert into student values" + name + rollNumber + className);
        Connection connection = null;
        try {
            //Reference to connection interface
            connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement() ;
            ResultSet rs = statement.executeQuery("select * from movie");
            int m= statement.executeUpdate(sql);
            if(m==1){
                System.out.println("Inserted successfully: " + sql);
            } else{
                System.out.println("insertion failed");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
