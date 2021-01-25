/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Arushan Sinnaduurai SN:101039300
 */
public class ConnectFourApplication extends Application implements Observer {

    public static final int NUM_COLUMNS = 8;
    public static final int NUM_ROWS = 8;
    public static final int NUM_TO_wIN = 4;
    public static final int BUTTON_SIZE = 20;
    public ConnectFourGame gameEngine;
    public ConnectButton buttons[][];
    private int tempRow;
    private int tempColumn;
    private String playerturn;
    private Alert alert;
    private GridPane grid;
    ConnectFourEnum colour;

    /**
     * This method create the GUI and also use a Gridpane create the board Also
     * include the button handler and the takeTurn handler
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        boolean x = random.nextBoolean();
        // random which player will go first

        if (x == true) {
            colour = ConnectFourEnum.BLACK;
        } else {
            colour = ConnectFourEnum.RED;
        }
        gameEngine = new ConnectFourGame(colour);
        gameEngine.addObserver(this); // //add this object to the observer
        alert = new Alert(AlertType.INFORMATION); //initialize the alert
        buttons = new ConnectButton[NUM_ROWS][NUM_COLUMNS]; //creating the game button

        playerturn = gameEngine.getTurn().toString();
        BorderPane board = new BorderPane();// Creating the GUI
        TextField TF = new TextField(playerturn);
        TF.setEditable(false);
        grid = new GridPane();
        Button takeTurn = new Button("Take My Turn");
        // the button handler for the grid
        takeTurn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                gameEngine.takeTurn(tempRow, tempColumn);
                TF.setText(gameEngine.getTurn().toString());
            }
        });
        EventHandler<ActionEvent> sharedHandler = new ButtonInnerClass();
        //This sets the grid
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLUMNS; c++) {
                buttons[r][c] = new ConnectButton("EMPTY", r, c);
                buttons[r][c].setMinHeight(BUTTON_SIZE);
                buttons[r][c].setMaxWidth(Double.MAX_VALUE);
                buttons[r][c].setOnAction(sharedHandler);
                grid.add((buttons[r][c]), c, NUM_ROWS - r);
            }
        }

        board.setTop(TF);//Add to the top
        board.setCenter(grid);//Add to the center
        board.setBottom(takeTurn);//add to the Bottom

        Scene scene = new Scene(board);// would of add 510,380 couldnt get to fix the screan

        primaryStage.setTitle("Connect Four Game");
        primaryStage.setScene(scene);
        primaryStage.show();// output the game board 
        
    }

    /**
     * This methods is used for the observer as it change the board whenever
     * action is taken
     *
     * @param o // the observer object
     * @param arg // the object that is being pass in
     */
    @Override
    public void update(Observable o, Object arg) {

        ConnectMove move = (ConnectMove) arg; //convert that object to the ConnectMove
        buttons[move.getRow()][move.getColumn()].setText(move.getColour().toString()); //check the button text
        buttons[move.getRow()][move.getColumn()].setDisable(true); //turn off the button
        if (gameEngine.getGameState() != ConnectFourEnum.IN_PROGRESS) { //if the game is not in progress
            // check whos as won the game or if the game is a draw
            if (gameEngine.getGameState() == ConnectFourEnum.RED) {
                alert.setTitle("Information Alert");
                alert.setHeaderText("Game Over");
                alert.setContentText("RED WINS");
                alert.showAndWait();
                 //Optional<ButtonType> result = alert.showAndWait();
                

            }
            if (gameEngine.getGameState() == ConnectFourEnum.BLACK) {
                alert.setTitle("Information Alert");
                alert.setHeaderText("Game Over");
                alert.setContentText("BLACK WINS");
                alert.showAndWait();
               

            }
            if (gameEngine.getGameState() == ConnectFourEnum.DRAW) {
                alert.setTitle("Information Alert");
                alert.setHeaderText("Game Over");
                alert.setContentText("DRAW");
                alert.showAndWait();
               

            }

            //reset the board.
            for (int r = 0; r < NUM_ROWS; r++) {
                for (int c = 0; c < NUM_COLUMNS; c++) {
                    //buttons[r][c] = new ConnectButton("EMPTY", r, c);
                    //grid.add((buttons[r][c]), c, NUM_ROWS - r);
                    buttons[r][c].setText("EMPTY");
                    buttons[r][c].setDisable(false);
                }
            }
            gameEngine.reset(ConnectFourEnum.BLACK);//set colour
        }

//buttons[tempRow][tempColumn].setText(gameEngine.getTurn().toString());
        //playerturn = "it's " + gameEngine.getTurn().toString() +" turn"; 
    }

    class ButtonInnerClass implements EventHandler<ActionEvent> {

        /**
         * This method handle the button whenever it is press but store the
         * values in tempRow and tempColumn
         *
         * @param event
         */
        @Override
        public void handle(ActionEvent event) {
            //System.out.println("Drop the checker");
            tempRow = ((ConnectButton) event.getSource()).getRow();
            tempColumn = ((ConnectButton) event.getSource()).getColumn();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
