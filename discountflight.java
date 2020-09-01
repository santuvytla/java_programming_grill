import java.util.*;

public class discountflight {
    /*
    Your task is to find a minimum-price flight route from Syrjälä to Metsälä. You have one discount coupon, using which you can halve the price of any single flight during the route. However, you can only use the coupon once.

Input

The first input line has two integers n and m: the number of cities and flight connections. The cities are numbered 1,2,…,n. City 1 is Syrjälä, and city n is Metsälä.

After this there are m lines describing the flights. Each line has three integers a, b, and c: a flight begins at city a, ends at city b, and its price is c. Each flight is unidirectional.

You can assume that it is always possible to get from Syrjälä to Metsälä.

Output

Print one integer: the price of the cheapest route from Syrjälä to Metsälä.

When you use the discount coupon for a flight whose price is x, its price becomes ⌊x/2⌋ (it is rounded down to an integer).

Constraints
2≤n≤105
1≤m≤2⋅105
1≤a,b≤n
1≤c≤109
Example

Input:
3 4
1 2 3
2 3 1
1 3 7
2 1 5

Output:
2
     */
    public  static int d1[]=new int[100];
    public static int d2[]=new int[100];

    public static Vector<int[]> arr[] = new Vector[1000];
    public static Vector<int[]> arr1[]=new Vector[1000];
    public static void main(String[] args) {

        int d[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = new Vector<int[]>();
        }
        for (int i = 0; i < 100; i++) {
            arr1[i] = new Vector<int[]>();
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
            arr1[b].add(new int[]{c, a});
        }
        solve(0,arr,d1);
        solve(n-1,arr1,d2);
        int ans=1000;
        for(int i=0;i<n;i++)
        {
            for(int[] j:arr[i]) {
                ans = Math.min(ans, d1[i]+d2[j[1]]+j[0]/2);
            }
        }
        System.out.println(ans);
        for(int i=0;i<n;i++)
        {
            System.out.println(d1[i]+" "+d2[i]);
        }


    }

    public static void solve(int u,Vector<int[]>[] adj,int[] d) {
        for(int i=0;i<100;i++)
        {
            d[i]=0x3f;
        }
        d[u]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(10, Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, u});
         // making values as max value for d array
        while (pq.size() != 0) {
            int[] u1 = pq.peek();  //first add 0 to array
            pq.poll();
            if (u1[0] > d[u1[1]]) {
                continue;
            }
            for (int[] v : adj[u1[1]]) {
                if (d[v[1]] > u1[0] + v[0]) {
                    d[v[1]] = u1[0] + v[0];
                    pq.add(new int[]{d[v[1]], v[1]});
                }
            }
        }
    }
}
