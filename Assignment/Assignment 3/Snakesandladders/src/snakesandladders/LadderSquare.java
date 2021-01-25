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
public class LadderSquare extends SorLSquare 
{
    /**
     * 
     * @param number inherit from SnLSquare - the number of the square
     * @param endSquare inherit from SorLSquare - change the position 
     */
    public LadderSquare(int number, int endSquare)
    {
        super(number,endSquare);
        if(endSquare <number )
        {
             throw new IllegalArgumentException ("The value end square is less than to your current square" );
        }
    }

    /**
     * get the value from the SorLSquare - purpose is to change current positions 
     * @return the value of the position where the player will end up
     */
    public int landOn()
    {
        return super.getEndSquare();
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString()
    {
        return super.getNumber() +"+"+ super.getEndSquare();
       
    }
    
}
/*
The equals methods is not need for SnakesSquare and LaddersSquared because your comparing two similar object with different functions. 
Since snakes will never equal ladder it not necessary. 
However both snakes and ladder have same input and its inherited by SorLSquare the equals will return true if used but it's not useful.
*/