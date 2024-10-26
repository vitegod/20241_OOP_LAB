package Lab02.Code;

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
                System.out.println("Đã xóa DVD '" + dvdTitle + "' khỏi giỏ hàng.");
                return;
            }
        }
        System.out.println("Không tìm thấy DVD '" + dvdTitle + "' trong giỏ hàng.");
    }

    public void addDigitalVideoDisc(DVD dvd) {
        if (quantityOrder >= MAX_NUMBER_ORDER) {
            System.out.println("Giỏ hàng đã đầy! Không thể thêm DVD.");
            return;
        }
        listDVDInCart.add(dvd);
        quantityOrder++;
        System.out.println("Đã thêm DVD '" + dvd.getName() + "' vào giỏ hàng.");
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
            System.out.println("Giỏ hàng trống.");
            return;
        }
        System.out.println("Danh sách DVD trong giỏ hàng:");
        for (DVD dvd : listDVDInCart) {
            System.out.println("- " + dvd.getName() + " - Giá: " + dvd.getPrice());
        }
        System.out.println("Tổng giá trị: " + totalCost());
    }

    public void searchById(int dvdId) {
        System.out.println("Chức năng tìm kiếm theo ID chưa được triển khai.");
    }

    public void searchByTitle(String dvdTitle) {
        for (DVD dvd : listDVDInCart) {
            if (dvd.getName().equals(dvdTitle)) {
                System.out.println("Thông tin DVD:");
                dvd.displayDVDInfo();
                return;
            }
        }
        System.out.println("Không tìm thấy DVD '" + dvdTitle + "' trong giỏ hàng.");
    }
}
