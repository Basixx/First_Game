package com.kodilla.marbles.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class EndRoundButton {

    private final Image roundEnd= new Image("file:src/main/resources/UI/panel_endround.png");
    private final ImageView endRound = new ImageView(roundEnd);

    public Button setEndRoundButton(){
        Button endRoundButton = new Button();
        endRoundButton.setGraphic(endRound);
        endRoundButton.setPadding(Insets.EMPTY);
        endRoundButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> endRoundButton.setEffect(new DropShadow()));
        endRoundButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> endRoundButton.setEffect(null));
        return endRoundButton;
    }
}
