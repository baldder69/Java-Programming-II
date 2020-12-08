package buttonandlabel;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    public void start(Stage window) {

        Button buttonComponent = new Button("Hello");
        Label labelComponent = new Label("This is a label");

        FlowPane componentGroup = new FlowPane(Orientation.VERTICAL);
        componentGroup.getChildren().add(labelComponent);
        componentGroup.getChildren().add(buttonComponent);

        Scene scene = new Scene(componentGroup);

        window.setTitle("ButtonAndLabel Application");
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
