import java.awt.image.DataBufferUShort;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
/*
Time limit: 1.00 s Memory limit: 512 MB
Given an array of n integers, your task is to find the maximum sum of values in a contiguous, nonempty subarray.

Input

The first input line has an integer n: the size of the array.

The second line has n integers x1,x2,…,xn: the array values.

Output

Print one integer: the maximum subarray sum.

Constraints
1≤n≤2⋅105
−109≤xi≤109
Example

Input:
8
-1 3 -2 5 3 -5 2 2

Output:
9
 */

public class sumarr {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DecimalFormat dd=new DecimalFormat("0.##");
        dd.setRoundingMode(RoundingMode.DOWN);
        int n=sc.nextInt();
        int arr[]=new int[n];
        double sum= Double.NEGATIVE_INFINITY,max=Double.NEGATIVE_INFINITY;
        for(int p=0;p<n;p++)
        {
            arr[p]=sc.nextInt();
            sum=Math.max(arr[p],sum+arr[p]);
            max=Math.max(max,sum);
        }

        System.out.println(dd.format(max));

    }
}
