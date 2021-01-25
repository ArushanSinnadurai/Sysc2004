/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

/**
 *@author Arushan Sinnadurai
 * Sn:101039300
 */
public class SnakesAndLadders {

    public static int NUM_PLAYERS; //constant value
    public static final int NUM_SQUARES = 100;// the size of the gameboard
    private SnLSquare board[];//the game board
    private int players[]; // the number of players and the storage of the their positions
    private Dice dices;// the number of dices 
    
/**
 * Default Constructor: using constructor chaining from two players
 */
    public SnakesAndLadders() {
        //player = new int [NUM_PLAYERS];
        //board = new SnLSquare [NUM_SQUARES];
        //dice = new Dice();
        this(2);
    }
    
    
/**
 * takes in number of people and initializing all the variables. 
 * Make a board of 100 SnLSquares and also assign all the ladders and snakes
 * initializing a dice which contains create 2 die
 * @param nplayers 
 */
    public SnakesAndLadders(int nplayers) {
        if (nplayers < 0) {
            throw new IllegalArgumentException("Please enter a Valid Number of Players");
        }
        NUM_PLAYERS = nplayers;// initizing the number of players
        players = new int[nplayers];// make an anrray of that many palyers
        board = new SnLSquare[NUM_SQUARES];// making a 100 object SnLSquare
        dices = new Dice();// make a pair of dices
        // creating the board and the snakes + ladders
        for (int i = 0; i < board.length; i += 1) {
            if (i == 3) {
                board[3] = new LadderSquare(4, 14);
            }else
            if (i == 8) {
                board[8] = new LadderSquare(9, 31);
            }else
            if (i == 19) {
                board[19] = new LadderSquare(20, 38);
            }else
            if (i == 27) {
                board[27] = new LadderSquare(28, 84);
            }else
            if (i == 39) {
                board[39] = new LadderSquare(40, 59);
            }else
            if (i == 62) {
                board[62] = new LadderSquare(63, 81);
            }else
            if (i == 70) {
                board[70] = new LadderSquare(71, 91);
            }else
            if (i == 16) {
                board[16] = new SnakeSquare(17, 7);
            }else
            if (i == 53) {
                board[53] = new SnakeSquare(54, 34);
            }else
            if (i == 61) {
                board[61] = new SnakeSquare(62, 18);
            }else
            if (i == 63) {
                board[63] = new SnakeSquare(64, 60);
            }else
            if (i == 86) {
                board[86] = new SnakeSquare(87, 24);
            }else
            if (i == 92) {
                board[92] = new SnakeSquare(93, 73);
            }else
            if (i == 94) {
                board[94] = new SnakeSquare(95, 75);
            }else
            if (i == 98) {
                board[98] = new SnakeSquare(99, 78);
            } else {
                board[i] = new SnLSquare(i + 1);
            }

        }
        for (int j = 0; j < players.length; j++) {
            players[j] = 1;

        }

    }

    
    /**
     * rolls the dices and add them into the position of players
     * if players exceeds 100 - move back by that exceeded value
     * check if the dices rolled a double 
     * @param player
     * @return ture dice has doubles 
     */
    public boolean takeTurn(int player) {
        int temp = 0;
        int leftover = 0;
        int holdvalue = 0;
        int lastspot=0;
        int stor=0;
        temp = dices.roll();
        stor =  this.players[player];
        this.players[player] = this.players[player] + temp;
        lastspot=stor + temp;
        System.out.println("players " + player + " rolled " + temp);
        
        // check if the players goes over 100 and if it does substract the exceeds
        if (players[player] > NUM_SQUARES) {
            holdvalue = players[player];
            leftover = holdvalue - NUM_SQUARES;
            players[player] = NUM_SQUARES - leftover;
        }
        players[player] = board[(players[player] - 1)].landOn(); // place the player position to the board

        if( lastspot > players[player])
        {
            System.out.println("Oh No");
        }
        if (dices.hasDoubles() == true) // checks for doubles
        { 
  
            
            return true;
         
            
        }

        return false;
    }
    
    
/**
 * checks if a player reached 100
 * 
 * @param player takes in the value of players
 * @return check if players reached 100
 */
    public boolean isPlayerWinner(int player) {
        if (players[player] == 100) {
            return true;
        }
        return false;

    }
/**
 * check if that players have reached a 100
 * @return the player at the index if have reached 100
 */
    public int getWinner() {
        for (int i = 0; i < players.length; i++) {
            if (players[i] == NUM_SQUARES) { //check for 100 and if so return that player
                return i;
            }
        }
        return -1;
    }
/**
 *  
 * @param player take in the player
 * @return the position of that player
 */
    public int getPlayerPosition(int player) {
        return players[player];
    }

    @Override
    public String toString() {
        String s1 = "";// making a new string
        for (int i = 0; i < board.length; i++) 
        {
            s1 += "|" + board[i].toString();//obtain the string from inherit
            if ((i + 1) % 10 == 0) // makes a new line for 10 multiple
            {
                s1 += "\n";
            }
        }
        return s1;
    }

    public String toStringCurrentPositions() {
        String s2 = "";
        for (int i = 0; i < players.length; i += 1) //get the players position
        {
            s2 += i + ":" + players[i];
            s2 += " ";
        }
        return s2;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        SnakesAndLadders snakesandladdersgameboard = new SnakesAndLadders();
        System.out.println(snakesandladdersgameboard.toString());
        System.out.println(snakesandladdersgameboard.toStringCurrentPositions());
        boolean twoturn;

        int winner = 0;
        while (winner == 0) {
            for (int i = 0; i < 2; i++) {
                twoturn = snakesandladdersgameboard.takeTurn(i);
                if (twoturn == true) {
                    snakesandladdersgameboard.takeTurn(i);
                }
                System.out.println(snakesandladdersgameboard.toStringCurrentPositions());
                if (snakesandladdersgameboard.isPlayerWinner(i)) {
                    winner = 1;
                    break;

                }
            }

        }
        System.out.println("Player " + snakesandladdersgameboard.getWinner() + " wins");

    }

}
