package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public void start(Stage window) {

        //Elements
        Label enterNameLabel = new Label("Enter your name and start.");
        TextField nameTextField = new TextField();
        Button buttonStart = new Button("Start");

        //Layout
        GridPane layout = new GridPane();

        layout.add(enterNameLabel, 0, 0);
        layout.add(nameTextField, 0, 1);
        layout.add(buttonStart, 0, 2);

        //Styling layout
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);

        //Scene view of entering name
        Scene nameView = new Scene(layout);

        /****************************************/
        
        //Creating new scene for welcome page
        Label welcomeText = new Label("Welcome");

        //Layout for welcome scene
        StackPane welcomeLayout = new StackPane();

        welcomeLayout.getChildren().add(welcomeText);
        
        //Styling layout
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        //Scene for welcome page
        Scene welcomeView = new Scene(welcomeLayout);
        
        
        //Event handlers
        buttonStart.setOnAction((value) -> {
            String userName = nameTextField.getText();
            welcomeText.setText("Welcome " + userName + "!");
            
            window.setScene(welcomeView);
        });
        
        

        //Window settings
        window.setScene(nameView);
        window.show();

    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
        System.out.println("Hellow world! :3");
    }
}
