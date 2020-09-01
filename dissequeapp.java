package com.company;

import java.util.Arrays;

public class dissequeapp {
    public static void main(String[] args) {

        String s="abc";
        int result=0;
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int count[]=new int[26];
        for(int i=0;i<n;i++)
        {
            int index=s.charAt(i)-'a';
            dp[i]+=result-count[index];
            result+=dp[i];
            count[index]+=dp[i];
        }
        System.out.print(result);
    }
}
