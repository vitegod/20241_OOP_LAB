package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    public CompactDisc(int id, String title, String category, String artist, String director, double cost, double d) {
        super(id, title, category, cost, d, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added track '" + track.getTitle() + "' to the CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' already exists in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed track '" + track.getTitle() + "' from the CD.");
        } else {
            System.out.println("Track '" + track.getTitle() + "' not found in the CD.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("CD length: " + this.getLength());
        for (Track track : tracks) {
            track.play(); 
        }
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Artist: " + this.getArtist());
        System.out.println("List of tracks:");
        for (Track track : tracks) {
            System.out.println("- " + track.getTitle() + " (" + track.getLength() + ")");
        }
    }
}