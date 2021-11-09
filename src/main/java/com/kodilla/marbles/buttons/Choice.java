package com.kodilla.marbles.buttons;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

public class Choice {
    private final ChoiceBox <Integer> ballsChoiceBox = new ChoiceBox <>();

    public void adjustChoiceBox(int ballsCount){
        ballsChoiceBox.getItems().clear();

        for (int i=1; i<= ballsCount; i++){
            ballsChoiceBox.getItems().add(i);
        }
        ballsChoiceBox.setTooltip(new Tooltip("Choose balls count to bet"));
    }

    public ChoiceBox<Integer> getBallsChoiceBox() {
        ballsChoiceBox.setStyle("-fx-font: 12 arial;");

        return ballsChoiceBox;
    }
}
