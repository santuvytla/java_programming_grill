import java.util.Scanner;
import java.util.Vector;

public class treediameter {
    /*
    You are given a tree consisting of n nodes.

The diameter of a tree is the maximum distance between two nodes. Your task is to determine the diameter of the tree.

Input

The first input line contains an integer n: the number of nodes. The nodes are numbered 1,2,…,n.

Then there are n−1 lines describing the edges. Each line contains two integers a and b: there is an edge between nodes a and b.

Output

Print one integer: the diameter of the tree.

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
3

Explanation: The diameter corresponds to the path 2→1→3→5.
     */
    public static int d[]=new int[100];
    public static Vector<Integer> adj[]=new Vector[100];
    public static int ans=0;
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
            ans=Math.max(ans,d[u]+d[v]+1);
            d[u]=Math.max(d[u],d[v]+1);
        }
    }

    private static void dfs(int u,int p) {

        for (int v : adj[u]) {
            if (v == p) {
                continue;
            }
            dfs(v, u);
            ans=Math.max(ans,d[u]+d[v]+1);
            d[u]=Math.max(d[u],d[v]+1);
        }
    }
}
