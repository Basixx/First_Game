package com.kodilla.marbles;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

public class User {
    private String name;
    private int ballsCount = 10;


    public String getName() {
        return name;
    }

    public int getBallsCount() {
        return ballsCount;
    }
}
