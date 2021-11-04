package com.kodilla.marbles;

import javafx.scene.layout.GridPane;

public class Round {

    User user = new User();
    Computer computer = new Computer();
    ChoiceButtons choiceButtons = new ChoiceButtons();
    private int userBalls = user.getBallsCount();
    private int computerBalls = computer.getBallsCount();

    public void playRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){

        roundUI.getBallsViewUser().getChildren().clear();
        roundUI.getBallsViewComputer().getChildren().clear();

        grid.getChildren().remove(roundUI.getBallsViewUser());
        grid.getChildren().remove(roundUI.getBallsViewComputer());
        grid.getChildren().remove(roundLogic.choice.getBallsChoiceBox());
        grid.getChildren().remove(choiceButtons.getEvenButton());
        grid.getChildren().remove(choiceButtons.getOddButton());
        roundLogic.computerBetTurn(userBalls, computerBalls,
                computer.chooseBallsQuantity(), computer.ifGuessed());

        /*roundLogic.userBetTurn(userBalls, computerBalls,
                 computer.chooseBallsQuantity(),
                user.ifGuessed(choiceButtons.isGuessIfEven(), computer.ifComputerBallsEven()));*/
        roundUI.showBalls(grid, userBalls, computerBalls);
        roundUI.showChoiceBox(grid, roundLogic, user);
        roundUI.showChoiceButtons(grid, choiceButtons);
   }

   public void firstRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){
       roundUI.showBalls(grid, userBalls, computerBalls);
       roundUI.showChoiceBox(grid, roundLogic, user);
   }
}


//musisz przypisać nową klasę z dwoma polami dla
// userBalls i computerBalls i wtedy je wykorzystać w formie returna
//żeby nie brało od nowa 10 dla usera i kompa