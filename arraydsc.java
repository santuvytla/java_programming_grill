import java.util.Scanner;

public class arraydsc {
    /*
    You know that an array has n integers between 1 and m, and the difference between two adjacent values is at most 1.

Given a description of the array where some values may be unknown, your task is to count the number of arrays that match the description.

Input

The first input line has two integers n and m: the array size and the upper bound for each value.

The next line has n integers x1,x2,…,xn: the contents of the array. Value 0 denotes an unknown value.

Output
Print one integer: the number of arrays modulo 109+7.

Constraints
1≤n≤105
1≤m≤100
0≤xi≤m
Example

Input:
3 5
2 0 2

Output:
3

Explanation: The arrays [2,1,2], [2,2,2] and [2,3,2] match the description
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int arr[]=new int[n];
        int arr1[][]=new int[p+1][1000];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            arr[i]--; //make 0 as -1(task)

        }
        for(int i=0;i<n;i++)
        {
            if(i>0){
                for(int j=0;j<p;j++)
                {
                    arr1[i][j]=arr1[i-1][j];
                    if(j>0)
                    {
                        arr1[i][j]+=arr1[i-1][j-1];
                    }
                    if(j<p-1)
                    {
                        arr1[i][j]+=arr1[i-1][j+1];
                    }
                }
                }
            else {
                for (int j = 0; j < p; j++) {
                    arr1[0][j] = 1;
                }
                }
            if (!(arr[i] < 0) )//wanted othr than 0 term which is -1 right now, for calculations
            {
                for (int j = 0; j < p; j++) // to make different terms as zero then given expect i.e all j as zeroes for that i;
                {
                    int k = j^arr[i];
                    if (k > 0) {
                        arr1[i][j] = 0;
                    }
                }

            }
        }

        int ans=0;
        for(int i=0;i<p;i++)
        {
            ans+=arr1[n-1][i];
        }
        System.out.println(ans);

    }
}
