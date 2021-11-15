package com.kodilla.marbles.buttons;

import com.kodilla.marbles.auxiliary.BallsImages;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BallsColorsButtons {
    private final BallsImages ballsImages = new BallsImages();

    private final Button greenBallButton = new Button();
    private final Button pinkBallButton = new Button();
    private final Button purpleBallButton = new Button();
    private final Button yellowBallButton = new Button();

    private Integer choiceNumber;

    private void setButton(javafx.scene.control.Button button, ImageView imageView){
        button.setTranslateX(200);
        button.setTranslateY(25);
        button.setGraphic(imageView);
        button.setPadding(Insets.EMPTY);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(new DropShadow()));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
    }

    public void setAllButtons(){
        setButton(greenBallButton, ballsImages.green);
        greenBallButton.setOnAction((e) -> choiceNumber = 0);
        setButton(pinkBallButton, ballsImages.pink);
        pinkBallButton.setOnAction((e) -> choiceNumber = 1);
        setButton(purpleBallButton, ballsImages.purple);
        purpleBallButton.setOnAction((e) -> choiceNumber = 2);
        setButton(yellowBallButton, ballsImages.yellow);
        yellowBallButton.setOnAction((e) -> choiceNumber = 3);
    }

    public Button getGreenBallButton() {
        return greenBallButton;
    }

    public Button getRedChipButton() {
        return pinkBallButton;
    }

    public Button getPurpleBallButton() {
        return purpleBallButton;
    }

    public Button getYellowBallButton() {
        return yellowBallButton;
    }

    public Integer getChoiceNumber() {
        return choiceNumber;
    }
}
