package hust.soict.dsai.test.store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store(5);

        DVD dvd1 = new DVD("The Lion King", "Animation", "Animation", "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction", "Science Fiction", "George Lucas", 87, 24.95f);
        DVD dvd3 = new DVD("Aladdin", "Animation", "Animation", "John Musker, Ron Clements", 90, 18.99f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        store.removeDVD("Star Wars"); 

        store.removeDVD("The Matrix"); 
    }
}