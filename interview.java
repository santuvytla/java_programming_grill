import java.util.Scanner;

public class interview {
    /*
    Blake is a CEO of a large company called "Blake Technologies". He loves his company very much and he thinks that his company should be the best.
     That is why every candidate needs to pass through the interview that consists of the following problem.

We define function f(x, l, r) as a bitwise OR of integers x l, x l + 1, ..., x r, where x i is the i-th element of the array x.
 You are given two arrays a and b of length n. You need to determine the maximum value of sum f(a, l, r) + f(b, l, r) among all possible 1 ≤ l ≤ r ≤ n
inputCopy
5
1 2 4 3 2
2 3 3 12 1
outputCopy
22
inputCopy
10
13 2 7 11 8 4 9 8 5 1
5 7 18 9 2 3 0 11 8 6
outputCopy
46

Because if a bit is already set to 1 and we include other element which has unset bit (0) at same position then
Bitwise OR will remain the same (i.e 1 at that position). So let’s take OR of all the elements in the array as
the sum will increase or remain same but will not decrease upon adding new elements.
so adding all bits only good to go
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int arr1[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            arr1[i]=sc.nextInt();
        }
        int sum1=arr[0];
        int sum2=arr1[0];
        for(int i=0;i<n;i++)
        {
            sum1|=arr[i];
            sum2|=arr1[i];
        }
        int ans=sum1+sum2;
        System.out.println(ans);
    }
}
