package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
            System.out.println("Added " + media.getTitle() + " to the cart.");
        } else {
            System.out.println("Cart is full. Cannot add more items.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed " + media.getTitle() + " from the cart.");
        } else {
            System.out.println(media.getTitle() + " not found in the cart.");
        }
    }

    public double totalCost() {
        double total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void printCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("List of items in cart:");
        for (Media media : itemsOrdered) {
            media.displayInfo();  
            System.out.println();  
        }
        System.out.println("Total cost: " + totalCost());
    }
    
    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST); 
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    public void addDigitalVideoDisc(DVD dvd1) {
        addMedia(dvd1); // Gọi lại phương thức addMedia đã có
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                media.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Media with ID " + id + " not found in cart.");
        }
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                media.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with title containing '" + title + "' found in cart.");
        }
    }

    public void displayCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
            return;
        }
        System.out.println("Items in cart:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.print((i + 1) + ". ");
            itemsOrdered.get(i).displayInfo();
            System.out.println();
        }
        System.out.println("Total cost: " + totalCost());
    }
}