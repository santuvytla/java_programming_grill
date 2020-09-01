package com.company;

import java.util.*;

public class ff {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Students:");
        int a=sc.nextInt();
        String s[]=new String[a];
        for(int i=0;i<s.length;i++)
        {
            s[i]=sc.next();
        }

        Set<String> ss=new HashSet<String>();
        for(int i=0;i<s.length;i++){
            ss.add(s[i]);
        }
        List<String> sss=new ArrayList<String>(ss);
        Collections.sort(sss);

        for(String i:sss){
            System.out.println(i);
        }
        /* Alternative way to display
        Iterator<String> ll=sss.iterator();
        while (ll.hasNext())
        {
            System.out.println(ll.next());
        }
        */
    }
}
