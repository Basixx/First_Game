package com.kodilla.marbles.players;

import java.util.Random;

public class Computer {


    private Random generator = new Random();
    private int computerBallsColor = generator.nextInt(4);

    public int chooseBallsQuantity(int ballsCount) {

        return generator.nextInt(ballsCount) + 1;
    }

    public boolean ifGuessed() {
        boolean guess = generator.nextBoolean();
        System.out.println(guess);
        return guess;
    }

    public boolean ifComputerBallsEven(int balls) {
        return chooseBallsQuantity(balls) % 2 == 0;
    }

    public int getComputerBallsColor() {
        return computerBallsColor;
    }
}
