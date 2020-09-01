import java.util.*;

public class treedistances {
    /*
    You are given a tree consisting of n nodes.

Your task is to determine for each node the maximum distance to another node.

Input

The first input line contains an integer n: the number of nodes. The nodes are numbered 1,2,…,n.

Then there are n−1 lines describing the edges. Each line contains two integers a and b: there is an edge between nodes a and b.

Output

Print n integers: for each node 1,2,…,n, the maximum distance to another node.

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
2 3 2 3 3
     */
    //after finding heights i will do second dfs
    //incorrect answer sorting probleem...logically perfect
    public static int d[]=new int[100];
    public static Vector<Integer> adj[]=new Vector[100];
    public static int ans[]=new int[10];
    public static void main(String[] args) {
        for(int i=0;i<100;i++)
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
        dfs2();
        for(int i=0;i<n;i++) {
            System.out.print(ans[i]+" ");
        }
    }

    public static void dfs2() {
        int u=0;
        int p=-1;
        int pd=0;
        ans[u]=Math.max(d[u],pd);
        Vector<int[]> w=new Vector<int[]>();
        w.add(new int[]{pd,-1});
        for(int v:adj[u])
        {
            if(v==p)
            {
                continue;
            }
            w.add(new int[]{d[v]+1,v});
        }
        w.add(new int[]{0,-1});
       Collections.sort(w, new Comparator<int[]>() {
           @Override
           public int compare(int[] o1, int[] o2) {
               if (o1[0] > o2[0])
                   return 1;
               else
                   return -1;
           }
       });
        for(int v:adj[u])
        {
            if(v==p)
            {
                continue;
            }
            dfs2(v,u,w.get(0)[1]==v?w.get(1)[0]+1:w.get(0)[0]+1);
        }
    }

    public static void dfs2(int u, int p, int pd) {
        ans[u]=Math.max(d[u],pd);
        Vector<int[]> w=new Vector<int[]>();
     //   Collections.sort(w,Comparator.comparingInt(o -> o[0]));
        w.add(new int[]{pd,-1});
        for(int v:adj[u])
        {
            if(v==p)
            {
                continue;
            }
            w.add(new int[]{d[v]+1,v});
        }
        w.add(new int[]{0,-1});
        Collections.sort(w, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return 1;
                else
                    return -1;
            }
        });
        for(int v:adj[u])
        {
            if(v==p)
            {
                continue;
            }
            dfs2(v,u,w.get(0)[1]==v?w.get(1)[0]+1:w.get(0)[0]+1);
        }
    }


    public static void dfs() {
        int u=0;
        int p=-1;

        for(int v:adj[u])
        {
            if(v==p)
            {
                continue;
            }
            dfs(v,u);
            d[u]=Math.max(d[u],d[v]+1);
        }
    }

    public static void dfs(int u,int p) {

        for (int v : adj[u]) {
            if (v == p) {
                continue;
            }
            dfs(v, u);
            d[u]=Math.max(d[u],d[v]+1);
        }
    }
}
