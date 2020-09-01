package com.company;

import java.util.Scanner;

public class sssw {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the letter");
        char s=sc.next().charAt(0);
        System.out.println("Enter the line");
        String ssi=sc.nextLine();
        String ss=sc.nextLine();
        String arr[]=ss.split(" ");
        if(arr.length>2)
        {
            int count=0;
            for(int i=0;i<arr.length;i++) {
                if (arr[i].charAt(0) == s) {
                        count++;
                }
                else
                {
                    System.out.println("No score");
                    System.exit(0);
                }

            }
            if(count==3){
                int score=2;
                System.out.println("Good,You get a score of "+score);
            }
            else if(count>3)
            {
                int s2=(count-3)*2+2;
                System.out.println("Good,You get a score of "+s2);
            }
            else
            {
                System.out.println("No score");
            }
        }
        else
        {
            System.out.println("No score");
        }

    }

}
