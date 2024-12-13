package hust.soict.dsai.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DVD;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	public static void mediaDetailsMenu(Scanner input, Cart cart, Store store, Media media) {
		if (media instanceof CompactDisc || media instanceof DVD) {
			System.out.println("================================");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("    1. Add to cart");
			System.out.println("    2. Play");
			System.out.println("    0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			System.out.print("Enter option: ");
			int option = input.nextInt();
			input.nextLine();
			
			if (option == 0) storeMenu(input, store, cart);
			else if (option == 1) {
				cart.addMedia(media);
				mediaDetailsMenu(input, cart, store, media);
			} else if (option == 2) {
				if (media instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) media;
					cd.play();
				} else if (media instanceof DVD) {
					DVD dvd = (DVD) media;
					dvd.play();
				}
				mediaDetailsMenu(input, cart, store, media);
			} else {
				System.out.println("Invalid input. Please reinput.");
				mediaDetailsMenu(input, cart, store, media);
			}
		} else {
			System.out.println("================================");
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("    1. Add to cart");
			System.out.println("    0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1");
			System.out.print("Enter option: ");
			int option = input.nextInt();
			input.nextLine();

			if (option == 0) storeMenu(input, store, cart);
			else if (option == 1) {
				cart.addMedia(media);
				mediaDetailsMenu(input, cart, store, media);
			}  else {
				System.out.println("Invalid input. Please reinput.");
				mediaDetailsMenu(input, cart, store, media);
			}
		}
	}
	
	public static void storeMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("    1. See a media’s details");
		System.out.println("    2. Add a media to cart");
		System.out.println("    3. Play a media");
		System.out.println("    4. See current cart");
		System.out.println("    0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) showMenu(input, store, cart);
		else if (option == 1) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			boolean found = false;
			for (Media media : itemsInStore) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					System.out.println(media.toString());
					mediaDetailsMenu(input, cart, store, media);
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			storeMenu(input, store, cart);
			
		} else if (option == 2) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			boolean found = false;
			for (Media media : itemsInStore) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					cart.addMedia(media);
					
					// nếu media vừa thêm là DVD thì print số lượng DVD trong cart
					if (media instanceof DVD) {
						int numDVDinCart = 0;
						for (Media m : cart.getItemsOrdered()) {
							if (m instanceof DVD) numDVDinCart++;
						}
						
						System.out.println("Number of DVD(s) in cart: " + numDVDinCart);
					}
					
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			storeMenu(input, store, cart);
		} else if (option == 3) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			boolean found = false;
			for (Media media : itemsInStore) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					
					if (media instanceof DVD) {
						DVD mediadvd = (DVD) media;
						mediadvd.play();
					} else if (media instanceof CompactDisc) {
						CompactDisc mediacd = (CompactDisc) media;
						mediacd.play();
					} else {
						System.out.println("Media \"" + media.getTitle() + "\" is unplayable.");
					}
					
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			storeMenu(input, store, cart);
		} else if (option == 4) {
			seeCurrentCart(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			storeMenu(input, store, cart);
		}

	}
	
	public static void updateStoreMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("Update store options: ");
		System.out.println("--------------------------------");
		System.out.println("    1. Add a media to store");
		System.out.println("    2. Remove a media from store");
		System.out.println("    0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) showMenu(input, store, cart);
		else if (option == 1) {
			System.out.print("Choose a type of media to add (1 = CD; 2 = DVD; 3 = Book): ");
			int mediatype = input.nextInt();
			input.nextLine();
			
			if (mediatype == 1) {
				System.out.print("Media id: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.print("CD title: ");
				String title = input.nextLine();
				System.out.print("CD category: ");
				String category = input.nextLine();
				System.out.print("CD cost: ");
				float cost = input.nextFloat();
				input.nextLine();
				System.out.print("CD artist: ");
				String artist = input.nextLine();
				System.out.print("CD director: ");
				String director = input.nextLine();
				System.out.print("CD track(s) (each track separated by ';' | title and length of each track separated by '/'): ");
				String tracksInput = input.nextLine();
				
				ArrayList<Track> trackList = new ArrayList<Track>();
		        for (String track : tracksInput.split(";")) {
		        	String trackTitle = track.split("/")[0].trim();
		        	int trackLength = Integer.parseInt(track.split("/")[1].trim());
		        	Track newTrack = new Track(trackTitle, trackLength);
		        	trackList.add(newTrack);
		        }
				
				CompactDisc newCD = new CompactDisc(id, title, category, cost, artist, trackList, director);
				store.addMedia(newCD);
				updateStoreMenu(input, store, cart);
			} else if (mediatype == 2) {
				System.out.print("Media id: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.print("DVD title: ");
				String title = input.nextLine();
				System.out.print("DVD category: ");
				String category = input.nextLine();
				System.out.print("DVD cost: ");
				float cost = input.nextFloat();
				input.nextLine();
				System.out.print("DVD length: ");
				int length = input.nextInt();
				input.nextLine();
				System.out.print("DVD director: ");
				String director = input.nextLine();
				
				DVD newDVD = new DVD(id, title, category, cost, length, director);
				store.addMedia(newDVD);
				updateStoreMenu(input, store, cart);
			} else if (mediatype == 3) {
				System.out.print("Media id: ");
				int id = input.nextInt();
				input.nextLine();
				System.out.print("Book title: ");
				String title = input.nextLine();
				System.out.print("Book category: ");
				String category = input.nextLine();
				System.out.print("Book cost: ");
				float cost = input.nextFloat();
				input.nextLine();
				System.out.print("Book author(s) (each author separated by a comma ','): ");
				String authorsInput = input.nextLine();
				
				ArrayList<String> authorList = new ArrayList<>();
		        for (String author : authorsInput.split(",")) {
		            authorList.add(author.trim());
		        }
				
				Book newBook = new Book(id, title, category, cost, authorList);
				store.addMedia(newBook);
				updateStoreMenu(input, store, cart);
			} else {
				System.out.println("Invalid input. You will be redirected to Update store menu.");
				updateStoreMenu(input, store, cart);
			}
		} else if (option == 2) {
			System.out.print("Enter id of media to remove: ");
			int id = input.nextInt();
			input.nextLine();
			
			boolean found = false;
			for (Media media : store.getItemsInStore()) {
				if (media.getId() == id) {
					store.removeMedia(media);
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with id = " + id + " not found in the store.");
			}
			updateStoreMenu(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			updateStoreMenu(input, store, cart);
		}
	}
	
	public static void seeCurrentCart(Scanner input, Store store, Cart cart) {
		cart.printCart();
		cartMenu(input, store, cart);
	}
	
	public static void cartMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("Cart options: ");
		System.out.println("--------------------------------");
		System.out.println("    1. Filter medias in cart");
		System.out.println("    2. Sort medias in cart");
		System.out.println("    3. Remove media from cart");
		System.out.println("    4. Play a media");
		System.out.println("    5. Place order");
		System.out.println("    0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) showMenu(input, store, cart);
		else if (option == 1) {
			System.out.print("Choose a filter criteria (1 = by id; 2 = by Title): ");
			int filtertype = input.nextInt();
			input.nextLine();
			if (filtertype == 1) {
				cart.searchMediabyID(input);
			} else if (filtertype == 2) {
				cart.searchMediabyTitle(input);
			} else {
				System.out.println("Invalid input. You will be redirected to Cart menu.");
			}
			cartMenu(input, store, cart);
		} else if (option == 2) {
			System.out.print("Choose a sort criteria (1 = by Title; 2 = by Cost): ");
			int sorttype = input.nextInt();
			input.nextLine();
			
			if (sorttype == 1) {
				cart.sortCart(Media.COMPARE_BY_TITLE_COST);
				System.out.println("Cart sorted by title.");
				cart.printCart();
			} else if (sorttype == 2) {
				cart.sortCart(Media.COMPARE_BY_COST_TITLE);
				System.out.println("Cart sorted by cost.");
				cart.printCart();
			} else {
				System.out.println("Invalid input. You will be redirected to Cart menu.");
			}
			cartMenu(input, store, cart);
			
		} else if (option == 3) {
			System.out.print("Enter title of media to remove (ignore case): ");
			String title = input.nextLine();
			
			boolean found = false;
			for (Media media : cart.getItemsOrdered()) {
				if (media.getTitle().equalsIgnoreCase(title)) {
					cart.removeMedia(media);
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in cart.");
			}
			cartMenu(input, store, cart);
		} else if (option == 4) {
			System.out.print("Enter media's title (ignore case): ");
			String title = input.nextLine();
			
			ArrayList<Media> itemsOrdered = cart.getItemsOrdered();
			boolean found = false;
			for (Media media : itemsOrdered) {
				if (media.getTitle().equalsIgnoreCase(title)) { // đúng title (không cần đúng chữ in hoa)
					
					if (media instanceof DVD) {
						DVD mediadvd = (DVD) media;
						mediadvd.play();
					} else if (media instanceof CompactDisc) {
						CompactDisc mediacd = (CompactDisc) media;
						mediacd.play();
					} else {
						System.out.println("Media \"" + media.getTitle() + "\" is unplayable.");
					}
					
					found = true;
					break;
				}
			}
			
			if (!found) {
				System.out.println("Media with title \"" + title + "\" not found in the store.");
			}
			cartMenu(input, store, cart);
		} else if (option == 5) {
			System.out.println("Your order is created.");
			cart.getItemsOrdered().clear();
			System.out.println("Cart is now emptied.");
			cartMenu(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			cartMenu(input, store, cart);
		}
}
	
	public static void showMenu(Scanner input, Store store, Cart cart) {
		System.out.println("================================");
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("    1. View store");
		System.out.println("    2. Update store");
		System.out.println("    3. See current cart");
		System.out.println("    0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		System.out.print("Enter option: ");
		int option = input.nextInt();
		input.nextLine();
		
		if (option == 0) System.exit(0);
		else if (option == 1) {
			ArrayList<Media> itemsInStore = store.getItemsInStore();
			System.out.println("**************** LIST OF ITEMS IN STORE ****************");
			for (Media media : itemsInStore) {
				System.out.println(media.toString());
			}
			System.out.println("********************************************************");
			storeMenu(input, store, cart);
		} else if (option == 2) {
			updateStoreMenu(input, store, cart);
		} else if (option == 3) {
			seeCurrentCart(input, store, cart);
		} else {
			System.out.println("Invalid input. Please reinput.");
			showMenu(input, store, cart);
		}
	}
	
	public static void main(String[] args) {
		
		Store store = new Store();
		Cart cart = new Cart();
		Scanner input = new Scanner(System.in);
		
		showMenu(input, store, cart);
		input.close();
	}
}