package com.kodilla.marbles.game;

import com.kodilla.marbles.auxiliary.BackgroundSet;
import com.kodilla.marbles.buttons.BackToMainButton;
import com.kodilla.marbles.buttons.BallsColorsButtons;
import com.kodilla.marbles.buttons.BallsNumbersButtons;
import com.kodilla.marbles.buttons.StartGameButton;
import com.kodilla.marbles.players.Computer;
import com.kodilla.marbles.texts.GameTexts;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu {

    private final BallsColorsButtons ballsColorsButtons = new BallsColorsButtons();
    private final BallsNumbersButtons ballsNumbersButtons = new BallsNumbersButtons();
    private final SinglePlayerUI singlePlayerUI = new SinglePlayerUI();
    private final DoublePlayerUI doublePlayerUI = new DoublePlayerUI();
    private final BackToMainButton backToMainButton = new BackToMainButton();
    private final Computer computer = new Computer();
    private final BackgroundSet backgroundSet = new BackgroundSet();
    private final GameTexts gameTexts = new GameTexts();

    public Scene showSinglePlayerMainMenu(Stage primaryStage) {

        ModeChoice modeChoice = new ModeChoice();

        GridPane grid = backgroundSet.setBackGround();
        grid.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        Text mainMenu = gameTexts.setMainMenuText();
        grid.add(mainMenu, 0, 0);

        Text initialChoice = gameTexts.setText("Choose balls count and color");
        grid.add(initialChoice, 0, 5);

        ballsNumbersButtons.setAllButtons();

        FlowPane numberPane = numberPane();

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
                singlePlayerUI.variables.playerBalls = ballsNumbersButtons.getHowManyStart();
                singlePlayerUI.variables.computerBalls = ballsNumbersButtons.getHowManyStart();
                singlePlayerUI.variables.playerBallsColor = ballsColorsButtons.getChoiceNumberPlayer1();
                singlePlayerUI.variables.computerBallsColor = computer.getComputerBallsColor();
                primaryStage.setScene(singlePlayerUI.showSimpleBet(primaryStage, singlePlayerUI.variables));
            }
            else {
                grid.add(new Text("choose color and count"), 6, 15);
            }
        });


        grid.add(startGame, 4, 20);

        Button mainMenuButton = backToMainButton.getBacktoMenuButton();
        mainMenuButton.setOnAction((e) -> primaryStage.setScene(modeChoice.showModeChoice(primaryStage)));
        grid.add(mainMenuButton, 0, 20);

        return scene;
    }

    public Scene showDoublePlayerMainMenu(Stage primaryStage){

        ModeChoice modeChoice = new ModeChoice();
        GridPane grid = backgroundSet.setBackGround();
        grid.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(grid, 1600, 900, Color.BLACK);

        Text mainMenu = gameTexts.setMainMenuText();
        grid.add(mainMenu, 0, 0);

        Text initialChoice = gameTexts.setText("Choose balls count and color for both players");
        grid.add(initialChoice, 0, 5);

        ballsNumbersButtons.setAllButtons();

        FlowPane numberPane = numberPane();

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
        mainMenuButton.setOnAction((e) ->
                primaryStage.setScene(modeChoice.showModeChoice(primaryStage)));
        grid.add(mainMenuButton, 4, 15);

        return scene;
    }

    private FlowPane numberPane(){
        FlowPane nrPane = new FlowPane();
        nrPane.setHgap(30);
        nrPane.getChildren().add(ballsNumbersButtons.getButton10());
        nrPane.getChildren().add(ballsNumbersButtons.getButton15());
        nrPane.getChildren().add(ballsNumbersButtons.getButton20());
        return nrPane;
    }
}
