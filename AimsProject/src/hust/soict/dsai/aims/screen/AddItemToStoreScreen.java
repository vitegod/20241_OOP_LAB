package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public abstract class AddItemToStoreScreen extends Application {
    protected Store store;
    protected Cart cart;

    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

    public static int ceil(double a) {
        return (int) Math.ceil(a);
    }

    protected MenuBar createMenuBar(Stage stage) {
        MenuBar menuBar = new MenuBar();
        Menu optionsMenu = new Menu("Options");
        MenuItem viewStoreItem = new MenuItem("View Store"); 
        viewStoreItem.setOnAction(e -> {
            StoreScreen storeScr = new StoreScreen(store, cart);
            try {
                storeScr.start(new Stage());
                stage.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        optionsMenu.getItems().add(viewStoreItem);
        menuBar.getMenus().add(optionsMenu);
        return menuBar;
    }

    protected abstract VBox createForm();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Add Item to Store");
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(createMenuBar(primaryStage));
        mainLayout.setCenter(createForm());

        Scene scene = new Scene(mainLayout, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}