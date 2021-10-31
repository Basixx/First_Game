package com.kodilla.marbles;

import javafx.scene.control.ChoiceBox;

public class User {
    private String name;
    private int ballsCount = 10;

    public ChoiceBox chooseBallsQuantity1(){

        ChoiceBox ballsChoiceBox = new ChoiceBox();

        for (int i=1; i<= ballsCount; i++){
            ballsChoiceBox.getItems().add(i);
        }
        return ballsChoiceBox;
    }

    public int chooseBallsQuantity(){
        return 2;
    }

    public String getName() {
        return name;
    }

    public int getBallsCount() {
        return ballsCount;
    }
}
