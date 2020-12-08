package smiley;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    public void start(Stage window) {

        Canvas paintingCanvas = new Canvas(400, 400);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        painter.setFill(Color.BLACK);
        painter.fillRect(50, 50, 50, 50);
        painter.fillRect(200, 50, 50, 50);
        painter.fillRect(50, 250, 200, 50);
        painter.fillRect(0, 200, 50, 50);
        painter.fillRect(250, 200, 50, 50);

        Scene scene = new Scene(paintingLayout, 500, 600, Color.WHITE);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
        System.out.println("Hello world!");
    }

}
