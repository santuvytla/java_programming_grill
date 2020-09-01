/*
Input:
3
1 2 300
3 3 600
1 4 800
output:
2900
900
0
0

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.function.IntUnaryOperator;
import java.util.function.LongUnaryOperator;

public class Railroute {
    static In in = new In();
    static Out out = new Out();
    static final long inf = 0x1fffffffffffffffL;
    static final int iinf = 0x3fffffff;
    static long mod = 1000000007;

    void solve() {
        int n = in.nextInt();
        IntPair[] pos = new IntPair[n];
        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            pos[i] = new IntPair(in.nextInt(), in.nextInt());
            p[i] = in.nextLong();
        }
        long[][] dp = new long[n + 1][1 << n];
        for (int i = 1; i < 1 << n; i++) {
            long val = 0;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    val += Math.min(Math.abs(pos[j].x), Math.abs(pos[j].y)) * p[j];
                }
            }
            dp[0][i] = val;
            long minX = inf;
            long minY = inf;
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 0) {
                    continue;
                }
                long scoreX = 0;
                long scoreY = 0;
                for (int k = 0; k < n; k++) {
                    if (((i >> k) & 1) == 0) {
                        continue;
                    }
                    scoreX += Math.abs(pos[j].x - pos[k].x) * p[k];
                    scoreY += Math.abs(pos[j].y - pos[k].y) * p[k];
                }
                minX = Math.min(minX, scoreX);
                minY = Math.min(minY, scoreY);
            }
            dp[1][i] = Math.min(dp[0][i], Math.min(minX, minY));
        }
        for (int i = 1; i <= n; i++) {
            for (int mask = 0; mask < 1 << n; mask++) {
                dp[i][mask] = i >= 2 ? dp[i - 1][mask] : Math.min(dp[i][mask], dp[i - 1][mask]);
                for (int j = mask; j > 0; j = (j - 1) & mask) {
                    dp[i][mask] = Math.min(dp[i][mask], dp[1][j] + dp[i - 1][mask ^ j]);
                }
            }
        }
        for (int i = 0; i <= n; i++) {
            out.println(dp[i][(1 << n) - 1]);
        }
    }

    public static void main(String[]$) {
        new Railroute().solve();
        out.flush();
    }
}

class IntPair implements Comparable<IntPair> {
    int x;
    int y;

    IntPair(int first, int second) {
        this.x = first;
        this.y = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof IntPair)) {
            return false;
        }
        IntPair that = (IntPair)o;
        return x == that.x && y == that.y;
    }

    @Override
    public int compareTo(IntPair o) {
        return x == o.x ? Integer.compare(y, o.y) : Integer.compare(x, o.x);
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", x, y);
    }
}

class In {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 0x10000);
    private StringTokenizer tokenizer;

    String next() {
        try {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        } catch (IOException ignored) {
        }
        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    char[] nextCharArray() {
        return next().toCharArray();
    }

    char[][] nextCharGrid(int n, int m) {
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = next().toCharArray();
        }
        return a;
    }

    int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    int[] nextIntArray(int n, IntUnaryOperator op) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = op.applyAsInt(nextInt());
        }
        return a;
    }

    long[] nextLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        return a;
    }

    long[] nextLongArray(int n, LongUnaryOperator op) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = op.applyAsLong(nextLong());
        }
        return a;
    }

    List<List<Integer>> nextEdges(int n, int m) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = nextInt() - 1;
            int v = nextInt() - 1;
            res.get(u).add(v);
            res.get(v).add(u);
        }
        return res;
    }
}

class Out {
    private PrintWriter out = new PrintWriter(System.out);
    boolean autoFlush = false;

    void println(Object... a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (Object obj : a) {
            joiner.add(String.valueOf(obj));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(char[] s) {
        out.println(String.valueOf(s));
        if (autoFlush) {
            out.flush();
        }
    }

    void println(int[] a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (int i : a) {
            joiner.add(Integer.toString(i));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void println(long[] a) {
        StringJoiner joiner = new StringJoiner(" ");
        for (long i : a) {
            joiner.add(Long.toString(i));
        }
        out.println(joiner);
        if (autoFlush) {
            out.flush();
        }
    }

    void flush() {
        out.flush();
    }
}