import java.util.Scanner;

public class pairmatching {
    /*
    There are
N
 men and
N
 women, both numbered
1
,
2
,
…
,
N
.

For each
i
,
j
 (
1
≤
i
,
j
≤
N
), the compatibility of Man
i
 and Woman
j
 is given as an integer
a
i
,
j
. If
a
i
,
j
=
1
, Man
i
 and Woman
j
 are compatible; if
a
i
,
j
=
0
, they are not.

Taro is trying to make
N
 pairs, each consisting of a man and a woman who are compatible. Here, each man and each woman must belong to exactly one pair.

Find the number of ways in which Taro can make
N
 pairs, modulo
10
9
+
7
.

Constraints
All values in input are integers.
1
≤
N
≤
21
a
i
,
j
 is
0
 or
1
.
Input
Input is given from Standard Input in the following format:

N

a
1
,
1

…

a
1
,
N

:

a
N
,
1

…

a
N
,
N

Output
Print the number of ways in which Taro can make
N
 pairs, modulo
10
9
+
7
.

Sample Input 1
Copy
3
0 1 1
1 0 1
1 1 1
Sample Output 1
Copy
3
There are three ways to make pairs, as follows (
(i,j) denotes a pair of Man i and Woman j):
(1,2),(2,1),(3,3)(1,2),(2,3),(3,1)(1,3),(2,1),(3,2)
Sample Input 2
Copy
4
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0
Sample Output 2
Copy
1
There is one way to make pairs, as follows:

     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int can[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                can[i][j]=sc.nextInt();
            }
        }
        int dp[]=new int[(1<<n)+1];//2^n bitmasking of dp, masking is used selecting pairs not matched
        dp[0]=1; //one way to match no one
        for(int mask=0;mask<(1<<n)-1;mask++)
        {
            int a=Integer.bitCount(mask);
            for(int b=0;b<n;b++)
            {
                if(can[a][b]!=0&& ((mask)&(1<<b))==0) //if it is not matched
                {
                    int m2=(mask)^(1<<b); //new mask
                    dp[m2]+=dp[mask];
                }
            }
        }
        System.out.println(dp[(1<<n)-1]);
    }
}
