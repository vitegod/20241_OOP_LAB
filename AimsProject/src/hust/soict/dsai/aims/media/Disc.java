package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
    private String director;
    private int length;

    public Disc(String title) {
    }
    public Disc(String director, String category, String title, float cost){
        super(category,title,cost);
        this.setDirector(director);
    }
    public Disc(String title, String category, String director, int length, float cost){
        this(director,category,title,cost);
        this.setLength(length);
    }
    public Disc(String director, int length) {
        super();
        this.setDirector(director);
        this.setLength(length);
    }
    public Disc(String s, String title, float cost) {
        super(title);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disc disc = (Disc) o;
        return getLength() == disc.getLength() &&
                getDirector().equalsIgnoreCase(disc.getDirector()) &&
                getTitle().equalsIgnoreCase(disc.getTitle()) &&
                getCategory().equalsIgnoreCase(disc.getCategory()) &&
                getCost() == disc.getCost();
    }

    @Override
    public int hashCode() {
        int result = getDirector().hashCode();
        result = 31 * result + getLength();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getCategory().hashCode();
        result = 31 * result + Float.floatToIntBits(getCost());
        return result;
    }

    public boolean isLongerThan(int minutes) {
        return this.getLength() > minutes;
    }

    public String getShortDetails() {
        return getTitle() + " - " + getDirector() + " - " + getLength() + " mins";
    }
}