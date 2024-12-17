// Store.java
package hust.soict.dsai.aims.store.Store;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();
    private int nbItems = 0;

    public void addMedia(Media media) {
        itemsInStore.add(media);
        nbItems += 1;
        System.out.println("The media is added");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            nbItems -= 1;
            System.out.println("The media is removed");
        } else {
            System.out.println("Media does not exist!");
        }
    }

    public Media searchMedia(String title) {
        for (Media medium : itemsInStore) {
            if (medium.getTitle().equalsIgnoreCase(title)) {
                return medium;
            }
        }
        return null;
    }

    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public static void writeWavFile(byte[] audioData, String filePath, AudioFormat format) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(audioData);
        AudioInputStream audioInputStream = new AudioInputStream(bais, format, audioData.length / format.getFrameSize());
        AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(filePath));

        audioInputStream.close();
        bais.close();
    }

    public void print() {
        System.out.println("\n-------------------------STORE--------------------------------------");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ".\t" + itemsInStore.get(i).getDetails() + "\n");
        }
        System.out.println("---------------------------------------------------\n");
    }
}