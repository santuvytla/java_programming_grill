import java.util.Scanner;
import java.util.Vector;

public class subordinates {
    /*
    Given the structure of a company, your task is to calculate for each employee the number of their subordinates.

Input

The first input line has an integer n: the number of employees. The employees are numbered 1,2,…,n, and employee 1 is the general director of the company.

After this, there are n−1 integers: for each employee 2,3,…,n their direct boss in the company.

Output

Print n integers: for each employee 1,2,…,n the number of their subordinates.

Constraints
1≤n≤2⋅105
Example

Input:
5
1 1 2 3

Output:
4 1 1 0 0
     */
    public static int s[]=new int[100];
    public static Vector<Integer> adj[]=new Vector[100];

    public static void main(String[] args) {
        for(int i=0;i<10;i++)
        {
            adj[i]=new Vector<>();
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=1;i<n;i++)
        {
            int p=sc.nextInt();
            --p;
            adj[p].add(i);
        }
        dfs();
        for(int i=0;i<n;i++)
        {
            System.out.print((s[i]-1)+" ");
        }
    }

    private static void dfs() {
        int u=0;
        int p=-1;
        s[u]=1;
        for(int v:adj[u])
        {
            dfs(v,u);
            s[u]+=s[v];
        }
    }

    private static void dfs(int u,int p) {
        s[u]=1;
        for(int v:adj[u])
        {
            dfs(v,u);
            s[u]+=s[v];
        }
    }
}
