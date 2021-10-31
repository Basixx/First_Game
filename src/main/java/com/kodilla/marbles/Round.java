package com.kodilla.marbles;

import javafx.scene.layout.GridPane;

public class Round {
    public void playRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){

        roundUI.getBallsViewUser().getChildren().clear();
        roundUI.getBallsViewComputer().getChildren().clear();

        grid.getChildren().remove(roundUI.getBallsViewUser());
        grid.getChildren().remove(roundUI.getBallsViewComputer());
        grid.getChildren().remove(roundLogic.choice.chooseBallsQuantityBox(roundLogic.user));

        roundLogic.singleTurn();
        roundUI.showBalls(grid, roundLogic);
        roundUI.showChoiceBox(grid, roundLogic, roundLogic.user);
   }

   public void firstRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){
       roundUI.showBalls(grid, roundLogic);
       roundUI.showChoiceBox(grid, roundLogic, roundLogic.user);
   }
}
