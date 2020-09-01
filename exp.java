package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class exp {
    public static void main(String[] args) {

        String s="RRRGBBBBBBBGGGR";
        String a="165315726482934";
        String arr[] =a.split("");
        int arr1[]=new int[arr.length];
        List<Integer> s1=new LinkedList<>();
        List<Integer> s2=new LinkedList<>();
        List<Integer> s3=new LinkedList<>();
        for(int i=0;i<arr.length;i++)
        {
            arr1[i]=Integer.parseInt(arr[i]);
            if(s.charAt(i)=='R')
            {
                s1.add(arr1[i]);
            }
           else if(s.charAt(i)=='B')
            {
                s2.add(arr1[i]);
            }
            else
            {
                s3.add(arr1[i]);
            }
        }
        Collections.sort(s1,Collections.reverseOrder());
        Collections.sort(s2,Collections.reverseOrder());
        Collections.sort(s3,Collections.reverseOrder());
        int l=0,j=0,m=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='R')
            {
                System.out.print(s1.get(l++));
            }
            else if(s.charAt(i)=='B')
            {
                System.out.print(s2.get(j++));
            }
            else
            {
                System.out.print(s3.get(m++));
            }
        }




    }
}
