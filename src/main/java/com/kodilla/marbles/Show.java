package com.kodilla.marbles;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Show {

    private Image imageback = new Image("file:src/main/resources/background.png");
    private Image blackChip = new Image("file:src/main/resources/chips/chipBlackWhite_border.png");
    private Image redChip = new Image("file:src/main/resources/chips/chipRedWhite_border.png");
    private Image blueChip = new Image("file:src/main/resources/chips/chipBlueWhite_border.png");
    private Image greenChip = new Image("file:src/main/resources/chips/chipGreenWhite_border.png");


    private FlowPane ballsPlayer1 = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane ballsPlayer2 = new FlowPane(Orientation.HORIZONTAL);

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



        for (int i =0; i<10; i++){
            ImageView chip = new ImageView(blackChip);
            ballsPlayer1.getChildren().add(chip);

        }
        for (int i =0; i<10; i++){
            ImageView chip = new ImageView(redChip);
            ballsPlayer2.getChildren().add(chip);

        }


        Button start = new Button();
        Text text = new Text("Let's start");
        StartScreen startScreen = new StartScreen();
        startScreen.mainMenu(start, grid, text);
        Round round = new Round();


        grid.add(start, 5, 5, 1, 1);
        start.setOnAction((e) -> { round.beginRound(grid, ballsPlayer1, ballsPlayer2, start, text);

        });




        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        return scene;

    }



}
