<<<<<<< HEAD
import java.util.Scanner;

public class mcandies1 {
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
=======
package com.company;

public class mcandies {
    /*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     */
    public static void main(String[] args) {
        String s="121";
        int k=numdecode(s);
        System.out.println(k);
    }

    private static int numdecode(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int dp[] = new int[s.length() + 1];
        return numDecodings_(s , 0 , dp);
    }

    private static int numDecodings_(String s, int idx, int[] dp) {
        for (idx = s.length(); idx >= 0; idx--) {
            if (idx == s.length()) {
                dp[idx] = 1;
                continue;
            }
            int count = 0;
            count += s.charAt(idx)=='0'?0:dp[idx + 1];
            if(idx < s.length()-1){
                String str = s.substring(idx , idx+2);
                if(Integer.parseInt(str) <= 26 && str.charAt(0)!='0'){
                    count += dp[idx+2];
                }
            }
            dp[idx] = count;
        }
        return dp[0];
>>>>>>> 05653a978ece795f54bbd7ff0cebe589d97e8145
    }
}
