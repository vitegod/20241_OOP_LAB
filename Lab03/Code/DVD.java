package Lab03.Code;

import java.util.List;

public class DVD {
    private static int nbDigitalVideoDiscs = 0; 

    private int id;
    String name;
    String description;
    double price;
    int quantityInStock;
    int rating;
    String genre;
    int releaseDate;
    // String category;
    String author;


    public DVD(String name, String description, double price, int quantityInStock, int rating, String genre,
               int releaseDate, String category, String author) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.rating = rating;
        this.genre = genre;
        this.releaseDate = releaseDate;
        // this.category = category;
        this.author = author;

        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs; 
    }

    public int getId() {
        return id;
    }

    public DVD(String name) {
        this.name = name;
    }

    public DVD(String name, String genre, String author, int releaseDate, double price) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public DVD(String name, String description, int price, int quantityInStock, int rating, String genre,
            int releaseDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.rating = rating;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public DVD(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public DVD(String name, String genre, double price) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public DVD(String name, String genre, int releaseDate) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void updateQuantity(int quantity) {
        quantityInStock += quantity;
        System.out.println("Quantity of DVD '" + name + "' updated. Current quantity: " + quantityInStock);
    }

    public void checkAvailability() {
        if (quantityInStock > 0) {
            System.out.println("DVD '" + name + "' is currently available.");
        } else {
            System.out.println("DVD '" + name + "' is currently out of stock.");
        }
    }

    public void calculateAverageRating(List<Integer> ratings) {
        if (ratings.isEmpty()) {
            rating = 0;
            return;
        }
        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        rating = sum / ratings.size();
        System.out.println("Average rating of DVD '" + name + "': " + rating);
    }

    public void displayDVDInfo() {
        System.out.println("DVD Information:");
        System.out.println("- Title: " + name);
        System.out.println("- Description: " + description);
        System.out.println("- Price: " + price);
        System.out.println("- Quantity in stock: " + quantityInStock);
        System.out.println("- Rating: " + rating);
        System.out.println("- Genre: " + genre);
        System.out.println("- Release year: " + releaseDate);
    }

    public String toString() {
        return "DVD - " + name + " - " + author + " - " + releaseDate + ": " + price + " $";
    }
    
    public boolean isMatch(String title) {
        String lowerCaseTitle = name.toLowerCase();
        String lowerCaseInput = title.toLowerCase();
        return lowerCaseTitle.contains(lowerCaseInput);
    }

    public String getGenre() {
        return genre;
    }
}