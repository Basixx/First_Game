package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsCount;
import com.kodilla.marbles.buttons.Choice;

public class RoundLogic {

    Choice choice = new Choice();

    public void computerBetTurn(Integer userBalls, Integer computerBalls,
                                      Integer computerBet, boolean ifCompGuessed, BallsCount ballsCount) {
        System.out.println("computerBetTurn");
        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

        int userBallsBet = choice.getBallsChoiceBox().getValue();
        int computerBallsBet = computerBet;

        System.out.println("user bet " + userBallsBet);
        System.out.println("comp bet " + computerBallsBet);

        if (ifCompGuessed) {
            computerBalls += computerBallsBet;
            userBalls -= computerBallsBet;
        } else {
            userBalls += userBallsBet;
            computerBalls -= userBallsBet;
        }

        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

        ballsCount.computerBalls = computerBalls;
        ballsCount.userBalls = userBalls;
    }

    public void userBetTurn(Integer userBalls, Integer computerBalls,
                                  Integer computerBet, boolean ifUserGuessed, BallsCount ballsCount) {
        System.out.println("userBetTurn");
        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

        int userBallsBet = choice.getBallsChoiceBox().getValue();
        int computerBallsBet = computerBet;

        System.out.println("user bet " + userBallsBet);
        System.out.println("comp bet " + computerBallsBet);
        System.out.println(ifUserGuessed);
        if (ifUserGuessed) {
            userBalls += userBallsBet;
            computerBalls -= userBallsBet;
        } else {
            computerBalls += computerBallsBet;
            userBalls -= computerBallsBet;
        }

        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

        ballsCount.computerBalls = computerBalls;
        ballsCount.userBalls = userBalls;
    }
}
