import java.util.Scanner;

public class sas {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a,b;
        int t=n;
        while(t!=0)
        {
             a=sc.nextInt();
            b=sc.nextInt();
            String s=((a+b)%3==0)&&2*a>=b&&2*b>=a?"yes":"no";

            System.out.println(s);

            t--;
        }
    }
}
