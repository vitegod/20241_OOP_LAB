package hust.soict.dsai.test.store.StoreTest;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();

        // Create some media items
        Book book1 = new Book("The Great Gatsby", "Classic", 15.99f);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 24.99f);
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Michael Jackson", "Michael Jackson", 42, 19.99f);

        // Test adding media to the store
        System.out.println("Adding media to the store:");
        store.addMedia(book1);
        store.addMedia(dvd1);
        store.addMedia(cd1);

        // Print the store contents
        System.out.println("\nStore contents:");
        store.print();

        // Test searching for media
        System.out.println("\nSearching for media:");
        System.out.println("Searching for 'Inception': " +
                (store.searchMedia("Inception") != null ? "Found" : "Not Found"));
        System.out.println("Searching for 'Random Book': " +
                (store.searchMedia("Random Book") != null ? "Found" : "Not Found"));

        // Test removing media
        System.out.println("\nRemoving media:");
        store.removeMedia(dvd1);

        // Print updated store contents
        System.out.println("\nUpdated store contents:");
        store.print();
    }
}