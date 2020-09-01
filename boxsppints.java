package com.company;

public class boxsppints {
    /*
    Given several boxes with different colors represented by different positive numbers.
You may experience several rounds to remove boxes until there is no box left. Each time you can choose some continuous boxes with the same color
(composed of k boxes, k >= 1), remove them and get k*k points.
Find the maximum points you can get.
Input: boxes = [1,3,2,2,2,3,4,3,1]
Output: 23
Explanation:
[1, 3, 2, 2, 2, 3, 4, 3, 1]
----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
----> [1, 3, 3, 3, 1] (1*1=1 points)
----> [1, 1] (3*3=9 points)
----> [] (2*2=4 points)

     */
    public static void main(String[] args) {
        int boxes[]={1,3,2,2,2,3,4,3,1};
        int k=removeboxes(boxes);
        System.out.print(k);
    }

    private static int removeboxes(int[] boxes) {
        int[][][] dp=new int[boxes.length][boxes.length][boxes.length];
        return dfs(boxes,0,boxes.length-1,0,dp);
    }

    private static int dfs(int[] boxes, int start, int end, int prefix, int[][][] dp) {
        int res=0;
        int count=0;
        if(start>end)
            return 0;
        if(start==end)
        {
            return (prefix+1)*(prefix+1);
        }
        if(dp[start][end][prefix]!=0)
        {
            return dp[start][end][prefix];
        }
        int index=start;
        while(index <= end && boxes[index] == boxes[start]){
            index++;
            count++;
        }
        int newstart=index;
        res=(prefix+count)*(prefix+count)+dfs(boxes,newstart,end,0,dp);
        while(index<=end)
        {
            if(boxes[index]==boxes[start]&&boxes[index-1]!=boxes[start])
            {
                res = Math.max(res, dfs(boxes, newstart, index-1, 0, dp) + dfs(boxes, index, end, count+prefix, dp));
            }
            index++;
        }
        dp[start][end][prefix]=res;
        return res;
    }

}
