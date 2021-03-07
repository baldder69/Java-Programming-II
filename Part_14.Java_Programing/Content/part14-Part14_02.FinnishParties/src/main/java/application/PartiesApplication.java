package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public void start(Stage window) {

        List<String[]> rows = new ArrayList<>();

        try {
            Files.lines(Paths.get("partiesdata.tsv"))
                    .map(row -> row.split("\t"))
                    .forEach(value -> rows.add(value));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of parties");

        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
 
            XYChart.Series data = new XYChart.Series();
            data.setName(row[0]);
 
            for (int column = 1; column < row.length; column++) {
                String value = row[column];
                if (value.equals("-")) {
                    continue;
                }
 
                int year = Integer.valueOf(rows.get(0)[column]);
                data.getData().add(new XYChart.Data(year, Double.valueOf(value)));
            }
 
            lineChart.getData().add(data);
 
        }

        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();

    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
        System.out.println("Hello world!");
    }

}
