import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class Schooldance {
    /*
    There are n boys and m girls in a school. Next week a school dance will be organized. A dance pair consists of a boy and a girl, and there are k potential pairs.

Your task is to find out the maximum number of dance pairs and show how this number can be achieved.

Input

The first input line has three integers n, m and k: the number of boys, girls, and potential pairs. The boys are numbered 1,2,…,n, and the girls are numbered 1,2,…,m.

After this, there are k lines describing the potential pairs. Each line has two integers a and b: boy a and girl b are willing to dance together.

Output

First print one integer r: the maximum number of dance pairs. After this, print r lines describing the pairs. You can print any valid solution.

Constraints
1≤n,m≤500
1≤k≤1000
1≤a≤n
1≤b≤m
Example

Input:
3 2 4
1 1
1 2
2 1
3 1

Output:
2
1 2
3 1
     */
    //even 2 1 and 1 2 works..maximum bipartite matching
    public static int mt[]=new int[100];
    public static Vector<Integer> adj[]=new Vector[100];
    public static boolean vis[]=new boolean[100];

    public static void main(String[] args) {
        for(int i=0;i<100;i++)
        {
            adj[i]=new Vector<>();
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        for(int i=0;i<k;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;
            b--;
            adj[a].add(b);
        }
        int f=0;
        Arrays.fill(mt,0,4*m,-1);
        Arrays.fill(vis,0,n,false);
        for(int i=0;i<n;i++)
        {
            Arrays.fill(vis,0,n,false);
            f+=dfs(i);
        }
        System.out.println(f);
        for(int i=0;i<m;i++)
        {
            if(~mt[i]!=0)
            {
                System.out.println((mt[i]+1)+" "+(i+1));
            }
        }

    }

    private static int dfs(int u) {
        vis[u]=true;
        for(int v1:adj[u])
        {
            if((mt[v1]<0)||(!vis[mt[v1]])&&(dfs(mt[v1])!=0))
            {
                mt[v1]=u;
                return 1;
            }

        }
        return 0;

    }
}
