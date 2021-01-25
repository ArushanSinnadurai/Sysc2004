/*
 * Background Reading:
 *   JavaFX Properties (where I want to go): https://docs.oracle.com/javafx/2/binding/jfxpub-binding.htm
 *   JavaBeans Background lesson: https://docs.oracle.com/javase/tutorial/javabeans/
 *
 * When building GUI applications with JavaFX, you will notice that certain classes in the API already implement properties. 
 * For example, the javafx.scene.shape.Rectangle class contains properties for arcHeight, arcWidth, height, width, x, and y. 
 * For each of these properties there will be corresponding methods that match the conventions previously described. 
 * For example, getArcHeight(), setArcHeight(double), arcHeightProperty(), which together indicate 
 * (to both developers and tools) that the given property exists.
 *
*/
import java.util.HashMap;

/**
 *
 * @author Schramm
 */

public class Lab6c {
    
    public static void main(String args[]) {
        
        Patient p = new Patient(1,"John","Doe");
        
        HashMap <Patient,String> hospital;
        
        hospital = new HashMap<Patient,String>();
        hospital.put( p, "C123");
        
        String room1, room2;
        
        room1 = hospital.get(p);
        
        Patient other = new Patient(1,"John","Doe"); 
        boolean flag = p.equals(other);
        room2 = hospital.get(other);
        System.out.println(p + " is in " + room1);        
        System.out.println(other + " is in " + room2);
        
    }
}
