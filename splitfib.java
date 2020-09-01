package com.company;

public class splitfib {
    /*
    We have a grid of 1s and 0s; the 1s in a cell represent bricks.
    A brick will not drop if and only if it is directly connected to the top of the grid, or at least one of its (4-way) adjacent bricks will not drop.

We will do some erasures sequentially. Each time we want to do the erasure at the location (i, j),
the brick (if it exists) on that location will disappear, and then some other bricks may drop because of that erasure.

Return an array representing the number of bricks that will drop after each erasure in sequence.

Example 1:
Input:
grid = [[1,0,0,0],[1,1,1,0]]
hits = [[1,0]]
Output: [2]
Explanation:
If we erase the brick at (1, 0), the brick at (1, 1) and (1, 2) will drop. So we should return 2.
Example 2:
Input:
grid = [[1,0,0,0],[1,1,0,0]]
hits = [[1,1],[1,0]]
Output: [0,0]
Explanation:
When we erase the brick at (1, 0), the brick at (1, 1) has already disappeared due to the last move. So each erasure will cause no bricks dropping.
 Note that the erased brick (1, 0) will not be counted as a dropped brick
     */
    public static void main(String[] args) {
        int grid[][]={{1,0,0,0},{1,1,1,0}};
        int hits[][]={{1,0}};
        int[] arr=brickfall(grid,hits);
        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]);
    }

    private static int[] brickfall(int[][] grid, int[][] hits) {
        int[] res=new int[hits.length];
        for(int[] hit:hits)
        {
            grid[hit[0]][hit[1]]-=1;
        }
        //mark all 1's to 2
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[0][j]>0)
                dfs(0,j,grid);
        }
        for(int k=hits.length-1;k>=0;k--)
        {
            int hit[]=hits[k];
            grid[hit[0]][hit[1]]+=1;
            if(grid[hit[0]][hit[1]]==1&&check(hit[0],hit[1],grid))
            {
                res[k]=dfs(hit[0],hit[1],grid)-1;
            }
        }

        return res;
    }
    private static int dfs(int i, int j, int[][] grid){
        if((i<0 || i>=grid.length) || (j<0 || j>=grid[0].length) || (grid[i][j] != 1)) return 0;
        grid[i][j] = 2;
        int cnt = 1;
        for(int[] nxt: new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}) cnt += dfs(i+nxt[0], j+nxt[1], grid);
        return cnt;
    }
    private static boolean check(int i, int j, int[][] grid){
        for(int[] nxt: new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0,-1}}){
            if((i+nxt[0]>=0 && i+nxt[0]<grid.length) && (j+nxt[1]>=0 && j+nxt[1]<grid[0].length) && grid[i+nxt[0]][j+nxt[1]] == 2) return true;
        }
        return i==0;
    }

}
