
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
public class SubSubClass extends SubClass {
    
    private int c;
    private URL url;
    
    public SubSubClass(int a, int b, int c, String str, Integer integer, URL url) {
        super(a, b, str, integer);
        this.c = c;
        this.url = url;
    }
    
    public int getA() { return this.c * super.getA(); };
    public int getB() { return this.c * super.getB(); };
    public int getC() { return this.c; };
    
    public String toString() { return super.toString() + " / c = " + this.c + " " + url.toString(); }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        SubSubClass obj = (SubSubClass)o;
        return super.equals(obj) && this.c == obj.c && this.url.equals(obj.url);
        
    }
}
 