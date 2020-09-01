import java.util.Scanner;

/*
You are given an array of n integers, and your task is to find two values (at distinct positions) whose sum is x.

Input

The first input line has two integers n and x: the array size and the target sum.

The second line has n integers a1,a2,…,an: the array values.

Output

Print two integers: the positions of the values. If there are several solutions, you may print any of them. If there are no solutions, print IMPOSSIBLE.

Constraints
1≤n≤2⋅105
1≤x,ai≤109
Example

Input:
4 8
2 7 5 1

Output:
2 4
 */
public class sumar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int pos[]=new int[2];
        int k=sc.nextInt();
        for(int p=0;p<n;p++)
        {
            arr[p]=sc.nextInt();
        }
        for(int i=0;i<1<<n;i++)
        {
            int kr[]=new int[n];
            int cs=0,o=0;
            for(int j=0;j<n;j++)
            {
                int b=i>>j&1;
                if(b>0)
                {
                    cs+=arr[j];
                    kr[o]=j+1;
                    o++;
                }
            }
            if(cs==k)
            {
                System.out.println(kr[0]+" "+kr[1]);
                System.exit(0);
            }
        }
        System.out.println("not possible");
    }
}
