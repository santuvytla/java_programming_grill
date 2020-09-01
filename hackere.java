package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class hackere {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        TreeSet<Integer> s1=new TreeSet<Integer>();
      //  TreeSet<Integer> s2=new TreeSet<Integer>(new The_Comparator());
        ArrayList<Integer> ss=new ArrayList<>();
        int k = sc.nextInt();
        while (k-- > 0) {
            int t=sc.nextInt();
            switch (t)
            {
                case 1: int x=sc.nextInt();
                        ss.add(x);
                        s1.add(x);
                    //    s2.add(x);
                        break;

                case 2: int d=sc.nextInt();
                            d--;
                        int p=ss.get(d);
                        ss.remove(d);
                        s1.remove(p);
                   //     s2.remove(p);
                        break;
                case 3: int i=sc.nextInt();//-3,4,
                        int size=s1.size();
                        boolean ans=((i-s1.first())>=(s1.last()-i));
                    if(ans)
                    {
                        System.out.println(i-s1.first());
                    }
                    else{
                        System.out.println(s1.last()-i);
                    }
                    break;
            }
        }
    }
}
/*
class The_Comparator implements Comparator<Integer> {
    public int compare(Integer str1, Integer str2)
    {
        Integer first_Str;
        Integer second_Str;
        first_Str = str1;
        second_Str = str2;
        return second_Str.compareTo(first_Str);
    }
}

 */
