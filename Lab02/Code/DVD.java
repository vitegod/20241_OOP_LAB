package Lab02.Code;
import java.util.List;

public class DVD {
    String name;
    String description;
    double price;
    int quantityInStock;
    int rating;
    String genre;
    int releaseDate;
    String category;
    String author;

    public DVD(String name, String genre, String author, int releaseDate, double price) {
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    public DVD(String name, String description, int price, int quantityInStock, int rating, String genre, int releaseDate) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.rating = rating;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public DVD(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public DVD(String name, String genre, double price) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }

    public DVD(String name, String genre, int releaseDate) {
        this.name = name;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void updateQuantity() {
    }

    public void calculateAverageRating() {
    }
    
    public void updateQuantity(int quantity) {
        quantityInStock += quantity;
        System.out.println("Số lượng DVD '" + name + "' đã được cập nhật. Số lượng hiện tại: " + quantityInStock);
    }

    public void checkAvailability() {
        if (quantityInStock > 0) {
            System.out.println("DVD '" + name + "' hiện đang có sẵn.");
        } else {
            System.out.println("DVD '" + name + "' hiện đang hết hàng.");
        }
    }

    public void calculateAverageRating(List<Integer> ratings) {
        if (ratings.isEmpty()) {
            rating = 0;
            return;
        }
        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }
        rating = sum / ratings.size();
        System.out.println("Đánh giá trung bình của DVD '" + name + "': " + rating);
    }

    public void displayDVDInfo() {
        System.out.println("Thông tin DVD:");
        System.out.println("- Tên: " + name);
        System.out.println("- Mô tả: " + description);
        System.out.println("- Giá: " + price);
        System.out.println("- Số lượng tồn kho: " + quantityInStock);
        System.out.println("- Đánh giá: " + rating);
        System.out.println("- Thể loại: " + genre);
        System.out.println("- Năm phát hành: " + releaseDate);
    }

    public String getGenre() {
        return genre; 
    }
}

