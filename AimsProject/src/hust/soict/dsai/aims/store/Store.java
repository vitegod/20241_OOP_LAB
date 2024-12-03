package hust.soict.vp.aims.store;
import java.util.ArrayList;

import hust.soict.vp.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore;

    public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public Store() {
        itemsInStore = new ArrayList<Media>();
    }
	
	public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Media \"" + media.getTitle() + "\" added to store.");
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
        System.out.println("Media \"" + media.getTitle() + "\" removed from store.");
    }
}
