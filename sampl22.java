package com.company;

import java.util.*;

public class sampl22 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str1=in.nextLine();
        System.out.println("Enter the string:");
        String str2=in.nextLine();
        in.close();
        Boolean status=false;

        char arraystr1[]=str1.toLowerCase().toCharArray();
        char arraystr2[]=str2.toLowerCase().toCharArray();
        Set<Character> arr=new HashSet<Character>();
         Set<Character> arr1=new HashSet<Character>();
         for(int i=0;i<arraystr1.length;i++)
         {
             arr.add(arraystr1[i]);
         }
        for(int i=0;i<arraystr2.length;i++)
        {
            arr1.add(arraystr2[i]);
        }

         List<Character> l1=new ArrayList<Character>();
         l1.addAll(arr);
         List<Character> l2=new ArrayList<Character>();
         l2.addAll(arr1);
         Collections.sort(l1);
         Collections.sort(l2);

         status=l1.equals(l2);

         if(status)
             {
                 System.out.println("\nSame");
             }
         else{
                 System.out.println("\nDifferent");
             }

         }
    }











