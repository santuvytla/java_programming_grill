package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class maxnonor {
    public static void main(String[] args) {
        Integer arr[]=new Integer[]{1,1,1,1,1,1};
        int target=2;
        List<Integer> nums=new ArrayList<Integer>(Arrays.asList(arr));
        Set<Integer> s=new HashSet<>();
        s.add(0);
        int ps=0,ans=0;
        for(int a:nums)
        {
            ps+=a;
            if(s.contains(ps-target))
            {
                ans++;
                s.clear();
            }
            s.add(ps);
        }
        System.out.println(ans);
    }
}
