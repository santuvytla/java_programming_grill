import java.util.Scanner;

public class lcs {
    /*
Problem Statement
You are given strings
s
 and
t
. Find one longest string that is a subsequence of both
s
 and
t
.

Notes
A subsequence of a string
x
 is the string obtained by removing zero or more characters from
x
 and concatenating the remaining characters without changing the order.

Constraints
s
 and
t
 are strings consisting of lowercase English letters.
1
≤
|
s
|
,
|
t
|
≤
3000
Input
Input is given from Standard Input in the following format:

s

t

Output
Print one longest string that is a subsequence of both
s
 and
t
. If there are multiple such strings, any of them will be accepted.
     */

    //worked for finding length of max subsequnce but for finding String itself
    public static void main(String[] args) {
        //dp[i][j]=maximum subsequence in both strings so far
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String b=sc.nextLine();
        int dp[][]=new int[a.length()+1][b.length()+1];
        for(int i=0;i<a.length();i++)
        {
            for(int j=0;j<b.length();j++)
            {
                if(a.charAt(i)==b.charAt(j))
                {
                    dp[i+1][j+1]=Math.max(dp[i][j]+1,dp[i+1][j+1]);
                }
                dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]);
                dp[i][j+1]=Math.max(dp[i][j+1],dp[i][j]);
            }
        }
        /*
        for(int i=0;i<a.length();i++)
        {
            for(int j=0;j<b.length();j++)
            {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

         */

        System.out.println(dp[a.length()-1][b.length()-1]+1);
    }


}