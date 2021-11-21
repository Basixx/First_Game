package com.kodilla.marbles.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChoiceButtons {

    private final Image oddButtonImage = new Image("file:src/main/resources/UI/red_panel_odd.png");
    private final Image evenButtonImage = new Image("file:src/main/resources/UI/green_panel_even.png");
    private final Button oddButton = new Button();
    private final Button evenButton = new Button();
    private final ImageView buttonOddImageView = new ImageView(oddButtonImage);
    private final ImageView buttonEvenImageView = new ImageView(evenButtonImage);
    private Boolean guessIfEven;

    private void setButton(Button button, ImageView imageView){
        button.setTranslateX(200);
        button.setTranslateY(25);
        button.setGraphic(imageView);
        button.setPadding(Insets.EMPTY);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(new DropShadow()));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
    }

    public void setBothButtons(){
        setButton(oddButton, buttonOddImageView);
        oddButton.setOnAction((e)-> guessIfEven = false);
        setButton(evenButton, buttonEvenImageView);
        evenButton.setOnAction((e)-> guessIfEven = true);
    }

    public Button getOddButton() {
        return oddButton;
    }

    public Button getEvenButton() {
        return evenButton;
    }

    public Boolean isGuessIfEven() {
        return guessIfEven;
    }
}
