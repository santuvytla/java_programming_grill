import java.util.Scanner;

public class consequtivesums {
    /*
    The array a=[a1,a2,…,an] (1≤ai≤n) is given. Its element ai is called special if there exists a pair of indices l and r (1≤l<r≤n) such that ai=al+al+1+…+ar. In other words, an element is called special if it can be represented as the sum of two or more consecutive elements of an array (no matter if they are special or not).

Print the number of special elements of the given array a.

For example, if n=9 and a=[3,1,4,1,5,9,2,6,5], then the answer is 5:

a3=4 is a special element, since a3=4=a1+a2=3+1;
a5=5 is a special element, since a5=5=a2+a3=1+4;
a6=9 is a special element, since a6=9=a1+a2+a3+a4=3+1+4+1;
a8=6 is a special element, since a8=6=a2+a3+a4=1+4+1;
a9=5 is a special element, since a9=5=a2+a3=1+4.
Please note that some of the elements of the array a may be equal — if several elements are equal and special, then all of them should be counted in the answer.

Input
The first line contains an integer t (1≤t≤1000) — the number of test cases in the input. Then t test cases follow.

Each test case is given in two lines. The first line contains an integer n (1≤n≤8000) — the length of the array a. The second line contains integers a1,a2,…,an (1≤ai≤n).

It is guaranteed that the sum of the values of n for all test cases in the input does not exceed 8000.

Output
Print t numbers — the number of special elements for each of the given arrays.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        int c[]=new int[n+1];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            c[i+1]=0;
        }
        for(int i=0;i<n;i++)
        {
            int sum=a[i];
            for(int j=i+1;j<n;j++)
            {
                sum+=a[j];
                if(sum>0&&sum<=n)
                {
                    c[sum]++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            if(c[a[i]]>0)
            {
                ans++;
            }
        }
        System.out.println(ans);

    }
}
