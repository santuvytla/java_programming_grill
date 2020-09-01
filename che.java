package com.company;

import java.util.Scanner;

class che {
    public static int solve(int n) {
        int notes = 0;
        for (int bill : new int[] {500, 200, 100, 50, 20, 10}) {
            notes += n / bill;
            n %= bill;
        }
        return n == 0 ? notes : -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=solve(a);

        System.out.println(b);

    }
}