/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Schramm
 */
public class MyClass {
    
    private int a;
    private String aString;
    
    public MyClass(int a, String str) {
        this.a = a;
        this.aString = str; 
    }
    
    public int getA() { return a; }
    
    public String toString() { return "a = " + a + " " + aString; }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        MyClass obj = (MyClass)o;
        return this.a == obj.a && this.aString.equals(obj.aString);
        
    }
    
}
