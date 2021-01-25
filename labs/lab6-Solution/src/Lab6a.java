
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Schramm
 */

public class Lab6a {
    
    public static void main(String args[]) {
        
        try {
            MyClass object = new MyClass(5, "MyClass");
            SubClass subObject = new SubClass(6,7, "SubClass", new Integer(55));
            SubSubClass subSubObject = new SubSubClass (8,9,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));

            System.out.println("object : " + object);
            System.out.println("subObject : " + subObject);
            System.out.println("subSubObject : " + subSubObject);

            System.out.println("object getA() " + object.getA() );
            System.out.println("subObject getA() " + subObject.getA() );
            System.out.println("subSubObject getA() " + subSubObject.getA() );

            // System.out.println("object getB() " + object.getB() );   Can't look "down"
            System.out.println("subObject getB() " + subObject.getB() );
            System.out.println("subSubObject getB() " + subSubObject.getB() );

            // System.out.println("object getB() " + object.getB() );       Can't look "down"
            // System.out.println("subObject getC() " + subObject.getC() ); Can't look "down"
            System.out.println("subSubObject getC() " + subSubObject.getC() );
                     
            MyClass object1 = new MyClass(5, "MyClass");
            SubClass subObject1 = new SubClass(6,7, "SubClass", new Integer(55));
            SubSubClass subSubObject1 = new SubSubClass (8,9,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));
            
            MyClass object2 = new MyClass(9, "MyClass");
            SubClass subObject2 = new SubClass(6,7, "SubClass", new Integer(85));
            SubSubClass subSubObject2 = new SubSubClass (8,0,10, "SubSubClass", new Integer(77), new URL("http://www.google.com"));
            
    
        } catch (MalformedURLException e) { e.printStackTrace(); }
                
        
   
    }
    
}
