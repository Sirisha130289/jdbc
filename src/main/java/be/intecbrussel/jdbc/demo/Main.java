package be.intecbrussel.jdbc.demo;

public class Main {
    public static void main(String[] args) {
        BeerDao beerDao = new BeerDao("jdbc:mysql://localhost:3306/sql_store", "root",
                "Sairam1*");
        try{
            Beer beer = beerDao.getBeerById(12);
            System.out.println(beer);

            System.out.println(beerDao.getBeerById(15));
        }catch(BeerException e){
            e.printStackTrace();
        }
    }
}
