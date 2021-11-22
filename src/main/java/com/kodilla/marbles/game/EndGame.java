package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BackgroundSet;
import com.kodilla.marbles.auxiliary.DoubleRoundVariables;
import com.kodilla.marbles.auxiliary.SingleRoundVariables;
import com.kodilla.marbles.texts.GameTexts;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EndGame {
    private final BackgroundSet backgroundSet = new BackgroundSet();

    public Scene endGameDouble(Stage primaryStage, DoubleRoundVariables variables) {
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
            ModeChoice modeChoice = new ModeChoice();
            primaryStage.setScene(modeChoice.showModeChoice(primaryStage));
        });
        grid.add(playAgain, 0, 4);

        return scene;
    }

    public Scene endGameSingle(Stage primaryStage, SingleRoundVariables variables){

        GridPane grid = backgroundSet.setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        GameTexts gameTexts = new GameTexts();
        Text gameOver = gameTexts.setText("Game Over");
        grid.add(gameOver,0,0);

        if (variables.playerBalls <= 0 && variables.computerBalls >0) {
            Text youLost = gameTexts.setText("Computer won :(");
            grid.add(youLost, 0, 2);
        }
        else{
            Text youWon = gameTexts.setText("YOU WON!!!");
            grid.add(youWon, 0, 2);
        }

        Button playAgain = new Button("Play Again");
        playAgain.setOnAction((e) ->
        {
            ModeChoice modeChoice = new ModeChoice();
            primaryStage.setScene(modeChoice.showModeChoice(primaryStage));
        } );
        grid.add(playAgain, 0, 4);

        return scene;
    }

}
