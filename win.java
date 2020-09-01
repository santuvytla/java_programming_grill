import java.util.Scanner;

public class win {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int dp[][]=new int[n+1][n+1];
       for(int i=0;i<=n;i++)
       {
           for(int j=0;j<=n;j++)
           {
               dp[i][j]=-1;
           }
       }
       int l=0,y=1;
       int r=n-1;
       int sum=0;
       int ans=solve(l,r,dp,arr,y);
       System.out.println(ans);
    }

    private static int solve(int l, int r, int[][] dp, int[] arr,int y) {
        if(l>=arr.length||r<0) {
            return 0;
        }
        if(l==r)
        {
            return y*arr[l];
        }
        if(dp[l][r]!=-1)
        {
            return dp[l][r];
        }
     int left=arr[l]*y+solve(l+1,r,dp,arr,y+1);
        int right =arr[r]*y+solve(l,r-1,dp,arr,y+1);
             return dp[l][r]=Math.max(left,right);
    }
}
