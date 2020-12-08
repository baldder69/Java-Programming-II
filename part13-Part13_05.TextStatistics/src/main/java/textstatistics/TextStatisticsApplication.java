package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application {

    public void start(Stage window){
        
        BorderPane layout = new BorderPane();
        
        HBox texts = new HBox();
        
        texts.getChildren().add(new Label("Letters: 0"));
        texts.getChildren().add(new Label("Words: 0"));
        texts.getChildren().add(new Label("The longest word is:"));
        texts.setSpacing(10);
        
        layout.setCenter(new TextArea(""));
        layout.setBottom(texts);
        
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
        window.setTitle("TextStatisticsApplication");
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

}
