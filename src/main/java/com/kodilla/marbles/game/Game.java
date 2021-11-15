package com.kodilla.marbles.game;

import com.kodilla.marbles.buttons.*;
import com.kodilla.marbles.texts.GameTexts;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game {
    private final Image inGameBackground = new Image("file:src/main/resources/background/background.png");
    private int i = 0;
    private int balls;
    private final GameTexts gameTexts = new GameTexts();
    private final Round round = new Round();
    private BallsColorsButtons ballsColorsButtons = new BallsColorsButtons();
    private BallsNumbersButtons ballsNumbersButtons = new BallsNumbersButtons();
    private ModeButtons modeButtons = new ModeButtons();
    private RoundUI roundUI = new RoundUI();
    private RoundLogic roundLogic = new RoundLogic();

    private GridPane setBackGround() {
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(inGameBackground, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(50, 50, 50, 50));
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setBackground(background);

        return grid;
    }

    public Scene showModeChoice(Stage primaryStage){
        GridPane grid = setBackGround();
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text choiceGameMode = gameTexts.setText("choose game mode");
        grid.add(choiceGameMode, 1, 0);
        modeButtons.setButtons();

        modeButtons.getSinglePlayerButton().setOnAction
                ((e) -> primaryStage.setScene(showMainMenu(primaryStage)));

        grid.add(modeButtons.getSinglePlayerButton(), 0, 10);
        grid.add(modeButtons.getDoublePlayerButton(), 2, 10);

        return scene;
    }
    public Scene showMainMenu(Stage primaryStage) {

        GridPane grid = setBackGround();
        grid.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        Text mainMenu = gameTexts.setMainMenuText();
        grid.add(mainMenu, 0, 0);

        Text initialChoice = gameTexts.setText("Choose balls count and color");
        grid.add(initialChoice, 0, 5);

        ballsNumbersButtons.setAllButtons();

        FlowPane numberPane = new FlowPane();
        numberPane.setHgap(80);
        numberPane.getChildren().add(ballsNumbersButtons.getButton10());
        numberPane.getChildren().add(ballsNumbersButtons.getButton15());
        numberPane.getChildren().add(ballsNumbersButtons.getButton20());

        grid.add(numberPane, 0, 10);

        ballsColorsButtons.setAllButtons();

        FlowPane colorPane = new FlowPane();
        colorPane.setHgap(60);
        colorPane.getChildren().add(ballsColorsButtons.getGreenBallButton());
        colorPane.getChildren().add(ballsColorsButtons.getRedChipButton());
        colorPane.getChildren().add(ballsColorsButtons.getPurpleBallButton());
        colorPane.getChildren().add(ballsColorsButtons.getYellowBallButton());

        grid.add(colorPane, 0, 15);

        StartGameButton startGameButton = new StartGameButton();
        startGameButton.setButton();
        Button startGame = startGameButton.getStartGameButton();


        startGame.setOnAction((e) -> {
                    if(ballsNumbersButtons.getHowManyStart() != null
                            && ballsColorsButtons.getChoiceNumber() != null){

                        primaryStage.setScene(showMainGame(primaryStage));
                    }
                    else {
                        grid.add(new Text("choose color and count"), 6, 15);
                    }
                });


                grid.add(startGame, 4, 20);

        System.out.println("1ile kulek: " + balls);
        return scene;
    }

    public Scene showMainGame(Stage primaryStage) {
        GridPane grid = setBackGround();

        int ballsColor = ballsColorsButtons.getChoiceNumber();

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        balls = ballsNumbersButtons.getHowManyStart();
        round.setBalls(balls);
        System.out.println("2ile kulek: " + balls);
        round.firstRound(roundUI, roundLogic, grid, ballsColor);
       // primaryStage.setScene(firstRound(roundUI, roundLogic, ballsColor));

        CheckButton checkButton = new CheckButton();
        Button check = checkButton.setCheckButton();

        grid.add(check, 10, 10, 1, 1);
        check.setOnAction((e) -> {
            if(roundLogic.choice.getBallsChoiceBox().getValue() != null) {
                round.playRound(roundUI, roundLogic, grid, i, ballsColor);
                // primaryStage.setScene(showRound());
                i++;

                if (round.ballsCount.userBalls <= 0 || round.ballsCount.computerBalls <= 0) {
                    primaryStage.setScene(showEnd(round.ballsCount.userBalls, round.ballsCount.computerBalls));
                }
            }
        });
        return scene;
    }

    public Scene showEnd(int userBalls, int computerBalls){

        GridPane grid = setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        GameTexts gameTexts = new GameTexts();
        Text gameOver = gameTexts.setText("Game Over");
        grid.add(gameOver,0,0);

        if (userBalls <= 0 && computerBalls >0) {
            Text youLost = gameTexts.setText("Computer won :(");
            grid.add(youLost, 0, 2);
        }
        else{
            Text youWon = gameTexts.setText("YOU WON!!!");
            grid.add(youWon, 0, 2);
        }
        return scene;
    }

   /* public Scene firstRound(RoundUI roundUI, RoundLogic roundLogic, int ballsColor) {
        GridPane gridFirstRound = setBackGround();
        Scene firstRound = roundUI.setFirstRoundScene(gridFirstRound, roundLogic, round.ballsCount.userBalls,
                round.ballsCount.computerBalls, ballsColor, round.computer.getComputerBallsColor());
        return firstRound;
    }*/
/*
    public Scene showRound(){
        GridPane grid = setBackGround();
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        roundUI.showIU(grid, roundLogic, round.ballsCount.userBalls, round.ballsCount.computerBalls,
                ballsColorsButtons.getChoiceNumber(), ballsColorsButtons.
        );

        return scene;
    }*/
}
