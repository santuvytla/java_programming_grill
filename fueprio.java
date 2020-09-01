package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class fueprio {
    public static void main(String[] args) {
        int target=4;
        int startfuel=1;
        int stations[][]={{1,1},{2,1},{3,1}};
        int k=minstati(target,startfuel,stations);
        System.out.print(k);
    }

    private static int minstati(int target, int startfuel, int[][] stations) {
        if(startfuel>=target)
        {
            return 0;
        }
        if(stations==null)
        {
            return -1;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->stations[b][1]-stations[a][1]);
        int trips=0;
        for(int i=0;i<stations.length;i++)
        {
            if(stations[i][1]>0)
                pq.offer(i);
        }
        while(!pq.isEmpty())
        {
            ++trips;
            ArrayList<Integer> tmp=new ArrayList<>();
            while(!pq.isEmpty()&&startfuel<stations[pq.peek()][0])
            {
                tmp.add(pq.poll());

            }
            if(pq.isEmpty())
            {
                return -1;
            }
            startfuel+=stations[pq.poll()][1];
            if(startfuel>=target)
            {
                return  trips;
            }
            for(int n:tmp)
            {
                pq.offer(n);
            }
        }
        return -1;
    }
}
