package be.intecbrussel.jdbc.demo;

import java.sql.*;

public class BeerDao {

    private String url;
    private String username;
    private String password;

    public BeerDao(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Beer getBeerById(int id) throws BeerException{
        try (Connection conn = getConnection();
             PreparedStatement preparedStatement =
                     conn.prepareStatement("SELECT Id,Name,Price,Stock,Alcohol FROM beers_db.beers" +
                             " WHERE Id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Beer beer = new Beer();
                    beer.setId(resultSet.getInt("Id"));
                    beer.setName(resultSet.getString("Name"));
                    beer.setAlcohol(resultSet.getFloat("Alcohol"));
                    beer.setPrice(resultSet.getFloat("Price"));
                    beer.setStock(resultSet.getInt("Stock"));

                    return beer;
                } else {
                    return null;
                }
            } catch (SQLException se) {
                System.out.println(se.getMessage());
                throw new BeerException();
            }
        } catch (
                SQLException se) {
            se.getMessage();
        }

        return null;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
