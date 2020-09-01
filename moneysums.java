import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class moneysums {
    /*
You have n coins with certain values. Your task is to find all money sums you can create using these coins.

Input

The first input line has an integer n: the number of coins.

The next line has n integers x1,x2,…,xn: the values of the coins.

Output

First print an integer k: the number of distinct money sums. After this, print all possible sums in increasing order.

Constraints
1≤n≤100
1≤xi≤1000
Example

Input:
4
4 2 5 2

Output:
9
2 4 5 6 7 8 9 11 13
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int dp[]=new int[10000];
        dp[0]=1;
        for(int j=0;j<n;j++)
        {
            for(int i=1000;i>0;i--)
            {
                if(i>=arr[j])
                {
                    dp[i]|=dp[i-arr[j]];
                }
            }
        }
        List<Integer> a=new LinkedList<>();
        for(int i=1;i<=1000;i++)
        {
            if(dp[i]>0)
            {
                a.add(i);
            }
        }
        System.out.println(a.size());
        for(int b:a)
        {
            System.out.print(b+" ");
        }
    }
}
