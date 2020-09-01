import java.util.Scanner;

public class greatcommondii {
    /*
    You are given an array of n positive integers. Your task is to find two integers such that their greatest common divisor is as large as possible.

Input

The first input line has an integer n: the size of the array.

The second line has n integers x1,x2,…,xn: the contents of the array.

Output

Print the maximum greatest common divisor.

Constraints
2≤n≤2⋅105
1≤xi≤106
Example

Input:
5
3 14 15 7 9

Output:
7
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int max=0;
        int arr[]=new int[k];
        for(int i=0;i<k;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<k-1;i++)
        {
            for(int j=i+1;j<k;j++)
            {
                int a=gcd(arr[i],arr[j]);
                max=Math.max(max,a);
            }
        }
        System.out.println(max);
    }

    private static int gcd(int i, int i1) {
        if(i==0)
        {
            return i1;
        }
        if(i1==0)
        {
            return i;
        }
        if(i==i1)
        {
            return i;
        }
        if(i>i1)
        {
           return gcd(i-i1,i1);
        }

          return gcd(i,i1-i);

    }
}
