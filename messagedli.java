import java.util.*;

public class messagedli {
    /*
Syrjälä's network has n computers and m connections. Your task is to find out if Uolevi can send a message to Maija, and if it is possible, what is the minimum number of computers on such a route.

Input

The first input line has two integers n and m: the number of computers and connections. The computers are numbered 1,2,…,n.
Uolevi's computer is 1 and Maija's computer is n.

Then, there are m lines describing the connections. Each line has two integers a and b: there is a connection between those computers.

Every connection is between two different computers, and there is at most one connection between any two computers.

Output

If it is possible to send a message, first print k: the minimum number of computers on a valid route. After this, print an example of such a route. You can print any valid solution.

If there are no routes, print "IMPOSSIBLE".

Constraints
2≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
5 5
1 2
1 3
1 4
2 3
5 4

Output:
3
1 4 5
     */
    public static Vector<Integer> arr[] = new Vector[10000];

    public static boolean vis[] = new boolean[1000];
    public static int p[]=new int[10000];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Vector<Integer>();
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            a--;
            b--;
            arr[a].add(b);
            arr[b].add(a);
        }
        Vector<Integer> arr1=new Vector<Integer>();
        for(int i=0;i<4*n;i++)
        {
            p[i]=-1;
        }
        Queue<Integer> qu=new LinkedList<>();
        qu.add(0);
        p[0]=-2;
        while (qu.size()!=0)
        {
            int k=qu.peek();
            qu.remove();
            for(int b:arr[k])
            {
                if(p[b]<0)
                {
                p[b]=k;
                qu.add(b);
                }
            }
        }
        /*
        for(int i=0;i<10;i++)
        {
            System.out.print(p[i]+" ");
        }

         */
        if(p[n-1]<0)
        {
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }
        else
        {
            int u=n-1;
            while(u>0)
            {
                arr1.add(u);
                u=p[u];
            }
            arr1.add(0);
        }
        Collections.reverse(arr1);
        System.out.println(arr1.size());
        for(int a:arr1)
        {
            System.out.print((a+1)+" ");
        }

    }
}