package hust.soict.vp.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;  // cùng là 1 đối tượng
	    
	    if (o == null || getClass() != o.getClass()) return false;  // đối tượng null hoặc không cùng lớp
	    
	    Track track = (Track) o;  // ép kiểu để so sánh
	    return this.title.equals(track.title) && this.length == track.length;
	}

}
