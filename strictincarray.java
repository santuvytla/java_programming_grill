public class strictincarray {
    /*
    Given two integer arrays arr1 and arr2, return the minimum number of operations (possibly zero) needed to make arr1 strictly increasing.

In one operation, you can choose two indices 0 <= i < arr1.length and 0 <= j < arr2.length and do the assignment arr1[i] = arr2[j].

If there is no way to make arr1 strictly increasing, return -1.



Example 1:

Input: arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
Output: 1
Explanation: Replace 5 with 2, then arr1 = [1, 2, 3, 6, 7].
Example 2:

Input: arr1 = [1,5,3,6,7], arr2 = [4,3,1]
Output: 2
Explanation: Replace 5 with 3 and then replace 3 with 4. arr1 = [1, 3, 4, 6, 7].
Example 3:

Input: arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
Output: -1
Explanation: You can't make arr1 strictly increasing.
     */
    final static int Max=100000;
    public static void main(String[] args) {
        int arr1[]={1,5,3,6,7};
        int arr2[]={4,3,1};
        int dp[][]=new int[1000][1000];
        dp[0][arr2.length]=0; //making first element unchagable
        for(int v=0;v<arr2.length;v++)
        {
            dp[0][v]=1; //changing first element, here 0 represents index in arr1 and v represents index from arr2
        }
        for(int i=1;i<arr1.length;i++)
        {
            for(int v=0;v<=arr2.length;v++)
            {
                dp[i][v]=Max;
            }
            for(int v0=0;v0<=arr2.length;v0++)
            {
                for(int v1=0;v1<=arr2.length;v1++)
                {
                    int value0=(v0==arr2.length)?arr1[i-1]:arr2[v0];
                    int value1=(v1==arr2.length)?arr1[i]:arr2[v1];
                    if(value0<value1)
                    {
                        dp[i][v1]=Math.min(dp[i][v1],dp[i-1][v0]+((v1==arr2.length)?0:1));//add to record change
                    }
                }
            }
        }
        int ans=Max;
        for(int i=0;i<=arr2.length;i++)
        {
            ans=Math.min(ans,dp[arr1.length-1][i]);
        }


        if(ans==Max)
        {
            System.out.println("-1");
        }
        else {
            System.out.println(ans);
        }


    }
}
