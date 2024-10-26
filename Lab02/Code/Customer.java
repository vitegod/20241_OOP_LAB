package Lab02.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    String name;
    String address;
    int phoneNumber;
    String email;

    List<DVD> dvdList = new ArrayList<>(); 
    Cart cart = new Cart();

    public void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Đăng ký tài khoản mới:");
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        phoneNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập email: ");
        email = scanner.nextLine();
        System.out.println("Đăng ký thành công!");
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Đăng nhập:");
        System.out.print("Nhập tên: ");
        String inputName = scanner.nextLine();
        System.out.print("Nhập email: ");
        String inputEmail = scanner.nextLine();
        if (inputName.equals(name) && inputEmail.equals(email)) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Tên hoặc email không đúng. Vui lòng thử lại!");
        }
    }

    public void viewShoppingCart() {
        cart.print();
    }

    public void placeOrder() {
        System.out.println("Đặt hàng thành công!");
        cart.print();
        cart = new Cart();
    }

    public void searchDVD(String keyword) {
        List<DVD> searchResults = new ArrayList<>();
        for (DVD dvd : dvdList) {
            if (dvd.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                dvd.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(dvd);
            }
        }
        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy DVD nào.");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            for (DVD dvd : searchResults) {
                dvd.displayDVDInfo();
            }
        }
    }

    public void filterDVD(String genre) {
        List<DVD> filteredDVDs = new ArrayList<>();
        for (DVD dvd : dvdList) {
            if (dvd.getGenre().equalsIgnoreCase(genre)) {
                filteredDVDs.add(dvd);
            }
        }
        if (filteredDVDs.isEmpty()) {
            System.out.println("Không tìm thấy DVD nào thuộc thể loại " + genre + ".");
        } else {
            System.out.println("Danh sách DVD thuộc thể loại " + genre + ":");
            for (DVD dvd : filteredDVDs) {
                dvd.displayDVDInfo();
            }
        }
    }

    public void addReview(DVD dvd, String review, int rating) {
        System.out.println("Đã thêm đánh giá cho DVD " + dvd.getName());
    }

}