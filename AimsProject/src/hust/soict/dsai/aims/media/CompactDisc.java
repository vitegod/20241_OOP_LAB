package hust.soict.dsai.aims.media;
import java.util.*;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();

	public String getArtist() {
		return artist;
	}

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist,
			ArrayList<Track> tracks, int length, String director) {
		super(id, title, category, cost, length, director);
		this.artist = artist;
		this.tracks = tracks;
	}
	
	public CompactDisc(int id, String title, String category, float cost, String artist,
			ArrayList<Track> tracks, String director) {
		super(id, title, category, cost, director);
		this.artist = artist;
		this.tracks = tracks;
	}

	public void addTrack(Track track) {
		boolean isIdentical = false;
		
		for (Track track : tracks) {
			if (track.equals(track)) {
				isIdentical = true;
				break;
			}
		}
		
		if (isIdentical) { // nếu đã tồn tại track rồi thì không add nữa
			System.out.println("Track \"" + track + "\" already exists in the tracks list.");
		} else {
			tracks.add(track);
			System.out.println("Track \"" + track + "\" successfully added.");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)) { // kiểm tra nếu danh sách có track cần xóa
	        tracks.remove(track);
	        System.out.println("Track \"" + track + "\" removed.");
	    } else {
	        System.out.println("Track \"" + track + "\" not found.");
	    }
	}
	
	public int getLength() {
		int sumLength = 0;
		for (Track track : tracks) {
			sumLength += track.getLength();
		}
		
		return sumLength;
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle()); // thông tin về CD
		System.out.println("CD artist: " + this.getArtist());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks) {
			track.play(); // play từng track trong CD
		}
	}
	
	public String toString() {
		
		return "CD - title: " + this.getTitle() +
				" - category: " + this.getCategory() +
				" - director: " + this.getDirector() +
				" - length: " + this.getLength() +
				" - cost: " + this.getCost() + "$";
	}
}
