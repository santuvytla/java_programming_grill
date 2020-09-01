package com.company;

import java.io.*;
import java.util.InputMismatchException;

/*
Koa the Koala has two strings A and B of the same length n (|A|=|B|=n) consisting of the first 20 lowercase English alphabet letters (ie. from a to t).

In one move Koa:

selects some subset of positions p1,p2,…,pk (k≥1;1≤pi≤n;pi≠pj if i≠j) of A such that Ap1=Ap2=…=Apk=x (ie. all letters on this positions are equal to some letter x).
selects a letter y (from the first 20 lowercase letters in English alphabet) such that y>x (ie. letter y is strictly greater alphabetically than x).
sets each letter in positions p1,p2,…,pk to letter y. More formally: for each i (1≤i≤k) Koa sets Api=y.
Note that you can only modify letters in string A.

Koa wants to know the smallest number of moves she has to do to make strings equal to each other (A=B) or to determine that there is no way to make them equal. Help her!

Input
Each test contains multiple test cases. The first line contains t (1≤t≤10) — the number of test cases. Description of the test cases follows.

The first line of each test case contains one integer n (1≤n≤105) — the length of strings A and B.

The second line of each test case contains string A (|A|=n).

The third line of each test case contains string B (|B|=n).

Both strings consists of the first 20 lowercase English alphabet letters (ie. from a to t).

It is guaranteed that the sum of n over all test cases does not exceed 105.

Output
For each test case:

Print on a single line the smallest number of moves she has to do to make strings equal to each other (A=B) or −1 if there is no way to make them equal.

Example
inputCopy
5
3
aab
bcc
4
cabc
abcb
3
abc
tsr
4
aabd
cccd
5
abcbd
bcdda
outputCopy
2
-1
3
2
-1
Note
In the 1-st test case Koa:
selects positions 1 and 2 and sets A1=A2= b (aab→bbb).
selects positions 2 and 3 and sets A2=A3= c (bbb→bcc).
In the 2-nd test case Koa has no way to make string A equal B.
In the 3-rd test case Koa:
selects position 1 and sets A1= t (abc→tbc).
selects position 2 and sets A2= s (tbc→tsc).
selects position 3 and sets A3= r (tsc→tsr).

 */
public class A implements Runnable
{
    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        w = new PrintWriter(System.out);
        t = Integer.parseInt(in.nextLine());
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(in.nextLine());
            s1 = in.nextLine();
            s2 = in.nextLine();
            getRes();
        }

        w.flush();
        w.close();
    }

    static PrintWriter w;
    static int t, k, n;
    static Integer[] arr;
    static String s1, s2;

    private static void getRes() {
        int[][] count = new int[20][20];
        for (int i = 0; i < n; i++) {
            int a = s1.charAt(i) - 'a', b = s2.charAt(i) - 'a';
            if (b < a) {
                w.println(-1);
                return;
            }
            count[a][b]++;
        }
        int res = 0;
        for (int i = 0; i < 20; i++) {
            int j  = i + 1;
            while (j < 20) {
                if (count[i][j] > 0) {
                    res++;
                    break;
                }
                j++;
            }
            int col = j;
            while (j < 20) {
                count[col][j] += count[i][j++];
            }
        }
        w.println(res);
    }

    static class InputReader
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream)
        {
            this.stream = stream;
        }

        public int read()
        {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars)
            {
                curChar = 0;
                try
                {
                    numChars = stream.read(buf);
                }
                catch (IOException e)
                {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt()
        {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-')
            {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do
            {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do
            {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-')
            {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.')
            {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.')
            {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString()
        {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do
            {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c)
        {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next()
        {
            return readString();
        }

        public interface SpaceCharFilter
        {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String args[]) throws Exception
    {
        new Thread(null, new A(),"Main",1<<27).start();
    }

}
