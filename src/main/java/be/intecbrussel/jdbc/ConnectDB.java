package be.intecbrussel.jdbc;

import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db",
                "root", "Sairam1*");
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("select * from beers limit 3");

        ) {  System.out.println("Connection OK "+con.getCatalog());
            while(rs.next())  { //next is used to check every record, it is always on the top before the first record.
                String beerName = rs.getString("Name");
                System.out.println(beerName);

            }

        } catch (Exception ex) {
            System.out.println("Oops: Something went wrong!");
            ex.printStackTrace(System.err);
        }
    }

}
