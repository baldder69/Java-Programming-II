package title;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application.Parameters;


public class UserTitle extends Application {
    
    public void start(Stage window) {

        Application.Parameters params = getParameters();

        String organization = params.getNamed().get("title");
        window.setTitle(organization);
        window.show();

    }

        public static void main(String[] args){
            
            
        }
    
}
