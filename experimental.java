package com.company;

import java.util.*;

public class experimental {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuilder ss=new StringBuilder();
        ss.append(s);
        String arr[]=new String[10];
        String s1=ss.reverse().toString();
        if(s.contentEquals(s1))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
        char sss2[]=s.toCharArray();
        List<Character> sss=new LinkedList<Character>();
        for(char c:sss2)
        {
            sss.add(c);
        }
        String sss1="";
        Collections.reverse(sss);
        for(char e:sss)
        {
            sss1+=e;
        }
        if(s.contentEquals(sss1))
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

    }
}
