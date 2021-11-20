package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.*;
import com.kodilla.marbles.buttons.BallsColorsButtons;
import com.kodilla.marbles.buttons.ChoiceBoxUser;
import com.kodilla.marbles.buttons.ChoiceButtons;
import com.kodilla.marbles.buttons.EndRoundButton;
import com.kodilla.marbles.texts.GameTexts;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DoublePlayerUI {
    private BackgroundSet backgroundSet = new BackgroundSet();
    private GameTexts gameTexts = new GameTexts();
    private FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
    private PaneSet paneSet = new PaneSet();

    private EndRoundButton endRoundButton = new EndRoundButton();
    private ChoiceButtons choiceButtons = new ChoiceButtons();
    private ChoiceBoxUser choiceBoxPlayer1 = new ChoiceBoxUser();
    private ChoiceBoxUser choiceBoxPlayer2 = new ChoiceBoxUser();


    DoublePlayerGame doublePlayerGame = new DoublePlayerGame();
    DoubleRoundVariables variables = new DoubleRoundVariables();
    private int roundNr = 1;

    public Scene showPlayer1Turn1(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text roundNumber = gameTexts.setText("Round: " + roundNr);
        grid.add(roundNumber, 1, 0);
        Text player1Turn = gameTexts.setText("Player 1 Turn");
        grid.add(player1Turn, 0, 0);

        pane = paneSet.setPane(variables.player1Balls, variables.player1BallsColor);

        grid.add(pane, 0, 1);

        choiceBoxPlayer1.adjustChoiceBox(variables.player1Balls);
        grid.add(choiceBoxPlayer1.getBallsChoiceBox(), 0, 2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> {
            variables.player1Bet = choiceBoxPlayer1.getBallsChoiceBox().getValue();
            System.out.println("player1 bet: " + variables.player1Bet);

            if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                primaryStage.setScene(showPlayer2Turn1(primaryStage, variables));

            } else {
                primaryStage.setScene(endGame(primaryStage, variables));
            }


        });
        grid.add(endRound, 1, 1);


        return scene;
    }

    public Scene showPlayer2Turn1(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text roundNumber = gameTexts.setText("Round: " + roundNr);
        grid.add(roundNumber, 1, 0);
        Text player1Turn = gameTexts.setText("Player 2 Turn");
        grid.add(player1Turn, 0, 0);

        pane = paneSet.setPane(variables.player2Balls, variables.player2BallsColor);

        grid.add(pane, 0, 1);

        choiceBoxPlayer2.adjustChoiceBox(variables.player2Balls);
        grid.add(choiceBoxPlayer2.getBallsChoiceBox(), 0, 2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> {
            variables.ifEven = choiceButtons.isGuessIfEven();
            variables.player2Bet = choiceBoxPlayer2.getBallsChoiceBox().getValue();
            doublePlayerGame.player2Guess(variables);

            if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                roundNr++;
                primaryStage.setScene(showPlayer2Turn2(primaryStage, variables));
            } else {
                primaryStage.setScene(endGame(primaryStage, variables));
            }
            System.out.println("player2 bet: " + variables.player2Bet);
        });
        grid.add(endRound, 1, 1);

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }

    public Scene showPlayer2Turn2(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text roundNumber = gameTexts.setText("Round: " + roundNr);
        grid.add(roundNumber, 1, 0);
        Text player1Turn = gameTexts.setText("Player 2 Turn");
        grid.add(player1Turn, 0, 0);

        pane = paneSet.setPane(variables.player2Balls, variables.player2BallsColor);

        grid.add(pane, 0, 1);

        choiceBoxPlayer2.adjustChoiceBox(variables.player2Balls);
        grid.add(choiceBoxPlayer2.getBallsChoiceBox(), 0, 2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) ->
        {
            variables.player2Bet = choiceBoxPlayer2.getBallsChoiceBox().getValue();
            System.out.println("player2 bet: " + variables.player2Bet);

            if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                primaryStage.setScene(showPlayer1Turn2(primaryStage, variables));
            } else {
                primaryStage.setScene(endGame(primaryStage, variables));
            }
        });
        grid.add(endRound, 1, 1);

        return scene;
    }

    public Scene showPlayer1Turn2(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text roundNumber = gameTexts.setText("Round: " + roundNr);
        grid.add(roundNumber, 1, 0);
        Text player1Turn = gameTexts.setText("Player 1 Turn");
        grid.add(player1Turn, 0, 0);

        pane = paneSet.setPane(variables.player1Balls, variables.player1BallsColor);

        grid.add(pane, 0, 1);

        choiceBoxPlayer1.adjustChoiceBox(variables.player1Balls);
        grid.add(choiceBoxPlayer1.getBallsChoiceBox(), 0, 2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> {
            variables.ifEven = choiceButtons.isGuessIfEven();
            variables.player1Bet = choiceBoxPlayer1.getBallsChoiceBox().getValue();
            doublePlayerGame.player1Guess(variables);

            if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                roundNr++;
                primaryStage.setScene(showPlayer1Turn1(primaryStage, variables));

            } else {
                primaryStage.setScene(endGame(primaryStage, variables));
            }
            System.out.println("player1 bet: " + variables.player1Bet);

        });
        grid.add(endRound, 1, 1);

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }


    private Scene endGame(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        GameTexts gameTexts = new GameTexts();
        Text gameOver = gameTexts.setText("Game over");
        grid.add(gameOver, 0, 0);

        if (variables.player1Balls > 0 && variables.player2Balls <= 0) {
            Text player1Won = gameTexts.setText("PLAYER 1 WON");
            grid.add(player1Won, 0, 2);
        } else {
            Text player2Won = gameTexts.setText("PLAYER 2 WON");
            grid.add(player2Won, 0, 2);
        }

        Button playAgain = new Button("Play Again");
        playAgain.setOnAction((e) -> {
            Game game = new Game();
            primaryStage.setScene(game.showModeChoice(primaryStage));
        });
        grid.add(playAgain, 0, 4);

        return scene;
    }

}
