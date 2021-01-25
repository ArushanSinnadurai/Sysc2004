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
public class SnakeSquare extends SorLSquare
{
    public SnakeSquare(int number,int endSquare)
    {
        super(number,endSquare);
        if(endSquare> number)
        {
            throw new IllegalArgumentException ("The value end square is greater than to your current square" );
        }
    }
    
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
