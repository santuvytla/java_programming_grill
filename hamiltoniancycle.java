import java.util.Scanner;

public class hamiltoniancycle {
    /*
    There are n cities and m flight connections between them. You want to travel from Syrjälä to Lehmälä so that you visit each city exactly once. How many possible routes are there?

Input

The first input line has two integers n and m: the number of cities and flights. The cities are numbered 1,2,…,n. City 1 is Syrjälä, and city n is Lehmälä.

Then, there are m lines describing the flights. Each line has two integers a and b: there is a flight from city a to city b. All flights are one-way flights.

Output

Print one integer: the number of routes modulo 109+7.

Constraints
2≤n≤20
1≤m≤n2
1≤a,b≤n
Example

Input:
4 6
1 2
1 3
2 3
3 2
2 4
3 4

Output:
2
     */
    public static boolean adj[][]=new boolean[20][20];
    public static int dp[][]=new int[1<<20][20];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            --a;
            --b;
            adj[a][b]=true;
        }
        dp[1][0]=1;
        for(int i=2;i<1<<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(((i>>j)&1)!=0)
                {
                    int i2=i^1<<j;
                    for(int k=0;k<n;k++)
                    {
                        if((((i2>>k)&1)!=0)&&adj[k][j])
                        {
                            dp[i][j]+=dp[i2][k];

                        }
                    }
                }
            }
        }
        System.out.println(dp[(1<<n)-1][n-1]);
    }
}
