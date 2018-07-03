package dev.harddrillstudio.gen.snakez;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();

        Scene scene = new Scene(root, 600, 600);
        scene.setFill(Color.GREEN);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snakez");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
