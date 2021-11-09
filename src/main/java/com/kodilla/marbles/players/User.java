package com.kodilla.marbles.players;

public class User {
    private int ballsCount = 10;

    public int getBallsCount() {
        return ballsCount;
    }

    public boolean ifGuessed(boolean isGuessIfEven, boolean isComputerBallsEven){
        return isComputerBallsEven == isGuessIfEven;
    }
}
