package com.kodilla.marbles;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class StartScreen {

    private Image startButtonBack = new Image("file:src/main/resources/UI/yellow_panel.png");
    public void mainMenu(Button start, GridPane grid, Text text){
        ImageView buttonStart = new ImageView(startButtonBack);

        start.setTranslateX(200);
        start.setTranslateY(25);
        start.setGraphic(buttonStart);
        start.setPadding(Insets.EMPTY);
        start.addEventHandler(MouseEvent.MOUSE_ENTERED, (EventHandler<MouseEvent>)
                e -> start.setEffect(new DropShadow()));
        start.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler<MouseEvent>)
                e -> start.setEffect(null));



        text.setFont(Font.font("arial", FontWeight.BOLD, FontPosture.ITALIC, 90));
        text.setFill(Color.RED);
        text.setStrokeWidth(5);
        text.setStroke(Color.BLACK);
        grid.add(text, 10, 10, 20, 1);
    }
}
