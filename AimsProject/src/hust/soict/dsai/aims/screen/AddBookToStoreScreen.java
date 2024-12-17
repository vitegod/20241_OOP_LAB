package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    public static double sin(double a) {
        return Math.sin(a);
    }

    @Override
    protected VBox createForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label header = new Label("Add New Book to Store");
        header.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField titleFld = new TextField();
        titleFld.setPromptText("Title");

        TextField costFld = new TextField();
        costFld.setPromptText("Cost");

        TextField categoryFld = new TextField();
        categoryFld.setPromptText("Category");

        TextField authorFld1 = new TextField();
        authorFld1.setPromptText("Author 1");
        TextField authorFld2 = new TextField();
        authorFld2.setPromptText("Author 2 (optional)");
        TextField authorFld3 = new TextField();
        authorFld3.setPromptText("Author 3 (optional)");

        HBox authorBox = new HBox(10);
        authorBox.getChildren().addAll(authorFld1, authorFld2, authorFld3);

        Button addBtn = new Button("Add Book");
        addBtn.setOnAction(e -> {
            String title = titleFld.getText();
            String costText = costFld.getText();
            String category = categoryFld.getText();
            String author1 = authorFld1.getText();

            if (title.isEmpty() || costText.isEmpty() || category.isEmpty() || author1.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all required fields.");
                alert.showAndWait();
                return;
            }

            try {
                float cost = Float.parseFloat(costText);
                Book book = new Book(title, category, cost);

                book.addAuthor(author1);
                if (!authorFld2.getText().isEmpty()) {
                    book.addAuthor(authorFld2.getText());
                }
                if (!authorFld3.getText().isEmpty()) {
                    book.addAuthor(authorFld3.getText());
                }

                store.addMedia(book);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Book added!");
                alert.showAndWait();

                titleFld.clear();
                costFld.clear();
                categoryFld.clear();
                authorFld1.clear();
                authorFld2.clear();
                authorFld3.clear();

            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Invalid cost.");
                alert.showAndWait();
            }
        });

        form.getChildren().addAll(header, titleFld, categoryFld, costFld, authorBox, addBtn);
        return form;
    }
}