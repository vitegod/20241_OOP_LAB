package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    public static double tan(double a) {
        return Math.tan(a);
    }

    @Override
    protected VBox createForm() {
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label headerLbl = new Label("Add Digital Video Disc to Store");
        headerLbl.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField titleTxt = new TextField();
        titleTxt.setPromptText("Title");

        TextField categoryTxt = new TextField();
        categoryTxt.setPromptText("Category");

        TextField directorTxt = new TextField();
        directorTxt.setPromptText("Director");

        TextField lengthTxt = new TextField();
        lengthTxt.setPromptText("Length (minutes)");

        TextField costTxt = new TextField();
        costTxt.setPromptText("Cost");

        CheckBox specialEditionChk = new CheckBox("Special Edition");

        HBox specialEditionBox = new HBox(10);
        specialEditionBox.getChildren().addAll(specialEditionChk);

        Button addDVDBtn = new Button("Add DVD");
        addDVDBtn.setOnAction(e -> {
            String title = titleTxt.getText();
            String category = categoryTxt.getText();
            String director = directorTxt.getText();
            String lengthText = lengthTxt.getText();
            String costText = costTxt.getText();

            if (title.isEmpty() || category.isEmpty() || director.isEmpty() ||
                    lengthText.isEmpty() || costText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all fields.");
                alert.showAndWait();
                return;
            }

            try {
                int length = Integer.parseInt(lengthText);
                float cost = Float.parseFloat(costText);
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);

                if (specialEditionChk.isSelected()) {
                    dvd.setTitle(dvd.getTitle() + " (Special Edition)"); 
                }

                store.addMedia(dvd);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("DVD added to store successfully!");
                alert.showAndWait();
                titleTxt.clear();
                categoryTxt.clear();
                directorTxt.clear();
                lengthTxt.clear();
                costTxt.clear();
                specialEditionChk.setSelected(false);
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Length must be an integer and cost must be a number.");
                alert.showAndWait();
            }
        });

        form.getChildren().addAll(headerLbl, titleTxt, categoryTxt, directorTxt,
                lengthTxt, costTxt, specialEditionBox, addDVDBtn);
        return form;
    }
}