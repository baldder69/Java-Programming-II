package borderpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class BorderPaneApplication extends Application {

    public void start(Stage window){
        
       BorderPane layout = new BorderPane();
       
       layout.setTop(new Label("NORTH"));
       layout.setBottom(new Label("SOUTH"));
       layout.setLeft(new Label("WEST"));
       layout.setRight(new Label("EAST"));
       
       Scene scene = new Scene(layout);
       
       window.setScene(scene);
       window.show();
        
    }
    
    public static void main(String[] args) {
        launch(BorderPaneApplication.class);
        System.out.println("Hello world!");
    }

}
