package com.company;

import java.util.HashMap;
import java.util.Map;

public class kperfeectsq {
    static boolean isPerfectSquare(double x)
    {
        double sr = Math.sqrt(x);
        return ((sr - Math.floor(sr)) == 0);
    }
    public static void main(String[] args) {
        int pref=0;
        int arr[]={4, 2, 5};
        int n=arr.length;
        for(int i = 0; i < n; i++) {
            if (isPerfectSquare(arr[i])) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        int req=0;
        int k=2;
        int ans=0;
        Map<Integer,Integer> s=new HashMap<Integer,Integer>();
        s.put(pref,1);
        for(int i=0;i<n;i++)
        {
            pref+=arr[i];
            req=pref-k;
            if(s.containsKey(req)) {
                ans += s.get(req);
            }
            if(s.containsKey(pref))
            {
                int a=s.get(pref);
                s.put(pref,a+1);
            }
            else
            {
                s.put(pref,1);
            }
        }
        System.out.println(ans);
    }
}
