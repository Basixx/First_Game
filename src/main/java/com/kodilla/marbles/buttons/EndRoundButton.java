package com.kodilla.marbles.buttons;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class EndRoundButton {
    private Button endRoundButton = new Button();
    public void setEndRoundButton(){
        endRoundButton.setText("END ROUND");
        endRoundButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> endRoundButton.setEffect(new DropShadow()));
        endRoundButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> endRoundButton.setEffect(null));
    }

    public Button getEndRoundButton() {
        return endRoundButton;
    }
}
