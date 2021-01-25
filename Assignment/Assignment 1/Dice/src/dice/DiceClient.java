/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

/**
 *
 * @author Arushan Sinnadurai
 * SN:101039300
 */
public class DiceClient {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {
      int count[] = new int[]{0,0,0,0,0,0}; // creating a array to stored the dice values
      int temp[];
      // All the varaible need to code the average and the standard deviation
      double sum=0;
      double sqsum=0;
      double variance=0;
      double variance1=0;
      double mean=0;
      double standarddeviation=0; 
      Dice dice = new Dice();
    
   for(int i =0 ; i < 2000; i++)
   {
        dice.roll();
        temp = dice.getDieValues();
       for( int j= 0; j<2; j++)
       {
           count[temp[j]-1] = count[temp[j]-1]+1; // the value of rolled dice in to proper arrays
       }
      
   }  
   // calculating for average and the standard deviation
     for(int j=0; j<count.length; j++)
   {
      sum += (j+1)*(count[j]) ;
      sqsum = (Math.pow(j+1, 2))* count[j] + sqsum ;
   }
     
     
      mean = sum / 4000;
      variance1 = (sqsum/ 4000);
      variance = variance1 - (mean * mean);
      standarddeviation = Math.sqrt(variance);
      System.out.println("The average roll was " + mean );
      System.out.println("The standard deviation of the rolls was " + standarddeviation);
      System.out.println("The histogram of the rolls is: ");
  
      // all the histogram of rolled values
   for(int j=0; j<count.length; j++)
   {
      System.out.print(j+1 + "(" +count[j] + ") :");
      for(int k =0; k < (count[j]/10);k++)
      {
          System.out.print("*");
      }
      System.out.println();
   }
  
   
    }
}



    



