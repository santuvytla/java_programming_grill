public class burstbaloon {
    /*
    Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
    You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
    Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
     */
    public static void main(String[] args) {
        int arr[]={ 3,1,5,8};
        int n=arr.length;
        int dp[][]=new int[1000][1000];
        for(int l=n-1;l>=0;l--)
        {
            for(int r=l;r<n;r++)
            {
                for(int i=l;i<=r;i++)
                {
                    dp[l][r]=Math.max(dp[l][r],arr[i]*(l==0?1:arr[l-1])*(r==n-1?1:arr[r+1])+(l<=i-1?dp[l][i-1]:0)+(r>=i+1?dp[i+1][r]:0));
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
