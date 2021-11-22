package com.kodilla.marbles.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BallsNumbersButtons {
    private final Image bluePanel10 = new Image  ("file:src/main/resources/UI/panel_10.png");
    private final Image bluePanel15 = new Image  ("file:src/main/resources/UI/panel_15.png");
    private final Image bluePanel20 = new Image  ("file:src/main/resources/UI/panel_20.png");

    private final ImageView panel10 = new ImageView(bluePanel10);
    private final ImageView panel15 = new ImageView(bluePanel15);
    private final ImageView panel20 = new ImageView(bluePanel20);

    private final Button button10 = new Button();
    private final Button button15 = new Button();
    private final Button button20 = new Button();

    private Integer howManyStart;

    private void setButton(Button button, ImageView imageView){
        button.setTranslateX(200);
        button.setTranslateY(25);
        button.setGraphic(imageView);
        button.setPadding(Insets.EMPTY);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(new DropShadow()));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
    }

    public void setAllButtons(){
        setButton(button10, panel10);
        button10.setOnAction((e) -> howManyStart = 10);
        setButton(button15, panel15);
        button15.setOnAction((e) -> howManyStart = 15);
        setButton(button20, panel20);
        button20.setOnAction((e) -> howManyStart = 20);
    }

    public Button getButton10() {
        return button10;
    }

    public Button getButton15() {
        return button15;
    }

    public Button getButton20() {
        return button20;
    }

    public Integer getHowManyStart() {
        return howManyStart;
    }
}
