package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsImages;
import com.kodilla.marbles.auxiliary.PaneSet;
import com.kodilla.marbles.buttons.ChoiceButtons;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.util.Map;

public class RoundUI {
    private FlowPane ballsViewComputer = new FlowPane(Orientation.HORIZONTAL);
    private FlowPane ballsViewUser = new FlowPane(Orientation.HORIZONTAL);
    private PaneSet paneSet = new PaneSet();

    private void showChoiceBox(GridPane grid, RoundLogic roundLogic, int ballsCount) {
        roundLogic.choice.adjustChoiceBox(ballsCount);
        grid.add(roundLogic.choice.getBallsChoiceBox(), 15, 10);
    }

    private void showBalls(GridPane grid, Integer userBalls, Integer computerBalls, int userBallsColor, int computerBallsColor) {

        ballsViewComputer = paneSet.setPane(computerBalls, computerBallsColor);
        ballsViewUser = paneSet.setPane(userBalls, userBallsColor);

        grid.add(ballsViewComputer, 1, 0, 10, 1);
        grid.add(ballsViewUser, 1, 20, 10, 1);
    }



    public void showChoiceButtons(GridPane grid, ChoiceButtons choiceButtons) {
        choiceButtons.setBothButtons();
        grid.add(choiceButtons.getOddButton(), 15, 20);
        grid.add(choiceButtons.getEvenButton(), 20, 20);
    }

    public FlowPane getBallsViewComputer() {
        return ballsViewComputer;
    }

    public FlowPane getBallsViewUser() {
        return ballsViewUser;
    }

    public void showIU(GridPane grid, RoundLogic roundLogic, Integer userBalls,
                       Integer computerBalls, int userBallsColor, int computerBallsColor){

        showChoiceBox(grid, roundLogic, userBalls);
        showBalls(grid, userBalls, computerBalls, userBallsColor, computerBallsColor);

    }
    public Scene setFirstRoundScene(GridPane grid, RoundLogic roundLogic, Integer userBalls,
                                    Integer computerBalls, int userBallsColor, int computerBallsColor){
        Scene userInterface = new Scene(grid, 1600, 900, Color.BLACK);
        showIU(grid, roundLogic, userBalls, computerBalls, userBallsColor, computerBallsColor);
        return userInterface;
    }

}
