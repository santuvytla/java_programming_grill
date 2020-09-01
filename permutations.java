import java.util.Scanner;

public class permutations {
    /*
    A permutation of length n is an array p=[p1,p2,…,pn], which contains every integer from 1 to n (inclusive) and, moreover, each number appears exactly once. For example, p=[3,1,4,2,5] is a permutation of length 5.

For a given number n (n≥2), find a permutation p in which absolute difference (that is, the absolute value of difference) of any two neighboring (adjacent) elements is between 2 and 4, inclusive. Formally, find such permutation p that 2≤|pi−pi+1|≤4 for each i (1≤i<n).

Print any such permutation for the given integer n or determine that it does not exist.

Input
The first line contains an integer t (1≤t≤100) — the number of test cases in the input. Then t test cases follow.

Each test case is described by a single line containing an integer n (2≤n≤1000).

Output
Print t lines. Print a permutation that meets the given requirements. If there are several such permutations, then print any of them. If no such permutation exists, print -1.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[100];
        if(n<4)
        {
            System.out.println("-1");
            System.exit(0);
        }
        for(int i=0;i<n/5;i++)
        {
            int j=i*5;
            a[j]=j+3;
            a[j+1]=j+1;
            a[j+2]=j+5;
            a[j+3]=j+2;
            a[j+4]=j+4;
        }
        if(n%5==1)
        {
            a[n-1]=n;
        }
        else if(n%5==2)
        {
            a[n-3]=n-1;
            a[n-2]=n-3;
            a[n-1]=n;
        }
        else if(n%5==3)
        {
            a[n-4]=n-2;
            a[n-3]=n;
            a[n-2]=n-4;
            a[n-1]=n-1;
        }
        else if(n%5==4)
        {
            a[n-4]=n-1;
            a[n-3]=n-3;
            a[n-2]=n;
            a[n-1]=n-2;
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(a[i]+" ");
        }


    }
}
