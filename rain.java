package com.company;

public class rain {
    public static void main(String[] args) {
        int arr[]=new int[]{5,3};
        int ans=trap(arr);
        System.out.print(ans);
    }
    public static int trap(int[] height) {
        int arrSize = height.length;
        if(height==null || arrSize==0){
            return 0;
        }
        int level = 0;  //max height
        int si = 0;     //start index
        int ei = arrSize-1; //end index
        int result =0;

        while(si < ei){

            int lower = 0, pos = 0;
            if(height[si] < height[ei]){
                pos = si++;
            }
            else{
                pos = ei--;
            }
            lower = height[pos];

            level = Math.max(lower, level);
            result += level - lower;
        }
        return result;
    }
}
