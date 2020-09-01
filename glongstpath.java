import java.util.Scanner;
import java.util.Vector;

public class glongstpath {
    /*
   when vertices and edges are given,and directed edges are given.find the longest directed graph
     */
    public static Vector<Integer> arr[]=new Vector[100];
    public static int indeg[]=new int[100];
    public static boolean vis[]=new boolean[100];
    public static int dis[]=new int[100];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<100;i++)
        {
            arr[i]=new Vector<Integer>();
        }
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[a].add(b);
            indeg[b]++;
        }
        for(int i=1;i<=n;i++)
        {
            if(!vis[i]&& indeg[i]==0)
            {
                dfs(i);
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans=Math.max(ans,dis[i]);
        }
        System.out.println(ans);
    }

    private static void dfs(int i) {
        assert(!vis[i]);
        vis[i]=true;
        for(int b:arr[i])
        {
            dis[b]=Math.max(dis[i]+1,dis[b]);
            indeg[b]--;
            if(indeg[b]==0)
            {
                dfs(b);
            }
        }
    }
}
