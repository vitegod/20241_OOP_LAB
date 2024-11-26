package hust.soict.dsai.test.cart;


import java.util.*;
import hust.soict.dsai.aims.disc.*;
import hust.soict.dsai.aims.cart.*;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DVD dvd1 = new DVD("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DVD dvd3 = new DVD("Aladdin", "Animation", "John Musker, Ron Clements", 90, 18.99f); 
        cart.addDigitalVideoDisc(dvd3);

        cart.printCart();
        
        cart.searchById(1);
        cart.searchById(4);

        cart.searchByTitle("The Lion King");
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("The Matrix");
    }
}