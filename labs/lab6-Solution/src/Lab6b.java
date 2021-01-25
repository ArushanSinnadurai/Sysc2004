

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Schramm
 */

public class Lab6b {
    
    public static void main(String args[]) {
        
        final String grades[] = {"F","D-","D","D+","C-","C","C+","B-","B","B+","A-","A","A+"};
        HashMap<Integer,String> gradebook;
        gradebook = new HashMap<>();
        
        Random random = new Random( new Date().hashCode() );
        
        for (int i=0; i<1000; i++) {
            int number;
            do {
                number = random.nextInt(10000);
            } while ( gradebook.containsKey( number ) );
            int gpa = random.nextInt(12);
            // Technically correct call: Object previous = gradebook.put(number, grades[gpa]);
            gradebook.put(number, grades[gpa]);  
        }
        
        System.out.println("The gradebook has " + gradebook.size() + " students." );
        
        int numStudentsFound = 0;
        int numStudentsTried = 0;
        while (numStudentsFound < 10) {
            int number;
            number = random.nextInt(10000);
            String grade = gradebook.get( number );
            if (grade != null) {
                System.out.println("Student " + number + " has a grade of " + grade);
                numStudentsFound++;
            }
            numStudentsTried++;
        }
        System.out.println(numStudentsTried + " students tried");
               
        Set keys = gradebook.keySet();
        Iterator<Integer> i = keys.iterator();
        while (i.hasNext()) {
            Integer number = i.next();
            String grade = (String) gradebook.get(number);
            System.out.println(number + " = " + grade);
        }
 
       
   
    }
    
}
