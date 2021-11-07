package com.kodilla.marbles;

import javafx.scene.layout.GridPane;

public class Round {

    User user = new User();
    Computer computer = new Computer();
    ChoiceButtons choiceButtons = new ChoiceButtons();
    BallsCount ballsCount = new BallsCount();
    //private int userBalls = user.getBallsCount();
   // private int computerBalls = computer.getBallsCount();

    public void setBalls(){
        ballsCount.userBalls = user.getBallsCount();
        ballsCount.computerBalls = computer.getBallsCount();
    }


    public void playRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid, int i){

        roundUI.getBallsViewUser().getChildren().clear();
        roundUI.getBallsViewComputer().getChildren().clear();

        grid.getChildren().remove(roundUI.getBallsViewUser());
        grid.getChildren().remove(roundUI.getBallsViewComputer());
        grid.getChildren().remove(roundLogic.choice.getBallsChoiceBox());
        grid.getChildren().remove(choiceButtons.getEvenButton());
        grid.getChildren().remove(choiceButtons.getOddButton());


        if (i%2==1) {
            roundLogic.computerBetTurn(ballsCount.userBalls, ballsCount.computerBalls,
                    computer.chooseBallsQuantity(), computer.ifGuessed(), ballsCount);
        }
        else {
            roundUI.showChoiceButtons(grid, choiceButtons);
            roundLogic.userBetTurn(ballsCount.userBalls, ballsCount.computerBalls,
                    computer.chooseBallsQuantity(),
                    user.ifGuessed(choiceButtons.isGuessIfEven(), computer.ifComputerBallsEven()), ballsCount);

        }
        roundUI.showBalls(grid, ballsCount.userBalls, ballsCount.computerBalls);
        roundUI.showChoiceBox(grid, roundLogic, user.getBallsCount());
   }

   public void firstRound (RoundUI roundUI, RoundLogic roundLogic, GridPane grid){
       roundUI.showBalls(grid, ballsCount.userBalls, ballsCount.computerBalls);
       roundUI.showChoiceBox(grid, roundLogic, user.getBallsCount());
   }
}


//musisz przypisać nową klasę z dwoma polami dla
// userBalls i computerBalls i wtedy je wykorzystać w formie returna
//żeby nie brało od nowa 10 dla usera i kompa