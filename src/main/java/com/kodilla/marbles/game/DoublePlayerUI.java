package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.*;
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
    private final BackgroundSet backgroundSet = new BackgroundSet();
    private final GameTexts gameTexts = new GameTexts();
    private FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
    private final PaneSet paneSet = new PaneSet();
    private final EndGame endGame = new EndGame();
    private final EndRoundButton endRoundButton = new EndRoundButton();
    private final ChoiceButtons choiceButtons = new ChoiceButtons();
    private final ChoiceBoxUser choiceBoxPlayer1 = new ChoiceBoxUser();
    private final ChoiceBoxUser choiceBoxPlayer2 = new ChoiceBoxUser();

    DoublePlayerGame doublePlayerGame = new DoublePlayerGame();
    DoubleRoundVariables variables = new DoubleRoundVariables();
    private int roundNr = 1;

    public Scene showSimpleBetTurn(GridPane grid, String turn,  int ballsCountPlA, int ballsColor, ChoiceBoxUser choiceBoxUser){
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        Text roundNumber = gameTexts.setText("Round: " + roundNr);
        grid.add(roundNumber, 1, 0);

        Text playerTurn = gameTexts.setText(turn);
        grid.add(playerTurn, 0, 0);

        pane = paneSet.setPane(ballsCountPlA, ballsColor);
        grid.add(pane, 0, 1);

        choiceBoxUser.adjustChoiceBox(ballsCountPlA);
        grid.add(choiceBoxUser.getBallsChoiceBox(), 0, 2);

        return scene;
    }

   /* public Scene playerBet (Stage primaryStage, String turn){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = showSimpleBetTurn(grid, turn,  player1Balls,
                player1BallsColor,  choiceBox);

        Button endRound = endRoundButton.setEndRoundButton();
        endRound.setOnAction((e) -> {
            if(choiceBox.getBallsChoiceBox().getValue() != null) {
                player1Bet = choiceBox.getBallsChoiceBox().getValue();
                System.out.println(turn + " bet: " + variables.player1Bet);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    primaryStage.setScene(showPlayer2Guess(primaryStage, variables));

                } else {
                    primaryStage.setScene(endGame.endGameDouble(primaryStage, variables));
                }
            } else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });
        grid.add(endRound, 1, 1);

        return scene;
    }*/

    public Scene showPlayer1Bet(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        System.out.println("Player1Turn1 - Bet");
        Scene scene = showSimpleBetTurn(grid, "Player 1 turn",  variables.player1Balls,
                variables.player1BallsColor,  choiceBoxPlayer1);

        Button endRound = endRoundButton.setEndRoundButton();
        endRound.setOnAction((e) -> {
            if(choiceBoxPlayer1.getBallsChoiceBox().getValue() != null) {
                variables.player1Bet = choiceBoxPlayer1.getBallsChoiceBox().getValue();
                System.out.println("player1 bet: " + variables.player1Bet);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    primaryStage.setScene(showPlayer2Guess(primaryStage, variables));

                } else {
                    primaryStage.setScene(endGame.endGameDouble(primaryStage, variables));
                }
            } else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });
        grid.add(endRound, 1, 1);

        return scene;
    }

    public Scene showPlayer2Bet(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        System.out.println("Player2Turn2 - bet");
        Scene scene = showSimpleBetTurn(grid, "Player 2 turn", variables.player2Balls,
                variables.player2BallsColor,  choiceBoxPlayer2);

        Button endRound = endRoundButton.setEndRoundButton();
        endRound.setOnAction((e) ->
        {
            if (choiceBoxPlayer2.getBallsChoiceBox().getValue() != null) {
                variables.player2Bet = choiceBoxPlayer2.getBallsChoiceBox().getValue();
                System.out.println("player2 bet: " + variables.player2Bet);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    primaryStage.setScene(showPlayer1Guess(primaryStage, variables));
                } else {
                    primaryStage.setScene(endGame.endGameDouble(primaryStage, variables));
                }
            }else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });
        grid.add(endRound, 1, 1);

        return scene;
    }

    public Scene showPlayer2Guess(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        System.out.println("Player2Turn1 - Guess");
        Scene scene = showSimpleBetTurn(grid, "Player 2 turn",  variables.player2Balls,
                variables.player2BallsColor,  choiceBoxPlayer2);

        Button endRound = endRoundButton.setEndRoundButton();
        endRound.setOnAction((e) -> {
            if (choiceBoxPlayer2.getBallsChoiceBox().getValue() != null && choiceButtons.isGuessIfEven() != null) {
                variables.ifEven = choiceButtons.isGuessIfEven();
                variables.player2Bet = choiceBoxPlayer2.getBallsChoiceBox().getValue();
                doublePlayerGame.player2Guess(variables);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    roundNr++;
                    primaryStage.setScene(showPlayer2Bet(primaryStage, variables));
                } else {
                    primaryStage.setScene(endGame.endGameDouble(primaryStage, variables));
                }
                System.out.println("player2 bet: " + variables.player2Bet);
            }else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });
        grid.add(endRound, 1, 1);

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }

    public Scene showPlayer1Guess(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        System.out.println("Player1Turn2 - Guess");
        Scene scene = showSimpleBetTurn(grid, "Player 1 turn", variables.player1Balls,
                variables.player1BallsColor, choiceBoxPlayer1);

        Button endRound = endRoundButton.setEndRoundButton();
        endRound.setOnAction((e) -> {
            if (choiceBoxPlayer1.getBallsChoiceBox().getValue() != null && choiceButtons.isGuessIfEven() != null){
                variables.ifEven = choiceButtons.isGuessIfEven();
                variables.player1Bet = choiceBoxPlayer1.getBallsChoiceBox().getValue();
                doublePlayerGame.player1Guess(variables);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    roundNr++;
                    primaryStage.setScene(showPlayer1Bet(primaryStage, variables));

                } else {
                    primaryStage.setScene(endGame.endGameDouble(primaryStage, variables));
                }
            System.out.println("player1 bet: " + variables.player1Bet);

        }else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });
        grid.add(endRound, 1, 1);

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }
}
