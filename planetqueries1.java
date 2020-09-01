import java.util.Scanner;

public class planetqueries1 {
    /*
    You are playing a game consisting of n planets. Each planet has a teleporter to another planet (or the planet itself).

Your task is to process q queries of the form: when you begin on planet x and travel through k teleporters, which planet will you reach?

Input

The first input line has two integers n and q: the number of planets and queries. The planets are numbered 1,2,…,n.

The second line has n integers t1,t2,…,tn: for each planet, the destination of the teleporter. It is possible that ti=i.

Finally, there are q lines describing the queries. Each line has two integers x and k: you start on planet x and travel through k teleporters.

Output

Print the answer to each query.

Constraints
1≤n,q≤2⋅105
1≤ti≤n
1≤x≤n
0≤k≤109
Example

Input:
4 3
2 1 1 4
1 2
3 4
4 1

Output:
1
2
4
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=0,q=0;
        n=sc.nextInt();
        q=sc.nextInt();
        int t[][]=new int[30][1000];
        for(int i=0;i<n;i++)
        {
            t[0][i]=sc.nextInt();
            --t[0][i];
        }
        for(int j=1;j<30;j++)
        {
            for(int i=0;i<n;i++)
            {
                t[j][i]=t[j-1][t[j-1][i]];
            }
        }
        while(q!=0)
        {
            int x,k;
            x=sc.nextInt();
            k=sc.nextInt();
            --x;
            for(int i=0;i<30;i++)
            {
                if((k>>i&1)!=0)
                {
                    x=t[i][x];
                }
            }



            System.out.println(x+1);
            q--;
        }
    }
}
