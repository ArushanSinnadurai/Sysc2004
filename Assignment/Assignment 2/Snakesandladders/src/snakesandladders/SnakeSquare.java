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
public class SnakeSquare extends SorLSquare
{
    /**
 * 
 * @param number inherit from SnLSquare - the number of the square
 * @param endSquare inherit from SorLSquare - change the position 
 */
    public SnakeSquare(int number,int endSquare)
    {
        super(number,endSquare);
        if(endSquare> number)
        {
            throw new IllegalArgumentException ("The value end square is greater than to your current square" );
        }
    }
     /**
     * get the value from the SorLSquare - purpose is to change current positions 
     * @return the value of the position where the player will end up
     */
    @Override
    public int landOn()
    {
        return super.getEndSquare();
    }
    
    @Override
    public String toString()
    {
        return super.getNumber() +"-"+ super.getEndSquare();
    }
   
}
