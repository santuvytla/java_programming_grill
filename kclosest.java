package com.company;


import java.util.PriorityQueue;
import java.util.Queue;

public class kclosest {

    public static void main(String[] args) {
        int arr[][] ={{1, 1}, {2, 2}, {3, 3}, {4, 4}};
        int k = 2;
        int res[][] = kclose(arr, k);
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<2;j++)
            {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] kclose(int[][] points, int k) {
        Queue<Node> que = new PriorityQueue<>(points.length);
        for (int[] point : points) {
            que.add(new Node(point));
        }
        int[][] results = new int[k][2];
        for (int i = 0; i < k; i++) {
            Node node = que.poll();
            results[i] = node.xy;
        }
        return results;
    }
}
     class Node implements Comparable<Node>
    {
        public int[] xy;
        public double distancefromorigin;
        public Node(int[] points)
        {
            this.xy=points;
            this.distancefromorigin=calculate(this.xy[0],this.xy[1]);

        }
        public int compareTo(Node comparable)
        {
            return Double.compare(this.distancefromorigin,comparable.distancefromorigin);
        }
        private double calculate(int x,int y)
        {
            return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        }

    }


