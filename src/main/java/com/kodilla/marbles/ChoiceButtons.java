package com.kodilla.marbles;


import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ChoiceButtons {

    private Image oddButtonImage = new Image("file:src/main/resources/UI/red_panel_odd.png");
    private Image evenButtonImage = new Image("file:src/main/resources/UI/green_panel_even.png");
    private Button oddButton = new Button();
    private Button evenButton = new Button();
    private ImageView buttonOddImageView = new ImageView(oddButtonImage);
    private ImageView buttonEvenImageView = new ImageView(evenButtonImage);


    public void setButton(Button button, ImageView imageView){
        button.setTranslateX(200);
        button.setTranslateY(25);
        button.setGraphic(imageView);
        button.setPadding(Insets.EMPTY);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, (EventHandler<MouseEvent>)
                e -> button.setEffect(new DropShadow()));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, (EventHandler<MouseEvent>)
                e -> button.setEffect(null));
    }

    public void setBothButtons(){
        setButton(oddButton, buttonOddImageView);
        setButton(evenButton, buttonEvenImageView);
    }

    public Button getOddButton() {
        return oddButton;
    }

    public Button getEvenButton() {
        return evenButton;
    }
}
