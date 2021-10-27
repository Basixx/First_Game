package com.kodilla.marbles;

public class Computer {
    private String name;
    private int ballsCount = 10;

    public int chooseBallsQuantity(){
        return 4;
    }

    public boolean isEven(){
        return true;
    }

    public String getName() {
        return name;
    }

    public int getBallsCount() {
        return ballsCount;
    }
}
