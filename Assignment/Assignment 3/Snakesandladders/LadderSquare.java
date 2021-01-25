/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;

/**
 *
 * @author arush
 */
public class LadderSquare extends SorLSquare 
{
    public LadderSquare(int number, int endSquare)
    {
        super(number,endSquare);
        if(endSquare <number )
        {
             throw new IllegalArgumentException ("The value end square is less than to your current square" );
        }
    }

    
    public int landOn()
    {
        return super.getEndSquare();
    }
    @Override
    public String toString()
    {
        return super.getNumber() +"+"+ super.getEndSquare();
       
    }
    
}
