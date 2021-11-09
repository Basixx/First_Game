package com.kodilla.marbles.buttons;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class StartGameButton {
    private final Image greyStart = new Image("file:src/main/resources/UI/grey_panel_startGame.png");

    private final Button startGameButton = new Button();

    private final ImageView greyPanelStart = new ImageView(greyStart);

    public void setButton() {
        startGameButton.setTranslateX(200);
        startGameButton.setTranslateY(25);
        startGameButton.setGraphic(greyPanelStart);
        startGameButton.setPadding(Insets.EMPTY);
        startGameButton.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> startGameButton.setEffect(new DropShadow()));
        startGameButton.addEventHandler(MouseEvent.MOUSE_EXITED, e -> startGameButton.setEffect(null));
    }

    public Button getStartGameButton() {
        return startGameButton;
    }
}
