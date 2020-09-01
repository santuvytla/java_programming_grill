package com.company;

import java.util.Scanner;

public class d2d {

    public static int digital_root(int n) {
     //   while(n > 9){
       //     n = n/10 + n % 10;
      //  }
        int sum=0;
        int p;
        while(n!=0)
        {
            p=n%10;
            sum+=p;
            n=n/10;


        }
        return(sum);
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int s=sc.nextInt();
        System.out.println(digital_root(s));
    }


}
