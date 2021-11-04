package com.kodilla.marbles;

public class RoundLogic {

    Choice choice = new Choice();


    public void computerBetTurn(Integer userBalls, Integer computerBalls,
                                Integer computerBet, boolean ifCompGuessed){

        System.out.println("user " + userBalls);
        System.out.println("comp " + computerBalls);

        int userBallsBet = choice.getBallsChoiceBox().getValue();
        int computerBallsBet = computerBet;
        System.out.println("czemu ciągle null " + choice.getBallsChoiceBox().getValue());
        System.out.println("user bet " + userBallsBet);
        System.out.println("comp bet " +  computerBallsBet);

        if (ifCompGuessed) {
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

    public void userBetTurn(Integer userBalls, Integer computerBalls,
                            Integer computerBet, boolean ifUserGuessed){
        System.out.println("user " +userBalls);
        System.out.println("comp " +computerBalls);

        int userBallsBet = choice.getBallsChoiceBox().getValue();
        int computerBallsBet = computerBet;

        System.out.println("user bet " + userBallsBet);
        System.out.println("comp bet " +  computerBallsBet);
        System.out.println(ifUserGuessed);
        if (ifUserGuessed) {
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




}
