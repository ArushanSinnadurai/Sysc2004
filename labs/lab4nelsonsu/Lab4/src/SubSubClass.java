public class SubSubClass extends SubClass{
    private int c;

    public SubSubClass(int a, int b, int c){
        super(a,b);
        this.c = c;
    }

    public int getC() {
        return this.c;
    }

    @Override
    public int getA(){
        return super.getA()*c;
    }

    @Override
    public int getB(){
        return super.getB()*c;
    }

    @Override
    public String toString() {
        return super.toString() + " c = " +this.c;
    }
}
