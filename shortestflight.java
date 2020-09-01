package com.company;

import java.util.*;

public class shortestflight {
/*
    There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

    Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

    Example 1:
    Input:
    n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
    src = 0, dst = 2, k = 1
    Output: 200
    Explanation:
    The graph looks like this:
 The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

 */
public static void main(String[] args) {
    int edges[][]={{0,1,100},{1,2,100},{0,2,500}};
    int n=3,src=0,dst=2,k=1;
    int ans=cheap(edges,src,dst,n,k);
    System.out.print(ans);

}

    private static int cheap(int[][] flights, int src, int dst, int n, int k) {
        Map<Integer, List<Edge>> graph = new HashMap();
        for(int i = 0; i < flights.length; i++) {
            graph.putIfAbsent(flights[i][0], new ArrayList());
            graph.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
        }
        Queue<int[]> q = new LinkedList();
        Map<Integer, Integer> seen = new HashMap();
        q.offer(new int[]{src, 0, 0});
        seen.put(src, 0);
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int cur = temp[0], costSoFar = temp[1], jumps = temp[2];
            if(jumps <= k) {
                for(Edge e:graph.getOrDefault(cur, new ArrayList<Edge>())) {
                    if(seen.getOrDefault(e.destination, Integer.MAX_VALUE) >= costSoFar + e.cost) {
                        q.offer(new int[]{e.destination, costSoFar + e.cost, jumps + 1});
                        seen.put(e.destination, costSoFar + e.cost);
                    }
                }
            }
        }
        return seen.getOrDefault(dst,-1);

    }
    static class Edge {
        int destination;
        int cost;
        Edge(int destination,int cost) {
            this.cost = cost;
            this.destination = destination;
        }
    }
}
