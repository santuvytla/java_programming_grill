import java.util.Scanner;

public class knapsackdp {
    /*
    There are
N
 items, numbered
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
), Item
i
 has a weight of
w
i
 and a value of
v
i
.

Taro has decided to choose some of the
N
 items and carry them home in a knapsack. The capacity of the knapsack is
W
, which means that the sum of the weights of items taken must be at most
W
.

Find the maximum possible sum of the values of items that Taro takes home.

Constraints
All values in input are integers.
1
≤
N
≤
100
1
≤
W
≤
10
5
1
≤
w
i
≤
W
1
≤
v
i
≤
10
9
Input
Input is given from Standard Input in the following format:

N

W

w
1

v
1

w
2

v
2

:

w
N

v
N

Output
Print the maximum possible sum of the values of items that Taro takes home.

Sample Input 1
Copy
3 8
3 30
4 50
5 60
Sample Output 1
Copy
90
Items
1
 and
3
 should be taken. Then, the sum of the weights is
3
+
5
=
8
, and the sum of the values is
30
+
60
=
90
.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int maxweight=sc.nextInt();
        int dp[]=new int[maxweight+1]; //for each weight i it stores the corresponding value
        for(int k=0;k<n;k++)
        {
            int weight=sc.nextInt();
            int value=sc.nextInt();
        //    for(int weight_already=0;weight_already<=(maxweight-weight);weight_already++) if allowed to take same item multiple times;
            for(int weight_already=maxweight-weight;weight_already>=0;weight_already--)
            {
                dp[weight_already+weight]=Math.max(dp[weight_already+weight],dp[weight_already]+value);
            }
        }
        int ans=0;
        for(int i=0;i<=maxweight;i++)
        {
            ans=Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
