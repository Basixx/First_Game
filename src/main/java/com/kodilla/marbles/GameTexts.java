package com.kodilla.marbles;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameTexts {

    public Text setMainMenuText(){
        Text mainMenuText = new Text();
        mainMenuText.setText("MAIN MENU");
        mainMenuText.setFont(Font.font("arial",
                FontWeight.BOLD, FontPosture.ITALIC, 90));
        mainMenuText.setFill(Color.RED);
        mainMenuText.setStrokeWidth(5);
        mainMenuText.setStroke(Color.BLACK);
        return mainMenuText;
    }

    public Text setInititialChoiceText(){
        Text initialSetup = new Text();
        initialSetup.setText("Choose balls count and color");
        initialSetup.setFont(Font.font("arial",
                FontWeight.BOLD, FontPosture.ITALIC, 30));
        return initialSetup;
    }
}
