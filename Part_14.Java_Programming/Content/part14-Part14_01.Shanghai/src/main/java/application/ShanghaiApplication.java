package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public void start(Stage window) {
       // NumberAxis xAxis = new NumberAxis();
        NumberAxis xAxis = new NumberAxis(2006, 2018, 4);
        NumberAxis yAxis = new NumberAxis();

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shangai Ranking");

        // create the data set that is going to be added to the line chart
        XYChart.Series shangaiData = new XYChart.Series();
        // and single points into the data set
        shangaiData.getData().add(new XYChart.Data(2007, 73));
        shangaiData.getData().add(new XYChart.Data(2008, 68));
        shangaiData.getData().add(new XYChart.Data(2009, 72));
        shangaiData.getData().add(new XYChart.Data(2010, 72));
        shangaiData.getData().add(new XYChart.Data(2011, 74));
        shangaiData.getData().add(new XYChart.Data(2012, 73));
        shangaiData.getData().add(new XYChart.Data(2013, 76));
        shangaiData.getData().add(new XYChart.Data(2014, 73));
        shangaiData.getData().add(new XYChart.Data(2015, 67));
        shangaiData.getData().add(new XYChart.Data(2016, 56));
        shangaiData.getData().add(new XYChart.Data(2017, 56));

        // add the data set to the line chart
        lineChart.getData().add(shangaiData);

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
        System.out.println("Hello world!");
    }

}
