import java.util.*;

public class divisum {
    /*
    Given an array of n integers, your task is to count the number of subarrays where the sum of values is divisible by n.

Input

The first input line has an integer n: the size of the array.

The next line has n integers a1,a2,…,an: the contents of the array.

Output

Print one integer: the required number of subarrays.

Constraints
1≤n≤2⋅105
−109≤ai≤109
Example

Input:
5
3 1 2 7 4

Output:
1

     */
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        long sum=0,ans=0;
        long arr[]=new long[s];
        Map<Long,Integer> ss=new HashMap<Long, Integer>();
        for(int i=1;i<s;i++)
        {
            ss.put((long)i,0);
        }
        ss.put((long)0,1);
        for(int i=0;i< arr.length;i++)
        {
            arr[i]=sc.nextInt();
            sum=(sum+arr[i]%s+s)%s;
            ans+=ss.get(sum);
            if(ss.containsKey(sum)){
                int freq=ss.get(sum);
                freq++;
                ss.put(sum,freq);
            }
            else {
                ss.putIfAbsent(sum, 1);
            }
        }
        System.out.println(ans);

    }
}
/*
for(int i=0;i<5;i++)
        {
            ss.put((long)i,0);
        }
 */