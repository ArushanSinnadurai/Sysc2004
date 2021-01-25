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
public class SnLSquare extends SnakesAndLadders {
    
    private int number;
    
    public SnLSquare(int number)
    {
       this.number=number;
    }
    
    public int getNumber()
    {
        return this.number;
    }
    public int landOn()
    {
        return this.number;
    }
    
    public String toString()
    {
        return ""+this.number;
    }
    
  
    @Override
    public boolean equals(Object o) 
    {
        if (o == this) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        SnLSquare r = (SnLSquare)o;
        
        return this.number == r.number;
    }
}
