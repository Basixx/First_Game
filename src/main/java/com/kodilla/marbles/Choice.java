package com.kodilla.marbles;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

public class Choice {
    private ChoiceBox <Integer> ballsChoiceBox = new ChoiceBox <>();

    public void adjustChoiceBox(User user){

        ballsChoiceBox.getItems().clear();

        for (int i=1; i<= user.getBallsCount(); i++){
            ballsChoiceBox.getItems().add(i);
        }

        ballsChoiceBox.setTooltip(new Tooltip("Choose balls count to bet"));
    }

    public ChoiceBox<Integer> getBallsChoiceBox() {
        return ballsChoiceBox;
    }
}
