package be.intecbrussel.jdbc.demo;

public class BeerException extends Exception {
    public BeerException() {
        super();
    }

    public BeerException(String message) {
        super(message);
    }
}
