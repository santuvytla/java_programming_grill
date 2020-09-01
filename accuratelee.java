import java.util.Scanner;

public class accuratelee {
    /*
    Lee was cleaning his house for the party when he found a messy string under the carpets. Now he'd like to make it clean accurately and in a stylish way...

The string s he found is a binary string of length n (i. e. string consists only of 0-s and 1-s).

In one move he can choose two consecutive characters si and si+1, and if si is 1 and si+1 is 0, he can erase exactly one of them (he can choose which one to erase but he can't erase both characters simultaneously). The string shrinks after erasing.

Lee can make an arbitrary number of moves (possibly zero) and he'd like to make the string s as clean as possible. He thinks for two different strings x and y, the shorter string is cleaner, and if they are the same length, then the lexicographically smaller string is cleaner.

Now you should answer t test cases: for the i-th test case, print the cleanest possible string that Lee can get by doing some number of moves.

Small reminder: if we have two strings x and y of the same length then x is lexicographically smaller than y if there is a position i such that x1=y1, x2=y2,..., xi−1=yi−1 and xi<yi.

Input
The first line contains the integer t (1≤t≤104) — the number of test cases.

Next 2t lines contain test cases — one per two lines.

The first line of each test case contains the integer n (1≤n≤105) — the length of the string s.

The second line contains the binary string s. The string s is a string of length n which consists only of zeroes and ones.

It's guaranteed that sum of n over test cases doesn't exceed 105.

Output
Print t answers — one per test case.

The answer to the i-th test case is the cleanest string Lee can get after doing some number of moves (possibly zero).

Example
inputCopy
5
10
0001111111
4
0101
8
11001101
10
1110000000
1
1
outputCopy
0001111111
001
01
0
1
Note
In the first test case, Lee can't perform any moves.

In the second test case, Lee should erase s2.

In the third test case, Lee can make moves, for example, in the following order: 11001101 → 1100101 → 110101 → 10101 → 1101 → 101 → 01.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[] line=sc.next().toCharArray();
        int pref=0;
        int suff=0;
        boolean hasz=false,haso=false;
        for(char a:line)
        {
            if(a=='0')
            {
                hasz=true;
            }
            else
            {
                haso=true;
            }
        }
        if(!hasz||!haso)
        {
            System.out.println(line);
            System.exit(0);
        }
        for(int i=0;i<n;i++)
        {
            if(line[i]=='1')
            {
                pref=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(line[i]=='0')
            {
                suff=i;
                break;
            }
        }
        if(pref+(n-suff+1)>n)
        {
            System.out.println(line);
            System.exit(0);
        }
        for(int i=0;i<pref;i++)
        {
            System.out.print(line[i]);
        }

        for(int i=suff;i<n;i++)
        {
            System.out.print(line[i]);
        }


    }
}
