package com.kodilla.marbles;

import com.kodilla.marbles.buttons.ChoiceButtons;
import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class RoundUI {

    private Image blackChip = new Image("file:src/main/resources/chips/chipBlackWhite_border.png");
    private Image redChip = new Image("file:src/main/resources/chips/chipRedWhite_border.png");
    private Image blueChip = new Image("file:src/main/resources/chips/chipBlueWhite_border.png");
    private Image greenChip = new Image("file:src/main/resources/chips/chipGreenWhite_border.png");
    private FlowPane ballsViewComputer = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane ballsViewUser = new FlowPane(Orientation.HORIZONTAL);

    public void showChoiceBox(GridPane grid, RoundLogic roundLogic, int ballsCount){
        roundLogic.choice.adjustChoiceBox(ballsCount);
        grid.add(roundLogic.choice.getBallsChoiceBox(), 4, 4);
    }

    public void showBalls(GridPane grid, Integer userBalls, Integer computerBalls){

        for (int i =0; i<userBalls; i++){
            ImageView chip = new ImageView(blackChip);
            ballsViewComputer.getChildren().add(chip);
        }
        for (int i =0; i<computerBalls; i++){
            ImageView chip = new ImageView(redChip);
            ballsViewUser.getChildren().add(chip);
        }

        grid.add(ballsViewComputer, 0, 0, 10, 1);
        grid.add(ballsViewUser, 0, 40, 10, 1);
    }

    public void showChoiceButtons(GridPane grid, ChoiceButtons choiceButtons){
        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getOddButton(), 10, 10);
        grid.add(choiceButtons.getEvenButton(), 20, 20);

    }


    public FlowPane getBallsViewComputer() {
        return ballsViewComputer;
    }

    public FlowPane getBallsViewUser() {
        return ballsViewUser;
    }


}
