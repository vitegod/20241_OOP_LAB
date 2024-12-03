package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store(10);
        Cart cart = new Cart();
        Scanner scanner = new Scanner(System.in);

        store.addMedia(new DVD(1, "The Lion King", "Animation", "Roger Allers", 88, 19.95));
        store.addMedia(new DVD(2, "Star Wars", "Science Fiction", "George Lucas", 121, 24.95));
        store.addMedia(new Book(1, "The Lord of the Rings", "Fantasy", 25.0));
        
        store.addMedia(new CompactDisc(1, "Dark Side of the Moon", "Rock", "Pink Floyd", "Alan Parsons", 43, 10.5)); 

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    int storeChoice;
                    do {
                        showStoreMenu();
                        storeChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (storeChoice) {
                            case 1:
                                System.out.print("Enter the ID of the media: ");
                                int mediaId = scanner.nextInt();
                                scanner.nextLine();
                                store.displayMediaDetails(mediaId);
                                break;
                            case 2:
                                System.out.print("Enter the ID of the media to add to cart: ");
                                int mediaIdToAdd = scanner.nextInt();
                                scanner.nextLine();
                                store.addMediaToCart(cart, mediaIdToAdd);
                                break;
                            case 3: // Play a media
                                System.out.print("Enter the ID of the media to play: ");
                                int mediaIdToPlay = scanner.nextInt();
                                scanner.nextLine();
                                store.playMedia(mediaIdToPlay);
                                break;
                            case 4:
                                showCart(cart, scanner);
                                break;
                            case 0:
                                System.out.println("Going back to main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (storeChoice != 0);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. Store");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void showStoreMenu() {
        System.out.println("\nOptions:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    public static void showCart(Cart cart, Scanner scanner) {
        cart.displayCart();
        
    }
}