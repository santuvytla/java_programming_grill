import java.util.Scanner;

public class twosets {
    /*
Your task is to count the number of ways numbers 1,2,…,n can be divided into two sets of equal sum.

For example, if n=7, there are four solutions:
{1,3,4,6} and {2,5,7}
{1,2,5,6} and {3,4,7}
{1,2,4,7} and {3,5,6}
{1,6,7} and {2,3,4,5}
Input

The only input line contains an integer n.

Output

Print the answer modulo 109+7.

Constraints
1≤n≤500
Example

Input:
7

Output:
4
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s=n*(n+1)/2;
        int k=s&1;
        int arr[]=new int[s+1];
        if(k>0)
        {
            System.out.println("0");
            System.exit(0);
        }
        s/=2;
        arr[0]=1;
        for(int i=1;i<n;i++)
        {
            for(int j=i*(i+1)/2;j>=i;j--)
            {
                arr[j]=arr[j]+arr[j-i];
            }
        }
        System.out.println(arr[s]);
    }
}
