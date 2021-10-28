package com.kodilla.marbles;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Game {
    private Image imageback = new Image("file:src/main/resources/background.png");

    public Scene show(){
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 30, 50));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);

        Round round = new Round();
        RoundUI roundUI = new RoundUI();
        RoundLogic roundLogic = new RoundLogic();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        round.playRound(roundUI, roundLogic, grid);
        Button nextRound = new Button("next round");
        grid.add(nextRound, 10, 10, 1, 1);
                nextRound.setOnAction((e) -> {
                    roundUI.getBallsViewUser().getChildren().removeAll();
                    roundUI.getBallsViewComputer().getChildren().removeAll();

                    grid.getChildren().remove(roundUI.getBallsViewUser());
                    grid.getChildren().remove(roundUI.getBallsViewComputer());

                    //round.playRound(roundUI, roundLogic, grid);  //ten fragment powoduje zbyt
                });                                              // dużą ilość kulek
        return scene;
    }
}
