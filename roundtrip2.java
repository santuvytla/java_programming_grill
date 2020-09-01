import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class roundtrip2 {
    /*
    Byteland has n cities and m flight connections. Your task is to design a round trip that begins in a city, goes through one or more other cities,
    and finally returns to the starting city. Every intermediate city on the route has to be distinct.

Input

The first input line has two integers n and m: the number of cities and flights. The cities are numbered 1,2,…,n.

Then, there are m lines describing the flights. Each line has two integers a and b: there is a flight connection from city a to city b. All connections are one-way flights from a city to another city.

Output

First print an integer k: the number of cities on the route. Then print k cities in the order they will be visited. You can print any valid solution.

If there are no solutions, print "IMPOSSIBLE".

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
4 5
1 3
2 1
2 4
3 2
3 4

Output:
4
2 1 3 2
     */
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
        int n = sc.nextInt();
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
        System.out.println("IMPOSSIBLE");
    }

    private static void dfs(int i) {
        vis[i] = true;
        act[i]=true;
        for (int b : arr[i]) {
            if (act[b]) {

                Vector<Integer> ans=new Vector<>();
                ans.add(i);
                while((i^b)!=0)
                {
                    i=p[i];
                    ans.add(i);

                }
                ans.add(ans.get(0));
                Collections.reverse(ans);
                System.out.println(ans.size());
                for(int a:ans)
                {
                    System.out.print((a+1)+" ");
                }
                System.exit(0);


            } else {
                if(!vis[b]) {
                    p[b] = i;
                    dfs(b);
                }
            }
        }
        act[i]=false;




    }
}
