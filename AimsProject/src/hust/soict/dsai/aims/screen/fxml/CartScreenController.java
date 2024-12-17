package hust.soict.dsai.aims.screen.fxml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.sound.sampled.AudioFormat;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private Cart cart;
    private FilteredList<Media> filteredData;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label lblTotalCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    // No-arg constructor
    public CartScreenController() {
    }

    public static byte[] changevlm(byte[] audioData, float volume, AudioFormat format) {
        byte[] newAudioData = new byte[audioData.length];

        int sampleSizeInBytes = format.getSampleSizeInBits() / 8;
        boolean isBigEndian = format.isBigEndian();

        for (int i = 0; i < audioData.length; i += sampleSizeInBytes) {
            int sample = 0;
            if (isBigEndian) {
                for (int j = 0; j < sampleSizeInBytes; j++) {
                    sample = (sample << 8) | (audioData[i + j] & 0xff);
                }
            } else {
                for (int j = sampleSizeInBytes - 1; j >= 0; j--) {
                    sample = (sample << 8) | (audioData[i + j] & 0xff);
                }
            }

            sample = (int) (sample * volume);

            if (isBigEndian) {
                for (int j = sampleSizeInBytes - 1; j >= 0; j--) {
                    newAudioData[i + j] = (byte) (sample >> (8 * j));
                }
            } else {
                for (int j = 0; j < sampleSizeInBytes; j++) {
                    newAudioData[i + j] = (byte) (sample >> (8 * j));
                }
            }
        }

        return newAudioData;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
        initialize();
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9);
        Collections.sort(numbers);
        updateTotalCost();
    }

    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Wrap the ObservableList in a FilteredList
        filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredData);

        // Initially hide the buttons
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Add a listener to the TableView selection
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        } else {
                            btnPlay.setVisible(false);
                            btnRemove.setVisible(false);
                        }
                    }
                });

        // Add ChangeListener to tfFilter
        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });
    }

    private void showFilteredMedia(String filter) {
        filteredData.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }

            if (radioBtnFilterId.isSelected()) {
                String idStr = String.valueOf(media.getId());
                return idStr.startsWith(filter);
            } else if (radioBtnFilterTitle.isSelected()) {
                String title = media.getTitle();
                if (title == null) {
                    return false;
                }
                return title.toLowerCase().startsWith(filter.toLowerCase());
            }
            return false;
        });
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    private void handlePlay(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Player Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void handleRemove(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            tblMedia.getItems().remove(media);
            lblTotalCost.setText(String.format("%.2f $", cart.calculateTotalCost()));
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
    }

    @FXML
    private void handlePlaceOrder(ActionEvent event) {
        cart.empty();
        tblMedia.getItems().clear();
        lblTotalCost.setText("0 $");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("%.2f $", cart.calculateTotalCost()));
    }
}