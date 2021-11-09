package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsCount;
import com.kodilla.marbles.buttons.ChoiceButtons;
import com.kodilla.marbles.players.Computer;
import com.kodilla.marbles.players.User;
import javafx.scene.layout.GridPane;

public class Round {

    User user = new User();
    Computer computer = new Computer();
    ChoiceButtons choiceButtons = new ChoiceButtons();
    BallsCount ballsCount = new BallsCount();

    public void setBalls(int balls) {
        ballsCount.userBalls = balls;
        ballsCount.computerBalls = balls;
    }

    public void playRound(RoundUI roundUI, RoundLogic roundLogic, GridPane grid, int i, int ballsColor) {

        roundUI.getBallsViewUser().getChildren().clear();
        roundUI.getBallsViewComputer().getChildren().clear();

        grid.getChildren().remove(roundUI.getBallsViewUser());
        grid.getChildren().remove(roundUI.getBallsViewComputer());
        grid.getChildren().remove(roundLogic.choice.getBallsChoiceBox());
        grid.getChildren().remove(choiceButtons.getEvenButton());
        grid.getChildren().remove(choiceButtons.getOddButton());

        if (i % 2 == 1) {
            roundLogic.computerBetTurn(ballsCount.userBalls, ballsCount.computerBalls,
                    computer.chooseBallsQuantity(ballsCount.computerBalls), computer.ifGuessed(), ballsCount);
        } else {
            roundUI.showChoiceButtons(grid, choiceButtons);
            roundLogic.userBetTurn(ballsCount.userBalls, ballsCount.computerBalls,
                    computer.chooseBallsQuantity(ballsCount.computerBalls),
                    user.ifGuessed(choiceButtons.isGuessIfEven(), computer.ifComputerBallsEven(ballsCount.computerBalls)), ballsCount);
        }
        roundUI.showBalls(grid, ballsCount.userBalls, ballsCount.computerBalls, ballsColor, computer.getComputerBallsColor());
        roundUI.showChoiceBox(grid, roundLogic, ballsCount.userBalls);

        if (ballsCount.userBalls <= 0 || ballsCount.computerBalls <= 0) {
            System.out.println("koniec");
        }
    }

    public void firstRound(RoundUI roundUI, RoundLogic roundLogic, GridPane grid, int ballsColor) {
        roundUI.showBalls(grid, ballsCount.userBalls, ballsCount.computerBalls, ballsColor, computer.getComputerBallsColor());
        roundUI.showChoiceBox(grid, roundLogic, ballsCount.userBalls);
    }
}
