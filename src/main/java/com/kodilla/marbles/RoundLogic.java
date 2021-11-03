package com.kodilla.marbles;

public class RoundLogic {

    User user = new User();
    Computer computer = new Computer();
    Choice choice = new Choice();
    public int computerBalls= computer.getBallsCount();
    public int userBalls = user.getBallsCount();

    public void computerBetTurn(){

        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

        int userBallsBet = choice.getBallsChoiceBox().getValue();
        int computerBallsBet = computer.chooseBallsQuantity();
        System.out.println("czemu ciągle null " + choice.getBallsChoiceBox().getValue());
        System.out.println("user bet " + userBallsBet);
        System.out.println("comp bet " +  computerBallsBet);

        if (computer.ifGuessed()) {
            computerBalls += computerBallsBet;
            userBalls -= computerBallsBet;
        }
        else {
            userBalls += userBallsBet;
            computerBalls -= userBallsBet;
        }

        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);
    }

    public void userBetTurn(){
        System.out.println("user " +userBalls);
        System.out.println("comp " +computerBalls);

        int userBallsBet = choice.getBallsChoiceBox().getValue();
        int computerBallsBet = computer.chooseBallsQuantity();
        System.out.println("czemu ciągle null " + choice.getBallsChoiceBox().getValue());
        System.out.println("user bet " + userBallsBet);
        System.out.println("comp bet " +  computerBallsBet);

        if (user.ifGuessed()) {
            userBalls += userBallsBet;
            computerBalls -= userBallsBet;
        }
        else {
            computerBalls += computerBallsBet;
            userBalls -= computerBallsBet;
        }

        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

    }



    public int getUserBalls() {
        return userBalls;
    }

    public int getComputerBalls() {
        return computerBalls;
    }


}
