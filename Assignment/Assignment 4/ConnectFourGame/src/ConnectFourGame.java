
import java.util.Observable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 *  * @author Arushan Sinnaduurai SN:101039300
 */
public class ConnectFourGame extends Observable {

    private int nColumns;
    private int nRows;
    private int NumToWin;
    private ConnectFourEnum grid[][];
    private ConnectFourEnum gameState;//IN_PROGRESS, RED (won), BLACK(won), DRAW
    private ConnectFourEnum turn;
    private int maxdraw;
    private ConnectMove position;

    /**
     * This default constructor use constructor chaining with the player
     * initialTurn(black or red)(
     *
     * @param initialTurn
     */
    public ConnectFourGame(ConnectFourEnum initialTurn) {
        this(8, 8, 4, initialTurn);
    }

    /**
     * This constructor initialize the nRows, nColumns, and numToWin and create
     * the grid using nRows and nColoumns
     *
     * @param nRows number of the rows need to initialize the grid
     * @param nColumns number of the columns need to initialize the grid
     * @param numToWin number of checker need to win
     * @param initialTurn which player
     */
    public ConnectFourGame(int nRows, int nColumns, int numToWin, ConnectFourEnum initialTurn) {
        if (nRows < 0 || nColumns < 0) {
            throw new IllegalArgumentException("The Grid should greater then 0");
        }
        if (numToWin > nRows || numToWin > nColumns) {
            throw new IllegalArgumentException("The dimensions should be greater size need to win ");
        }

        this.nRows = nRows;
        this.nColumns = nColumns;
        this.NumToWin = numToWin;
        this.grid = new ConnectFourEnum[nRows][nColumns]; //creating the board

        maxdraw = 0; // variable used to ensure that check if the game is draw
        reset(initialTurn); //reset the game and make sure that board is empty
    }

    /**
     * This method reset the game by reset board and make sure that game is in
     * progress
     *
     * @param initialTurn The player's colour
     */
    public void reset(ConnectFourEnum initialTurn) {
        for (int nr = 0; nr < nRows; nr++) {
            for (int nc = 0; nc < nColumns; nc++) {
                this.grid[nr][nc] = ConnectFourEnum.EMPTY;
            }
        }
        maxdraw = 0;
        this.gameState = ConnectFourEnum.IN_PROGRESS;
        this.turn = initialTurn;
        notifyObservers();//used for the reset
    }

    /**
     * TThis method used to play the game. Take in the row and column of the
     * location that player chose to place the checker. then call finnerWinner
     *
     * @param row the row of checker
     * @param column the column of checker
     * @return
     */
    public ConnectFourEnum takeTurn(int row, int column) {

        if (column < 0 || column > this.nColumns) {
            throw new IllegalArgumentException("The game board is " + this.nRows + " by " + this.nColumns);  //Return  error if the column is greater or lesser the game board 
        }
        if (row < 0 || row > this.nRows) {
            throw new IllegalArgumentException("The game board is " + this.nRows + " by " + this.nColumns); //Return  error if the rows is greater or lesser the game board 
        }
        if (this.gameState != ConnectFourEnum.IN_PROGRESS) {
            throw new IllegalArgumentException("The Game Over-- No More Plays");
        }
        if (this.grid[row][column] != ConnectFourEnum.EMPTY) {
            throw new IllegalArgumentException("A player has selected this posistion ");
        }
        if (row - 1 >= 0 && (grid[row - 1][column] == ConnectFourEnum.EMPTY)) {
            throw new IllegalArgumentException("Try again");
        }
        this.grid[row][column] = this.turn; // what location you are in 

        maxdraw++;
        if (maxdraw == (nColumns * nRows)) // check if there no more moves and ends in draws
        {
            this.gameState = ConnectFourEnum.DRAW;
            return this.gameState;
        }

        findWinner(row, column); // check if there is a winner
        position = new ConnectMove(row, column, this.turn); //used for observer as it needs the row,column and players's colour
        setChanged(); //used in observer as it check for any change
        notifyObservers(position);//sent to the update method
        //switch the players
        if (this.turn == ConnectFourEnum.RED) {
            this.turn = ConnectFourEnum.BLACK;
        } else {
            this.turn = ConnectFourEnum.RED;
        }

        return this.gameState;
    }

    /**
     * Check if the player as won
     *
     * @param row the row of checker
     * @param column the column of checker
     * @return the gameState (in process,Red,Black)
     */
    private ConnectFourEnum findWinner(int row, int column) {
// check left
        int counter = 1;
        for (int i = 1; i <= NumToWin; i++) {
            if (column - i >= 0) {

                if (this.grid[row][column] == this.grid[row][column - i]) {
                    counter++;
                } else {
                    break;
                }
            }
        }
// checking right
        for (int i = 1; i <= NumToWin; i++) {
            if (column + i < nColumns) {
                if (this.grid[row][column] == this.grid[row][column + i]) {
                    counter++;
                } else {
                    break;
                }
            }
        }
//checking down
        if (counter == NumToWin) {
            return this.gameState = this.turn;

        }

        counter = 1;
        for (int i = 1; i <= NumToWin; i++) {
            if (row - i >= 0) {

                if (this.grid[row][column] == this.grid[row - i][column]) {
                    counter++;

                } else {
                    break;
                }
            }
        }
        if (counter == NumToWin) {
            return this.gameState = this.turn;

        }

        return gameState;
    }

    /**
     * This get gameState
     *
     * @return the gameState (in process,Red,Black)
     */
    public ConnectFourEnum getGameState() {
        return this.gameState;
    }

    /**
     * Get the player's turn
     *
     * @return the player's turn (Red or Black)
     */
    public ConnectFourEnum getTurn() {
        return this.turn;
    }

    /**
     * This print the grid
     *
     * @return The board
     */
    @Override
    public String toString() {
        String sl = "";
        for (int nR = nRows - 1; nR >= 0; nR--) {
            for (int nC = 0; nC < nColumns; nC++) {
                sl += grid[nR][nC] + " | ";
            }
            sl += "\n";
        }
        return sl;
    }
}
