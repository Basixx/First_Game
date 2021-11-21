package com.kodilla.marbles.auxiliary;

import javafx.geometry.Orientation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import java.util.Map;

public class PaneSet {

    public FlowPane setPane(int ballsCount, int ballsColor){
        FlowPane pane = new FlowPane(Orientation.HORIZONTAL);
        BallsImages ballsImages = new BallsImages();
        Map<Integer, Image> imagesMap = ballsImages.imageHashMap();

        for (int i =0; i<ballsCount; i++){
            ImageView ball = new ImageView(imagesMap.get(ballsColor));
            pane.getChildren().add(ball);
        }
        return pane;
    }
}
