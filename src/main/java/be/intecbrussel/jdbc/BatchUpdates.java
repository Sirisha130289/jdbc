package be.intecbrussel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdates {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "root",
                "Sairam1*");
             Statement stmt = conn.createStatement();
        ) {
            conn.setAutoCommit(false);
            stmt.addBatch("UPDATE sql_store.customers SET city='BXL' WHERE customer_id=1");
            stmt.addBatch("UPDATE sql_store.customers SET phone ='654-325-975' WHERE customer_id=2");
            stmt.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
