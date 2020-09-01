package com.company;

import java.util.Arrays;

public class googlqq1 {
    /*
    Given an Array A, find the minimum amplitude you can get after changing up to 3 elements. Amplitude is the range of the array (basically difference between largest and smallest element).

Example 1:

Input: [-1, 3, -1, 8, 5 4]
Output: 2
Explanation: we can change -1, -1, 8 to 3, 4 or 5
     */
    public static void main(String[] args) {
        int arr[]={-1, 3, -1, 8, 5 ,4}; // -1,-1,3,4,5,8
        int k=minampl(arr);
        System.out.println(k);
    }

    private static int minampl(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n <= 3) return 0;
        int ans = nums[n-1]-nums[0];
        for(int i = 0, j = n-4; j < n; i++, j++) {
            ans = Math.min(ans, nums[j]-nums[i]);
        }
        return ans;

    }
}
