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
    private Image ball1 = new Image("file:src/main/resources/chips/chipBlackWhite_border.png");
    private Image ball2 = new Image("file:src/main/resources/chips/chipRedWhite_border.png");
    private FlowPane balls = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane balls2 = new FlowPane(Orientation.HORIZONTAL);

    public Scene showGame(){
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 10, 10));
        grid.setHgap(5.5);
        grid.setVgap(5.5);
        grid.setBackground(background);
        ImageView img1 = new ImageView(ball1);
        ImageView img2 = new ImageView(ball2);
        balls.getChildren().add(img1);
        balls2.getChildren().add(img2);

        grid.add(balls, 0, 0, 1, 1);
        grid.add(balls2, 0, 1, 1, 1);

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        return scene;

    }



}
