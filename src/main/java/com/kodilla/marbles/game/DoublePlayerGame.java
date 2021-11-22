package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsCount;
import com.kodilla.marbles.auxiliary.DoubleRoundVariables;

public class DoublePlayerGame {

    public void player2Guess(DoubleRoundVariables doubleRoundVariables){
        System.out.println("player2 guess");
        BallsCount ballsCount = playerGuess(doubleRoundVariables.player2Balls, doubleRoundVariables.player1Balls,
                doubleRoundVariables.player2Bet, doubleRoundVariables.player1Bet, doubleRoundVariables.ifEven);
        doubleRoundVariables.player1Balls = ballsCount.playerBallsB;
        doubleRoundVariables.player2Balls = ballsCount.playerBallsA;
    }

    public void  player1Guess(DoubleRoundVariables doubleRoundVariables){
        System.out.println("player1 guess");
        BallsCount ballsCount = playerGuess(doubleRoundVariables.player1Balls, doubleRoundVariables.player2Balls,
                doubleRoundVariables.player1Bet, doubleRoundVariables.player2Bet, doubleRoundVariables.ifEven);
        doubleRoundVariables.player1Balls = ballsCount.playerBallsA;
        doubleRoundVariables.player2Balls = ballsCount.playerBallsB;
    }

    private BallsCount playerGuess(int playerABalls, int playerBBalls, int playerABet, int playerBBet, boolean ifEven){

        BallsCount ballsCount = new BallsCount();

        System.out.println("początek rundy");
        System.out.println("PlayerABalls = " + playerABalls);
        System.out.println("PlayerBBalls = " + playerBBalls);
        System.out.println("PlayerABet = " + playerABet);
        System.out.println("PlayerBBet = " + playerBBet);
        System.out.println("czy obstawia parzyste: " + ifEven);

        if (ifEven == (playerBBet %2 ==0)){
            System.out.println("PlayerABalls = " + playerABalls);
            System.out.println("PlayerBBalls = " + playerBBalls);
            playerABalls += playerABet;
            playerBBalls -= playerABet;
        }
        else{
            System.out.println("PlayerABalls = " + playerABalls);
            System.out.println("PlayerBBalls = " + playerBBalls);
            playerABalls -= playerBBet;
            playerBBalls += playerBBet;
        }

        System.out.println("po rundzie");
        System.out.println("PlayerABalls = " + playerABalls);
        System.out.println("PlayerBBalls = " + playerBBalls);
        ballsCount.playerBallsA = playerABalls;
        ballsCount.playerBallsB = playerBBalls;
        return  ballsCount;
    }
}
