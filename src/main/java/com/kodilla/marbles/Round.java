package com.kodilla.marbles;

import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Round {
    public void beginRound(GridPane grid, FlowPane ballsPlayer1, FlowPane ballsPlayer2, Button start, Text text){
        User user = new User();
        Computer computer = new Computer();
        int userBalls = user.getBallsCount();
        int computerBalls = computer.getBallsCount();

        System.out.println("user" +userBalls);
        System.out.println("comp" +computerBalls);

        grid.add(ballsPlayer1, 0, 0, 10, 1);
        grid.add(ballsPlayer2, 0, 40, 10, 1);
        grid.getChildren().remove(start);
        grid.getChildren().remove(text);

        int userBallsBet = user.chooseBallsQuantity();
        int computerBallsBet = computer.chooseBallsQuantity();

        System.out.println("user bet" + userBallsBet);
        System.out.println("comp bet" +  computerBallsBet);

        if (!computer.isEven()) {
            userBalls += computerBallsBet;
            computerBalls -= computerBallsBet;
        }
        else {
            computerBalls += userBallsBet;
            userBalls -= userBallsBet;
        }
        System.out.println(!computer.isEven());
        System.out.println("user" + userBalls);
        System.out.println("comp" + computerBalls);
    }

}
