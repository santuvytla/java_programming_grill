import java.util.Scanner;

public class forestquery {
    /*
    You are given an n×n grid representing the map of a forest. Each square is either empty or contains a tree. The upper-left square has coordinates (1,1), and the lower-right square has coordinates (n,n).

Your task is to process q queries of the form: how many trees are inside a given rectangle in the forest?

Input

The first input line has two integers n and q: the size of the forest and the number of queries.

Then, there are n lines describing the forest. Each line has n characters: . is an empty square and * is a tree.

Finally, there are q lines describing the queries. Each line has four integers y1, x1, y2, x2 corresponding to the corners of a rectangle.

Output

Print the number of trees inside each rectangle.

Constraints
1≤n≤1000
1≤q≤2⋅105
1≤y1≤y2≤n
1≤x1≤x2≤n
Example

Input:
4 3
.*..
*.**
**..
****
2 2 3 4
3 1 3 1
1 1 2 2

Output:
3
1
2
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int q=sc.nextInt();
        int a[][]=new int[1000][1000];
        String arr[]=new String[m+1];
        for(int i=0;i<m;i++)
        {
            arr[i]=sc.next();
            for(int j=0;j<m;j++)
            {
                if(arr[i].charAt(j)=='*')
                {
                        ++a[i+1][j+1];
                }
            }
            for(int j=0;j<m;j++)
            {
                a[i+1][j+1]+=a[i+1][j];
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=1;j<=m;j++)
            {
                a[i+1][j]+=a[i][j];
            }
        }
        while (q!=0)
        {
            int y1=sc.nextInt();
            int x1=sc.nextInt();
            int y2=sc.nextInt();
            int x2=sc.nextInt();
            --y1;
            --x1;
            //principle of exclusion exclusion
            System.out.println((a[y2][x2]-a[y1][x2]-a[y2][x1]+a[y1][x1]));
            q--;
        }

    }
}
