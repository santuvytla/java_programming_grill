import java.util.Scanner;

public class tpermutatin {
    /*
    Let
N
 be a positive integer. You are given a string
s
 of length
N
−
1
, consisting of < and >.

Find the number of permutations
(
p
1
,
p
2
,
…
,
p
N
)
 of
(
1
,
2
,
…
,
N
)
 that satisfy the following condition, modulo
10
9
+
7
:

For each
i
 (
1
≤
i
≤
N
−
1
),
p
i
<
p
i
+
1
 if the
i
-th character in
s
 is <, and
p
i
>
p
i
+
1
 if the
i
-th character in
s
 is >.
 input:
 4
<><
output:
5
example is (1,3,2,4)---1<3>2<4
     */
    public static void main(String[] args) {
/*
individually finding dp is very hard...because we should be fixing each value also remeber that value
so that it will not be used again also previous and next equality should satisfy.
so best thing is if we fix last number and chck the possiblibilities of subsets and combinations of other numbers we may get the required..
repeat by fixing all n numbers in last position
dp[i][j]---the number of ways to put the numbers in prefix of size i when the suffix or last number is j
 */

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String s=sc.next();
        char c[]=s.toCharArray();
        int dp[][]=new int[n+1][n+1];
        dp[1][1]=1;//1way for 1 as last
        for(int len=2;len<=n;len++)
        {
            for(int b=1;b<=len;b++) //iterate a number to put here
            {
                for(int a=1;a<=len-1;a++) //to take number that is here a moment ago..len-1
                {
                    int real_a=a;
                    if(a>=b)
                    {
                        ++real_a;
                    }
                   assert(real_a!=b);
                    if(real_a<b!=(c[len-2]=='<'))
                    {
                        continue;
                    }
                   dp[len][b]+=dp[len-1][a];
                }
            }
        }
        int ans=0;
        for(int b=1;b<=n;b++)
        {
            ans+=dp[n][b];
        }
        System.out.println(ans);

    }
}
