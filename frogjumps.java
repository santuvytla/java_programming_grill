import java.util.Scanner;

public class frogjumps {
    /*
    frog jumps one step ahead or two each associated with a height.find the minimum height.

     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int dp[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        dp[0]=0;
        for(int i=0;i<n;i++)
        {
            for(int j: new int[]{i + 1, i + 2}) // if it can shift k steps from begin we use for loop from i+1 to i+k
            {
                if(j<n)
                {
                    dp[j]=Math.min(dp[j],dp[i]+Math.abs(arr[i]-arr[j]));
                }
            }
        }
        System.out.println(dp[n-1]);
    }
}
