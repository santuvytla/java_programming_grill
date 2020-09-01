import java.util.Scanner;

public class oddsum {
    /*
    You are given sequence a 1, a 2, ..., a n of integer numbers of length n. Your task is to find such subsequence that its sum is odd and maximum among all such subsequences.
     It's guaranteed that given sequence contains subsequence with odd sum.

Subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements.

You should write a program which finds sum of the best subsequence.

Input
The first line contains integer number n (1 ≤ n ≤ 105).

The second line contains n integer numbers a 1, a 2, ..., a n ( - 104 ≤ a i ≤ 104). The sequence contains at least one subsequence with odd sum.

Output
Print sum of resulting subseqeuence.

Examples
inputCopy
4
-2 2 -3 1
outputCopy
3
inputCopy
3
2 -5 -3
outputCopy
-1
Note
In the first example sum of the second and the fourth elements is 3.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int sum=0;
        int oddmin=100000,oddmax=-100000;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]>0) {
                sum += arr[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if((arr[i]&1)>0) {


                if (arr[i] > 0)
                {
                    oddmin=Math.min(oddmin,arr[i]);
                }
                else
                {
                    oddmax=Math.max(oddmax,arr[i]);
                }
            }
        }
        if(sum%2==0)
        {
            sum=sum-Math.min(Math.abs(oddmin),Math.abs((oddmax)));
        }
        System.out.println(sum);

    }
}
