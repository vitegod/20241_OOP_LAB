package hust.soict.dsai.aims.screen;

import java.util.Arrays;
import java.util.List;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private ObservableList<Track> tracks = FXCollections.observableArrayList();

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
    }

    public static int calculateSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static double cos(double a) {
        return Math.cos(a);
    }

    @Override
    protected VBox createForm() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));

        Label header = new Label("Add New Compact Disc to Store");
        header.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        TextField titleFld = new TextField();
        titleFld.setPromptText("Title");

        TextField categoryFld = new TextField();
        categoryFld.setPromptText("Category");

        TextField artistFld = new TextField();
        artistFld.setPromptText("Artist");

        TextField directorFld = new TextField();
        directorFld.setPromptText("Director");

        TextField lengthFld = new TextField();
        lengthFld.setPromptText("Length (minutes)");

        TextField costFld = new TextField();
        costFld.setPromptText("Cost");

        TableView<Track> trackTable = new TableView<>();
        trackTable.setEditable(true);

        TableColumn<Track, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Track, Integer> lengthCol = new TableColumn<>("Length");
        lengthCol.setCellValueFactory(new PropertyValueFactory<>("length"));

        trackTable.getColumns().addAll(titleCol, lengthCol);
        trackTable.setItems(tracks);

        TextField trackTitleFld = new TextField();
        trackTitleFld.setPromptText("Track Title");
        TextField trackLengthFld = new TextField();
        trackLengthFld.setPromptText("Track Length");

        Button addTrackBtn = new Button("Add Track");
        addTrackBtn.setOnAction(e -> {
            String trackTitle = trackTitleFld.getText();
            String trackLengthText = trackLengthFld.getText();

            if (trackTitle.isEmpty() || trackLengthText.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all track fields.");
                alert.showAndWait();
                return;
            }

            try {
                int trackLength = Integer.parseInt(trackLengthText);
                Track track = new Track(trackTitle, trackLength);
                tracks.add(track);
                trackTitleFld.clear();
                trackLengthFld.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Track length must be an integer.");
                alert.showAndWait();
            }
        });

        HBox trackInputBox = new HBox(10);
        trackInputBox.getChildren().addAll(trackTitleFld, trackLengthFld, addTrackBtn);

        Button addBtn = new Button("Add CD");
        addBtn.setOnAction(e -> {
            String title = titleFld.getText();
            String category = categoryFld.getText();
            String artist = artistFld.getText();
            String director = directorFld.getText();
            String lengthText = lengthFld.getText();
            String costText = costFld.getText();

            if (title.isEmpty() || category.isEmpty() || artist.isEmpty() ||
                    director.isEmpty() || lengthText.isEmpty() || costText.isEmpty()) {
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
                CompactDisc cd = new CompactDisc(title, category, artist, director, length, cost);

                cd.setTracks(tracks);

                store.addMedia(cd);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("CD added to store successfully!");
                alert.showAndWait();
                titleFld.clear();
                categoryFld.clear();
                artistFld.clear();
                directorFld.clear();
                lengthFld.clear();
                costFld.clear();
                tracks.clear();
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Input Error");
                alert.setHeaderText(null);
                alert.setContentText("Length must be an integer and cost must be a number.");
                alert.showAndWait();
            }
        });

        form.getChildren().addAll(
                header,
                titleFld,
                categoryFld,
                artistFld,
                directorFld,
                lengthFld,
                costFld,
                trackTable,
                trackInputBox,
                addBtn);
        return form;
    }
}