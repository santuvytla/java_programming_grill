import java.util.Arrays;
import java.util.Scanner;

public class primesadda {
    /*
    Panda can do any problem anytime and anywhere. Panda is doing an extensive research on prime numbers. Milinda has got a question for Panda.
     The only way for Panda to impress Milinda is by solving this question.
Given a number N, find the minimum number of primatic numbers which sum upto N.
A primatic number refers to a number which is either a prime number or can be expressed as power of prime number to itself i.e. primeprime e.g. 4, 27, etc.
Note: 8, 32, etc are not primatic numbers.
Panda is very sad since he is unable to solve the problem. Please help Panda in solving this problem.

enter image description here

Input Format:
The first line will contain two integers: T, the number of test cases.
Each test case consists of a single integer N.

Output Format:
For each query output the minimum number of primatic numbers which can sum upto N.

Constraints:
1 <= T <= 105
2 <= N <= 104

Subtask 1:
T = 100, 2 <= N <= 1000 - 20 points

Subtask 2:
T = 105, 2 <= N <= 104 - 80 points

SAMPLE INPUT
2
6
3
SAMPLE OUTPUT
2
1
Explanation
The number 6 can be represented as 2 + 2 + 2, 3 + 3, etc. The smallest one among these is 3 + 3 consisting of 2 primatic numbers.
The number 3 is itself primatic. Hence the answer is 1.
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t= scan.nextInt();
        int min[] = new int[10001];
        Arrays.fill(min,89898);
        min[0] = 0;
        int pn[] = new int[10001];
        boolean p[] = new boolean[10001];
        for(int i=2;i<101;++i)
        {
            if(!p[i])
                for(int j=i*i;j<10001;j+=i)
                    p[j] = true;
        }
        int index = 0;
        for(int i=2;i<10001;++i)
            if(!p[i])
                pn[index++] = i;
        int last = index-1;
        for(int i=0;i<=last;++i)
        {
            int temp = (int)Math.pow(pn[i], pn[i]);
            if(temp<10001)
                pn[index++] = temp;
            else break;
        }
        pn[index++] = 898989;
        Arrays.sort(pn,0,index);
        for(int i=2;i<10001;++i)
        {
            for(int j=0;pn[j]<=i;++j)
                if(min[i]>1+min[i-pn[j]])
                    min[i] = 1+min[i-pn[j]];
        }

        StringBuilder sb = new StringBuilder("");
        while(t-->0)
        {
            sb.append(min[scan.nextInt()]+"\n");
        }
        System.out.println(sb);
    }
}
