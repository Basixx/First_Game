package com.kodilla.marbles;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

public class Choice {
    public ChoiceBox<Integer> chooseBallsQuantityBox(User user){
        ChoiceBox <Integer> ballsChoiceBox = new ChoiceBox <>();

        for (int i=1; i<= user.getBallsCount(); i++){
            ballsChoiceBox.getItems().add(i);
        }

        ballsChoiceBox.setTooltip(new Tooltip("Choose balls count to bet"));

        return ballsChoiceBox;
    }

}
