package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        NumberAxis xAxis = new NumberAxis(0, 30, 4);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Years");
        yAxis.setLabel("Money");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings calculator");

        layout.setCenter(lineChart);

        VBox topSliders = new VBox();

        BorderPane layoutMonthlySavings = new BorderPane();
        layoutMonthlySavings.setPrefSize(450, 0);

        Label monthlySavingsLabel = new Label("Monthly savings");
        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        Label monthlySavingsValue = new Label("25");
        monthlySavingsSlider.setMajorTickUnit(5.0);
        monthlySavingsSlider.setMinorTickCount(1);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setSnapToTicks(true);

        monthlySavingsSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            monthlySavingsValue.setText(String.valueOf(newValue.intValue()));
        });

        layoutMonthlySavings.setLeft(monthlySavingsLabel);
        layoutMonthlySavings.setCenter(monthlySavingsSlider);
        layoutMonthlySavings.setRight(monthlySavingsValue);

        BorderPane layoutYearlyInterest = new BorderPane();

        Label yearlyInterestLabel = new Label("Yearly interest rate");
        Slider yearlyInterestSlider = new Slider(0, 10, 0);
        Label yearlyInterestValue = new Label("0");
        yearlyInterestSlider.setMajorTickUnit(1.0);
        yearlyInterestSlider.setMinorTickCount(0);
        yearlyInterestSlider.setShowTickMarks(true);
        yearlyInterestSlider.setShowTickLabels(true);
        yearlyInterestSlider.setSnapToTicks(true);

        yearlyInterestSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            yearlyInterestValue.setText(String.valueOf(newValue.intValue()));
        });

        layoutYearlyInterest.setLeft(yearlyInterestLabel);
        layoutYearlyInterest.setCenter(yearlyInterestSlider);
        layoutYearlyInterest.setRight(yearlyInterestValue);

        topSliders.getChildren().addAll(layoutMonthlySavings, layoutYearlyInterest);

        layout.setTop(topSliders);

        XYChart.Series data = new XYChart.Series();
        XYChart.Series yearlyInterest = new XYChart.Series();

        int initialValue = 0;
        int monthlySavings = Integer.valueOf(monthlySavingsValue.getText());
        int constant = monthlySavings * 12;

        for (int i = 0; i < 31; i++) {
            yearlyInterest.getData().add(new XYChart.Data(i, initialValue));
            data.getData().add(new XYChart.Data(i, initialValue));
            initialValue += constant;
        }

        monthlySavingsSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            data.getData().clear();

            int startValue = 0;
            int yearlySavings = newValue.intValue() * 12;

            for (int i = 0; i < 31; i++) {
                data.getData().add(new XYChart.Data(i, startValue));
                startValue += yearlySavings;
            }

            yearlyInterest.getData().clear();
            double interestRate = yearlyInterestSlider.valueProperty().intValue();
            double interestPay = 0;

            for (int i = 0; i < 31; i++) {
                yearlyInterest.getData().add(new XYChart.Data(i, interestPay));
                interestPay += yearlySavings;
                interestPay = interestPay * (1.00 + (interestRate / 100));
            }

        });

        yearlyInterestSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            yearlyInterest.getData().clear();
            int monthlyPay = monthlySavingsSlider.valueProperty().intValue();

            int yearlySavings = monthlyPay * 12;
            double interestRate = newValue.intValue();
            double interestPay = 0;

            for (int i = 0; i < 31; i++) {
                yearlyInterest.getData().add(new XYChart.Data(i, interestPay));
                interestPay += yearlySavings;
                interestPay = interestPay * (1.00 + (interestRate / 100));
            }

        });

        lineChart.getData().add(data);
        lineChart.getData().add(yearlyInterest);

        Scene scene = new Scene(layout, 300, 300);
        window.setTitle("SavingsCalculator");
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
        System.out.println("Hello world!");
    }

}
