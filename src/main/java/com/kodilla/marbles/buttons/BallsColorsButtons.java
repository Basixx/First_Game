package com.kodilla.marbles.buttons;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class BallsColorsButtons {
    private Image blackChip = new Image("file:src/main/resources/chips/chipBlackWhite_border.png");
    private Image redChip = new Image("file:src/main/resources/chips/chipRedWhite_border.png");
    private Image blueChip = new Image("file:src/main/resources/chips/chipBlueWhite_border.png");
    private Image greenChip = new Image("file:src/main/resources/chips/chipGreenWhite_border.png");

    private ImageView black = new ImageView(blackChip);
    private ImageView red = new ImageView(redChip);
    private ImageView blue = new ImageView(blueChip);
    private ImageView green = new ImageView(greenChip);

    private Button blackChipButton = new Button();
    private Button redChipButton = new Button();
    private Button blueChipButton = new Button();
    private Button greenChipButton = new Button();

    private int choiceNumber;

    private void setButton(javafx.scene.control.Button button, ImageView imageView){
        button.setTranslateX(200);
        button.setTranslateY(25);
        button.setGraphic(imageView);
        button.setPadding(Insets.EMPTY);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, (EventHandler<MouseEvent>)
                e -> button.setEffect(new DropShadow()));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler<MouseEvent>)
                e -> button.setEffect(null));
    }

    public void setAllButtons(){
        setButton(blackChipButton, black);
        blackChipButton.setOnAction((e) -> choiceNumber = 0);
        setButton(redChipButton, red);
        redChipButton.setOnAction((e) -> choiceNumber = 1);
        setButton(blueChipButton, blue);
        blueChipButton.setOnAction((e) -> choiceNumber = 2);
        setButton(greenChipButton, green);
        greenChipButton.setOnAction((e) -> choiceNumber = 4);
    }

    public Button getBlackChipButton() {
        return blackChipButton;
    }

    public Button getRedChipButton() {
        return redChipButton;
    }

    public Button getBlueChipButton() {
        return blueChipButton;
    }

    public Button getGreenChipButton() {
        return greenChipButton;
    }

    public int getChoiceNumber() {
        return choiceNumber;
    }
}
