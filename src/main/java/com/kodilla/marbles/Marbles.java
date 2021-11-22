package com.kodilla.marbles;

import com.kodilla.marbles.game.ModeChoice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Marbles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ModeChoice modeChoice = new ModeChoice();
        Scene scene = modeChoice.showModeChoice(primaryStage);
        primaryStage.setTitle("Marbles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
