package gameexchanger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Game Exchanger");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
        handleDatabase();
    }

    public static void handleDatabase() {
        //DBController dbController = new DBController();
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}
