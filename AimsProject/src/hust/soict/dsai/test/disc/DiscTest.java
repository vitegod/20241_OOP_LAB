package hust.soict.dsai.test.disc;

import java.util.*;
import hust.soict.dsai.aims.disc.*;

public class DiscTest {
    public static void main(String[] args) {
        DVD dvd = new DVD("The Lion King", "Animation", "Animation", "Roger Allers", 87, 19.95f);

        DVD digitalVideoDisc = new DVD(
                dvd.getName(), 
                dvd.getCategory(), 
                dvd.getGenre(), 
                dvd.getAuthor(),  
                dvd.getReleaseDate(), 
                dvd.getPrice()
        );

        System.out.println("DVD Information:");
        dvd.displayDVDInfo();

        System.out.println("\nDigitalVideoDisc Information:");
        digitalVideoDisc.displayDVDInfo(); 
    }
}