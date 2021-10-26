package com.kodilla.marbles;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Show {

    private Image imageback = new Image("file:src/main/resources/background.png");
    private Image blackChip = new Image("file:src/main/resources/chips/chipBlackWhite_border.png");
    private Image redChip = new Image("file:src/main/resources/chips/chipRedWhite_border.png");
    private Image blueChip = new Image("file:src/main/resources/chips/chipBlueWhite_border.png");
    private Image greenChip = new Image("file:src/main/resources/chips/chipGreenWhite_border.png");

    private FlowPane ballsPlayer1 = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane ballsPlayer2 = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane balls = new FlowPane(Orientation.HORIZONTAL);

    public Scene show(){
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(50, 50, 30, 50));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);

        ImageView blackChip1 = new ImageView(blackChip);
        ImageView redChip1 = new ImageView(redChip);
        ImageView blueChip1 = new ImageView(blueChip);
        ImageView greenChip1 = new ImageView(greenChip);

        ImageView blackChip2 = new ImageView(blackChip);
        ImageView redChip2 = new ImageView(redChip);
        ImageView blueChip2 = new ImageView(blueChip);
        ImageView greenChip2 = new ImageView(greenChip);

        ballsPlayer1.getChildren().add(blackChip1);
        ballsPlayer1.getChildren().add(redChip1);
        ballsPlayer1.getChildren().add(blueChip1);
        ballsPlayer1.getChildren().add(greenChip1);


        for (int i =0; i<10; i++){
            ImageView chip = new ImageView(blackChip);
            balls.getChildren().add(chip);

        }
        ballsPlayer2.getChildren().add(blackChip2);
        ballsPlayer2.getChildren().add(redChip2);
        ballsPlayer2.getChildren().add(blueChip2);
        ballsPlayer2.getChildren().add(greenChip2);

        grid.add(balls, 0, 0, 25, 1);
        grid.add(ballsPlayer2, 15, 40, 2, 1);
        //grid.add(balls, 1, 1, 1, 1);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        return scene;

    }



}
