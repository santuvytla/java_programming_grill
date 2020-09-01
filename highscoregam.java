import java.util.Scanner;
import java.util.Vector;

public class highscoregam {
    /*
    You play a game consisting of n rooms and m tunnels. Your initial score is 0, and each tunnel increases your score by x where x may be both positive or negative.
     You may go through a tunnel several times.

Your task is to walk from room 1 to room n. What is the maximum score you can get?

Input

The first input line has two integers n and m: the number of rooms and tunnels. The rooms are numbered 1,2,…,n.

Then, there are m lines describing the tunnels. Each line has three integers a, b and x: the tunnel starts at room a, ends at room b, and it increases your score by x. All tunnels are one-way tunnels.

You can assume that it is possible to get from room 1 to room n.

Output

Print one integer: the maximum score you can get. However, if you can get an arbitrarily large score, print −1.

Constraints
1≤2500≤n
1≤5000≤m
1≤a,b≤n
−109≤x≤109
Example

Input:
4 5
1 2 3
2 4 -1
1 3 -2
3 4 7
1 4 4

Output:
5
     */
    public static    Vector<int[]> arr[] = new Vector[1000];
    public static  Vector<Integer> arr1[]=new Vector[1000];
   public static boolean vis[]=new boolean[100];
    public static boolean vis2[]=new boolean[100];
    public static void main(String[] args) {

        long d[] = new long[100];
        int ans[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Vector<int[]>();
        }
        for (int i = 0; i < 100; i++) {
            arr1[i] = new Vector<Integer>();
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();


        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;
            b--;
            arr[a].add(new int[]{c, b});
            arr1[b].add(a);
        }
        dfs(n-1);
        dfs2(0);

        for (int i = 0; i < 100; i++) {
            d[i] = -4;
        }


        d[0] = 0;
        for (int i = 0; i < 5 * n; i++) {
            boolean ch = false;
            for (int j = 0; j < n; j++) {
                for (int[] a : arr[j]) {
                    //  d[a[1]] = Math.max(d[a[1]], d[j] + a[0]);
                    if (d[j] + a[0] > d[a[1]]) {
                        if(vis[a[1]]&&vis2[a[1]])
                        {
                            ch = true;
                            d[a[1]] = d[j] + a[0];
                        }
                    }
                }

            }
            if (i >= n - 1 && ch) {
                System.out.println("-1");
                System.exit(0);
            }
        }


        System.out.println(d[n - 1]);

    }
    public static void dfs(int u)
    {
        vis[u]=true;
        for(int v:arr1[u])
        {
            if(!vis[v])
            {
                dfs(v);
            }
        }
    }
    public static void dfs2(int u)
    {
        vis2[u]=true;
        for(int[] v:arr[u])
        {
            if(!vis2[v[1]])
            {
                dfs2(v[1]);
            }
        }
    }
}

