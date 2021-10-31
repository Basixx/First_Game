package com.kodilla.marbles;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;

public class RoundLogic {

    User user = new User();
    Computer computer = new Computer();
    Choice choice = new Choice();
    public int computerBalls= computer.getBallsCount();
    public int userBalls = user.getBallsCount();

    public void singleTurn(){

        System.out.println("user " +userBalls);
        System.out.println("comp " +computerBalls);

        int userBallsBet = 3;// choice.choiceCount(user);
        int computerBallsBet = computer.chooseBallsQuantity();
        System.out.println("czemu ciągle null " + choice.chooseBallsQuantityBox(user).getValue());
        System.out.println("user bet " + userBallsBet);
        System.out.println("comp bet " +  computerBallsBet);

        if (computer.ifGuessed()) {
            computerBalls += userBallsBet;
            userBalls -= userBallsBet;
        }
        else {
            userBalls += computerBallsBet;
            computerBalls -= computerBallsBet;
        }

        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);
    }



    public int getUserBalls() {
        return userBalls;
    }

    public int getComputerBalls() {
        return computerBalls;
    }


}
