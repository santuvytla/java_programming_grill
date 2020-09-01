import java.util.Scanner;
import java.util.Vector;

public class gameroutesnumber {
    /*
    A game has n levels, connected by m teleporters, and your task is to get from level 1 to level n.
    The game has been designed so that there are no directed cycles in the underlying graph. In how many ways can you complete the game?

Input

The first input line has two integers n and m: the number of levels and teleporters. The levels are numbered 1,2,…,n.

After this, there are m lines describing the teleporters. Each line has two integers a and b: there is a teleporter from level a to level b.

Output

Print one integer: the number of ways you can complete the game. Since the result may be large, print it modulo 109+7.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
4 5
1 2
2 4
1 3
3 4
1 4

Output:
3
     */
    public static int dp[]=new int[1000];
    public static int n=0;
    public static Vector<Integer> ans=new Vector<>();
    public static Vector<Integer> arr[] = new Vector[10000];
    public static int p[]=new int[10000];
    public static boolean vis[] = new boolean[1000];
    public static boolean act[]=new boolean[1000];
    public static Vector<Integer> arr1 = new Vector<Integer>();
    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Vector<Integer>();
        }

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            arr[a].add(b);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }

            System.out.println(dp[0]);

    }

    private static void dfs(int i) {
        dp[i]=i==n-1?1:0;
        vis[i] = true;
        act[i]=true;
        for (int b : arr[i]) {
            if (act[b]) {

                System.out.println("Impossible");
                System.exit(0);


            } else {
                if(!vis[b]) {
                    p[b] = i;
                    dfs(b);
                }
            }
           dp[i]=dp[i]+dp[b];
        }
        act[i]=false;

    }
}
