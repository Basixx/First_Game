package com.kodilla.marbles.texts;

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

    public Text setText(String textString){
        Text text = new Text();
        text.setText(textString);
        text.setFont(Font.font("arial",
                FontWeight.BOLD, FontPosture.ITALIC, 30));
        return text;
    }

}
