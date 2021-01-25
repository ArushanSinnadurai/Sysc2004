/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;
import java.util.Scanner;

/**
 *
 * @author Arushan Sinnadurai
 * SN:101039300
 */
public class TicTacToe 
{
  private int nRows ; 
  private int nColumns ;
  private int numToWin;
  private char grid[][];
  private char turn;
  private TicTacToeEnum gameState;
  private int nMark;
  
  /**
   * this method is constructor that initial the value for nRows, nColumns,nMark, turn 
   * @param initalTurn 
   */
  public  TicTacToe(char initialTurn)
  {
     this(3,3,3, initialTurn);
  }
  /**
   * this constructor initial the nRows, nColumns, numToWin and also create an 2-D array for nRows and nColumns
   * @param nRows
   * @param nColumns
   * @param numToWin
   * @param initialTurn 
   */
  public  TicTacToe(int nRows, int nColumns, int numToWin, char initialTurn)
  {
        if (nRows < 0 || nColumns < 0)
        {
            throw new IllegalArgumentException("The Grid should greater then 0");
        }
        if (numToWin > nRows || numToWin > nColumns) 
        {
            throw new IllegalArgumentException("The dimensions should be greater size need to win ");
        }
        
        this.nRows = nRows;
        this.nColumns = nColumns;
        this.numToWin = numToWin;
        this.grid = new char[nRows][nColumns];
        
        reset(initialTurn);
      
  }
  /**
   * This reset the game by setting 0 and clearing the game board
   * @param initialTurn 
   */
  public void reset(char initialTurn)
  {
         for (int nr=0;nr<nRows; nr++) {
            for (int nc=0; nc<nColumns; nc++) {
                this.grid[nr][nc] = ' ';
            }
        }      
        this.nMark = 0;
        this.gameState = TicTacToeEnum.IN_PROGRESS;
        this.turn = initialTurn;
  }
  /**
   * this method return the current turn 
   * @return turn
   */
  public int getTurn()
  {
      return this.turn;
  }
  /**
   * This return the current game state
   * @return gameState
   */
  public TicTacToeEnum getGameState()
   {
      return this.gameState;
    }
  /**
   * Check the input of the user and also call upon TicTacToeEnum
   * @param player
   * @return X_WON, O_WON
   */
  private TicTacToeEnum charToEnum(char player)
  {
     if (player == 'X') {return TicTacToeEnum.X_WON;}
        if (player == 'O') {return TicTacToeEnum.O_WON;}
        throw new IllegalArgumentException("charToEnum("+player+"): Invaild input: Please enter either X or O");
    } 
  
  
  /**
   *  This method check for proper input(x’ or ‘o’)  and call on the findWinner 
   * @param row
   * @param column
   * @return gameState
   */
  public TicTacToeEnum takeTurn(int row,int column )
  {
      if (column < 0 || column > this.nColumns) {
          throw new IllegalArgumentException("The game board is " + this.nRows + " by " + this.nColumns);  //Return  error if the column is greater or lesser the game board 
      }
      if (row < 0 || row > this.nRows) {
          throw new IllegalArgumentException("The game board is " + this.nRows + " by " + this.nColumns); //Return  error if the rows is greater or lesser the game board 
      }
      if (this.gameState != TicTacToeEnum.IN_PROGRESS) {
          throw new IllegalArgumentException("The Game Over-- No More Plays");
      }
      if (this.grid[row][column] != ' ') {
          throw new IllegalArgumentException("A player has selected this posistion ");
      }
      this.grid[row][column] = this.turn;
      this.nMark++;

      this.gameState = findWinner();
      if (this.turn == 'X') {
          this.turn = 'O';
      } else {
          this.turn = 'X';
      }
        
       
        return this.gameState;
  }
  /**
   * This method check to if the condition are meet to win by checking the horizontally  and  vertically 
   * @return gameState, IN_PROGRESS
   */
  private TicTacToeEnum findWinner()
  {// horizontal check left and right
       int counter =0;
       for(int a = 0; a<nRows;a++)
       {
           for(int b =0; b < nColumns;b++ )
           {
               if((this.grid[a][b]== this.turn) &&(b + numToWin <= nColumns))
               {
                   counter=0;
                   for(int c=0; c< numToWin; c++)
                   {
                       if(this.grid[a][b + c]== this.turn)
                       {
                           counter++;
                       }
                   }
                   if(counter == this.numToWin)
                   {
                       this.gameState = charToEnum(this.turn);
                       return this.gameState;
                   }
               }
           }
       }
       // vertical check to up and down
       for(int a = 0;a<nRows;a++)
       {
           for(int b =0; b < nColumns;b++ )
           {
               if((this.grid[a][b]== this.turn) &&(a + numToWin <= nRows))
               {
                   counter=0;
                   for(int c=0; c< numToWin; c++)
                   {
                       if(this.grid[a+c][b]== this.turn)
                       {
                           counter++; 
                       }
                   }
                   if(counter == this.numToWin)
                    {
                         this.gameState = charToEnum(this.turn);
                       return this.gameState;
                    }
               }
           }
       }
       
       return TicTacToeEnum.IN_PROGRESS;
  }
  
  /**
   * create string used to create the game board
   * @return Sl
   */
  @Override
   public String toString() {
        String sl = "";
        for (int nR=0; nR < nRows; nR++ ) {
            for (int nC=0; nC < nColumns; nC++) {
                sl += grid[nR][nC] + " | ";
            }
            sl += "\n";
        }
        return sl;
    }
    


    /**
     * The main class the call on the methods
     * @param args the command line arguments
     */
  public static void main(String args[]) {
        TicTacToe game = new TicTacToe('X');
        Scanner scanner = new Scanner(System.in);

        do { 
            System.out.println(game.toString());
            System.out.println(game.getTurn() + ": Where do you want to mark? Enter row column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            scanner.nextLine();
            game.takeTurn(row, column);
            
        } while (game.getGameState() == TicTacToeEnum.IN_PROGRESS);
        System.out.println( game.getGameState());
       
    }
}