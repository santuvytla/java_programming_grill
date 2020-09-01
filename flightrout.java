import java.util.*;

public class flightrout {
    /*
    Your task is to find the k shortest flight routes from Syrjälä to Metsälä. A route can visit the same city several times.

Note that there can be several routes with the same price and each of them should be considered (see the example).

Input

The first input line has three integers n, m, and k: the number of cities, the number of flights, and the parameter k. The cities are numbered 1,2,…,n. City 1 is Syrjälä, and city n is Metsälä.

After this, the input has m lines describing the flights. Each line has three integers a, b, and c: a flight begins at city a, ends at city b, and its price is c. All flights are one-way flights.

You may assume that there are at least k distinct routes from Syrjälä to Metsälä.

Output

Print k integers: the prices of the k cheapest routes sorted according to their prices.

Constraints
2≤n≤105
1≤m≤2⋅105
1≤a,b≤n
1≤c≤109
1≤k≤10
Example

Input:
4 6 3
1 2 1
1 3 3
2 3 2
2 4 6
3 2 8
3 4 1

Output:
4 4 7

Explanation: The cheapest routes are 1→3→4 (price 4), 1→2→3→4 (price 4) and 1→2→4 (price 7).
     */
    public static void main(String[] args) {
        Vector<Integer> d[]=new Vector[1000];
        Vector<int[]> arr[] = new Vector[1000];

        for (int i = 0; i < 10; i++) {
            arr[i] = new Vector<int[]>();
        }
        for (int i = 0; i < 10; i++) {
            d[i] = new Vector<Integer>();
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k=sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            a--;
            b--;
            arr[a].add(new int[]{c, b});

        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(m, Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, 0});
        while (pq.size() != 0) {
            int[] u = pq.peek();
            pq.poll();
            if (d[u[1]].size()>=k) {
                continue;
            }
            d[u[1]].add(u[0]);
            for (int[] v : arr[u[1]]) {

                    pq.add(new int[]{u[0]+v[0], v[1]});

            }

        }
        for(int i=0;i<k;i++)
        {
            System.out.print(d[n-1].get(i)+" ");
        }
    }
}
