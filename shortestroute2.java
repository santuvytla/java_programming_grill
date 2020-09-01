import java.util.Arrays;
import java.util.Scanner;

public class shortestroute2 {
    /*
    There are n cities and m roads between them. Your task is to process q queries where you have to determine the length of the shortest route between two given cities.

Input

The first input line has three integers n, m and q: the number of cities, roads, and queries.

Then, there are m lines describing the roads. Each line has three integers a, b and c: there is a road between cities a and b whose length is c. All roads are two-way roads.

Finally, there are q lines describing the queries. Each line has two integers a and b: determine the length of the shortest route between cities a and b.

Output

Print the length of the shortest route for each query. If there is no route, print −1 instead.

Constraints
1≤n≤500
1≤m≤n2
1≤q≤105
1≤a,b≤n
1≤c≤109
Example

Input:
4 3 5
1 2 5
1 3 9
2 3 3
1 2
2 1
1 3
1 4
3 2

Output:
5
5
8
-1
3
     */
    public static void main(String[] args) {
        int d[][]=new int[1000][1000];
        for(int i=0;i<1000;i++)
        {
            for(int j=0;j<1000;j++)
            {
                d[i][j]=0x3f;
            }
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int q=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            --a;
            --b;
            d[a][b]=Math.min(d[a][b],c);
            d[b][a]=Math.min(d[b][a],c);
        }
        for(int i=0;i<n;i++)
        {
            d[i][i]=0;
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    d[i][j]=Math.min(d[i][j],d[i][k]+d[k][j]);
                }
            }
        }
        while(q!=0)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            --a;
            --b;
            int res=d[a][b]>=0x3f?-1:d[a][b];
            System.out.println(res);
            q--;
        }

    }
}
