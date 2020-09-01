import java.util.*;

public class Investigation {
    /*
    You are going to travel from Syrjälä to Lehmälä by plane. You would like to find answers to the following questions:
what is the minimum price of such a route?
how many minimum-price routes are there? (modulo 109+7)
what is the minimum number of flights in a minimum-price route?
what is the maximum number of flights in a minimum-price route?
Input

The first input line contains two integers n and m: the number of cities and the number of flights. The cities are numbered 1,2,…,n. City 1 is Syrjälä, and city n is Lehmälä.

After this, there are m lines describing the flights. Each line has three integers a, b, and c: there is a flight from city a to city b with price c. All flights are one-way flights.

You may assume that there is a route from Syrjälä to Lehmälä.

Output

Print four integers according to the problem statement.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
1≤c≤109
Example

Input:
4 5
1 4 5
1 2 4
2 4 5
1 3 2
3 4 3

Output:
5 2 1 2
     */
    //first find dag using djsktra
    public static int dp[]=new int[1000];
    public static int n=0;
    public static Vector<Integer> ans=new Vector<>();
    public static Vector<Integer> arr[] = new Vector[10000];
    public static int p[]=new int[10000];
    public static boolean vis[] = new boolean[1000];
    public static boolean act[]=new boolean[1000];
    public static Vector<Integer> arr1 = new Vector<Integer>();
    public static int d[]=new int[1000];
    public static Vector<int[]> ar[]=new Vector[1000];
    public static void main(String[] args) {
        for(int i=0;i<10;i++)
        {
            ar[i]=new Vector<int[]>();
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Vector<Integer>();
        }

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c=sc.nextInt();
            a--;
            b--;
            ar[a].add(new int[]{c,b});
        }
        Arrays.fill(d,0x3f);
        d[0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(10, Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, 0});
        while (pq.size() != 0) {
            int[] u1 = pq.peek();  //first add 0 to array
            pq.poll();
            if (u1[0] > d[u1[1]]) {
                continue;
            }
            for (int[] v : ar[u1[1]]) {
                if (d[v[1]] > u1[0] + v[0]) {
                    d[v[1]] = u1[0] + v[0];
                    pq.add(new int[]{d[v[1]], v[1]});
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int[] j:ar[i])
            {
                if(d[i]+j[0]==d[j[1]])
                {
                    arr[i].add(j[1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        System.out.println(d[n-1]+" "+dp[0]);
        for(int i=0;i<100;i++)
        {
            vis[i]=false;
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs2(i);
            }

        }
        System.out.println(dp[0]-1);
        for(int i=0;i<100;i++)
        {
            vis[i]=false;
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs3(i);
            }
        }
        System.out.println(dp[0]-1);

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
    private static void dfs2(int i) {
        dp[i]=i==n-1?1:10000;
        vis[i] = true;
        act[i]=true;
        for (int b : arr[i]) {
            if (act[b]) {

                System.out.println("Impossible");
                System.exit(0);


            } else {
                if(!vis[b]) {
                    p[b] = i;
                    dfs2(b);
                }
            }
            if(dp[b]+1<dp[i])
            {
                p[i]=b;
                dp[i]=dp[b]+1;
            }
        }
        act[i]=false;

    }
    private static void dfs3(int i) {
        dp[i]=i==n-1?1:-1000;
        vis[i] = true;
        act[i]=true;
        for (int b : arr[i]) {
            if (act[b]) {

                System.out.println("Impossible");
                System.exit(0);


            } else {
                if(!vis[b]) {
                    p[b] = i;
                    dfs3(b);
                }
            }
            if(dp[b]+1>dp[i])
            {
                p[i]=b;
                dp[i]=dp[b]+1;
            }
        }
        act[i]=false;

    }
}
