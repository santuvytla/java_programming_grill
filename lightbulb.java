package com.company;

public class lightbulb {
    /*
    There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.
At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.

Return the number of moments in which all turned on bulbs are blue.
Example 1:
Input: light = [2,1,3,5,4]
Output: 3
Explanation: All bulbs turned on, are blue at the moment 1, 2 and 4.
     */
    public static void main(String[] args) {
        int arr[]={2,1,3,5,4};
        int k=light(arr);
        System.out.println(k);

    }

    private static int light(int[] lights) {
        int right = 0;
        int count = 0;

        int len = lights.length;
        for(int i=0;i<len;i++)
        {
            right = Math.max(right,lights[i]); //2
            if(right == i+1)
            {
                count = count+1;
            }
        }
return count;
    }
}
