import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class courscompl {
    /*
    You have to complete n courses. There are m requirements of the form "course a has to be completed before course b". Your task is to find an order in which you can complete the courses.

Input

The first input line has two integers n and m: the number of courses and requirements. The courses are numbered 1,2,…,n.

After this, there are m lines describing the requirements. Each line has two integers a and b: course a has to be completed before course b.

Output

Print an order in which you can complete the courses. You can print any valid order that includes all the courses.

If there are no solutions, print "IMPOSSIBLE".

Constraints
1≤n≤105
1≤m≤2⋅105
1≤a,b≤n
Example

Input:
5 3
1 2
3 1
4 5

Output:
3 4 1 5 2
     */
   public static Vector<Integer> ans=new Vector<>();
    public static Vector<Integer> arr[] = new Vector[10000];
    public static int p[]=new int[10000];
    public static boolean vis[] = new boolean[1000];
    public static boolean act[]=new boolean[1000];
    public static Vector<Integer> arr1 = new Vector<Integer>();
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
        }
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        Collections.reverse(ans);
        for(int p:ans)
        {
            System.out.print((p+1)+" ");
        }
    }

    private static void dfs(int i) {
        vis[i] = true;
        act[i]=true;
        for (int b : arr[i]) {
            if (act[b]) {

                System.out.println("Impossible");
                System.exit(0);


            } else {
                if(!vis[b]) {
                    p[b] = i;
                    dfs(b);
                }
            }
        }
        act[i]=false;
        ans.add(i);



    }
}
