package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    public void start(Stage window) {

        //BorderPane layout = new BorderPane();

        TextField textField = new TextField();
        Button updateButton = new Button("Update");
        Label textOutput = new Label();

        updateButton.setOnAction((event) -> {
            textOutput.setText(textField.getText());
        });

        VBox componentGroup = new VBox();

        componentGroup.getChildren().addAll(textField, updateButton, textOutput);

        Scene scene = new Scene(componentGroup);
        
        window.setTitle("NotifierApplication");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
