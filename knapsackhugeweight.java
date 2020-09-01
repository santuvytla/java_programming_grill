import java.util.Scanner;

public class knapsackhugeweight {
    /*
    when weights are huge..dp will not work for every weight
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int maxweight=sc.nextInt();
        int weight[]=new int[n];
        int value[]=new int[n];
        for(int i=0;i<n;i++)
        {
            weight[i]=sc.nextInt();
            value[i]=sc.nextInt();
        }
        int sum_value=0;
        for(int i:value)
        {
            sum_value+=i;
        }
        int dp[]=new int[sum_value+1]; //min total weight with total value exactly i
        for(int i=0;i<sum_value+1;i++)
        {
            dp[i]=10000000;
        }
        dp[0]=0;
        for(int k=0;k<n;k++)
        {
            for(int value_already=sum_value-value[k];value_already>=0;value_already--)
            {
                dp[value_already+value[k]]=Math.min(dp[value_already+value[k]],dp[value_already]+weight[k]);
            }
        }
        int ans=0;
        for(int i=0;i<=sum_value;i++)
        {
            if(dp[i]<=maxweight)
            {
                ans=Math.max(ans,i);
            }
        }
        System.out.println(ans);
    }
}
