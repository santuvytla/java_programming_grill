import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class ExtraElement {
    /*
    A sequence a1,a2,…,ak is called an arithmetic progression if for each i from 1 to k elements satisfy the condition ai=a1+c⋅(i−1) for some fixed c.

For example, these five sequences are arithmetic progressions: [5,7,9,11], [101], [101,100,99], [13,97] and [5,5,5,5,5].
And these four sequences aren't arithmetic progressions: [3,1,2], [1,2,4,8], [1,−1,1,−1] and [1,2,3,3,3].

You are given a sequence of integers b1,b2,…,bn. Find any index j (1≤j≤n), such that if you delete bj from the sequence, you can reorder the remaining n−1 elements, so that you will get an arithmetic progression. If there is no such index, output the number -1.

Input
The first line of the input contains one integer n (2≤n≤2⋅105) — length of the sequence b. The second line contains n integers b1,b2,…,bn (−109≤bi≤109) — elements of the sequence b.

Output
Print such index j (1≤j≤n), so that if you delete the j-th element from the sequence, you can reorder the remaining elements, so that you will get an arithmetic progression. If there are multiple solutions, you are allowed to print any of them. If there is no such index, print -1.

Examples
inputCopy
5
2 6 8 7 4
outputCopy
4
inputCopy
8
1 2 3 4 5 6 7 8
outputCopy
1
inputCopy
4
1 2 4 8
outputCopy
-1
Note
Note to the first example. If you delete the 4-th element, you can get the arithmetic progression [2,4,6,8].

Note to the second example. The original sequence is already arithmetic progression, so you can delete 1-st or last element and you will get an arithmetical progression again.
     */
    public static int b[][]=new int[100][100];
    public static int n=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            b[i][0]=sc.nextInt();
            b[i][1]=i;
        }
        Arrays.sort(b, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]<o2[0])
                {
                    return 1;
                }
                else
                    return -1;
            }
        });
        test(0);
        test(1);
        int cs=2*b[1][0]-b[0][0];
        int i=2;
        while(i<n&&b[i][0]==cs)
        {
            i++;
            cs+=b[1][0]-b[0][0];
        }
        if(i<n)
        {
            test(i);
        }
        System.out.println("-1");

    }

    private static void test(int x) {
        Vector<Integer> v=new Vector<>();
        for(int i=0;i<n;i++)
        {
            if((i^x)!=0)
            {
                v.add(b[i][0]);
            }
        }
        if(v.size()<2)
        {
            System.out.println(b[x][1]+1);
            System.exit(0);
        }
        int d=v.get(1)-v.get(0);
        int s=v.get(1)+d;
        for(int i=2;i<v.size();i++,s+=d)
        {
            if((v.get(i)^s)!=0)
            {
                return;
            }
        }
        System.out.println(b[x][1]+1);
        System.exit(0);

    }
}
