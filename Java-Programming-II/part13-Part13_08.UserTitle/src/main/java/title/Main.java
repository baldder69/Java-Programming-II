package title;

import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Title of Program: ");
        String title = scanner.nextLine();

        Application.launch(UserTitle.class,
                "--title=" + title);

    }

}
