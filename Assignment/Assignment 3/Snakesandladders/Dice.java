/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.Random;
/**
 *
 * @author Arushan Sinnadurai
 * SN:101039300
 */
public class Dice extends SnakesAndLadders
{
    private int die [];
   
    private Random random;
   /**
    * //The default constructor will construct a default pair of die 
    */ 
  public Dice()
  {
        die = new int [2];
         random = new Random();
        //roll();
  }
  /**
   * This constructor allow for any size for the constructor
   * 
   */
  public Dice(int numDice)
  {
      if (numDice < 1)
 
       throw new IllegalArgumentException ("The value for the number of dice needs to be greater then 1");
        
        this.random = new Random(new Date().hashCode());
      this.die = new int [numDice];
      roll();
  }
  /**
   *  This method roll all of the dice at once, returning their total value.
   * This method as call on the rollDice to random the value between 1-6
   * @return totalroll
   */
  public int roll()  
  {
      int totalroll=0;
      for(int i =0;i<die.length; i++)
      {
        die[i] = rollDice();
        totalroll = die[i] + totalroll;
      }
      return totalroll;
      
  }
  
  
/**
 * Create a random between 1 to 6
 * @return the random value
 */
private int rollDice()// and ensures that this rolled value is between 1 and 6, inclusive
{
        return random.nextInt(6) + 1; 
}
  
 /**
  * This method copy the array of dice in a new array
  * @return die_value
  */ 
public int[] getDieValues()
{
       int die_value[] = new int [die.length];
       for(int i = 0; i<die.length; i++)
       {
           die_value[i]= die[i];
       }
        return die_value;
 }
     /**
      * this method check if there is any number that appear twice
      * @return true when there is a value that appear twice
      */
    public boolean hasDoubles()//(2) hasDoubles() returns true if there are any double-values amongst the die-values. 
    {
         for(int i =0; i < die.length; i++)
         {
             for(int j = i+1; i<die.length;i++)
             {
                 if(die[i]== die[j])
                 return true;
             }
         }
         return false;
    }
    /**
     *  This method create a string that print all the value with a space in bewteen
     * @return s1
     */
   @Override
     public String toString() //this method is as follows: a space-separated list of all the individual die-values
  { 
       String s1 = (String.valueOf(die[0]) + " " );
       
     for(int i =1; i< die.length; i++)
     {
         s1+=  (String.valueOf(die[i])  + " ");
     }
    return s1;
    
}
}