import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class planetsandkingdoms {
    /*
    A game has n planets, connected by m teleporters. Two planets a and b belong to the same kingdom exactly when there is a route both from a to b and from b to a. Your task is to determine for each planet its kingdom.

Input

The first input line has two integers n and m: the number of planets and teleporters. The planets are numbered 1,2,…,n.

After this, there are m lines describing the teleporters. Each line has two integers a and b: you can travel from planet a to planet b through a teleporter.

Output

First print an integer k: the number of kingdoms. After this, print for each planet a kingdom label between 1 and k. You can print any valid solution.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
5 6
1 2
2 3
3 1
3 4
4 5
5 4

Output:
2
1 1 1 2 2
     */
    public static Vector<Integer> adj[] = new Vector[100];
    public static Vector<Integer> adj1[] = new Vector[100];
    public static Vector<Integer> st = new Vector<Integer>();
    public static Vector<Integer> co = new Vector<Integer>();
    public static Boolean vis[] = new Boolean[100];
    public static int who[] = new int[100];

    public static void dfs1(int u) {
        vis[u] = true;
        for (int v : adj[u]) {
            if (!vis[v]) {
                dfs1(v);

            }
        }
        st.add(u);
    }

    public static void dfs2(int u, int rt) {
        vis[u] = false;
        who[u] = rt;
        for (int v : adj1[u]) {
            if (vis[v]) {
                dfs2(v, rt);
            }
        }
        co.add(u);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < 100; i++) {
            vis[i] = false;
        }
       /* for(int i=0;i<n;i++)
        {
            st.add(0);
        }

        */
        for (int i = 0; i < 100; i++) {
            adj[i] = new Vector<>();
        }
        for (int i = 0; i < 100; i++) {
            adj1[i] = new Vector<>();
        }


        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            --a;
            --b;
            adj[a].add(b);
            adj1[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs1(i);
            }
        }
        Vector<Integer> ans = new Vector<>();
        for (int i = n - 1; i >= 0; i--) {
            if (vis[st.get(i)]) {

                dfs2(st.get(i), st.get(i));

                ans.add(st.get(i));

                co.clear();
            }

        }
        System.out.println(ans.size());
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<ans.size();i++)
        {
            mp.put(ans.get(i),i);
        }
        for(int i=0;i<n;i++)
        {
            System.out.print((mp.get(who[i])+1)+" ");
        }
    }
}