package be.intecbrussel.jdbc;

import javax.lang.model.type.ArrayType;
import java.sql.*;

public class InsertData {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_store", "root",
                "Sairam1*");
            Statement stmt = conn.createStatement();)
        {
            stmt.executeUpdate("INSERT INTO sql_store.customers "+
            "VALUES(DEFAULT,'name','koekbook','1995-02-12','98621-46522','address','city','IL',DEFAULT)",Statement.RETURN_GENERATED_KEYS);

            try(ResultSet rs = stmt.getGeneratedKeys()){
                if(rs.next()){
                    int id=rs.getInt(1);
                    System.out.println(id);
                }
            }
            //System.out.println("Rows affected:"+" "+ rowsAffected  );
        } catch(SQLException se){
            se.getMessage();
        }
    }
    }

