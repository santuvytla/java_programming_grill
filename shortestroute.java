import java.util.*;

public class shortestroute {
    /*
    There are n cities and m flight connections between them. Your task is to determine the length of the shortest route from Syrjälä to every city.

Input

The first input line has two integers n and m: the number of cities and flight connections. The cities are numbered 1,2,…,n, and city 1 is Syrjälä.

After that, there are m lines describing the flight connections. Each line has three integers a, b and c: a flight begins at city a, ends at city b, and
its price is c. Each flight is a one-way flight.

You can assume that it is possible to travel from Syrjälä to all other cities.

Output

Print n integers: the shortest route lengths from Syrjälä to cities 1,2,…,n.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
1≤c≤109
Example

Input:
3 4
1 2 6
1 3 2
3 2 3
1 3 4

Output:
0 5 2
     */

    public static void main(String[] args) {
        Vector<int[]> arr[]=new Vector[1000];
        int d[]=new int[100];
        for(int i=0;i<10;i++)
        {
            arr[i]=new Vector<int[]>();
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            a--;
            b--;
            arr[a].add(new int[]{c,b});
            arr[b].add(new int[]{c,a});
        }

        /*
        for(int i=0;i<m;i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(arr[i].get(j)[0] + " " + arr[i].get(j)[1]);
            }
        }

         */
        PriorityQueue<int[] > pq = new PriorityQueue<int[] >(m, Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, 0});
        Arrays.fill(d,0,100,0x3f); // making values as max value for d array
        d[0]=0;
        while(pq.size()!=0)
        {
            int[] u=pq.peek();  //first add 0 to array
            pq.poll();
            if(u[0]>d[u[1]])
            {
                continue;
            }
            for(int[] v:arr[u[1]]) //u[0] or u[1]
            {
                if(d[v[1]]>u[0]+v[0])
                {
                    d[v[1]]=u[0]+v[0];
                    pq.add(new int[]{d[v[1]],v[1]});
                }
            }
            /* checking for verification
            int[] show=pq.peek();
            System.out.println(show[0]+" "+show[1]);

             */
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(d[i]+" ");
        }

    }
}
