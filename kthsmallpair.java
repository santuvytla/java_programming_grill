package com.company;

public class kthsmallpair {
    /*
    Given an integer array, return the k-th smallest distance among all the pairs. The distance of a pair (A, B) is defined as the absolute difference between A and B.

Example 1:
Input:
nums = [1,3,1]
k = 1
Output: 0
Explanation:
Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
     */
    public static void main(String[] args) {
        int nums[]={1,3,1};
        int s=1;
        int k=findsmall(nums,s);
        System.out.print(k);

    }

    private static int findsmall(int[] arr, int s) {
        int max = 0;
        int n =arr.length;
        for(int ele : arr)max = Math.max(ele,max);
        int temp[]=new int[max+1];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                temp[Math.abs(arr[j]-arr[i])]++;
            }
        }
        for(int i=0;i<max+1;i++)
        {
            s-=temp[i];
            if(s<=0)
            {
                return i;
            }
        }
        return -1;



    }
}
