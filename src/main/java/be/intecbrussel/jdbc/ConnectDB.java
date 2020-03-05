package be.intecbrussel.jdbc;

import java.sql.*;

public class ConnectDB {
    public static void main(String[] args) {
        String orderByAlcohol = "SELECT Name,Alcohol FROM beers_db.beers ORDER BY Alcohol LIMIT 10";
        String alcoholQuery = "SELECT Name,Alcohol FROM beers_db.beers WHERE Alcohol >5 LIMIT 5";
        String relatedData = "SELECT b.Name, br.Name,c.Category FROM beers_db.beers AS b " +
                "JOIN beers_db.brewers AS br ON b.BrewerId=br.Id " +
                "JOIN beers_db.categories AS c ON b.CategoryId= c.Id ";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beers_db",
                "root", "Sairam1*");
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery(relatedData);

        ) {
            System.out.println("Connection OK " + con.getCatalog());
            while (rs.next()) { //next is used to check every record, it is always on the top before the first record.
                String beerName = rs.getString("b.Name");
                String brewersName = rs.getString("br.Name");
                String category = rs.getString("Category");
                System.out.println(beerName + " " + brewersName+" "+category);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

}
