package hust.soict.dsai.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public Disc(int id, String title, String category, double cost, double d, String director) {
        super(id, title, category, cost);
        this.length = (int) d;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
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
        System.out.println("Length: " + this.getLength());
        System.out.println("Director: " + this.getDirector());
    }
}