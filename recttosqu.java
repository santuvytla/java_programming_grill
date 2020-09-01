import java.util.Scanner;

public class recttosqu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int dp[][]=new int[1000][1000];
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=p;j++)
            {
                int k=i^j;
                if(k>0)
                {
                    dp[i][j]=Integer.MAX_VALUE;
                    for(int m=1;m<i;m++)
                    {
                        dp[i][j]=Math.min(dp[i][j],dp[m][j]+dp[i-m][j]+1);
                    }
                    for(int m=1;m<j;m++)
                    {
                        dp[i][j]=Math.min(dp[i][j],dp[i][m]+dp[i][j-m]+1);
                    }
                }
            }
        }
        System.out.println(dp[n][p]);
    }
}
