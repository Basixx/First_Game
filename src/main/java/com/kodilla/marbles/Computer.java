package com.kodilla.marbles;

import java.util.Random;

public class Computer {

    private int ballsCount = 10;
    private Random generator = new Random();
    public int chooseBallsQuantity(){

        int computerBetChoice = generator.nextInt(ballsCount) +1;
        return computerBetChoice;
    }

    public boolean ifGuessed(){
        boolean guess = generator.nextBoolean();
        System.out.println(guess);
        return guess;
    }

    public int getBallsCount() {
        return ballsCount;
    }
}
