package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class lol {

    static String ReverseWords(String str) {

        StringBuilder input1 = new StringBuilder();
        input1.append(str);
        input1 = input1.reverse();
        String reversed=input1.toString();
        return reversed;

    }

    public static void main(String[] args) {
// TODO Auto-generated method stub
        List<String> ll=new ArrayList<String>();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str=in.nextLine();
        String ss[]=str.split(" ");
        String aar[]=new String[ss.length];
        for(int i=0;i<ss.length;i++) {
          String  reversed=ReverseWords(ss[i]);
          if(reversed.equals(ss[i])&&reversed.length()>1)
          {
              ll.add(ss[i]);
          }
          aar[i]=reversed;

        }
        for(int j=0;j<aar.length;j++)
        {
            System.out.print(aar[j]+" ");

        }
        System.out.println();
      boolean  ans=ll.isEmpty();
        if(ans==true)
        {
            System.out.println("No palindrome");
        }
        else
        {
            ll.forEach((str1) -> System.out.println(str1 + " "));
        }
        in.close();
    }

}

