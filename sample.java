public class sample {
    public static void main(String args[])

    {

        A obj = new A();

        obj.cal(2, 3);

        System.out.println(obj.x + " " + obj.y);

    }
}
class A{

    public int x;

    protected int y;

    void cal(int a, int b){

        x =  a + 1;

        y =  b;

    }

}

