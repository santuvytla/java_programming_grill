import java.util.Scanner;

public class dicesum {
    /*
    You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.



Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation:
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation:
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation:
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation:
You throw one die with 2 faces.  There is no way to get a sum of 3.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int d=sc.nextInt();
        int f=sc.nextInt();
        int t=sc.nextInt();
        int dp[]=new int[t+1];
        dp[0]=1;
        for(int rep=1;rep<=d;rep++)
        {
            int newway[]=new int[t+1];
            for(int i=0;i<=t;i++)
            {
                for(int faces=1;faces<=f;faces++)
                {
                    if(i+faces<=t)
                    {
                        newway[i+faces]+=dp[i];
                    }
                }
            }
            dp=newway.clone();
        }
        System.out.println(dp[t]);
    }
}
