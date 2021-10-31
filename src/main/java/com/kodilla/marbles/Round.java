package com.kodilla.marbles;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class Round {
    private RoundUI roundUI = new RoundUI();
    private RoundLogic roundLogic = new RoundLogic();
    private User user = new User();
    private Computer computer = new Computer();
    public void playRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){

            roundLogic.singleTurn();
            roundUI.showBalls(grid, roundLogic);
            //roundUI.showChoiceBox(grid, roundLogic);

   }
}
