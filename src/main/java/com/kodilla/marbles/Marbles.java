package com.kodilla.marbles;

import com.kodilla.marbles.game.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Marbles extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Game game = new Game();
        Scene scene = game.showModeChoice(primaryStage);
        primaryStage.setTitle("Marbles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
