import java.util.Scanner;
import java.util.Vector;

public class RoundTrip {
    /*
    Byteland has n cities and m roads between them. Your task is to design a round trip that begins in a city, goes through two or more other cities, and finally returns to the starting city. Every intermediate city on the route has to be distinct.

Input

The first input line has two integers n and m: the number of cities and roads. The cities are numbered 1,2,…,n.

Then, there are m lines describing the roads. Each line has two integers a and b: there is a road between those cities.

Every road is between two different cities, and there is at most one road between any two cities.

Output

First print an integer k: the number of cities on the route. Then print k cities in the order they will be visited. You can print any valid solution.

If there are no solutions, print "IMPOSSIBLE".

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
5 6
1 3
1 2
5 3
1 5
2 4
4 5

Output:
4
3 5 1 3
     */
    //lets find a cycle between a graph...
    public static Vector<Integer> arr[] = new Vector[10000];
    public static int p[]=new int[10000];
    public static boolean vis[] = new boolean[1000];
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
            arr[b].add(a);
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static void dfs(int i) {
        int pu = -1;//to have track of nodes for cycle in dfs itself
        p[i] = pu;
        vis[i] = true;
        for (int b : arr[i]) {
            if (b == pu) {
                continue;
            }
            if (vis[b]) {
                int u2=i;
                    while((i^b)!=0)
                    {
                        arr1.add(i);
                        i=p[i];
                    }
                    arr1.add(b);
                    arr1.add(u2);
                System.out.println(arr1.size());
                for(int a:arr1)
                {
                    System.out.print((a+1)+" ");
                }
                System.exit(0);


            } else {
                dfs(b, i);
            }
        }
    }
        private static void dfs(int i,int pu) {

            p[i]=pu;
            vis[i]=true;
            for(int b:arr[i])
            {
                if(b==pu)
                {
                    continue;
                }
                if(vis[b])
                {
                    int u2=i;
                    while((i^b)!=0)
                    {
                        arr1.add(i);
                        i=p[i];
                    }
                    arr1.add(b);
                    arr1.add(u2);
                    System.out.println(arr1.size());
                    for(int a:arr1)
                    {
                        System.out.print((a+1)+" ");
                    }
                    System.exit(0);
                }
                else
                {
                    dfs(b,i);
                }
            }


    }
}