package com.company;

public class candies {
    public static void main(String[] args) {
        int n=5;
        int k=2;
        int m=2;
        int ans=mincandiways(n,k,m);

                System.out.println(ans);
    }

    private static int mincandiways(int n, int k, int m) {
        int dp[][]=new int[n-k+1][m+1];

        for(int i=0;i<=m;i++)
            dp[0][i]=1;
        for(int j=1;j<=n-k;j++)
            dp[j][0]=dp[j-1][0]+1;

/*
2days
min=2 max=5
1+1+1+1--4ways(1day)
2 2
3 2
4 2
5 2
3 3
4 3
4 4
5 5
5 4
5 3-- 2days (10ways)
        for(int i=0;i<=n-k;i++) {


            for (int j = 0; j <= m; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }

 */
        for(int i=2;i<=n-k;i++)
        {

            for(int j=1;j<=m;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[n-k][m];
    }
}
