import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Scanner;

public class paritybasedadd {
    /*
    when given number,and number of positive numbers to make up the given sum..only even-odd numbers not both sum.
    example:
   10 3
   yes
   4 2 4
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        if((n&1)!=0&&((k&1)^1)!=0)
        {
            System.out.println("No");
            System.exit(0);
        }
        if(((n&1)^1)!=0&&(k&1)!=0)
        {
            if (n < 2 * k) {
                System.out.println("No");
                System.exit(0);
            }
            System.out.println("Yes");
            for (int i = 1; i < k; i++) {
                System.out.print("2 ");
            }
            System.out.print(n - 2 * (k - 1));
        }
        else {
            if(n<k)
            {
                System.out.println("No");
                System.exit(0);
            }
            System.out.println("Yes");
            for(int i=1;i<k;i++)
            {
                System.out.print("1 ");
            }
            System.out.println(n-(k-1));
        }
    }
}
