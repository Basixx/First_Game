package com.kodilla.marbles;

import com.kodilla.marbles.buttons.BallsColorsButtons;
import com.kodilla.marbles.buttons.BallsNumbersButtons;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Game {
    private Image inGameBackground = new Image("file:src/main/resources/background/gameBackground.png");
    private int i=0;
    private GameTexts gameTexts = new GameTexts();

    private GridPane setBackGround(){
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(inGameBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);

        return grid;
    }

    public Scene showMainGame(){
        GridPane grid = setBackGround();

        Round round = new Round();
        RoundUI roundUI = new RoundUI();
        RoundLogic roundLogic = new RoundLogic();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        round.setBalls();

        round.firstRound(roundUI, roundLogic, grid);
        Button nextRound = new Button("next round");


        grid.add(nextRound, 10, 10, 1, 1);
                nextRound.setOnAction((e) -> {
                    round.playRound(roundUI, roundLogic, grid, i);
                    i++;
                });

        return scene;
    }

    public Scene showMainMenu(){
        GridPane grid = setBackGround();
        grid.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        Text mainMenu = gameTexts.setMainMenuText();
        grid.add(mainMenu, 0 , 0);

        Text initialChoice = gameTexts.setInititialChoiceText();
        grid.add(initialChoice, 0, 5);

        BallsNumbersButtons ballsNumbersButtons = new BallsNumbersButtons();
        ballsNumbersButtons.setAllButtons();

        FlowPane numberPane = new FlowPane();
        numberPane.setHgap(80);
        numberPane.getChildren().add(ballsNumbersButtons.getButton10());
        numberPane.getChildren().add(ballsNumbersButtons.getButton15());
        numberPane.getChildren().add(ballsNumbersButtons.getButton20());

        grid.add(numberPane,0,10);

        BallsColorsButtons ballsColorsButtons = new BallsColorsButtons();
        ballsColorsButtons.setAllButtons();

        FlowPane colorPane = new FlowPane();
        colorPane.setHgap(60);
        colorPane.getChildren().add(ballsColorsButtons.getBlackChipButton());
        colorPane.getChildren().add(ballsColorsButtons.getRedChipButton());
        colorPane.getChildren().add(ballsColorsButtons.getBlueChipButton());
        colorPane.getChildren().add(ballsColorsButtons.getGreenChipButton());

        grid.add(colorPane, 0,15);

        return scene;
    }
}
