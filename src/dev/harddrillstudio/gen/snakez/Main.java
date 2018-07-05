package dev.harddrillstudio.gen.snakez;

import dev.harddrillstudio.gen.snakez.genetics.GeneticLauncher;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GeneticLauncher geneticLauncher = new GeneticLauncher();

        Line line = new Line(0, 0, 100,120);

        Text text = new Text("IM GAY");
        text.setFont(new Font(40));
        text.setX(300);
        text.setY(300);

        Group lineGroup = new Group(line);
        Group group = new Group(text, lineGroup);

        Scene scene = new Scene(group, 600, 600);
        scene.setFill(Color.GREEN);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Snakez");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
