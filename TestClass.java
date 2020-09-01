import java.util.*;
class TestClass {
    public static void main(String[] args) {
        int t=0;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        int dp[]=new int[100000];
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<100000;i++)
        {
            for(int j=0;j<=i;j++)
            {
                dp[i]=dp[i-1]+dp[i-2];

            }
        }
        for(int i=0;i<50;i++)
        {
            System.out.println(dp[i]);
        }

    }
}