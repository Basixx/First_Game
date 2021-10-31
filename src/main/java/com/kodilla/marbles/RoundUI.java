package com.kodilla.marbles;

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
    public void showBalls(GridPane grid, RoundLogic roundLogic){

        for (int i =0; i<roundLogic.getUserBalls(); i++){
            ImageView chip = new ImageView(blackChip);
            ballsViewComputer.getChildren().add(chip);
        }
        for (int i =0; i<roundLogic.getComputerBalls(); i++){
            ImageView chip = new ImageView(redChip);
            ballsViewUser.getChildren().add(chip);
        }

        grid.add(ballsViewComputer, 0, 0, 10, 1);
        grid.add(ballsViewUser, 0, 40, 10, 1);
    }

    public FlowPane getBallsViewComputer() {
        return ballsViewComputer;
    }

    public FlowPane getBallsViewUser() {
        return ballsViewUser;
    }

    public void showChoiceBox(GridPane grid, RoundLogic roundLogic){
        grid.add(roundLogic.user.chooseBallsQuantity1(), 4, 4);
    }
}
