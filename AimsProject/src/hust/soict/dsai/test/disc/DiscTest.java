package hust.soict.dsai.test.disc;

package Lab03.Code;

public class DiscTest {
    public static void main(String[] args) {
        DVD dvd = new DVD("The Lion King", "Animation", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(
                dvd.getName(), 
                dvd.getCategory(), 
                dvd.getGenre(), 
                dvd.getAuthor(),  
                dvd.releaseDate, 
                dvd.getPrice()
        );

        System.out.println("DVD Information:");
        dvd.displayDVDInfo();

        System.out.println("\nDigitalVideoDisc Information:");
        digitalVideoDisc.displayDVDInfo(); 
    }
}