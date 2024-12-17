package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

    public String getType() {
        return "DVD";
    }

    public String getDetails() {
        return "Product ID: " + this.getId()
                + "\n\tTitle: " + this.getTitle()
                + "\n\tCategory: " + this.getCategory()
                + "\n\tDirector: " + this.getDirector()
                + "\n\tLength: " + this.getLength() + " minutes"
                + "\n\tPrice: $" + this.getCost();
    }
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength() + " minutes");
        } else {
            System.err.println("ERROR: DVD length is non-positive!");
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.setDirector(director);
        this.setLength(length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DigitalVideoDisc that = (DigitalVideoDisc) o;
        return getLength() == that.getLength() &&
                getTitle().equalsIgnoreCase(that.getTitle()) &&
                getCategory().equalsIgnoreCase(that.getCategory()) &&
                getCost() == that.getCost() &&
                getDirector().equalsIgnoreCase(that.getDirector());
    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + Float.floatToIntBits(getCost());
        result = 31 * result + getDirector().hashCode();
        result = 31 * result + getLength();
        return result;
    }

    public boolean isSpecialEdition() {
        return this.getTitle().toLowerCase().contains("special edition"); 
    }

    public void applyDiscount(float discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            float discountAmount = this.getCost() * discountPercentage / 100;
            this.setCost(this.getCost() - discountAmount);
            System.out.println("Discount applied: " + discountPercentage + "%");
        } else {
            System.out.println("Invalid discount percentage. Please enter a value between 0 and 100.");
        }
    }
}