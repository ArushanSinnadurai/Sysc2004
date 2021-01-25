/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Schramm
 */
public class SubClass extends MyClass {
    
    private int b;
    private Integer bWrapper;
    
    public SubClass(int a, int b, String str, Integer integer) {
        super(a, str);
        this.b = b;
        this.bWrapper = integer;
    }
    
    public int getA() { return super.getA() * 2; }
    public int getB() { return this.b; };
    
    public String toString() { return super.toString() + " / b = " + this.b + " " + bWrapper.toString(); }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        SubClass obj = (SubClass)o;
        return super.equals(obj) && this.b == obj.b && this.bWrapper.equals(obj.bWrapper);
        
    }
}
 