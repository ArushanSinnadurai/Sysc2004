public class MyClass {
    private int a;

    public MyClass(int a){
        this.a = a;
    }

    public int getA(){
        return this.a;
    }

    @Override
    public String toString() {
        return "a = " + this.a;
    }
}
