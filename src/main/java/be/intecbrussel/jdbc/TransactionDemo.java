package be.intecbrussel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {
    public static void main(String[] args) {
        String update1 = "UPDATE sql_store.customers SET points = 10 WHERE customer_id=1";
        String update2 = "UPDATE sql_store.customers SET points=20 WHERE customer_id=2";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "root",
                "Sairam1*");
             Statement stmt = conn.createStatement()) {

            conn.setAutoCommit(false);

            stmt.executeUpdate(update1);
            stmt.executeUpdate(update2);

            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
