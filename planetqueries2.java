import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class planetqueries2 {
    /*
    You are playing a game consisting of n planets. Each planet has a teleporter to another planet (or the planet itself).

You have to process q queries of the form: You are now on planet a and want to reach planet b. What is the minimum number of teleportations?

Input

The first input line contains two integers n and q: the number of planets and queries. The planets are numbered 1,2,…,n.

The second line contains n integers t1,t2,…,tn: for each planet, the destination of the teleporter.

Finally, there are q lines describing the queries. Each line has two integers a and b: you are now on planet a and want to reach planet b.

Output

For each query, print the minimum number of teleportations. If it is not possible to reach the destination, print −1.

Constraints
1≤n,q≤2⋅105
1≤a,b≤n
Example

Input:
5 3
2 3 2 3 2
1 2
1 3
1 4

Output:
1
2
-1
     */
    public static Vector<Integer> adj[]=new Vector[100];
    public static boolean vis[]=new boolean[100];
   public static int t[]=new int[100];
    public static  int d[]=new int[100];
    public static  int ds[]=new int[100];
    public static  int de[]=new int[100];
    public static int rt[]=new int[100];
    public static  int rp[]=new int[100];
    public static  int cr[]=new int[100];
    public static  int cs[]=new int[100];
    public static int dt=0;
    public static  Vector<Integer> cyc=new Vector<Integer>();
    public static void main(String[] args) {

        for(int i=0;i<100;i++)
        {
            adj[i]=new Vector<Integer>();
        }
        int n,q;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        q=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            t[i]=sc.nextInt();
            --t[i];
            adj[t[i]].add(i);
        }
        Arrays.fill(rt,-1);
        for(int i=0;i<n;i++)
        {

            if(~rt[i]!=0)
            {
                continue;
            }
            int u=i;
            while (!vis[u])
            {
                vis[u]=true;
                u=t[u];
            }
            while (cyc.size()==0||(u^cyc.get(0))!=0)
            {
                rp[u]=cyc.size();
                cyc.add(u);
                rt[u]=u;
                cr[u]=i;
                u=t[u];

            }
            for(int ci:cyc)
            {
                dt=0;
                cs[ci]=cyc.size();
                dfs1(ci);

            }
            cyc.clear();
        }
        while(q!=0)
        {
            int a=0,b=0;
            a=sc.nextInt();
            b=sc.nextInt();
            a--;
            b--;
            int ans=-1;
            if(cr[a]==cr[b]) {
                if (rt[b] == b) {
                    ans=d[a];
                    a=rt[a];
                    ans+=(rp[b]-rp[a]+cs[a])%cs[a];
                } else {
                    if (rt[a] == rt[b] &&ds[b]<=ds[a]&&ds[a]<de[b]) {
                        ans=d[a]-d[b];
                    }
                }
            }
            System.out.println(ans);
            q--;
        }


    }

    private static void dfs1(int u) {
        ds[u]=dt++;
        for(int v: adj[u])
        {
            if((rt[v]^v)!=0){
                d[v]=d[u]+1;
                cr[v]=cr[u];
                rt[v]=rt[u];
                dfs1(v);
            }
        }
        de[u]=dt;
    }
}
