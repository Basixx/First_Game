package com.kodilla.marbles;

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
        Scene scene = game.showGame();

        primaryStage.setTitle("BlackJack");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
