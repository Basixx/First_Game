package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BackgroundSet;
import com.kodilla.marbles.auxiliary.PaneSet;
import com.kodilla.marbles.auxiliary.SingleRoundVariables;
import com.kodilla.marbles.buttons.CheckButton;
import com.kodilla.marbles.buttons.ChoiceBoxUser;
import com.kodilla.marbles.buttons.ChoiceButtons;
import com.kodilla.marbles.players.Computer;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SinglePlayerUI {
    private final BackgroundSet backgroundSet = new BackgroundSet();
    private FlowPane paneUser = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane paneComputer = new FlowPane(Orientation.HORIZONTAL);
    private final PaneSet paneSet = new PaneSet();
    private final ChoiceBoxUser choiceBox = new ChoiceBoxUser();
    private final ChoiceButtons choiceButtons = new ChoiceButtons();
    private final EndGame endGame = new EndGame();
    private final Computer computer = new Computer();

    SinglePlayerGame singlePlayerGame = new SinglePlayerGame();
    SingleRoundVariables variables = new SingleRoundVariables();


    public Scene showSimpleBet(Stage primaryStage, SingleRoundVariables variables){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK );

        paneUser = paneSet.setPane(variables.playerBalls, variables.playerBallsColor);
        grid.add(paneUser, 0, 10);

        paneComputer = paneSet.setPane(variables.computerBalls, variables.computerBallsColor);
        grid.add(paneComputer, 0, 0);

        choiceBox.adjustChoiceBox(variables.playerBalls);
        grid.add(choiceBox.getBallsChoiceBox(), 1, 5);

        CheckButton checkButton = new CheckButton();
        Button check = checkButton.setCheckButton();
        grid.add(check, 2, 10);

        check.setOnAction((e) -> {
            if(choiceBox.getBallsChoiceBox().getValue() != null) {
                variables.playerBet = choiceBox.getBallsChoiceBox().getValue();
                variables.computerBet = computer.chooseBallsQuantity(variables.computerBalls);
                variables.ifEven = new Computer().ifGuessedEven();
                System.out.println("player1 bet: " + variables.playerBet);
                singlePlayerGame.computerGuessRound(variables);

                if (variables.playerBalls > 0 && variables.computerBalls > 0) {
                    primaryStage.setScene(showFullBet(primaryStage, variables));

                } else {
                    primaryStage.setScene(endGame.endGameSingle(primaryStage, variables)); //wartosci chwilowe
                }
            } else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });

        return scene;
    }

    public Scene showFullBet(Stage primaryStage, SingleRoundVariables variables){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK );

        paneUser = paneSet.setPane(variables.playerBalls, variables.playerBallsColor);
        grid.add(paneUser, 0, 5);

        paneComputer = paneSet.setPane(variables.computerBalls, variables.computerBallsColor);
        grid.add(paneComputer, 0, 0);

        choiceBox.adjustChoiceBox(variables.playerBalls);
        grid.add(choiceBox.getBallsChoiceBox(), 1, 5);

        CheckButton checkButton = new CheckButton();
        Button check = checkButton.setCheckButton();
        grid.add(check, 2, 5);

        check.setOnAction((e) -> {
            if(choiceBox.getBallsChoiceBox().getValue() != null && choiceButtons.isGuessIfEven() != null) {
                variables.playerBet = choiceBox.getBallsChoiceBox().getValue();
                variables.computerBet = computer.chooseBallsQuantity(variables.computerBalls);
                variables.ifEven = choiceButtons.isGuessIfEven();
                System.out.println("player1 bet: " + variables.playerBet);
                singlePlayerGame.playerGuessRound(variables);
                if (variables.playerBalls > 0 && variables.computerBalls > 0) {
                    primaryStage.setScene(showSimpleBet(primaryStage, variables));
                } else {
                    primaryStage.setScene(endGame.endGameSingle(primaryStage, variables)); //wartosci chwilowe
                }
            } else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }
}
