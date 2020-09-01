import java.util.Scanner;

public class mcandies {
    /*
    There are
N
 children, numbered
1
,
2
,
…
,
N
.

They have decided to share
K
 candies among themselves. Here, for each
i
 (
1
≤
i
≤
N
), Child
i
 must receive between
0
 and
a
i
 candies (inclusive). Also, no candies should be left over.

Find the number of ways for them to share candies, modulo
10
9
+
7
. Here, two ways are said to be different when there exists a child who receives a different number of candies.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int dp[]=new int[k+1];
        dp[0]=1; //the number of ways of i candies used dp[i]
        for(int i=0;i<n;i++)
        {
            int upto=sc.nextInt();
            for(int j=k;j>=0;j--) //used candies
            {
                for(int here=1;here<=Math.min(upto,k-j);here++)
                {
                    dp[here+j]+=dp[j];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
