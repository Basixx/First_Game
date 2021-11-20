package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BackgroundSet;
import com.kodilla.marbles.auxiliary.BallsImages;
import com.kodilla.marbles.auxiliary.PaneSet;
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


    public Scene showPlayer1Turn1(Stage primaryStage, int startBalls){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text player1Turn = gameTexts.setText("Player 1 Turn");
        grid.add(player1Turn,0,0);

        pane = paneSet.setPane(startBalls,2);

        grid.add(pane, 0, 1);

        choiceBoxPlayer1.adjustChoiceBox(startBalls);
        grid.add(choiceBoxPlayer1.getBallsChoiceBox(), 0,2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> primaryStage.setScene(showPlayer2Turn1(primaryStage, startBalls)));
                grid.add(endRound, 1,1);



        return scene;
    }

    public Scene showPlayer2Turn1(Stage primaryStage, int startBalls){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text player1Turn = gameTexts.setText("Player 2 Turn");
        grid.add(player1Turn,0,0);

        pane = paneSet.setPane(startBalls, 2);

        grid.add(pane, 0, 1);

        choiceBoxPlayer2.adjustChoiceBox(startBalls);
        grid.add(choiceBoxPlayer2.getBallsChoiceBox(), 0,2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> primaryStage.setScene(showPlayer2Turn2(primaryStage, startBalls)));
        grid.add(endRound, 1,1);

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }

    public Scene showPlayer2Turn2(Stage primaryStage, int startBalls){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text player1Turn = gameTexts.setText("Player 2 Turn");
        grid.add(player1Turn,0,0);

        pane = paneSet.setPane(startBalls, 2);

        grid.add(pane, 0, 1);

        choiceBoxPlayer2.adjustChoiceBox(startBalls);
        grid.add(choiceBoxPlayer2.getBallsChoiceBox(), 0,2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> primaryStage.setScene(showPlayer1Turn2(primaryStage, startBalls)));
        grid.add(endRound, 1,1);

        return scene;
    }

    public Scene showPlayer1Turn2(Stage primaryStage, int startBalls){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text player1Turn = gameTexts.setText("Player 1 Turn");
        grid.add(player1Turn,0,0);

        pane = paneSet.setPane(startBalls, 2);

        grid.add(pane, 0, 1);

       choiceBoxPlayer1.adjustChoiceBox(startBalls);
        grid.add(choiceBoxPlayer1.getBallsChoiceBox(), 0,2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> primaryStage.setScene(showPlayer1Turn1(primaryStage, startBalls)));
        grid.add(endRound, 1,1);

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }



}
