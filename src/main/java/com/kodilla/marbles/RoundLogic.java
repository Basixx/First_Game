package com.kodilla.marbles;

public class RoundLogic {

    User user = new User();
    Computer computer = new Computer();
    private int userBalls = user.getBallsCount();
    private int computerBalls = computer.getBallsCount();

    public void singleTurn(){
        System.out.println("user" +userBalls);
        System.out.println("comp" +computerBalls);

        int userBallsBet = user.chooseBallsQuantity();
        int computerBallsBet = computer.chooseBallsQuantity();

        System.out.println("user bet" + userBallsBet);
        System.out.println("comp bet" +  computerBallsBet);

        if (computer.ifGuessed()) {
            computerBalls += userBallsBet;
            userBalls -= userBallsBet;
        }
        else {
            userBalls += computerBallsBet;
            computerBalls -= computerBallsBet;
        }

        System.out.println("user" + userBalls);
        System.out.println("comp" + computerBalls);
    }

    public int getUserBalls() {
        return userBalls;
    }

    public int getComputerBalls() {
        return computerBalls;
    }
}
