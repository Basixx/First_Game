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
    private BackgroundSet backgroundSet = new BackgroundSet();
    private GameTexts gameTexts = new GameTexts();
    private FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
    private PaneSet paneSet = new PaneSet();
    private EndGame endGame = new EndGame();
    private EndRoundButton endRoundButton = new EndRoundButton();
    private ChoiceButtons choiceButtons = new ChoiceButtons();
    private ChoiceBoxUser choiceBoxPlayer1 = new ChoiceBoxUser();
    private ChoiceBoxUser choiceBoxPlayer2 = new ChoiceBoxUser();

    DoublePlayerGame doublePlayerGame = new DoublePlayerGame();
    DoubleRoundVariables variables = new DoubleRoundVariables();
    private int roundNr = 1;

    public Scene showSimpleBetTurn(GridPane grid, String turn, String player, int ballsCountPlA, int ballsColor, int bet, ChoiceBoxUser choiceBoxUser){
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

    public Scene showPlayer1Turn1(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();

        Scene scene = showSimpleBetTurn(grid, "Player 1 turn", "player1 ", variables.player1Balls,
                variables.player1BallsColor, variables.player1BallsColor, choiceBoxPlayer1);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> {
            if(choiceBoxPlayer1.getBallsChoiceBox().getValue() != null) {
                variables.player1Bet = choiceBoxPlayer1.getBallsChoiceBox().getValue();
                System.out.println("player1 bet: " + variables.player1Bet);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    primaryStage.setScene(showPlayer2Turn1(primaryStage, variables));

                } else {
                    primaryStage.setScene(endGame.endGameDouble(primaryStage, variables));
                }
            } else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });
        grid.add(endRound, 1, 1);

        //Button endRound = endRoundButtonSet(primaryStage, grid, choiceBoxPlayer1, variables.player1Bet, variables.player1Balls, variables.player2Balls, showPlayer2Turn1(primaryStage, variables));
        return scene;

    }

    //ZA POMOCA PONIZSZEJ METODY CHCIALAM WRZUCIC UNIWERSALNY ENDBUTTON, ALE POJAWIA SIE BLAD PRZY "BET"
    // - BO JEST W LAMBDZIE, A NIE JEST FINAL, NIE MOGLAM WPASC NA POMYSL CO Z TYM ZROBIC, WIEC ZOSTAWILAM W FORMIE KOMENTARZA,
    //ZEBY MOZE Z TYM PODZIALAC, ALE ZEBY SAM KOD DZIALAL

    /*public Button endRoundButtonSet(Stage primaryStage, GridPane grid, ChoiceBoxUser choiceBox, int bet, int pl1Balls, int pl2Balls, Scene scene){
        Button button = new Button();
        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();

        endRound.setOnAction((e) -> {
            if(choiceBox.getBallsChoiceBox().getValue() != null) {
                bet = choiceBox.getBallsChoiceBox().getValue();
                System.out.println("player bet: " + bet);

                if (pl1Balls > 0 && pl2Balls > 0) {
                    primaryStage.setScene(scene);

                } else {
                    primaryStage.setScene(endGame(primaryStage, variables));
                }
            } else {
                grid.add(new Text("make all choices"), 2, 1);
            }
        });
        return button;
    }*/

    public Scene showPlayer2Turn2(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = showSimpleBetTurn(grid, "Player 2 turn", "player2 ", variables.player2Balls,
                variables.player2BallsColor, variables.player2BallsColor, choiceBoxPlayer2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) ->
        {
            if (choiceBoxPlayer2.getBallsChoiceBox().getValue() != null) {
                variables.player2Bet = choiceBoxPlayer2.getBallsChoiceBox().getValue();
                System.out.println("player2 bet: " + variables.player2Bet);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    primaryStage.setScene(showPlayer1Turn2(primaryStage, variables));
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

    public Scene showPlayer2Turn1(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = showSimpleBetTurn(grid, "Player 2 turn", "player2 ", variables.player2Balls,
                variables.player2BallsColor, variables.player2BallsColor, choiceBoxPlayer2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> {
            if (choiceBoxPlayer2.getBallsChoiceBox().getValue() != null && choiceButtons.isGuessIfEven() != null) {
                variables.ifEven = choiceButtons.isGuessIfEven();
                variables.player2Bet = choiceBoxPlayer2.getBallsChoiceBox().getValue();
                doublePlayerGame.player2Guess(variables);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    roundNr++;
                    primaryStage.setScene(showPlayer2Turn2(primaryStage, variables));
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

    public Scene showPlayer1Turn2(Stage primaryStage, DoubleRoundVariables variables) {
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = showSimpleBetTurn(grid, "Player 1 turn", "player1 ", variables.player1Balls,
                variables.player1BallsColor, variables.player1BallsColor, choiceBoxPlayer1);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> {
            if (choiceBoxPlayer1.getBallsChoiceBox().getValue() != null && choiceButtons.isGuessIfEven() != null){
                variables.ifEven = choiceButtons.isGuessIfEven();
                variables.player1Bet = choiceBoxPlayer1.getBallsChoiceBox().getValue();
                doublePlayerGame.player1Guess(variables);

                if (variables.player1Balls > 0 && variables.player2Balls > 0) {
                    roundNr++;
                    primaryStage.setScene(showPlayer1Turn1(primaryStage, variables));

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
