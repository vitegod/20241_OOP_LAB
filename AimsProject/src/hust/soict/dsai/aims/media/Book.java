package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();

    public Book(int id, String title, String category, double cost) {
        super(id, title, category, cost);
    }

    public Book(int id, String title, String category, double cost, List<String> authors) {
        super(id, title, category, cost);
        this.authors = authors;
    }

    public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public List<String> getAuthors() {
        return authors;
    }

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        }
    }
   
    @Override
    public void play() {
    	
    }
    
    @Override
    public void displayInfo() {
        System.out.println("ID: " + this.getId());
        System.out.println("Title: " + this.getTitle());
        System.out.println("Category: " + this.getCategory());
        System.out.println("Cost: " + this.getCost());
        System.out.println("Authors: " + String.join(", ", this.getAuthors()));
    }
}