import java.util.Scanner;

public class slimes {
    /*
    There are
N
 slimes lining up in a row. Initially, the
i
-th slime from the left has a size of
a
i
.

Taro is trying to combine all the slimes into a larger slime. He will perform the following operation repeatedly until there is only one slime:

Choose two adjacent slimes, and combine them into a new slime. The new slime has a size of
x
+
y
, where
x
 and
y
 are the sizes of the slimes before combining them. Here, a cost of
x
+
y
 is incurred. The positional relationship of the slimes does not change while combining slimes.
Find the minimum possible total cost incurred.

Constraints
All values in input are integers.
2
≤
N
≤
400
1
≤
a
i
≤
10
9
Input
Input is given from Standard Input in the following format:

N

a
1

a
2

…

a
N

Output
Print the minimum possible total cost incurred.

Sample Input 1
Copy
4
10 20 30 40
Sample Output 1
Copy
190
Taro should do as follows (slimes being combined are shown in bold):

(10, 20, 30, 40) → (30, 30, 40)
(30, 30, 40) → (60, 40)
(60, 40) → (100)

     */
    public static int n=0;
   public static int arr[]=new int[1000];
    public static void main(String[] args) {
        //if u think it of as a binary tree,we need the node value to minimum for the interval of nodes.
        //dp[i][j]=the minimum cost of combining in the interval of {i,j}
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int dp[][]=new int[n+1][n+1];
        for(int l=n-1;l>=0;l--)
        {
            for(int r=l;r<n;r++)
            {
                if(l==r)
                {
                    dp[l][r]=0;
                }
                else
                {
                    dp[l][r]=1000000;
                    for(int i=l;i<=r-1;i++) { //r-1 beacause right child also requires something when you think of binary three
                        dp[l][r] = Math.min(dp[l][r],dp[l][i]+dp[i+1][r]+sum(l,r));
                    }
                }
            }

        }
        System.out.println(dp[0][n-1]);
    }

    private static int sum(int l, int r) {
        int sum=0;
        for(int i=l;i<=r;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }
}
