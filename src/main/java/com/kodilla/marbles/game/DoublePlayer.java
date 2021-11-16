package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BackgroundSet;
import com.kodilla.marbles.auxiliary.BallsImages;
import com.kodilla.marbles.auxiliary.PaneSet;
import com.kodilla.marbles.buttons.ChoiceBoxUser;
import com.kodilla.marbles.buttons.ChoiceButtons;
import com.kodilla.marbles.buttons.EndRoundButton;
import com.kodilla.marbles.texts.GameTexts;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Map;

public class DoublePlayer {
    private BackgroundSet backgroundSet = new BackgroundSet();
    private GameTexts gameTexts = new GameTexts();
    private FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
    private PaneSet paneSet = new PaneSet();
    private ChoiceBoxUser choiceBox = new ChoiceBoxUser();
    private EndRoundButton endRoundButton = new EndRoundButton();
    private ChoiceButtons choiceButtons = new ChoiceButtons();

    public Scene showPlayer1Turn(Stage primaryStage, int startBalls){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text player1Turn = gameTexts.setText("Player 1 Turn");
        grid.add(player1Turn,0,0);

        pane = paneSet.setPane(startBalls, 2);

        grid.add(pane, 0, 1);

        choiceBox.adjustChoiceBox(startBalls);
        grid.add(choiceBox.getBallsChoiceBox(), 0,2);

        endRoundButton.setEndRoundButton();
        Button endRound = endRoundButton.getEndRoundButton();
        endRound.setOnAction((e) -> primaryStage.setScene(showPlayer2Turn(startBalls)));
                grid.add(endRound, 1,1);



        return scene;
    }

    public Scene showPlayer2Turn(int startBalls){
        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text player1Turn = gameTexts.setText("Player 2 Turn");
        grid.add(player1Turn,0,0);

        pane = paneSet.setPane(startBalls, 2);

        grid.add(pane, 0, 1);

        choiceBox.adjustChoiceBox(startBalls);
        grid.add(choiceBox.getBallsChoiceBox(), 0,2);

        endRoundButton.setEndRoundButton();
        grid.add(endRoundButton.getEndRoundButton(), 1,1);

        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getEvenButton(), 2, 1);
        grid.add(choiceButtons.getOddButton(), 2, 2);

        return scene;
    }



}
