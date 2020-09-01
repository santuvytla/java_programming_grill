import java.util.Scanner;

public class shortestarray {
    /*
    given 2 integers u and v,find the shortest array such that bitwise-xor of its elements is u, and the sum of its elements is v.
    a+b=a^b+2(a&b)
    u=a^b;v=a+b;(given);
    v=u+2(a&b);
    (v-u)/2=a&b;

     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        if(a<0&&b<0)
        {
            System.out.println(0);
            System.exit(0);
        }
        if(a==b)
        {
            System.out.println(1);
            System.out.println(a);
        }
        if((a&1^b&1)!=0||a>b)
        {
            System.out.println(-1);
            System.exit(0);
        }
        int ana=(b-a)/2;
        int c=a+ana;
        int d=ana;
        if((c^d)==a) {
            System.out.println(2);
            System.out.println(c + " " + d);
            System.exit(0);
        }
        System.out.println(3);
        System.out.println((b-a)/2+" "+(b-a)/2+" "+a);

    }
    }
