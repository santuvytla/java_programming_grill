import java.security.PublicKey;
import java.util.Scanner;
import java.util.Vector;

public class flightroutschck {
    /*
    There are n cities and m flight connections. Your task is to check if you can travel from any city to any other city using the available flights.

Input

The first input line has two integers n and m: the number of cities and flights. The cities are numbered 1,2,…,n.

After this, there are m lines describing the flights. Each line has two integers a and b: there is a flight from city a to city b. All flights are one-way flights.

Output

Print "YES" if all routes are possible, and "NO" otherwise. In the latter case also print two cities a and b such that you cannot travel from city a to city b.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
4 5
1 2
2 3
3 1
1 4
3 4

Output:
NO
4 2
//4 1, 4 3 is also valid solution
     */
    public static Vector<Integer> adj[]=new Vector[100];
    public static Vector<Integer> adj1[]=new Vector[100];
    public static Vector<Integer> st=new Vector<Integer>();
    public static Vector<Integer> co=new Vector<Integer>();
    public static Boolean vis[]=new Boolean[100];
    public static int who[]=new int[100];
    public static void dfs1(int u)
    {
        vis[u]=true;
        for(int v:adj[u])
        {
            if(!vis[v])
            {
                dfs1(v);

            }
        }
        st.add(u);
    }
    public static void dfs2(int u,int rt)
    {
        vis[u]=false;
        who[u]=rt;
        for(int v: adj1[u])
        {
            if(vis[v])
            {
                dfs2(v,rt);
            }
        }
        co.add(u);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<100;i++)
        {
            vis[i]=false;
        }
       /* for(int i=0;i<n;i++)
        {
            st.add(0);
        }

        */
        for(int i=0;i<100;i++)
        {
            adj[i]=new Vector<>();
        }
        for(int i=0;i<100;i++)
        {
            adj1[i]=new Vector<>();
        }


        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            --a;
            --b;
            adj[a].add(b);
            adj1[b].add(a);
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs1(i);
            }
        }
        Vector<Integer> ans=new Vector<>();
        for(int i=n-1;i>=0;i--)
        {
            if(vis[st.get(i)])
            {

                dfs2(st.get(i),st.get(i));
            if(co.size()==n)
            {
                System.out.println("YES");
                System.exit(0);
            }
            else {
                ans.add(st.get(i));
            }
                co.clear();
            }

        }
        System.out.println("NO "+(ans.get(1)+1)+" "+(ans.get(0)+1));
    }
}
