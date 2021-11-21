package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsCount;
import com.kodilla.marbles.auxiliary.SingleRoundVariables;

public class SinglePlayerGame {
    public SingleRoundVariables computerGuessRound(SingleRoundVariables singleRoundVariables){
        System.out.println("computerGuess: A - user, B - Computer");
        BallsCount ballsCount = playerGuess(singleRoundVariables.playerBalls, singleRoundVariables.computerBalls,
                singleRoundVariables.playerBet, singleRoundVariables.computerBet, singleRoundVariables.ifEven);
        singleRoundVariables.playerBalls = ballsCount.playerBallsA;
        singleRoundVariables.computerBalls = ballsCount.playerBallsB;

        return singleRoundVariables;
    }
    public SingleRoundVariables playerGuessRound(SingleRoundVariables singleRoundVariables){
        System.out.println("playerGuess: A - computer, B - user");
        BallsCount ballsCount = playerGuess(singleRoundVariables.computerBalls, singleRoundVariables.playerBalls,
                singleRoundVariables.computerBet, singleRoundVariables.playerBet, singleRoundVariables.ifEven);
        singleRoundVariables.playerBalls = ballsCount.playerBallsB;
        singleRoundVariables.computerBalls = ballsCount.playerBallsA;

        return singleRoundVariables;
    }

    private BallsCount playerGuess(int playerABalls, int playerBBalls, int playerABet, int playerBBet, boolean ifEven){

        BallsCount ballsCount = new BallsCount();

        System.out.println("początek rundy");
        System.out.println("PlayerABalls = " + playerABalls);
        System.out.println("PlayerBBalls = " + playerBBalls);
        System.out.println("PlayerABet = " + playerABet);
        System.out.println("PlayerBBet = " + playerBBet);
        System.out.println("czy obstawia parzyste: " + ifEven);



        if (ifEven == (playerABet % 2 ==0)){
            System.out.println("PlayerABalls = " + playerABalls);
            System.out.println("PlayerBBalls = " + playerBBalls);
            playerABalls -= playerBBet;
            playerBBalls += playerBBet;
        }
        else{
            System.out.println("PlayerABalls = " + playerABalls);
            System.out.println("PlayerBBalls = " + playerBBalls);
            playerABalls += playerABet;
            playerBBalls -= playerABet;
        }

        System.out.println("po rundzie");
        System.out.println("PlayerABalls = " + playerABalls);
        System.out.println("PlayerBBalls = " + playerBBalls);
        ballsCount.playerBallsA = playerABalls;
        ballsCount.playerBallsB = playerBBalls;
        return  ballsCount;
    }
}
