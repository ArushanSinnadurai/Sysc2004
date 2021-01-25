/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Seun
 * The game Engine for a snakes and Ladders game
 */
public class SnakesAndLadders {

    final int NUM_SQUARES = 100; //The number of squares
    final int NUM_PLAYERS;//The number of players
    private SnLSquare[] board; // The Board arry
    private int[] players; // The Players postion array
    private Dice dice; // The dice

    /**
     * The defualt constructor for the Game engine
     */
    public SnakesAndLadders() {
        this.NUM_PLAYERS = 2;
        this.dice = new Dice();
        board = new SnLSquare[this.NUM_SQUARES];
        players = new int[2];
        for (int i = 0; i < this.players.length; i++) {
            this.players[i] = 1;
        }
        for (int i = 0; i < this.board.length; i++) {
            this.board[i] = new SnLSquare(i + 1);
        }

        for (int i = 0; i < this.board.length; i++) {

            switch (i + 1) {
                case 4:
                    this.board[i] = new LadderSquare(4, 14);
                    break;
                case 9:
                    this.board[i] = new LadderSquare(9, 31);
                    break;
                case 17:
                    this.board[i] = new SnakeSquare(17, 7);
                    break;
                case 20:
                    this.board[i] = new LadderSquare(20, 38);
                    break;
                case 28:
                    this.board[i] = new LadderSquare(28, 84);
                    break;
                case 40:
                    this.board[i] = new LadderSquare(40, 59);
                    break;
                case 54:
                    this.board[i] = new SnakeSquare(54, 34);
                    break;
                case 62:
                    this.board[i] = new SnakeSquare(62, 18);
                    break;
                case 63:
                    this.board[i] = new LadderSquare(63, 81);
                    break;
                case 64:
                    this.board[i] = new SnakeSquare(64, 60);
                    break;
                case 71:
                    this.board[i] = new LadderSquare(71, 91);
                    break;
                case 87:
                    this.board[i] = new SnakeSquare(87, 24);
                    break;
                case 93:
                    this.board[i] = new SnakeSquare(93, 73);
                    break;
                case 95:
                    this.board[i] = new SnakeSquare(95, 75);
                    break;
                case 99:
                    this.board[i] = new SnakeSquare(99, 78);
                    break;
                default:
                    break;
            }

        }

    }

    /**
     * One arugement constructor allows for any numbe of players to be entered
     *
     * @param nPlayers
     */
    public SnakesAndLadders(int nPlayers) {
        if (nPlayers < 0) {
            throw new IllegalArgumentException("Please enter a Valid Number of Players");
        }
        this.NUM_PLAYERS = nPlayers;
        this.dice = new Dice();
        board = new SnLSquare[this.NUM_SQUARES];
        players = new int[nPlayers];
        for (int i = 0; i < this.players.length; i++) {
            this.players[i] = 1;
        }
        for (int i = 0; i < this.board.length; i++) {
            this.board[i] = new SnLSquare(i + 1);
        }

        for (int i = 0; i < this.board.length; i++) {

            switch (i + 1) {
                case 4:
                    this.board[i] = new LadderSquare(4, 14);
                    break;
                case 9:
                    this.board[i] = new LadderSquare(9, 31);
                    break;
                case 17:
                    this.board[i] = new SnakeSquare(17, 7);
                    break;
                case 20:
                    this.board[i] = new LadderSquare(20, 38);
                    break;
                case 28:
                    this.board[i] = new LadderSquare(28, 84);
                    break;
                case 40:
                    this.board[i] = new LadderSquare(40, 59);
                    break;
                case 54:
                    this.board[i] = new SnakeSquare(54, 34);
                    break;
                case 62:
                    this.board[i] = new SnakeSquare(62, 18);
                    break;
                case 63:
                    this.board[i] = new LadderSquare(63, 81);
                    break;
                case 64:
                    this.board[i] = new SnakeSquare(64, 60);
                    break;
                case 71:
                    this.board[i] = new LadderSquare(71, 91);
                    break;
                case 87:
                    this.board[i] = new SnakeSquare(87, 24);
                    break;
                case 93:
                    this.board[i] = new SnakeSquare(93, 73);
                    break;
                case 95:
                    this.board[i] = new SnakeSquare(95, 75);
                    break;
                case 99:
                    this.board[i] = new SnakeSquare(99, 78);
                    break;
                default:
                    break;
            }

        }

    }

    /**
     *
     * @param player
     * @return
     */
    public boolean takeTurn(int player) {
        int temp;
        int steps = this.dice.roll();
        this.players[player] = this.players[player] + steps;
        if (this.players[player] > 100) {
            temp = this.players[player] - 100;
            this.players[player] = 100 - temp;
        }
        this.players[player] = this.board[player].landOn();

        if (this.dice.hasDoubles()) {
            return true;
        }

        return false;

    }

    /**
     *
     * @param player
     * @return
     */
    public boolean isPlayerWinner(int player) {
        if (this.players[player] == 100) { //Checks to see if the player is at the 100 sqaure
            return true;
        }
        return false;

    }

    /**
     * Finds the first player on the 100 square if no players are found returns
     * -1
     *
     * @return
     */
    public int getWinner() {

        for (int i = 0; i < this.players.length; i++) {
            if (this.players[i] == 100) {
                return i;
            }
        }
        return -1;

    }

    /**
     *
     * @param player
     * @return
     */
    public int getPlayerPosition(int player) {
        return this.players[player];
    }

    /**
     *
     * @return
     */

    public String toString() {
        String s1 = "";
        for (int i = 0; i < this.board.length; ++i) {
            s1 = s1 + "|" + this.board[i].toString();
            if ((i+1) % 10 == 0) {
                s1 += "\n";
            }
        }

        return s1;
    }

    public String toStringCurrentPositions() {
        String s1 = "";

        for (int i = 0; i < this.players.length; i++) {
            s1 = s1 + i + ":" + this.players[i];
            s1 = s1 + " ";
        }

        return s1;
    }

    
    
    public static void main(String args[]) {
    
    SnakesAndLadders boardGame = new SnakesAndLadders();
    System.out.print(boardGame.toString());
   
    
    }
}

