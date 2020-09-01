package com.company;

import java.util.LinkedHashMap;
import java.util.Vector;

public class subtreelabels {
    /*
    Given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).

The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.

Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.

A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.

 Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
Output: [2,1,1,1,1,1,1]
Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
     */
    public static Vector<Integer> adj[]=new Vector[100];
    public static int  ans[]=new int[100];
    public static int c[]=new int[26];
   public static final String l="abaedcd";

    public static void main(String[] args) {
        for(int i=0;i<50;i++)
        {
            adj[i]=new Vector<>();
        }
        int arr[][]={{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        int n=7;
        for(int i=0;i<arr.length;i++)
        {
            adj[arr[i][0]].add(arr[i][1]);
            adj[arr[i][1]].add(arr[i][0]);
        }


        dfs();
        for(int i:ans) {
            if(i!=0) {
                System.out.print(i + " ");
            }
        }

        LinkedHashMap<Integer,Integer> s=new LinkedHashMap<>(10,1,true);

    }

    private static void dfs() {
        int u=0;
        int p=-1;
        int lc=c[l.charAt(u)-'a']++;
        for(int v:adj[u])
        {
            if((v^p)!=0)
            {
                dfs(v,u);
            }
        }
        ans[u]=(c[l.charAt(u)-'a']-lc);
    }

    private static void dfs(int u, int p) {
        int lc=c[l.charAt(u)-'a']++;
        for(int v:adj[u])
        {
            if((v^p)!=0)
            {
                dfs(v,u);
            }
        }
        ans[u]=(c[l.charAt(u)-'a']-lc);
    }
}
