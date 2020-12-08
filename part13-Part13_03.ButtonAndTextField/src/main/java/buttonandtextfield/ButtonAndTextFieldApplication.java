package buttonandtextfield;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application {

    public void start(Stage window){
        
        TextField textFieldComponent = new TextField();
        Button buttonComponent = new Button("Button");
        
        FlowPane componentGroup = new FlowPane();
        
        componentGroup.getChildren().add(buttonComponent);
        componentGroup.getChildren().add(textFieldComponent);
        
        Scene scene = new Scene(componentGroup);
        
        window.setTitle("ButtonAndTextFieldApplication");
        window.setScene(scene);
        window.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
        System.out.println("hello world");
    }

}
