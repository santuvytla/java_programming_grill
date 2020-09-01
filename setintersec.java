package com.company;

import java.util.Arrays;

public class setintersec {
    /*
    An integer interval [a, b] (for integers a < b) is a set of all consecutive integers from a to b, including a and b.

Find the minimum size of a set S such that for every integer interval A in intervals, the intersection of S with A has size at least 2.

Example 1:
Input: intervals = [[1, 3], [1, 4], [2, 5], [3, 5]]
Output: 3
Explanation:
Consider the set S = {2, 3, 4}.  For each interval, there are at least 2 elements from S in the interval.
Also, there isn't a smaller size set that fulfills the above condition.
Thus, we output the size of this set, which is 3.
     */
    public static void main(String[] args) {
        int intervals[][]={{1,4},{1,3},{2,5},{3,5}};
        int k=setinter(intervals);
        System.out.print(k);
    }

    private static int setinter(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]==b[1]?b[0]-a[0]:a[1]-b[1]);
        int count=0;
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        for(int i=0;i<intervals.length;i++)
        {
            int[] interval=intervals[i];
            if(first>=interval[0])
            {
                continue;
            }
            else if(second>=interval[0])
            {
                first=second;
                second=interval[1];
                count+=1;
            }
            else {
                first = interval[1] - 1;
                second = interval[1];
                count += 2;
            }
        }
        return count;

    }
}
