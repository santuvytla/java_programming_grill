package com.company;

import java.util.Arrays;
import java.util.PriorityQueue;

public class shortpathallnode {
    /*
    An undirected, connected graph of N nodes (labeled 0, 1, 2, ..., N-1) is given as graph.

graph.length = N, and j != i is in the list graph[i] exactly once, if and only if nodes i and j are connected.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.



Example 1:

Input: [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:

Input: [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
     */
    public static void main(String[] args) {
        int graph[][]={{1,2,3},{0},{0},{0}};
        int k=shortpath(graph);
        System.out.print(k);
    }

    private static int shortpath(int[][] graph) {
        int n=graph.length;
        //int[]--cost,status,index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        //dp--endindex,status
        int dp[][]=new int[n][1<<n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][1<<i] = 0;
            pq.add(new int[] {0, 1<<i, i});
        }
        while(pq.size() != 0) {
            int[] top = pq.poll();
            int cost = top[0], status = top[1], index = top[2];
            if(status == (1<<n)-1) return cost;
            for(int to: graph[index]) {
                int newStatus = (status | (1<<to));
                if(dp[to][newStatus] > cost+1) {
                    dp[to][newStatus] = cost+1;
                    pq.add(new int[] {cost+1, newStatus, to});
                }
            }
        }
        return 0;


    }
}
