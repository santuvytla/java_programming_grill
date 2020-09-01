import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class candylott {
    /*
    There are n children, and each of them independently gets a random integer number of candies between 1 and k.

What is the expected maximum number of candies a child gets?

Input

The only input line contains two integers n and k.

Output

Print the expected number rounded to six decimal places.

Constraints
1≤n≤100
1≤k≤100
Example

Input:
2 3

Output:
2.444444
     */
    public static void main(String[] args) {
        DecimalFormat dc=new DecimalFormat("##.000000");
        double ans=0;
        double arr[]=new double[(int) 1e5+1];
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        for(int i=1;i<=k;i++)
        {
            arr[i]=1;
            for(int j=0;j<n;j++)
            {
                arr[i]*= (double) i /k;
            }
        }
        for(int i=k;i>=1;i--)
        {
            arr[i]-=arr[i-1];
            ans+=i*arr[i];
        }
        System.out.println(dc.format(ans));

    }
}
