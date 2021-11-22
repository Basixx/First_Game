package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BackgroundSet;
import com.kodilla.marbles.buttons.*;
import com.kodilla.marbles.texts.GameTexts;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ModeChoice {

    private final GameTexts gameTexts = new GameTexts();
    private final ModeButtons modeButtons = new ModeButtons();
    private final BackgroundSet backgroundSet = new BackgroundSet();
    private final MainMenu mainMenu = new MainMenu();

    public Scene showModeChoice(Stage primaryStage){
        GridPane grid = backgroundSet.setBackGround();
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text choiceGameMode = gameTexts.setText("CHOOSE GAME MODE");
        grid.add(choiceGameMode, 1, 0);
        modeButtons.setButtons();

        modeButtons.getSinglePlayerButton().setOnAction
                ((e) -> primaryStage.setScene(mainMenu.showSinglePlayerMainMenu(primaryStage)));

        modeButtons.getDoublePlayerButton().setOnAction
                ((e) -> primaryStage.setScene(mainMenu.showDoublePlayerMainMenu(primaryStage)));

        grid.add(modeButtons.getSinglePlayerButton(), 0, 5);
        grid.add(modeButtons.getDoublePlayerButton(), 2, 5);

        return scene;
    }
}
