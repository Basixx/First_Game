package com.kodilla.marbles.buttons;

import javafx.scene.control.Button;

public class ModeButtons {
    Button singlePlayerButton = new Button();
    Button doublePlayerButton = new Button();

    public void setButton(Button button, String text){
        button.setText(text);
        button.setStyle("-fx-font-size: 18; -fx-font: arial");
    }

    public void setButtons(){
        setButton(singlePlayerButton, "Single Player");
        setButton(doublePlayerButton, "Double Player");
    }

    public Button getSinglePlayerButton() {
        return singlePlayerButton;
    }

    public Button getDoublePlayerButton() {
        return doublePlayerButton;
    }
}
