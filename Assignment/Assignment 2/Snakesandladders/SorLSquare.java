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
public class SorLSquare extends SnLSquare {
    
    private int endSquare;
    
    public SorLSquare(int number,int endSquare)
    {
        super(number);
        if (endSquare == number)
        {
            throw new IllegalArgumentException ("The value end square is equal to your current square" );
        }
        this.endSquare = endSquare;
    }
    
    public int getEndSquare()
    {
        return this.endSquare;
    }
 
    @Override
    public int landOn()
    {
        return this.endSquare;
    }
    @Override
    public String toString()
    {
        return super.toString()+":"+this.endSquare;
    }
    
    @Override
    public boolean equals(Object o) 
    {
        if (o == this) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false; 
        SorLSquare r = (SorLSquare)o;
        return (super.equals(r))&& (this.endSquare == r.endSquare);
    }
}
