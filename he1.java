package com.company;

import java.util.Scanner;

public class he1 {

    public static void main(String[] args) {
        int count=0;
        Scanner sc=new Scanner(System.in);
        long l=sc.nextInt();
        long r=sc.nextInt();
        for (long i = l; i <= r; i++) {
            long k = Long.bitCount(i);
            String s = Long.toBinaryString(i);
            long p = s.length();

            if((p-k)==1)
            {
                count++;
            }
        }
        System.out.print(count);
    }
}
