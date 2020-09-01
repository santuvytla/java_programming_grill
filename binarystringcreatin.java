import java.util.Scanner;

public class binarystringcreatin {
    /*
    For some binary string s (i.e. each character si is either '0' or '1'), all pairs of consecutive (adjacent) characters were written. In other words, all substrings of length 2 were written. For each pair (substring of length 2), the number of '1' (ones) in it was calculated.

You are given three numbers:

n0 — the number of such pairs of consecutive characters (substrings) where the number of ones equals 0;
n1 — the number of such pairs of consecutive characters (substrings) where the number of ones equals 1;
n2 — the number of such pairs of consecutive characters (substrings) where the number of ones equals 2.
For example, for the string s="1110011110", the following substrings would be written: "11", "11", "10", "00", "01", "11", "11", "11", "10". Thus, n0=1, n1=3, n2=5.

Your task is to restore any suitable binary string s from the given values n0,n1,n2. It is guaranteed that at least one of the numbers n0,n1,n2 is greater than 0. Also, it is guaranteed that a solution exists.

Input
The first line contains an integer t (1≤t≤1000) — the number of test cases in the input. Then test cases follow.

Each test case consists of one line which contains three integers n0,n1,n2 (0≤n0,n1,n2≤100; n0+n1+n2>0). It is guaranteed that the answer for given n0,n1,n2 exists.

Output
Print t lines. Each of the lines should contain a binary string corresponding to a test case. If there are several possible solutions, print any of them.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        if(b==0)
        {
            if(a!=0)
            {
                for(int i=0;i<=a;i++)
                {
                    System.out.print("0");
                }
            }
            else
            {
                for(int i=0;i<=c;i++)
                {
                    System.out.print("1");
                }
            }
        }
        else {
            for(int i=0;i<a;i++)
            {
                System.out.print("0");
            }
            System.out.print("01");
            b--;
            for(int i=0;i<c;i++)
            {
                System.out.print("1");
            }
            int d=0;
            while(b!=0)
            {
                System.out.print(d);
                d^=1;
                b--;
            }
        }
    }
}
