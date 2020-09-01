import java.util.Scanner;

public class maximumsquare {
    /*
    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        int ans=0;
        int dp[][]=new int[n+1][m+1];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
                if(arr[i][j]==1) {
                    dp[i][j] = Math.min(dp[i + 1][j + 1], dp[i][j + 1]);
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j]) + 1;
                }
                else{
                    dp[i][j]=0;
                }
                ans=Math.max(dp[i][j]*dp[i][j],ans);
            }
        }
        System.out.println(ans);
    }
}
