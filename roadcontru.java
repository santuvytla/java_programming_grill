import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class roadcontru {
    /*
    There are n cities and initially no roads between them. However, every day a new road will be constructed, and there will be a total of m roads.

A component is a group of cities where there is a route between any two cities using the roads. After each day, your task is to find the number of components
and the size of the largest component.

Input

The first input line has two integers n and m: the number of cities and roads. The cities are numbered 1,2,…,n.

Then, there are m lines describing the new roads. Each line has two integers a and b: a new road is constructed between cities a and b.

You may assume that every road will be constructed between two different cities.

Output

Print m lines: the required information after each day.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
5 3
1 2
1 3
4 5

Output:
4 2
3 3
2 3
     */
//mst with disjoint set
    public static   int n=0,m=0;
    public static int p[]=new int[100];
    public  static int s[]=new int[100];
    public static int find(int x)
    {

        return (x^p[x])!=0?p[x]=find(p[x]):x;
    }
    public static boolean join(int x,int y)
    {
        if((x=find(x))==(y=find(y)))
        {
            return false;
        }
        p[x]=y;
        s[y]+=s[x];
        return true;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++)
        {
            p[i]=i;
        }
        for(int i=0;i<100;i++)
        {
            s[i]=1;
        }
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        int e[][]=new int[100][3];
        for(int i=0;i<m;i++)
        {
            e[i][1]=sc.nextInt();
            e[i][2]=sc.nextInt();
            --e[i][1];
            --e[i][2];
        }

        int a1=n;
        int a2=1;
        for(int i=0;i<m;i++)
        {
            if(join(e[i][1],e[i][2]))
            {
                --a1;
                a2=Math.max(a2,s[find(e[i][1])]);
            }
            System.out.println(a1+" "+a2);
        }

    }
}
