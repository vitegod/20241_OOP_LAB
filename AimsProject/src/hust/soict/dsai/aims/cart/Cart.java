package hust.soict.vp.aims.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import hust.soict.vp.aims.media.Media; 

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20; // số lượng media tối đa có thể có
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	
	public void sortCart(Comparator<Media> comparator) {
		Collections.sort(this.itemsOrdered, comparator);
	}

	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("Maximum number of medias reached, unable to add anymore to cart.");
		} else {
			boolean isIdentical = false;
			for (Media media : itemsOrdered) {
				if (media.equals(media)) {
					isIdentical = true;
					break;
				}
			}
			
			if (isIdentical) {
				System.out.println("Media \"" + media.getTitle() + "\" is already added to cart.");
				return;
			}
			
			itemsOrdered.add(media);
			System.out.println("Media \"" + media.getTitle() + "\" added to cart.");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Media \"" + media.getTitle() + "\" removed from cart.");
		} else {
			System.out.println("Media \"" + media.getTitle() + "\" not found in cart.");
		}
	}

	// phương thức trả về tổng giá các disc trong cart
	public float totalCost() {
		float sumCost = (float)0.0; // tổng giá các disc trong cart
		for (Media media : itemsOrdered) {
			sumCost += media.getCost();
		}
		
		return sumCost;
	}
	
	// hàm in danh sách các DVD đã đặt trong cart ()
	public void printCart() {
		System.out.println("********************** CART **********************");
		System.out.println("Ordered items");
		int i = 1;
		for (Media media : itemsOrdered) {
			System.out.println(i + ". " + media.toString());
			i++;
		}
		System.out.println("Total cost: " + Math.round(this.totalCost() * 100.0) / 100.0 + "$");
		System.out.println("**************************************************");
	}
	
	public void searchMediabyID(Scanner input) {
		System.out.println("**************************************************");
		System.out.print("Input ID to search: ");
		int inputID = input.nextInt(); // người dùng nhập id cần tra cứu
		input.nextLine(); // bỏ qua \n ở sau inputID để các phần nhập xâu ở sau (nếu có) không bị ảnh hưởng
		int resultCount = 0; // số kết quả trả về
		for (Media media : itemsOrdered) {
			if (inputID == media.getId()) {
				resultCount++;
				if (resultCount == 1) System.out.println("Media(s) with ID = " + inputID + ":");
				System.out.println(resultCount + ". " + media.toString());
			}
		}
		
		if (resultCount == 0) System.out.println("No match is found.");
		System.out.println("**************************************************");
	}
	
	public void searchMediabyTitle(Scanner input) {
		System.out.println("**************************************************");
		System.out.print("Input title to search: ");
		String inputTitle = input.nextLine(); // người dùng nhập title cần tra cứu
		int resultCount = 0; // số kết quả trả về
		
		for (Media media : itemsOrdered) {
			if (media.isMatch(inputTitle)) {
				resultCount++;
				if (resultCount == 1) System.out.println("Media(s) with title that matches \"" + inputTitle + "\":");
				System.out.println(resultCount + ". " + media.toString());
			}
		}
		
		if (resultCount == 0) System.out.println("No match is found.");
		System.out.println("**************************************************");
	}
}