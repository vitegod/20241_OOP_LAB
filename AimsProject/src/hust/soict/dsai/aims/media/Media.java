package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private double cost;

    public Media(int id, String title, String category, double cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getCost() {
        return cost;
    }
    
    public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public abstract void play();

	public abstract void displayInfo();
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Media media = (Media) o;
        return this.getTitle().equals(media.getTitle());
    }
    
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = Comparator.comparing(Media::getTitle).thenComparing(Media::getCost, Comparator.reverseOrder());

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = Comparator.comparing(Media::getCost, Comparator.reverseOrder()).thenComparing(Media::getTitle);
}