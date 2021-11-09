package com.kodilla.marbles.auxiliary;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;

public class BallsImages {

    private final Image greenBall = new Image("file:src/main/resources/balls/green_ball.png");
    private final Image pinkBall = new Image("file:src/main/resources/balls/pink_ball.png");
    private final Image purpleBall = new Image("file:src/main/resources/balls/purple_ball.png");
    private final Image yellowBall = new Image("file:src/main/resources/balls/yellow_ball.png");

    public ImageView green = new ImageView(greenBall);
    public ImageView pink = new ImageView(pinkBall);
    public ImageView purple = new ImageView(purpleBall);
    public ImageView yellow = new ImageView(yellowBall);

    public HashMap <Integer, Image> imageHashMap(){
        HashMap<Integer, Image> integerImageMap = new HashMap<>();

        integerImageMap.put(0, greenBall);
        integerImageMap.put(1, pinkBall);
        integerImageMap.put(2,purpleBall);
        integerImageMap.put(3,yellowBall);

        return integerImageMap;
    }
}
