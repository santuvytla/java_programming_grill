import java.util.Scanner;

public class qflowers {
    /*
    There are
N
 flowers arranged in a row.
 For each i
 (1≤i≤N), the height and the beauty of the
i-th flower from the left is
h
i
 and
a
i
, respectively. Here,
h
1
,
h
2
,
…
,
h
N
 are all distinct.

Taro is pulling out some flowers so that the following condition is met:

The heights of the remaining flowers are monotonically increasing from left to right.
Find the maximum possible sum of the beauties of the remaining flowers.
input
4
3 1 4 2
10 20 30 40
output:
60
     */
    public static void main(String[] args) {
        //what is important,it is not important which flowers are taken,it is more imp that height of last taken flower(to cmp) and beauty value
        //dp[i]--it max total beauty value so far when the height of last taken is equal to i.
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c[]=new int[n];
        int h[]=new int[n];
        for(int i=0;i<n;i++)
        {
            h[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            c[i]=sc.nextInt();
        }
        int dp[]=new int[n+1];
        for(int flowers=0;flowers<n;flowers++)
        {
            for(int i=0;i<h[flowers];i++)
            {
                dp[h[flowers]]=Math.max(dp[h[flowers]],dp[i]+c[flowers]);
            }
        }
        int ans=0;
        for(int i=0;i<=n;i++)
        {
            ans=Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
