package com.kodilla.marbles.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CheckButton {
    private final Image greyPanelCheck= new Image("file:src/main/resources/UI/grey_panel_check.png");
    private final ImageView checkPanel = new ImageView(greyPanelCheck);

    public Button setCheckButton(){
        Button button = new Button();
        button.setGraphic(checkPanel);
        button.setPadding(Insets.EMPTY);
        return button;
    }


}
