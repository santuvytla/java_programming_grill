<<<<<<< HEAD
=======
package com.company;

>>>>>>> 05653a978ece795f54bbd7ff0cebe589d97e8145
import java.util.Scanner;

public class sass {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a,b;
        int t=n;
        while(t!=0)
        {
<<<<<<< HEAD
             a=sc.nextInt();
            b=sc.nextInt();
            String s=((a+b)%3==0)&&2*a>=b&&2*b>=a?"yes":"no";

=======
            a=sc.nextInt();
            b=sc.nextInt();
            String s="";
            if(((a+b)%3==0)&&(2*a>=b)&&(2*b>=a)) {
                s="Yes";
            }
            else {
                s="No";
            }
>>>>>>> 05653a978ece795f54bbd7ff0cebe589d97e8145
            System.out.println(s);

            t--;
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 05653a978ece795f54bbd7ff0cebe589d97e8145
