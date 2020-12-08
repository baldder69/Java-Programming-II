package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox texts = new HBox();

        Label lettersLabel = new Label("Letters:");
        Label wordsLabel = new Label("Words:");
        Label longestLabel = new Label("The longests word is:");
        TextArea textArea = new TextArea();

        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            
            int characters = newValue.replace(" ", "").length();
            String[] parts = newValue.split("\\s+");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestLabel.setText("The longest word is: " + longest);
        });

        texts.getChildren().add(lettersLabel);
        texts.getChildren().add(wordsLabel);
        texts.getChildren().add(longestLabel);
        texts.setSpacing(20);

        layout.setCenter(textArea);
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
