import java.util.Scanner;
import java.util.Vector;

public class treematching {
    /*
    You are given a tree consisting of n nodes.

A matching is a set of edges where each node is an endpoint of at most one edge. What is the maximum number of edges in a matching?

Input

The first input line contains an integer n: the number of nodes. The nodes are numbered 1,2,…,n.

Then there are n−1 lines describing the edges. Each line contains two integers a and b: there is an edge between nodes a and b.

Output

Print one integer: the maximum number of pairs.

Constraints
1≤n≤2⋅105
1≤a,b≤n
Example

Input:
5
1 2
1 3
3 4
3 5

Output:
2

Explanation: One possible matching is (1,2) and (3,4).
     */

    public static Vector<Integer> adj[]=new Vector[100];
    public static int dp1[]=new int[100];
    public static int dp2[]=new int[100];

    public static void main(String[] args) {
        for(int i=0;i<10;i++)
        {
            adj[i]=new Vector<>();
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<n;i++)
        {
            int p=sc.nextInt();
            int q=sc.nextInt();
            --p;
            --q;
            adj[p].add(q);
            adj[q].add(p);
        }
        dfs();
        int ans=Math.max(dp1[0],dp2[0]);
        System.out.print(ans);
    }

    private static void dfs() {
        int u=0;
        int p=-1;

        for(int v:adj[u])
        {
            if(v==p)
            {
                continue;
            }
            dfs(v,u);
            dp2[u]=Math.max(dp2[u]+Math.max(dp1[v],dp2[v]),dp1[u]+dp1[v]+1);
            dp1[u]+=Math.max(dp1[v],dp2[v]);
        }
    }

    private static void dfs(int u,int p) {

        for (int v : adj[u]) {
            if (v == p) {
                continue;
            }
            dfs(v, u);
            dp2[u] = Math.max(dp2[u] + Math.max(dp1[v], dp2[v]), dp1[u] + dp1[u] + 1);

        }
    }
}
