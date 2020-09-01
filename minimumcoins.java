import java.util.Scanner;

public class minimumcoins {

        /*
        Consider a money system consisting of n coins. Each coin has a positive integer value. Your task is to produce a sum of money x using the available coins in such a way that the number of coins is minimal.

For example, if the coins are {1,5,7} and the desired sum is 11, an optimal solution is 5+5+1 which requires 3 coins.

Input

The first input line has two integers n and x: the number of coins and the desired sum of money.

The second line has n distinct integers c1,c2,…,cn: the value of each coin.

Output

Print one integer: the minimum number of coins. If it is not possible to produce the desired sum, print −1.

Constraints
1≤n≤100
1≤x≤106
1≤ci≤106
Example

Input:
3 11
1 5 7

Output:
3
         */
        public static void main(String[] args) {
            Scanner sc =new Scanner(System.in);

            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            int arr1[]=new int[1000];
            for(int i=1;i<=k;i++)
            {
                arr1[i]=Integer.MAX_VALUE;
                for(int j=0;j<n;j++)
                {
                    if(i>=arr[j])
                    {
                     arr1[i]=Math.min(arr1[i],arr1[i-arr[j]]+1);
                    }
                }
            }
            System.out.println(arr1[k]);

    }
}
