package com.kodilla.marbles.buttons;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class EndRoundButton {

    public Button setEndRoundButton(){
        Button endRoundButton = new Button();
        endRoundButton.setText("END ROUND");
        endRoundButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> endRoundButton.setEffect(new DropShadow()));
        endRoundButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> endRoundButton.setEffect(null));
        return endRoundButton;
    }
}
