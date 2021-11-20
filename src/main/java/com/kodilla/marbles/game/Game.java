package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BackgroundSet;

import com.kodilla.marbles.buttons.*;
import com.kodilla.marbles.texts.GameTexts;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game {
    private int i = 0;
    private int balls;
    private final GameTexts gameTexts = new GameTexts();
    private final Round round = new Round();
    private BallsColorsButtons ballsColorsButtons = new BallsColorsButtons();
    private BallsNumbersButtons ballsNumbersButtons = new BallsNumbersButtons();
    private ModeButtons modeButtons = new ModeButtons();
    private RoundUI roundUI = new RoundUI();
    private RoundLogic roundLogic = new RoundLogic();
    private BackgroundSet backgroundSet = new BackgroundSet();
    private DoublePlayerUI doublePlayerUI = new DoublePlayerUI();
    private BackToMainButton backToMainButton = new BackToMainButton();

    public Scene showModeChoice(Stage primaryStage){
        GridPane grid = backgroundSet.setBackGround();
        grid.setAlignment(Pos.CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        Text choiceGameMode = gameTexts.setText("choose game mode");
        grid.add(choiceGameMode, 1, 0);
        modeButtons.setButtons();

        modeButtons.getSinglePlayerButton().setOnAction
                ((e) -> primaryStage.setScene(showMainMenuSinglePlayer(primaryStage)));

        modeButtons.getDoublePlayerButton().setOnAction
                ((e) -> primaryStage.setScene(showDoublePlayerMainMenu(primaryStage)));

        grid.add(modeButtons.getSinglePlayerButton(), 0, 10);
        grid.add(modeButtons.getDoublePlayerButton(), 2, 10);

        return scene;
    }
    public Scene showMainMenuSinglePlayer(Stage primaryStage) {

        GridPane grid = backgroundSet.setBackGround();
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

        ballsColorsButtons.setAllButtonsPlayer1();

        FlowPane colorPane = new FlowPane();
        colorPane.setHgap(60);
        colorPane.getChildren().add(ballsColorsButtons.getGreenBallButton1());
        colorPane.getChildren().add(ballsColorsButtons.getPinkBallButton1());
        colorPane.getChildren().add(ballsColorsButtons.getPurpleBallButton1());
        colorPane.getChildren().add(ballsColorsButtons.getYellowBallButton1());

        grid.add(colorPane, 0, 15);

        StartGameButton startGameButton = new StartGameButton();
        startGameButton.setButton();
        Button startGame = startGameButton.getStartGameButton();

        startGame.setOnAction((e) -> {
                    if(ballsNumbersButtons.getHowManyStart() != null
                            && ballsColorsButtons.getChoiceNumberPlayer1() != null){

                        primaryStage.setScene(showSinglePlayerGame(primaryStage));
                    }
                    else {
                        grid.add(new Text("choose color and count"), 6, 15);
                    }
                });


        grid.add(startGame, 4, 20);

        Button mainMenuButton = backToMainButton.getBacktoMenuButton();
        mainMenuButton.setOnAction((e) -> primaryStage.setScene(showModeChoice(primaryStage)));
        grid.add(mainMenuButton, 0, 20);

        System.out.println("1ile kulek: " + balls);
        return scene;
    }

    public Scene showSinglePlayerGame(Stage primaryStage) {
        GridPane grid = backgroundSet.setBackGround();

        int ballsColor = ballsColorsButtons.getChoiceNumberPlayer1();

        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);
        balls = ballsNumbersButtons.getHowManyStart();
        round.setBalls(balls);
        System.out.println("2ile kulek: " + balls);
        round.firstRound(roundUI, roundLogic, grid, ballsColor);

        CheckButton checkButton = new CheckButton();
        Button check = checkButton.setCheckButton();

        grid.add(check, 10, 10, 1, 1);
        check.setOnAction((e) -> {
            if(roundLogic.choice.getBallsChoiceBox().getValue() != null) {
                round.playRound(roundUI, roundLogic, grid, i, ballsColor);
                // primaryStage.setScene(showRound());
                i++;

                if (round.ballsCount.userBalls <= 0 || round.ballsCount.computerBalls <= 0) {
                    primaryStage.setScene(showEnd(round.ballsCount.userBalls, round.ballsCount.computerBalls, primaryStage));
                }
            }
        });
        return scene;
    }


    public Scene showDoublePlayerMainMenu(Stage primaryStage){

        GridPane grid = backgroundSet.setBackGround();
        grid.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        Text mainMenu = gameTexts.setMainMenuText();
        grid.add(mainMenu, 0, 0);

        Text initialChoice = gameTexts.setText("Choose balls count and color for both players");
        grid.add(initialChoice, 0, 5);

        ballsNumbersButtons.setAllButtons();

        FlowPane numberPane = new FlowPane();
        numberPane.setHgap(30);
        numberPane.getChildren().add(ballsNumbersButtons.getButton10());
        numberPane.getChildren().add(ballsNumbersButtons.getButton15());
        numberPane.getChildren().add(ballsNumbersButtons.getButton20());

        grid.add(numberPane, 0, 10);

        ballsColorsButtons.setAllButtonsPlayer1();
        ballsColorsButtons.setAllButtonsPlayer2();

        FlowPane colorPane1 = new FlowPane();
        colorPane1.setHgap(25);
        colorPane1.getChildren().add(ballsColorsButtons.getGreenBallButton1());
        colorPane1.getChildren().add(ballsColorsButtons.getPinkBallButton1());
        colorPane1.getChildren().add(ballsColorsButtons.getPurpleBallButton1());
        colorPane1.getChildren().add(ballsColorsButtons.getYellowBallButton1());

        FlowPane colorPane2 = new FlowPane();
        colorPane2.setHgap(25);
        colorPane2.getChildren().add(ballsColorsButtons.getGreenBallButton2());
        colorPane2.getChildren().add(ballsColorsButtons.getPinkBallButton2());
        colorPane2.getChildren().add(ballsColorsButtons.getPurpleBallButton2());
        colorPane2.getChildren().add(ballsColorsButtons.getYellowBallButton2());

        grid.add(colorPane1, 0, 15, 3, 1);
        grid.add(colorPane2, 0, 20, 3, 1);

        Text player1 = gameTexts.setText("Player 1");
        Text player2 = gameTexts.setText("Player 2");

        grid.add(player1, 0, 15);
        grid.add(player2, 0, 20);

        StartGameButton startGameButton = new StartGameButton();
        startGameButton.setButton();
        Button startGame = startGameButton.getStartGameButton();



        startGame.setOnAction((e) -> {
            if(ballsNumbersButtons.getHowManyStart() != null
                    && ballsColorsButtons.getChoiceNumberPlayer1() != null){
                doublePlayerUI.variables.player1Balls = ballsNumbersButtons.getHowManyStart();
                doublePlayerUI.variables.player2Balls = ballsNumbersButtons.getHowManyStart();
                doublePlayerUI.variables.player1BallsColor = ballsColorsButtons.getChoiceNumberPlayer1();
                doublePlayerUI.variables.player2BallsColor = ballsColorsButtons.getChoiceNumberPlayer2();

                primaryStage.setScene(doublePlayerUI.showPlayer1Turn1
                        (primaryStage, doublePlayerUI.variables));


            }
            else {
                grid.add(new Text("choose color and count"), 6, 15);
            }
        });

        grid.add(startGame, 4, 20);

        Button mainMenuButton = backToMainButton.getBacktoMenuButton();
        mainMenuButton.setOnAction((e) -> primaryStage.setScene(showModeChoice(primaryStage)));
        grid.add(mainMenuButton, 4, 15);

        System.out.println("1ile kulek: " + balls);
        return scene;
    }

    public Scene showEnd(int userBalls, int computerBalls, Stage primaryStage){

        GridPane grid = backgroundSet.setBackGround();
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

        Button playAgain = new Button("Play Again");
        playAgain.setOnAction((e) -> primaryStage.setScene(showModeChoice(primaryStage)) );
        grid.add(playAgain, 0, 4);

        return scene;
    }
}
