import java.util.Scanner;

public class gridpath {
    /*
grid path from start to end which as walls in between as '#'
input
3 4
...#
.#..
....
output
3
input
5 5
..#..
.....
#...#
.....
..#..
output:
24
     */
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        char map[][]=new char[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                map[i][j]=sc.next().charAt(0);
            }
        }
        int dp[][]=new int[r+1][c+1]; //irrespective of going right or down,count number of paths till that cell.
        dp[0][0]=1;
        for(int row=0;row<r;row++)
        {
            for(int col=0;col<c;col++)
            {
                int ar[]={row,row+1};
                for(int r2:ar)
                {
                    int c2=col;
                    if(r2==row)
                    {
                        c2=col+1;
                    }
                    if(r2<r&&c2<c&&map[r2][c2]=='.')
                    {
                        dp[r2][c2]+=dp[row][col];
                    }
                }
            }
        }
        System.out.println(dp[r-1][c-1]);

    }
}
