/**
 *
 * @title Lab 3 - Objective 3
 */
 
import java.util.Random;
 
public class Lab1 {
    
    public static int NUM_RECTANGLES = 10;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Rectangle r1 = new Rectangle(10,20);
        
        System.out.println("Rectangle r1 ("+r1.getLength()+","+r1.getWidth()+")");
        System.out.println("\tArea = " + r1.area());
          // Notice the use of the tab character \t
          
        // Task 1 : On the next line, print out the perimeter, similarly tabbed
        System.out.println("\tParameter =" + r1.perimeter());
        
        // Task 2: Create a second rectangle called r2 with length = 20, width=10.
        Rectangle r2 = new Rectangle(20,10);
        System.out.println("Rectangle r2 ("+r2.getLength()+","+r2.getWidth()+")");
        System.out.println("\tArea = " + r2.area());
                
        
        //  DO NOT CHANGE THE FOLLOWING CODE
        
        Rectangle rectangles[] = new Rectangle[NUM_RECTANGLES];
        Random randomGenerator = new Random();
        int width, length;
        for (int i=0; i< rectangles.length; i++)
        {
            width = randomGenerator.nextInt(49) + 1;
            length = randomGenerator.nextInt(49) + 1;
            rectangles[i] = new Rectangle(length, width);
        }
        
        // Task 3 : Print out all randomly generated rectangles, one per line.
        //   Each line should print EXACTLY: r[i] = (w,l)
        for(int j=0;j< rectangles.length; j++ )
        {
            System.out.println("Rectangle rI ("+rectangles[j].getLength() +","+ rectangles[j].getWidth()+")");
            System.out.println("area ("+rectangles[j].area()+ ")");
        }
        
        // Task 4 : Search and print out the information for the rectangle with
        //   the largest area
        
        int lar=rectangles[0].area();
      
        
        for(int k=1;k< rectangles.length; k++ )
        {
                 
            if  (rectangles[k].area() > lar)
            {
                lar = rectangles[k].area();
            }
        }
        System.out.println("The largest area is " + lar);
        
        // Task 5 : Search and print out the information for the rectangle with
        //   the shortest perimeter
        
        int smallest = rectangles[0].area();
        for(int k=1;k< rectangles.length; k++ )
        {
                 
            if  (rectangles[k].area() < smallest)
            {
                smallest = rectangles[k].area();
            }
        }
       
        System.out.println("The smallest area is " + smallest);
        
        
        Random myRandomGenerator = new Random();
        int x [] = new int [2000];
        System.out.print(x.length);
        for(int s=0; s<x.length;s++)
        {
            x[s] =myRandomGenerator.nextInt(26) + 65;
        }
        System.out.println("4");
        System.out.print("");
        int max = x[0];
        int min = x[0];
        
        for(int i=0;i< rectangles.length; i++ )
        {
                 
            if  (x[i] > max)
            {
                max = x[i];
            
            }
        }
            System.out.println("The maxium value is " + max);
            
        for(int c=0;c< rectangles.length; c++ )
        {
                 
            if  (x[c] < min)
            {
                min = x[c];
            
            }
        }
            System.out.println("The maxium value is " + min);
            
    }
    
}
 