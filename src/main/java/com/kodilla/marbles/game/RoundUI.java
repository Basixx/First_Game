package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BallsImages;
import com.kodilla.marbles.buttons.ChoiceButtons;
import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import java.util.Map;

public class RoundUI {
    private final FlowPane ballsViewComputer = new FlowPane(Orientation.HORIZONTAL);
    private final FlowPane ballsViewUser = new FlowPane(Orientation.HORIZONTAL);

    public void showChoiceBox(GridPane grid, RoundLogic roundLogic, int ballsCount) {
        roundLogic.choice.adjustChoiceBox(ballsCount);
        grid.add(roundLogic.choice.getBallsChoiceBox(), 4, 4);
    }

    public void showBalls(GridPane grid, Integer userBalls, Integer computerBalls, int userBallsColor, int computerBallsColor) {

        BallsImages ballsImages = new BallsImages();
        Map<Integer, Image> imagesMap = ballsImages.imageHashMap();

        for (int i = 0; i < userBalls; i++) {
            ImageView ball = new ImageView(imagesMap.get(computerBallsColor));
            ballsViewComputer.getChildren().add(ball);
        }
        for (int i = 0; i < computerBalls; i++) {
            ImageView ball = new ImageView(imagesMap.get(userBallsColor));
            ballsViewUser.getChildren().add(ball);
        }

        grid.add(ballsViewComputer, 0, 0, 10, 1);
        grid.add(ballsViewUser, 0, 40, 10, 1);
    }

    public void showChoiceButtons(GridPane grid, ChoiceButtons choiceButtons) {
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
