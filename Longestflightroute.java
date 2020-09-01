import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Longestflightroute {
    /*
    Uolevi has won a contest, and the prize is a free flight trip that can consist of one or more flights through cities. Of course, Uolevi wants to choose a trip that has as many cities as possible.

Uolevi wants to fly from Syrjälä to Lehmälä so that he visits the maximum number of cities. You are given the list of possible flights, and you know that there are no directed cycles in the flight network.

Input

The first input line has two integers n and m: the number of cities and flights. The cities are numbered 1,2,…,n. City 1 is Syrjälä, and city n is Lehmälä.

After this, there are m lines describing the flights. Each line has two integers a and b: there is a flight from city a to city b. Each flight is a one-way flight.

Output

First print the maximum number of cities on the route. After this, print the cities in the order they will be visited. You can print any valid solution.

If there are no solutions, print "IMPOSSIBLE".

Constraints
2≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
5 5
1 2
2 5
1 3
3 4
4 5

Output:
4
1 3 4 5
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
       if(dp[0]<0)
       {
           System.out.println("IMPOSSIBLE");
       }
       else
       {
           ans.add(0);
           int u=0;
           while((u^n-1)!=0)
           {
               u=p[u];
               ans.add(u);
           }
           System.out.println(ans.size());
           for(int a:ans)
           {
               System.out.print((a+1)+" ");
           }

       }
    }

    private static void dfs(int i) {
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
                    dfs(b);
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
