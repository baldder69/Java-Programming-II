package application;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public void start(Stage window) {

        //First scene
        BorderPane scene1 = new BorderPane();

        Label firstLabel = new Label("First view!");
        Button secondButton = new Button("To the second view!");

        scene1.setTop(firstLabel);
        scene1.setCenter(secondButton);
        Scene firstScene = new Scene(scene1);

        //Second scene
        VBox scene2 = new VBox();

        Button thirdButton = new Button("To the third view!");
        Label secondLabel = new Label("Second view!");

        scene2.getChildren().addAll(thirdButton, secondLabel);

        Scene secondScene = new Scene(scene2);

        //Third scene
        GridPane scene3 = new GridPane();

        Label thirdLabel = new Label("Third view!");
        Button firstButton = new Button("First view!");

        scene3.getChildren().addAll(thirdLabel, firstButton);
        GridPane.setConstraints(thirdLabel, 0, 0);
        GridPane.setConstraints(firstButton, 1, 1);

        Scene thirdScene = new Scene(scene3);

        secondButton.setOnAction((event) -> {
            window.setScene(secondScene);
        });

        thirdButton.setOnAction((event) -> {
            window.setScene(thirdScene);
        });

        firstButton.setOnAction((event) -> {
            window.setScene(firstScene);
        });

        window.setScene(firstScene);
        window.show();

    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
        System.out.println("Hello world!");
    }

}
