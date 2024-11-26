package hust.soict.dsai.aims.store;

public class Store {
    private DVD[] itemsInStore;
    private int numberOfItems; 

    public Store(int capacity) {
        itemsInStore = new DVD[capacity];
        numberOfItems = 0;
    }

    public void addDVD(DVD dvd) {
        if (numberOfItems < itemsInStore.length) {
            itemsInStore[numberOfItems] = dvd;
            numberOfItems++;
            System.out.println("Added DVD '" + dvd.getName() + "' to the store.");
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(String dvdTitle) {
        for (int i = 0; i < numberOfItems; i++) {
            if (itemsInStore[i].getName().equals(dvdTitle)) {
                for (int j = i; j < numberOfItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numberOfItems - 1] = null;
                numberOfItems--;
                System.out.println("Removed DVD '" + dvdTitle + "' from the store.");
                return;
            }
        }
        System.out.println("DVD '" + dvdTitle + "' not found in the store.");
    }
}