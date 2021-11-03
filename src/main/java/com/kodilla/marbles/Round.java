package com.kodilla.marbles;

import javafx.scene.layout.GridPane;

public class Round {

    /*User user = new User();
    Computer computer = new Computer();*/
    ChoiceButtons choiceButtons = new ChoiceButtons();
    public void playRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){

        roundUI.getBallsViewUser().getChildren().clear();
        roundUI.getBallsViewComputer().getChildren().clear();

        grid.getChildren().remove(roundUI.getBallsViewUser());
        grid.getChildren().remove(roundUI.getBallsViewComputer());
        grid.getChildren().remove(roundLogic.choice.getBallsChoiceBox());

        roundLogic.computerBetTurn();
        roundUI.showBalls(grid, roundLogic);
        roundUI.showChoiceBox(grid, roundLogic, roundLogic.user);
        roundUI.showChoiceButtons(grid, choiceButtons);
   }

   public void firstRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){
       roundUI.showBalls(grid, roundLogic);
       roundUI.showChoiceBox(grid, roundLogic, roundLogic.user);
   }
}
