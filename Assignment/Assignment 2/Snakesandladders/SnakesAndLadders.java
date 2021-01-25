/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

import java.util.Scanner;

/**
 *
 * @author arush
 */
public class SnakesAndLadders {

    public static final int NUM_PLAYERS=2;
    public static final int NUM_SQUARES= 100;
    private SnLSquare board[];
    private int players [];
    private Dice dice;
    
    public SnakesAndLadders()
    {
       //player = new int [NUM_PLAYERS];
       //board = new SnLSquare [NUM_SQUARES];
       //dice = new Dice();
        this(2);
    
    }
    public SnakesAndLadders(int nplayers)
    {
        if (nplayers < 0) {
            throw new IllegalArgumentException("Please enter a Valid Number of Players");
        }
        players = new int [nplayers]; 
        board = new SnLSquare [NUM_SQUARES]; 
        dice = new Dice();
        
        for(int i=0; i<board.length; i++)
        {
             board[i] = new SnLSquare(i+1);
        }
        for(int j =0; j <players.length;j++)
        {
         players[j]=1;
         
        }
         for(int i =0;i<board.length; i++)
        {
       
           if(board[i]==board[3])
           {
               board[3]= new LadderSquare(4,14);
           }
           if(board[i]==board[8])
           {
               board[8]= new LadderSquare(9,31);
           }
           if(board[i]==board[19])
           {
               board[19]= new LadderSquare(20,38);
           }
           if(board[i]==board[27])
           {
               board[27]= new LadderSquare(28,84);
           }
           if(board[i]==board[39])
           {
               board[39]= new LadderSquare(40,59);
           }
          if(board[i]==board[62])
           {
               board[62]= new LadderSquare(63,81);
           } 
          if(board[i]==board[70])
           {
               board[70]= new LadderSquare(71,91);
           }
         if(board[i]==board[16])
           {
               board[16]= new SnakeSquare(17,7);
           }
         if(board[i]==board[53])
           {
               board[53]= new SnakeSquare(54,34);
           }
         if(board[i]==board[61])
           {
               board[61]= new SnakeSquare(62,18);
           }
         if(board[i]==board[63])
           {
               board[63]= new SnakeSquare(64,60);
           }
         if(board[i]==board[86])
           {
               board[86]= new SnakeSquare(87,24);
           }
         if(board[i]==board[92])
           {
               board[92]= new SnakeSquare(93,73);
           }
         if(board[i]==board[94])
           {
               board[94]= new SnakeSquare(95,75);
           }
         if(board[i]==board[98])
           {
               board[98]= new SnakeSquare(99,78);
           }
        }
    }
    
    public boolean takeTurn(int player)
    {
        int temp=0;
        int leftover=0;
        int holdvalue = 0;
 
        temp = dice.roll();
        this.players[player] = this.players[player] + temp;
        
        if(players[player]>NUM_SQUARES)
          {
             holdvalue = players[player];
             leftover= holdvalue - NUM_SQUARES;
             players[player] = NUM_SQUARES - leftover; 
          }
        players[player]= board[(players[player]-1)].landOn();
        
        if(dice.hasDoubles())
        {
            return true;
        }
        
        return false;
    }
    
    
    public boolean isPlayerWinner(int player)
    {
        if(players[player]==100)
         {
             return true;
         }
           return false; 
        
    }
    public int getWinner()
    {
        for(int i = 0; i<players.length; i++)
        {
            if(players[i]==NUM_SQUARES)
                return i;
        }
        return -1;
    }
    
    public int getPlayerPosition(int player)
    {
        return players[player];
    }        
        
    @Override
    public String toString()
    {
        String s1 = "";
        for(int i = 0; i < this.board.length; i++)
        {
             s1 += "|" + this.board[i].toString();
            if ((i+1) % 10 == 0) {
                s1 += "\n";
            }
        }
        return s1;
    }
    public String toStringCurrentPositions()
    {
        String s2="";
        for(int i = 0; i<players.length;i++)
        {
            s2+= i + ":" + getPlayerPosition(players[i]);
            s2 += s2 + " ";
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
        int win = 0;

        while (win == 0) {
            for (int i = 0; i < 2; i++) {
                twoturn = snakesandladdersgameboard.takeTurn(i);
                if (twoturn) {
                   snakesandladdersgameboard.takeTurn(i);
                }
                System.out.println(snakesandladdersgameboard.toStringCurrentPositions());
                if (snakesandladdersgameboard.isPlayerWinner(i)) {
                    win = 1;
                    break;

                }
            }
            
        }
        System.out.print("The winner is player ");
        System.out.println(snakesandladdersgameboard.getWinner());

    }
    
}
