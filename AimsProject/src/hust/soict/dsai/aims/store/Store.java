package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import java.util.*;

public class Store {
    private List<Media> itemsInStore;
    private int numberOfItems;

    public Store(int capacity) {
        itemsInStore = new ArrayList<>(capacity);
        numberOfItems = 0;
    }

    public void addMedia(Media media) {
        int capacity = itemsInStore.size();
        if (numberOfItems < capacity) { 
            itemsInStore.add(media);
            numberOfItems++;
            System.out.println("Added " + media.getTitle() + " to the store.");
        } else {
            System.out.println("Store is full. Cannot add more items.");
        }
    }

    public void removeMedia(String title) {
        for (Iterator<Media> iterator = itemsInStore.iterator(); iterator.hasNext(); ) {
            Media media = iterator.next();
            if (media.getTitle().equals(title)) {
                iterator.remove();
                numberOfItems--;
                System.out.println("Removed " + title + " from the store.");
                return;
            }
        }
        System.out.println(title + " not found in the store.");
    }

    public void displayStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
            return;
        }
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.print((i + 1) + ". ");
            itemsInStore.get(i).displayInfo();
            System.out.println();
        }
    }

    public List<Media> getItemsInStore() {
        return itemsInStore;
    }
    
    public void displayStore1() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
            return;
        }
        System.out.println("Items in store:");
        for (Media media : itemsInStore) {
            media.displayInfo();
            System.out.println();
        }
    }

    public List<Media> getItemsInStore1() {
        return itemsInStore; 
    }

    public void displayMediaDetails(int mediaId) {
        for (Media media : itemsInStore) {
            if (media.getId() == mediaId) {
                media.displayInfo();
                return;
            }
        }
        System.out.println("Media with ID " + mediaId + " not found.");
    }

    public void addMediaToCart(Cart cart, int mediaId) {
        for (Media media : itemsInStore) {
            if (media.getId() == mediaId) {
                cart.addMedia(media);
                return;
            }
        }
        System.out.println("Media with ID " + mediaId + " not found.");
    }

    public void playMedia(int mediaId) {
        for (Media media : itemsInStore) {
            if (media.getId() == mediaId && media instanceof Playable) {
                ((Playable) media).play();
                return;
            }
        }
        System.out.println("Media with ID " + mediaId + " not found or is not playable.");
    }

    public void addDVD(DVD dvd1) {
        addMedia(dvd1);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                media.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No media with title containing '" + title + "' found in store.");
        }
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsInStore) {
            if (media.getId() == id) {
                media.displayInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Media with ID " + id + " not found in store.");
        }
    }
}