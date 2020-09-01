package com.company;

import java.sql.Array;
import java.util.Arrays;

public class distinsubseq {
    public static void main(String[] args) {

        String s="abc";
        int result=0;
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(s.charAt(j)!=s.charAt(i))
                {
                    dp[i]+=dp[j];
                }
            }
            result+=dp[i];
        }
        System.out.print(result);
    }
}
