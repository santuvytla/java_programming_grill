package com.company;

public class longestmountiam {
    /*
    Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain.

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
     */
    public static void main(String[] args) {
        int mont[]={2,1,4,7,3,2,5};
        int k=createmont(mont);
        System.out.print(k);
    }
    public static int i=0;
    private static int createmont(int[] arr) {
        int max=0;
        for( i=0;i<arr.length-1;i++){
            if(arr[i]<arr[i+1]){
                max=Math.max(max,check(arr,i));
            }
        }
        return max;
    }

    private static int check(int[] arr, int i) {
        int count=0;
        boolean flag1=false;
        boolean flag2=false;
        while(i+1<arr.length && arr[i]<arr[i+1]){
            i++;
            count++;
            flag1=true;
        }
        while(i+1<arr.length && arr[i]>arr[i+1]){
            i++;
            count++;
            flag2=true;
        }
        if(flag1 && flag2){
            return count+1;
        }
        return 0;
    }
}
