package hust.soict.vp.aims.media;

public class DVD extends Disc implements Playable {
	private static int nbDVDs = 0;
	
	public DVD(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost, length, director);
		nbDVDs++;
	}

	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public String toString() {
		
		return "DVD - title: " + this.getTitle() +
				" - category: " + this.getCategory() +
				" - director: " + this.getDirector() +
				" - length: " + this.getLength() +
				" - cost: " + this.getCost() + "$";
	}
}
