package com.company;

import java.util.Scanner;
import java.util.Stack;

public class stack {
    public static void reverse(String s)
    {
        Stack<Character> ss=new Stack<Character>();

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) != ' ') {
                ss.push(s.charAt(i));
            }
            else
            {
                while(ss.empty()==false)
                {
                    System.out.print(ss.pop());
                }
                System.out.print(" ");
            }



        }

        while(ss.empty()==false)
        {
            System.out.print(ss.pop());
        }


        }








    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        reverse(ss);
    }
}
