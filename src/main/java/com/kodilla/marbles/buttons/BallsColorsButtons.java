package com.kodilla.marbles.buttons;

import com.kodilla.marbles.auxiliary.BallsImages;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class BallsColorsButtons {
    private final BallsImages ballsImages = new BallsImages();

    private final Button greenBallButton1 = new Button();
    private final Button pinkBallButton1 = new Button();
    private final Button purpleBallButton1 = new Button();
    private final Button yellowBallButton1 = new Button();
    private final Button greenBallButton2 = new Button();
    private final Button pinkBallButton2 = new Button();
    private final Button purpleBallButton2 = new Button();
    private final Button yellowBallButton2 = new Button();

    private Integer choiceNumberPlayer1;
    private Integer choiceNumberPlayer2;

    private void setButton(javafx.scene.control.Button button, ImageView imageView){
        button.setTranslateX(200);
        button.setTranslateY(25);
        button.setGraphic(imageView);
        button.setPadding(Insets.EMPTY);
        button.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> button.setEffect(new DropShadow()));
        button.addEventHandler(MouseEvent.MOUSE_EXITED, e -> button.setEffect(null));
    }

    public void setAllButtonsPlayer1(){
        setButton(greenBallButton1, ballsImages.green1);
        greenBallButton1.setOnAction((e) -> choiceNumberPlayer1 = 0);
        setButton(pinkBallButton1, ballsImages.pink1);
        pinkBallButton1.setOnAction((e) -> choiceNumberPlayer1 = 1);
        setButton(purpleBallButton1, ballsImages.purple1);
        purpleBallButton1.setOnAction((e) -> choiceNumberPlayer1 = 2);
        setButton(yellowBallButton1, ballsImages.yellow1);
        yellowBallButton1.setOnAction((e) -> choiceNumberPlayer1 = 3);
    }
    public void setAllButtonsPlayer2(){
        setButton(greenBallButton2, ballsImages.green2);
        greenBallButton2.setOnAction((e) -> choiceNumberPlayer2 = 0);
        setButton(pinkBallButton2, ballsImages.pink2);
        pinkBallButton2.setOnAction((e) -> choiceNumberPlayer2 = 1);
        setButton(purpleBallButton2, ballsImages.purple2);
        purpleBallButton2.setOnAction((e) -> choiceNumberPlayer2 = 2);
        setButton(yellowBallButton2, ballsImages.yellow2);
        yellowBallButton2.setOnAction((e) -> choiceNumberPlayer2 = 3);
    }

    public Button getGreenBallButton1() {
        return greenBallButton1;
    }

    public Button getPinkBallButton1() {
        return pinkBallButton1;
    }

    public Button getPurpleBallButton1() {
        return purpleBallButton1;
    }

    public Button getYellowBallButton1() {
        return yellowBallButton1;
    }

    public Button getGreenBallButton2() {
        return greenBallButton2;
    }

    public Button getPinkBallButton2() {
        return pinkBallButton2;
    }

    public Button getPurpleBallButton2() {
        return purpleBallButton2;
    }

    public Button getYellowBallButton2() {
        return yellowBallButton2;
    }

    public Integer getChoiceNumberPlayer1() {
        return choiceNumberPlayer1;
    }

    public Integer getChoiceNumberPlayer2() {
        return choiceNumberPlayer2;
    }
}
