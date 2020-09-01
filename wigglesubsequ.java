public class wigglesubsequ {
    /*
    A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
     */
    public static void main(String[] args) {
        //dp[i][2]--i signifies the max length upto that index i, and 2 is whether up(positive start) or down(negative start)
        int arr[]={1,17,5,10,13,15,10,5,16,8};
        int dp[][]=new int[arr.length+1][2];
        for(int i=0;i<arr.length;i++)
        {
            dp[i][0]=dp[i][1]=1;
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i])
                {
                    dp[i][1]=Math.max(dp[i][1],dp[i][0]+1);
                }
                if(arr[j]>arr[i])
                {
                    dp[i][0]=Math.max(dp[i][0],dp[i][1]+1);
                }
            }
        }
        int ans=Math.max(dp[arr.length-1][0],dp[arr.length-1][1]);
        System.out.println(ans);
    }
}
