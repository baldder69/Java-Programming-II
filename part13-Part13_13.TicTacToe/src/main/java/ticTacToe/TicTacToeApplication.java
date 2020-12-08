package ticTacToe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    Button[] buttons;
    String playerValue = "X";

    public void start(Stage window) {

        //Layout
        BorderPane layout = new BorderPane();
        layout.setPrefSize(600, 600);

        //Menu for Top
        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        //Elements for menu
        Label playerTurn = new Label("Turn: " + playerValue);
        playerTurn.setFont(Font.font("Monospaced", 30));

        //Add elements to menu
        menu.getChildren().add(playerTurn);
        layout.setTop(playerTurn);

        //Subviews
        GridPane boxView = new GridPane();

        //Elements
        buttons = new Button[12];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(" ");
            Button button = buttons[i];

            button.setFont(Font.font("Monospaced", 40));
            button.setMaxSize(40, 40);
            button.setText(" ");

            button.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {

                    for (int i = 0; i < 9; i++) {
                        if (event.getSource() == buttons[i]) {
                            if (playerValue.equals("X")) {
                                if (!(buttons[i].getText().equals("O") || buttons[i].getText().equals("O"))) {
                                    buttons[i].setText(playerValue);
                                    playerValue = "O";
                                    playerTurn.setText("Turn: " + playerValue);
                                }
                            } else {
                                if (!(buttons[i].getText().equals("X") || buttons[i].getText().equals("O"))) {
                                    buttons[i].setText(playerValue);
                                    playerValue = "X";
                                    playerTurn.setText("Turn: " + playerValue);
                                }
                            }

                            winningStrats(playerTurn, buttons);
                            isFull(playerTurn, buttons);

                        }
                    }

                }
            });

        }

        int buttonIndex = 0;
        for (int rowIndex = 0; rowIndex < 4; rowIndex++) {
            for (int columnIndex = 0; columnIndex < 3; columnIndex++) {
                boxView.add(buttons[buttonIndex], columnIndex, rowIndex);
                buttonIndex++;
            }
        }

        //Styling layout
        boxView.setPrefSize(600, 600);
        boxView.setAlignment(Pos.CENTER);
        boxView.setVgap(10);
        boxView.setHgap(10);

        //Initial layout
        layout.setCenter(boxView);

        //Scene
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.setTitle("TicTacToe");
        window.show();

    }

    public boolean whoWon(int fromIndex, int toIndex, Label playerTurn, Button buttons[]) {

        String emptyString = "";
        for (int i = fromIndex; i < toIndex; i++) {
            String value = buttons[i].getText();
            emptyString += value;
            if (emptyString.equals("XXX")) {
                playerTurn.setText("Player X wins!");

                for (Button button : buttons) {
                    button.setDisable(true);
                }
                return true;

            } else if (emptyString.equals("OOO")) {
                playerTurn.setText("Player O wins!");
                for (Button button : buttons) {
                    button.setDisable(true);
                }
                return true;
            }

        }
        return false;
    }

    public boolean whoWonIncremeted(int fromIndex, int toIndex, int increment, Label playerTurn, Button buttons[]) {

        String emptyString = "";
        for (int i = fromIndex; i < toIndex; i += increment) {
            String value = buttons[i].getText();
            emptyString += value;
            if (emptyString.equals("XXX")) {
                playerTurn.setText("Player X wins!");
                for (Button button : buttons) {
                    button.setDisable(true);
                }
                return true;
            } else if (emptyString.equals("OOO")) {
                playerTurn.setText("Player O wins!");
                for (Button button : buttons) {
                    button.setDisable(true);
                }
                return true;
            }
        }
        return false;
    }

    public boolean winningStrats(Label playerTurn, Button buttons[]) {

        if (whoWon(0, 3, playerTurn, buttons)
                || whoWon(3, 6, playerTurn, buttons)
                || whoWon(6, 9, playerTurn, buttons)
                || whoWonIncremeted(0, 7, 3, playerTurn, buttons)
                || whoWonIncremeted(1, 8, 3, playerTurn, buttons)
                || whoWonIncremeted(2, 9, 3, playerTurn, buttons)
                || whoWonIncremeted(0, 9, 4, playerTurn, buttons)
                || whoWonIncremeted(2, 7, 2, playerTurn, buttons)) {
            return true;
        } else {
            return false;
        }
    }

    public void isFull(Label playerTurn, Button buttons[]) {
        int sum = 0;
        for (Button button : buttons) {
            if (button.getText().equals("X") || button.getText().equals("O")) {
                sum++;
            }
            if (sum == 9) {
                if (!winningStrats(playerTurn, buttons)) {
                    playerTurn.setText("Tie!");
                    for (Button buttonDisable : buttons) {
                        buttonDisable.setDisable(true);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
        System.out.println("Hello world!");
    }

}
