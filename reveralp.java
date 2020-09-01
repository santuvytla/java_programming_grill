package com.company;

import java.util.*;

public class reveralp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String  s=sc.nextLine();
        char arr[]=s.toCharArray();
        Set<Character> ss=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            ss.add(arr[i]);
        }
        ArrayList<Character> sss=new ArrayList<>();
        sss.addAll(ss);
        Collections.sort(sss, Collections.reverseOrder());
        for(char c:sss)
        {
            System.out.print(c);
        }
    }
}
