import java.util.Scanner;

public class removedigit {
    /*
    You are given an integer n. On each step, you may substract from it any one-digit number that appears in it.

How many steps are required to make the number equal to 0?

Input

The only input line has an integer n.

Output

Print one integer: the minimum number of steps.

Constraints
1≤n≤106
Example

Input:
27

Output:
5

Explanation: An optimal solution is 27→20→18→10→9→0.

     */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[(int) 1e6];
        for(int i=1;i<=n;i++)
        {
            arr[i]=10000;
            int n2=i;
            while(n2>0)
            {
                int k=n2%10;
                arr[i]=Math.min(arr[i],arr[i-k]+1);
                n2/=10;

            }

        }
        System.out.println(arr[n]);

    }
}

