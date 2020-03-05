package be.intecbrussel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "root",
                "Sairam1*");
             Statement stmt = con.createStatement();)
        {
            int rowsAffected =
                    stmt.executeUpdate("UPDATE sql_store.customers SET phone ='987-987-6325'" +
                            "WHERE customer_id= 5");
            System.out.println("Rows affected: "+ rowsAffected);
        } catch (SQLException se) {
            se.getMessage();
        }
    }
}
