import java.util.Scanner;

public class dicerollsimul {
    /*
    A die simulator generates a random number from 1 to 6 for each roll. You introduced a constraint to the generator such that it cannot roll the number i more than rollMax[i] (1-indexed) consecutive times.

Given an array of integers rollMax and an integer n, return the number of distinct sequences that can be obtained with exact n rolls.

Two sequences are considered different if at least one element differs from each other. Since the answer may be too large, return it modulo 10^9 + 7.



Example 1:

Input: n = 2, rollMax = [1,1,2,2,2,3]
Output: 34
Explanation: There will be 2 rolls of die, if there are no constraints on the die, there are 6 * 6 = 36 possible combinations. In this case, looking at rollMax array, the numbers 1 and 2 appear at most once consecutively, therefore sequences (1,1) and (2,2) cannot occur, so the final answer is 36-2 = 34.
Example 2:

Input: n = 2, rollMax = [1,1,1,1,1,1]
Output: 30
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        //dp[i][j]--here dp of i prefixed length of each element (each number repeated element with max rep in array or n)..and j is the number that can be
        // the prefix.
        //from 1 to 6
        int n=sc.nextInt();
        int arr[]=new int[6];
        for(int i=0;i<6;i++)
        {
            arr[i]=sc.nextInt();
        }
        int dp[][]=new int[n+1][6];
        for(int a=0;a<6;a++)
        {
            for(int len=1;len<=(Math.min(arr[a],n));len++)
            {
                dp[len][a]++;
            }
        }
        for(int i=1;i<n;i++)
        {
            for(int a=0;a<6;a++) //previous number

            {
             for(int j=0;j<6;j++) //next number
             {
                 if(a==j)
                 {
                     continue;
                 }
                 for(int len=1;len<=arr[j]&&(i+len)<=n;len++)
                 {
                     dp[i+len][j]+=dp[i][a];
                 }
             }
            }
        }
        int ans=0;
        for(int i=0;i<6;i++)
        {
            ans+=dp[n][i];
        }
        System.out.println(ans);
    }
}
