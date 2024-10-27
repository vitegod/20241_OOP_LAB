package Lab02.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    String name;
    String address;
    int phoneNumber;
    String email;

    List<DVD> dvdList = new ArrayList<>(); 
    Cart cart = new Cart();

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Register new account:");
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter address: ");
        address = scanner.nextLine();
        System.out.print("Enter phone number: ");
        phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter email: ");
        email = scanner.nextLine();
        System.out.println("Registration successful!");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Login:");
        System.out.print("Enter name: ");
        String inputName = scanner.nextLine();
        System.out.print("Enter email: ");
        String inputEmail = scanner.nextLine();
        if (inputName.equals(name) && inputEmail.equals(email)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Incorrect name or email. Please try again!");
        }
    }

    public void viewShoppingCart() {
        cart.print();
    }

    public void placeOrder() {
        System.out.println("Order placed successfully!");
        cart.print();
        cart = new Cart();
    }

    public void searchDVD(String keyword) {
        List<DVD> searchResults = new ArrayList<>();
        for (DVD dvd : dvdList) {
            if (dvd.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    dvd.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(dvd);
            }
        }
        if (searchResults.isEmpty()) {
            System.out.println("No DVDs found.");
        } else {
            System.out.println("Search results:");
            for (DVD dvd : searchResults) {
                dvd.displayDVDInfo();
            }
        }
    }

    public void filterDVD(String genre) {
        List<DVD> filteredDVDs = new ArrayList<>();
        for (DVD dvd : dvdList) {
            if (dvd.getGenre().equalsIgnoreCase(genre)) {
                filteredDVDs.add(dvd);
            }
        }
        if (filteredDVDs.isEmpty()) {
            System.out.println("No DVDs found for genre " + genre + ".");
        } else {
            System.out.println("DVDs in genre " + genre + ":");
            for (DVD dvd : filteredDVDs) {
                dvd.displayDVDInfo();
            }
        }
    }

    public void addReview(DVD dvd, String review, int rating) {
        System.out.println("Review added for DVD " + dvd.getName());
    }
}