package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Polymorphism {

    public static void main(String[] args) {
        List<Media> media = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc("DVD book","John","Williams",6.00f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Casas","Rap","Traevis",7,8.52f);
        Book book = new Book("Life of Pi","Adventure",5.32f);
        media.add(cd);
        media.add(dvd);
        media.add(book);

        for(Media m: media) {
            System.out.println(m.toString());
        }
    }

}
