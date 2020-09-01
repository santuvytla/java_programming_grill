import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class roadreparication {
    /*
    There are n cities and m roads between them. Unfortunately, the condition of the roads is so poor that they cannot be used. Your task is to repair some of the roads so that there will be a decent route between any two cities.

For each road, you know its reparation cost, and you should find a solution where the total cost is as small as possible.

Input

The first input line has two integers n and m: the number of cities and roads. The cities are numbered 1,2,…,n.

Then, there are m lines describing the roads. Each line has three integers a, b and c: there is a road between cities a and b, and its reparation cost is c. All roads are two-way roads.

Every road is between two different cities, and there is at most one road between two cities.

Output

Print one integer: the minimum total reparation cost. However, if there are no solutions, print "IMPOSSIBLE".

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
1≤c≤109
Example

Input:
5 6
1 2 3
2 3 5
2 4 2
3 4 8
5 1 7
5 4 4

Output:
14
     */
    //minimum cost spanning tree

    public static int p[]=new int[100];

    public static void main(String[] args) {
        for(int i=0;i<5;i++)
        {
            p[i]=i;
        }

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int e[][]=new int[100][3];
        for(int i=0;i<m;i++)
        {
            e[i][1]=sc.nextInt();
            e[i][2]=sc.nextInt();
            e[i][0]=sc.nextInt();
            --e[i][1];
            --e[i][2];
        }

    //Not printing less numbers first dont know for wat reason
        Arrays.sort(e, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0])
                    return 1;
                else
                    return -1;
            }
        });

        int a1=0;
        int a2=0;
        for(int i=m-1;i>=0;i--)
        {
            if(join(e[i][1],e[i][2]))
            {
                ++a1;
                a2+=e[i][0];
            }
        }
        if(a1<n-1)
        {
            System.out.println("IMPOSSIBLE");
        }
        else
        {
            System.out.println(a2);
        }
    }
    public static int find(int x)
    {
        if(p[x]!=x)
            return find(p[x]);;
        return x;
      //  return (x^p[x])!=0?p[x]=find(p[x]):x;
    }
    public static boolean join(int x,int y)
    {
        if((x=find(x))==(y=find(y)))
        {
            return false;
        }
        p[x]=y;
        return true;
    }


}
