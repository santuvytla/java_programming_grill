import java.util.Arrays;
import java.util.Scanner;

public class denomi {
    /*
   You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int coins[]=new int[]{1,2,5};
        int amount=5;
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(cc(coins, 0, amount, dp));

    }
    static int cc(int[] coins, int i, int amount, int[][] dp){
        if(amount == 0) return 1;
        if(amount < 0 || i == coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];

        return dp[i][amount] = cc(coins, i, amount - coins[i], dp) + cc(coins, i + 1, amount, dp);
    }
}
