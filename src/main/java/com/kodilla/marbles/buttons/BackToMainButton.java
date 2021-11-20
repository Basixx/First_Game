package com.kodilla.marbles.buttons;

import javafx.scene.control.Button;

public class BackToMainButton {
    Button backtoMenuButton = new Button("Back to Main Menu");

    public Button getBacktoMenuButton() {
        backtoMenuButton.setStyle("-fx-font-size: 18");
        return backtoMenuButton;
    }
}
