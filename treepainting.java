import java.util.Scanner;
import java.util.Vector;

public class treepainting {
    /*
    There is a tree with
N vertices, numbered
1
,
2
,
…
,
N
. For each
i
 (
1
≤
i
≤
N
−
1
), the
i
-th edge connects Vertex
x
i
 and
y
i
.

Taro has decided to paint each vertex in white or black. Here, it is not allowed to paint two adjacent vertices both in black.

Find the number of ways in which the vertices can be painted, modulo
10
9
+
7
.
input:
3
1 2
2 3
output:
5
Basic idea is any tree we go with bottom up approach,we take a subset of tree from bottom and check possibilities of colouring
for next subset,we only care about root element colour not the colours of children.

     */
    public static int arr[]=new int[2];//0 has the no of ways of black and 1 has no of ways of white
    public static Vector<Integer> edges[]=new Vector[1000];
    public static void main(String[] args) {
        for(int i=0;i<1000;i++)
        {
            edges[i]=new Vector<>();
        }
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n-1;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            edges[a].add(b);
            edges[b].add(a);
        }
       int ans[]= dfs(1,-1); //thinking 1 is the root and -1 is the parent which is fake one
        int sol=ans[0]+ans[1];
        System.out.println(sol);
    }
    //only after processing children, i will do something that is if parent is white then children are black and vice versa,and it influences its parent.i1 is parent
    private static int[] dfs(int i, int i1) {
        int all_white=1;//it means it can be painted black
        int s_black=0;//it means someting that is black is zero initially

        for(int a:edges[i])
        {
            if(a!=i1)
            {
               int arr1[]= dfs(a,i);
               int mem_all_white=all_white;
               all_white=arr1[1]*all_white;
               s_black=mem_all_white*arr1[0]+s_black*(arr1[0]+arr1[1]);//all is white and this child is black+something is already black and here ways to white and black paint
            }
        }
        int re[]={all_white,all_white+s_black};
        return re;
//return no of ways of black which means everything should be white..this vertex is white if everything is white or it can be painted black.
    }

}
