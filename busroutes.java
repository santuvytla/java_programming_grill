package com.company;

import java.util.*;

public class busroutes {
    /*
    We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.

Example:
Input:
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation:
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
     */
    public static void main(String[] args) {
        //bfs strategy is good to go
        int routes[][]={{1,2,7},{3,6,7}};
        int S=1;
        int T=6;
        int k=noofbus(routes,S,T);
        System.out.print(k);

    }

    private static int noofbus(int[][] routes, int S, int T) {
        int res = 0;
        if(S == T)return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            for(int j=0; j<routes[i].length; j++){
                List<Integer> buses = map.getOrDefault(routes[i][j],new ArrayList<>());
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] seen = new int[routes.length];

        queue.add(S);
        while(!queue.isEmpty())
        {
            while(!queue.isEmpty()) {
                int size = queue.size();
                res++;
                for (int i = 0; i < size; i++) {
                    int temp = queue.poll();
                    List<Integer> buses = map.get(temp);
                    for(int bus : buses) {
                        if (seen[bus] == 1) continue;
                        seen[bus] = 1;
                        for(int k=0;k<routes[bus].length;k++)
                        {
                            if(routes[bus][k]==T)
                            {
                                return res;
                            }
                            queue.offer(routes[bus][k]);
                        }
                    }
                }
            }
        }
    return -1;
    }
}
