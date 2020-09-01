import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class asas {
    /*
    Given an array of n positive integers, your task is to count the number of subarrays having sum x.

Input

The first input line has two integers n and x: the size of the array and the target sum x.

The next line has n integers a1,a2,…,an: the contents of the array.

Output

Print one integer: the required number of subarrays.

Constraints
1≤n≤2⋅105
1≤x,ai≤109
Example

Input:
5 7
2 4 1 2 7

Output:
3
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        long p=sc.nextInt();
        long sum=0,ans=0;
        long arr[]=new long[s];
        Map<Long,Integer> ss=new HashMap<Long, Integer>();
        ss.putIfAbsent((long) 0,1);
        for(int i=-1000;i<0;i++)
            ss.putIfAbsent((long)i,0);
        for(int i=0;i< arr.length;i++)
        {
            arr[i]=sc.nextInt();
            sum+=arr[i];
            ans+=ss.get(sum-p);
            ss.putIfAbsent(sum,1);
        }
        System.out.println(ans);


    }
}
