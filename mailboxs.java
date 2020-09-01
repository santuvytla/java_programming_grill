package com.company;

import java.util.Arrays;

public class mailboxs {
    static int MAX=1000000;
    public static void main(String[] args) {
        int houses[]={1,4,8,10,20};
        int k=3;
        int ans=mailing(houses,k);
        System.out.print(ans);
    }

    private static int mailing(int[] houses, int k) {
        int n=houses.length;
        Arrays.sort(houses);
        int dp[][]=new int[n][k];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return solve(houses,k,0,0,dp);
    }

    private static int solve(int[] houses, int k, int pos, int curk, int[][] dp) {
        if(pos==houses.length)
        {
            if(curk==k)
            {
                return 0;
            }
            return MAX;
        }
        if(curk==k)
        {
            return MAX;
        }
        if(dp[pos][curk]!=-1)
            return dp[pos][curk];
        int answer=MAX;
        for(int i=pos;i<houses.length;i++)
        {
            int median=houses[(i+pos)/2];
            int cost=0;
            for(int j=pos;j<=i;j++)
                cost+=Math.abs(median-houses[j]);
            answer=Math.min(answer,solve(houses,k,i+1,curk+1,dp)+cost);
        }
        dp[pos][curk]=answer;
        return answer;
    }
}
