import java.util.Scanner;

public class christmasgift {
    /*
    There are n children at a Christmas party, and each of them has brought a gift. The idea is that everybody will get a gift brought by someone else.

In how many ways can the gifts be distributed?

Input

The only input line has an integer n: the number of children.

Output

Print the number of ways modulo 109+7.

Constraints
1≤n≤106
Example

Input:
4

Output:
9
     */
    public static void main(String[] args) {
        //counting the number of dearrangements
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int dp[]=new int[k+1];
        dp[0]=1;
        dp[1]=0;
        for(int i=2;i<=k;i++)
        {
            dp[i]=(i-1)*dp[i-1]+(i-1)*dp[i-2];
        }
        System.out.println(dp[k]);


    }
}
