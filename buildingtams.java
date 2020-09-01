import java.util.Scanner;
import java.util.Vector;

public class buildingtams {
    /*
    There are n pupils in Uolevi's class, and m friendships between them. Your task is to divide the pupils into two teams in such a way that no two pupils in a team are friends. You can freely choose the sizes of the teams.

    Input

    The first input line has two integers n and m: the number of pupils and friendships. The pupils are numbered 1,2,…,n.

            Then, there are m lines describing the friendships. Each line has two integers a and b: pupils a and b are friends.

    Every friendship is between two different pupils. You can assume that there is at most one friendship between any two pupils.

    Output

    Print an example of how to build the teams. For each pupil, print "1" or "2" depending on to which team the pupil will be assigned. You can print any valid team.

    If there are no solutions, print "IMPOSSIBLE".

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
            1 2 2 1 2
    */
    public static Vector<Integer> arr[] = new Vector[10000];
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
        for(int i=0;i<4*n;i++)
        {
            p[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            if(p[i]<0)
            {
                dfs(i);
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.print((p[i]+1)+" ");
        }

    }

    private static void dfs(int i) {
        int cu=0;
        if(~p[i]!=0)
        {
            if((p[i]^cu)!=0)
            {
                System.out.println("IMPOSSIBLE");
                System.exit(0);
            }
            return;
        }
        p[i]=cu;
        for(int b:arr[i])
        {
            dfs(b,cu^1);
        }

    }
    private static void dfs(int i,int cu) {

        if(~p[i]!=0)
        {
            if((p[i]^cu)!=0)
            {
                System.out.println("IMPOSSIBLE");
                System.exit(0);
            }
            return;
        }
        p[i]=cu;
        for(int b:arr[i])
        {
            dfs(b,cu^1);
        }

    }
}
