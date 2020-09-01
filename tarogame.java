import java.util.Scanner;

public class tarogame {
    /*
    Problem Statement
Taro and Jiro will play the following game against each other.

Initially, they are given a sequence
a
=
(
a
1
,
a
2
,
…
,
a
N
)
. Until
a
 becomes empty, the two players perform the following operation alternately, starting from Taro:

Remove the element at the beginning or the end of
a
. The player earns
x
 points, where
x
 is the removed element.
Let
X
 and
Y
 be Taro's and Jiro's total score at the end of the game, respectively. Taro tries to maximize
X
−
Y
, while Jiro tries to minimize
X
−
Y
.

Assuming that the two players play optimally, find the resulting value of
X
−
Y
.

Constraints
All values in input are integers.
1
≤
N
≤
3000
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
Print the resulting value of
X
−
Y
, assuming that the two players play optimally.

Sample Input 1

4
10 80 90 30
Sample Output 1

10
The game proceeds as follows when the two players play optimally (the element being removed is written bold):

Taro: (10, 80, 90, 30) → (10, 80, 90)
Jiro: (10, 80, 90) → (10, 80)
Taro: (10, 80) → (10)
Jiro: (10) → ()
Here,
X
=
30
+
80
=
110
 and
Y
=
90
+
10
=
100
.
     */
    public static void main(String[] args) {
        //intervals are best to consider, that is when dp[0][n-1] i.e dp[l][r]represents the entire array
        //max diffrence will be when l or r is taken and remaining interval is left for opponent and goes on..also if l==r
        // return array[l]
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        //logic
        int dp[][]=new int[1000][1000];
        for(int l=n-1;l>=0;l--)
        {
            for(int r=l;r<n;r++)
            {
                if(l==r)
                {
                    dp[l][r]=arr[l];
                }
                else
                {
                    dp[l][r]=Math.max(arr[l]-dp[l+1][r],arr[r]-dp[l][r-1]);// if l is taken remaining is score of opponent,else if r (left) interval is taken that score for oppent is in other interval.
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}
