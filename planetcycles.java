import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class planetcycles {
    /*
    You are playing a game consisting of n planets. Each planet has a teleporter to another planet (or the planet itself).

You start on a planet and then travel through teleporters until you reach a planet that you have already visited before.

Your task is to calculate for each planet the number of teleportations there would be if you started on that planet.

Input

The first input line has an integer n: the number of planets. The planets are numbered 1,2,…,n.

The second line has n integers t1,t2,…,tn: for each planet, the destination of the teleporter. It is possible that ti=i.

Output

Print n integers according to the problem statement.

Constraints
1≤n≤2⋅105
1≤ti≤n
Example

Input:
5
2 4 3 1 4

Output:
3 3 1 3 4
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

        for (int i = 0; i < 100; i++) {
            adj[i] = new Vector<Integer>();
        }
        int n, q;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            --t[i];
            adj[t[i]].add(i);
        }
        Arrays.fill(rt, -1);
        for (int i = 0; i < n; i++) {

            if (~rt[i] != 0) {
                continue;
            }
            int u = i;
            while (!vis[u]) {
                vis[u] = true;
                u = t[u];
            }
            while (cyc.size() == 0 || (u ^ cyc.get(0)) != 0) {
                rp[u] = cyc.size();
                cyc.add(u);
                rt[u] = u;
                cr[u] = i;
                u = t[u];

            }
            for (int ci : cyc) {
                dt = 0;
                cs[ci] = cyc.size();
                dfs1(ci);

            }
            cyc.clear();
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(d[i]+cs[rt[i]]+" ");
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
