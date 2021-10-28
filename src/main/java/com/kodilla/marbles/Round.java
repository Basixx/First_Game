package com.kodilla.marbles;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Round {
    private RoundUI roundUI = new RoundUI();
    private RoundLogic roundLogic = new RoundLogic();

    public void playRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){
       roundUI.showBalls(grid);
       roundUI.showChoiceBox(grid);
       roundLogic.singleTurn();
   }
}
