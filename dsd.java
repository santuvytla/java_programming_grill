package com.company;

import java.util.Scanner;

public class dsd {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        int s=sc.nextInt();
        int sss=sc.nextInt();
        for(int i=0;i<10;i++)
        {
            ss=ss.concat(ss);
        }
        if(ss.charAt(s+1)==ss.charAt(sss+1))
        {
            System.out.println("Same");
        }
        else
        {
            System.out.println("Not Same");
        }
    }
}
