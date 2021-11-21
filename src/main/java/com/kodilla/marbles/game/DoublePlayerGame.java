package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsCount;
import com.kodilla.marbles.auxiliary.DoubleRoundVariables;

public class DoublePlayerGame {

    public DoubleRoundVariables player2Guess(DoubleRoundVariables doubleRoundVariables){

        BallsCount ballsCount = playerGuess(doubleRoundVariables.player1Balls, doubleRoundVariables.player2Balls,
                doubleRoundVariables.player1Bet, doubleRoundVariables.player2Bet, doubleRoundVariables.ifEven);
        doubleRoundVariables.player1Balls = ballsCount.playerBallsA;
        doubleRoundVariables.player2Balls = ballsCount.playerBallsB;

        return doubleRoundVariables;
    }

    public DoubleRoundVariables player1Guess(DoubleRoundVariables doubleRoundVariables){

        BallsCount ballsCount = playerGuess(doubleRoundVariables.player2Balls, doubleRoundVariables.player1Balls,
                doubleRoundVariables.player2Bet, doubleRoundVariables.player1Bet, doubleRoundVariables.ifEven);
        doubleRoundVariables.player1Balls = ballsCount.playerBallsB;
        doubleRoundVariables.player2Balls = ballsCount.playerBallsA;

        return doubleRoundVariables;
    }

    private BallsCount playerGuess(int playerABalls, int playerBBalls, int playerABet, int playerBBet, boolean ifEven){

        BallsCount ballsCount = new BallsCount();

        System.out.println("początek rundy");
        System.out.println("Player1Balls = " + playerABalls);
        System.out.println("Player2Balls = " + playerBBalls);
        System.out.println("Player1Bet = " + playerABet);
        System.out.println("Player2Bet = " + playerBBet);
        System.out.println("czy obstawia parzyste: " + ifEven);

        if (ifEven == (playerABet %2 ==0)){
            System.out.println("Player1Balls = " + playerABalls);
            System.out.println("Player2Balls = " + playerBBalls);
            playerABalls -= playerBBet;
            playerBBalls += playerBBet;
        }
        else{
            System.out.println("Player1Balls = " + playerABalls);
            System.out.println("Player2Balls = " + playerBBalls);
            playerABalls += playerABet;
            playerBBalls -= playerABet;
        }

        System.out.println("po rundzie");
        System.out.println("Player1Balls = " + playerABalls);
        System.out.println("Player2Balls = " + playerBBalls);
        ballsCount.playerBallsA = playerABalls;
        ballsCount.playerBallsB = playerBBalls;
        return  ballsCount;
    }
}
