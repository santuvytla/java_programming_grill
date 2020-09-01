import java.util.Scanner;
import java.util.Vector;

public class roadsandrouts {
    /*
    Byteland has n cities, and m roads between them. The goal is to construct new roads so that there is a route between any two cities.

Your task is to find out the minimum number of roads required, and also determine which roads should be built.

Input

The first input line has two integers n and m: the number of cities and roads. The cities are numbered 1,2,…,n.

After that, there are m lines describing the roads. Each line has two integers a and b: there is a road between those cities.

A road always connects two different cities, and there is at most one road between any two cities.

Output

First print an integer k: the number of required roads.

Then, print k lines that describe the new roads. You can print any valid solution.

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
4 2
1 2
3 4

Output:
1
2 3
     */
    public static Vector<Integer> arr[]=new Vector[10000];

   public static boolean vis[]=new boolean[1000];
    public static void main(String[] args) {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=new Vector<Integer>();
        }
        Vector<Integer> arr1=new Vector<Integer>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        for(int i=0;i<m;i++)
        {
            arr[i].add(0);
        }
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            a--;
            b--;
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                arr1.add(i);
                dfs(i);
            }
        }
        System.out.println(arr1.size()-1);
        for(int i=1;i<arr1.size();i++)
        {
            System.out.println((arr1.get(0)+1)+" "+(arr1.get(i)+1));
        }

    }

    private static void dfs(int i) {
        vis[i]=true;
        for(int a:arr[i]){
            if(!vis[a])
            {
                dfs(a);
            }
        }


    }
}
