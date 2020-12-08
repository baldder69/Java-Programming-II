package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    public void start(Stage window) {

        //Layout
        BorderPane layout = new BorderPane();

        //Menu for Top
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        //Buttons for menu
        Button jokeButton = new Button("Joke");
        Button answerButton = new Button("Answer");
        Button explanationButton = new Button("Explanation");
        
        //Add buttons to menu
        menu.getChildren().addAll(jokeButton, answerButton, explanationButton);
        layout.setTop(menu);

        //Subviews
        StackPane jokeLayout = createView("What do you call a bear with no teeth?");
        StackPane answerLayout = createView("A gummy bear.");
        StackPane explanationLayout = createView("The joke is that a gummy bear can't have teeth!");

        //Subviews to button
        jokeButton.setOnAction((value) -> {
            layout.setCenter(jokeLayout);
        });
        
        answerButton.setOnAction((value) -> {
            layout.setCenter(answerLayout);
        });
        
        explanationButton.setOnAction((value) -> {
            layout.setCenter(explanationLayout);
        });
        
        //Initial layout
        layout.setCenter(jokeLayout);
        
        //Creation of scene
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.setTitle("JokeApplication");
        window.show();
        
    }

    private StackPane createView(String text) {

        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
        System.out.println("Hello world!");
    }
}
