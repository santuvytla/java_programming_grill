import java.util.Scanner;

public class tossingcoins {
    /*
    tossing n coins with each having heads probability given to be pi and tails to be 1-pi..find probability of having more heads over tails
input:
3
0.30 0.60 0.80
output:
0.612
     */
    public static void main(String[] args) {
        //dp[heads][tails] ...wat is more imp is getting heads or tails not the order of which is first.
        //both are not required because always tails=total-heads so dp[heads] is enough
        //dp[i] is prob of having i heads

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double dp[]=new double[n+1];
        dp[0]=1;
        for(int toss=0;toss<n;toss++)
        {
            double ph=sc.nextDouble();
            for(int i=toss+1;i>=0;i--)
            {
                dp[i]=(double)((i==0)?0:dp[i-1]*ph)+dp[i]*(1-ph);
            }
        }
        double ans=0;
        for(int i=0;i<=n;i++)
        {
            int j=n-i;
            if(i>j)
            {
                ans+=dp[i];
            }
        }
        System.out.println(ans);

    }
}
