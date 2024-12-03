package hust.soict.dsai.aims.media;

import java.util.*;

public class DVD extends Disc {
	String name;
	String description;
	double price;
	int quantityInStock;
	int rating;
	String genre;
	int releaseDate;
	String category;
	String author;

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public DVD(int id, String title, String category, String director, int length, double cost) {
        super(id, title, category, cost, length, director);
    }
	
	public DVD(String name) {
	    super(0, name, "", 0.0, 0, ""); // Added length and director
	    this.name = name;
	}

	public DVD(String name, String genre, String author, int releaseDate, double price) {
	    super(0, name, "", price, releaseDate, author); // Added length and director
	    this.name = name;
	    this.genre = genre;
	    this.author = author;
	    this.releaseDate = releaseDate;
	    this.price = price;
	}

	public DVD(String name, String category, String genre, String author, int releaseDate, double price) {
	    super(0, name, category, price, releaseDate, author);
	    this.name = name;
	    this.category = category;
	    this.genre = genre;
	    this.author = author;
	    this.releaseDate = releaseDate;
	    this.price = price;
	}

	public DVD(String name, String description, int price, int quantityInStock, int rating, String genre,
	        int releaseDate) {
	    super(0, name, "", price, releaseDate, "");
	    this.name = name;
	    this.description = description;
	    this.price = price;
	    this.quantityInStock = quantityInStock;
	    this.rating = rating;
	    this.genre = genre;
	    this.releaseDate = releaseDate;
	}

	public DVD(String name, int price) {
	    super(0, name, "", price, 0, "");
	    this.name = name;
	    this.price = price;
	}

	public DVD(String name, String genre, double price) {
	    super(0, name, "", price, 0, "");
	    this.name = name;
	    this.price = price;
	    this.genre = genre;
	}

	public DVD(String name, String genre, int releaseDate) {
	    super(0, name, "", 0.0, releaseDate, "");
	    this.name = name;
	    this.genre = genre;
	    this.releaseDate = releaseDate;
	}

	public String getCategory() {
		return category;
	}

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getReleaseDate() {
		return releaseDate;
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

	public String getGenre() {
		return genre;
	}

	@Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }


	@Override
	public void displayInfo() {
	    super.displayInfo();
	    System.out.println("Genre: " + this.getGenre());
	}
}