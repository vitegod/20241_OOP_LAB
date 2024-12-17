package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Painter extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Painter.fxml")));

            stage.setTitle("Painter");
            stage.setScene(new Scene(root));
            
            stage.widthProperty().addListener((obs, oldVal, newVal) -> {
                System.out.println("Width changed from " + oldVal + " to " + newVal);
            });

            stage.heightProperty().addListener((obs, oldVal, newVal) -> {
                System.out.println("Height changed from " + oldVal + " to " + newVal);
            });
            
            stage.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args) {
        launch(args);
    }
}