package com.kodilla.marbles.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CheckButton {
    private final Image greyPanelCheck= new Image("file:src/main/resources/UI/panel_check.png");
    private final ImageView checkPanel = new ImageView(greyPanelCheck);

    public Button setCheckButton(){
        Button button = new Button();
        button.setGraphic(checkPanel);
        button.setPadding(Insets.EMPTY);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(new DropShadow()));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
        return button;
    }
}
