import java.util.Scanner;

public class vacation {
    /*
    Problem Statement
Taro's summer vacation starts tomorrow, and he has decided to make plans for it now.

The vacation consists of
N
 days. For each
i
 (
1
≤
i
≤
N
), Taro will choose one of the following activities and do it on the
i
-th day:

A: Swim in the sea. Gain
a
i
 points of happiness.
B: Catch bugs in the mountains. Gain
b
i
 points of happiness.
C: Do homework at home. Gain
c
i
 points of happiness.
As Taro gets bored easily, he cannot do the same activities for two or more consecutive days.

Find the maximum possible total points of happiness that Taro gains.

Constraints
All values in input are integers.
1
≤
N
≤
10
5
1
≤
a
i
,
b
i
,
c
i
≤
10
4
Input
Input is given from Standard Input in the following format:

N

a
1

b
1

c
1

a
2

b
2

c
2

:

a
N

b
N

c
N

Output
Print the maximum possible total points of happiness that Taro gains.

Sample Input 1
Copy
3
10 40 70
20 50 80
30 60 90
Sample Output 1
Copy
210
If Taro does activities in the order C, B, C, he will gain
70
+
50
+
90
=
210
 points of happiness.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int dp[]=new int[3]; //such that we did activity i on the last  considered day
        for(int k=0;k<n;k++)
        {

            int newdp[]=new int[3];
            int c[]=new int[3];
            for(int i=0;i<3;i++)
            {
                c[i]=sc.nextInt();
            }
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    if(i!=j)
                    {
                       newdp[j]=Math.max(newdp[j],dp[i]+c[j]);
                    }
                }
            }
            dp=newdp.clone();

        }
        for(int i=0;i<3;i++)
        {
            System.out.print(dp[i]+" ");
        }
        int ans=Math.max(dp[0],dp[1]);
        ans=Math.max(dp[2],ans);
        System.out.println(ans);
    }
}
