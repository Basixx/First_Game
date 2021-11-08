package com.kodilla.marbles;

import javafx.scene.Scene;

public class SceneSwitcher {
    Game game = new Game();
    public Scene mainGamePlay(){
        Scene scene = game.showMainGame();
        return scene;
    }



}
