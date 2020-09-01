package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class largeisl {
    /*
    In a 2D grid of 0s and 1s, we change at most one 0 to a 1.

After, what is the size of the largest island? (An island is a 4-directionally connected group of 1s).

Example 1:

Input: [[1, 0], [0, 1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
Example 2:

Input: [[1, 1], [1, 0]]
Output: 4
Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
     */
    public static void main(String[] args) {
        //dfs+hashmap
        int grid[][]={{1,0},{0,1}};
        int k=maxisland(grid);
        System.out.print(k);
    }

    private static int maxisland(int[][] grid) {
        if(grid==null || grid.length==0)
        {
            return 0;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int max_area=0;
        int island_id=2;
        int [][] dir = new int [][]{{0,-1} , {0,1}, {1,0}, {-1,0}};

        for(int i = 0 ; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count=getmaxarea(i,j,grid,island_id);
                    map.put(island_id++,count);
                    max_area = Math.max(max_area, count);
                }

            }
        }
        for(int i = 0 ; i < grid.length ; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0) {
                    HashSet<Integer> hs = new HashSet<>();

                    for (int[] d : dir) {
                        int x = d[0] + i;
                        int y = d[1] + j;
                        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
                            continue;
                        }
                        hs.add(grid[x][y]);
                    }
                    int new_island=1;
                    for(int id:hs)
                    {
                        new_island+=map.get(id);
                        max_area=Math.max(new_island,max_area);
                    }
                }
            }
        }
        return max_area;


    }

    private static int getmaxarea(int i, int j, int[][] grid, int id) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == id || grid[i][j] == 0)
        {
            return 0;
        }

        grid[i][j] = id;

        int left = getmaxarea(i,j-1,grid,id);
        int right = getmaxarea(i, j+1, grid, id);
        int up = getmaxarea(i-1, j , grid, id);
        int down = getmaxarea(i+1, j , grid, id);

        return left + right + up + down + 1;
    }
}
