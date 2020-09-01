package com.company;

public class operationdivisorntom {
     private static final int MAX =(int)1e5;
    public static void main(String[] args) {
        int n=8,m=12;
        int op=mins(n,m);
        if(op>=100000)
            System.out.println("-1");
        else
        System.out.println(op);
    }
    public static int dp[]=new int[MAX];
    private static int mins(int N, int M) {
        for (int i = N; i <= M; i++) {
            dp[i] = -1;
        }
        return minss(N,M);
    }

    private static int minss(int cur, int M) {
        if(cur>M)
            return 100000;
        if (cur == M)
            return 0;

        if (dp[cur] != -1)
            return dp[cur];

        int op = 100000;

        for (int i = 2; i * i <= cur; i++) {

            if (cur % i == 0) {

                if (i % 2 == 0) {

                    op = Math.min(op, (cur/i) + minss(cur + i, M));
                }
                if ((cur / i) != i && (cur / i) % 2 == 0) {

                    op = Math.min(op,
                            (cur/(cur/i)) + minss(cur + (cur / i), M));
                }
            }
        }
        return dp[cur]=op;
    }

}
