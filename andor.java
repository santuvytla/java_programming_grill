import java.util.Scanner;

public class andor {
    /*
    Gottfried learned about binary number representation. He then came up with this task and presented it to you.

You are given a collection of n non-negative integers a1,…,an. You are allowed to perform the following operation:
 choose two distinct indices 1≤i,j≤n. If before the operation ai=x, aj=y, then after the operation ai=x AND y, aj=x OR y,
 where AND and OR are bitwise AND and OR respectively (refer to the Notes section for formal description). The operation may be performed any number of times (possibly zero).

After all operations are done, compute ∑ni=1a2i — the sum of squares of all ai. What is the largest sum of squares you can achieve?

Input
The first line contains a single integer n (1≤n≤2⋅105).

The second line contains n integers a1,…,an (0≤ai<220).

Output
Print a single integer — the largest possible sum of squares that can be achieved after several (possibly zero) operations.

Examples
inputCopy
1
123
outputCopy
15129
inputCopy
3
1 3 5
outputCopy
51
inputCopy
2
349525 699050
outputCopy
1099509530625
Note
In the first sample no operation can be made, thus the answer is 123.

In the second sample we can obtain the collection 1,1,7, and 12+12+27=51.

If x and y are represented in binary with equal number of bits (possibly with leading zeros),
then each bit of x AND y is set to 1 if and only if both corresponding bits of x and y are set to 1.
Similarly, each bit of x OR y is set to 1 if and only if at least one of the corresponding bits of x and y are set to 1.
 For example, x=3 and y=5 are represented as 0112 and 1012 (highest bit first). Then, x AND y=0012=1, and x OR y=1112=7.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int ans[]=new int[k];
        int arr[]=new int[k];
        int count[]=new int[25];
        for(int i=0;i<k;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int a:arr)
        {
            for(int c=0;c<25;c++)
            {
                if((a&(1<<c))!=0)
                {
                    count[c]++;
                }
            }
        }
        for(int c=0;c<25;c++)
        {
            for(int i=0;i<k;i++)
            {
                if(count[c]>i)
                {
                    ans[i]+=1<<c;
                }
            }
        }
        int aa=0;
        for(int i:ans)
        {
            aa+=i*i;
        }
        System.out.println(aa);



    }
}
