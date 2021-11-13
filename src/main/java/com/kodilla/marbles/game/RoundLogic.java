package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsCount;
import com.kodilla.marbles.buttons.Choice;

public class RoundLogic {

    Choice choice = new Choice();

    public void computerGuessTurn(Integer userBalls, Integer computerBalls,
                                  Integer computerBet, boolean ifCompGuessed, BallsCount ballsCount) {
        System.out.println("computerGuessTurn");
        turn(computerBet, ifCompGuessed, computerBalls, userBalls, ballsCount );
    }

    public void userGuessTurn(Integer userBalls, Integer computerBalls,
                              Integer computerBet, boolean ifUserGuessed, BallsCount ballsCount) {
        System.out.println("userGuessTurn");
        turn(computerBet, !ifUserGuessed, computerBalls, userBalls, ballsCount);
    }

    private void turn(int computerBet, boolean guess, int computerBalls, int userBalls, BallsCount ballsCount){
        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

        int userBallsBet = choice.getBallsChoiceBox().getValue();
        int computerBallsBet = computerBet;

        if (guess) {
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
}
