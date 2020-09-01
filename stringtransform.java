package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class stringtransform {
    public static int n;
    public static String s1,s2;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        PrintWriter w=new PrintWriter(System.out); //aab //bcc
        n=sc.nextInt();
         s1=sc.next();
         s2=sc.next();
        getres();
    }

    private static void getres() {
        int[][] count=new int[20][20];
        for(int i=0;i<n;i++)
        {
            int a=s1.charAt(i)-'a';
            int b=s2.charAt(i)-'a';
            if(a>b)
            {
                System.out.println("-1");
                return;
            }
            count[a][b]++;
        }
        int res=0;
        for(int i=0;i<20;i++) {
            int j = i + 1;
            while (j < 20) {
                if (count[i][j] > 0) {
                    res++;
                    break;
                }
                j++;
            }
            int col = j;
            while(j<20)
            {
                count[col][j]+=count[i][j++];
            }
        }
        System.out.println(res);

    }
}
