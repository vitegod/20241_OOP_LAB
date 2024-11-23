package Lab03.Code;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    int quantityOrder;
    final int MAX_NUMBER_ORDER = 20;
    List<DVD> listDVDInCart = new ArrayList<>();

    public void removeDigitalVideoDisc(String dvdTitle) {
        for (int i = 0; i < listDVDInCart.size(); i++) {
            DVD dvd = listDVDInCart.get(i);
            if (dvd.getName().equals(dvdTitle)) {
                listDVDInCart.remove(i);
                quantityOrder--;
                System.out.println("Removed DVD '" + dvdTitle + "' from cart.");
                return;
            }
        }
        System.out.println("DVD '" + dvdTitle + "' not found in cart.");
    }

    public void addDigitalVideoDisc(DVD dvd) {
        if (quantityOrder >= MAX_NUMBER_ORDER) {
            System.out.println("Cart is full! Cannot add more DVDs.");
            return;
        }
        listDVDInCart.add(dvd);
        quantityOrder++;
        System.out.println("Added DVD '" + dvd.getName() + "' to cart.");
    }

    public void addDigitalVideoDisc(DVD[] dvdList) {
        if (dvdList == null) {
            return;
        }
        for (DVD dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    public void addDigitalVideoDisc(DVD dvd1, DVD dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    public double totalCost() {
        double total = 0;
        for (DVD dvd : listDVDInCart) {
            total += dvd.getPrice();
        }
        return total;
    }

    public void print() {
        if (listDVDInCart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("List of DVDs in cart:");
        for (DVD dvd : listDVDInCart) {
            System.out.println("- " + dvd.getName() + " - Price: " + dvd.getPrice());
        }
        System.out.println("Total cost: " + totalCost());
    }

    public void searchById(int dvdId) {
        for (DVD dvd : listDVDInCart) {
            if (dvd.getId() == dvdId) {
                System.out.println("DVD found:");
                dvd.displayDVDInfo();
                return;
            }
        }
        System.out.println("No DVD found with ID: " + dvdId);
    }
    
    public void searchByTitle(String dvdTitle) {
        boolean found = false;
        for (DVD dvd : listDVDInCart) {
            if (dvd.isMatch(dvdTitle)) { 
                System.out.println("DVD found:");
                dvd.displayDVDInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title: " + dvdTitle);
        }
    }

    public void printCart() {
        if (listDVDInCart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < listDVDInCart.size(); i++) {
            DVD dvd = listDVDInCart.get(i);
            System.out.println((i + 1) + ". " + dvd.toString()); 
        }

        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
}