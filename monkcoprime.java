import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class monkcoprime {
    /*
Monk visits the small town of Amathville. Amathville is a town of integers where numbers reside peacefully with each other. There are N citizens in Amathville i.e. integers 1 to N. Two integers are friends, only if they are mutually co-prime.
The Mayor of Amathville has a problem for Monk to solve. He wants Monk to build an army out of the citizens of Amathville, such that all the citizens in the army are friends i.e. each citizen in the army has to be friends with every other and the army has to be as large as possible. If there are multiple possible combinations of army of same size, choose the one that is lexicographically smallest, when sorted in ascending order. Check the sample case for further clarity.

Post this, Monk also has to arrange the army in the formation of a single line. Adjacent friends can have frictions between them, i.e If an integer I is placed after an integer J in the line, this amounts to a friction of (I * J) mod P units.

Help Monk solve the problem for the Mayor, by choosing the army and then minimizing the total friction of army. Report the minimum total value of friction.

Input:
The first line consists of integer T. T testcases follow.
The first line of each testcase consists of two space-separated integers N, P.

Output:
For each testcase, print the answer in a single line.

Constraints:



SAMPLE INPUT
1
4 6
SAMPLE OUTPUT
2
Explanation
The largest army Monk can choose is of 3 citizens: {1,2,3}, arranged in line as 1 - 2 - 3, having a friction = (1 * 2)mod 6 + (2 * 3)mod 6 = 2 units.
Monk can not choose the army of {1,3,4} as it is the same size and not lexicographically smaller than {1,2,3}
     */
    static final int INF = Integer.MAX_VALUE;
    static int[] pp = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int k = 0;
            while (k < pp.length && pp[k] <= n)
                k++;
            int[][] dp = new int[1 << k][k];
            for (int a = 0; a < 1 << k; a++)
                for (int i = 0; i < k; i++)
                    dp[a][i] = INF;
            for (int i = 0; i < k; i++)
                dp[1 << i][i] = 0;
            for (int a = 1; a < 1 << k; a++)
                for (int i = 0; i < k; i++)
                    if (dp[a][i] < INF)
                        for (int j = 0; j < k; j++)
                            if ((a & 1 << j) == 0) {
                                int b = a | 1 << j;
                                dp[b][j] = Math.min(dp[b][j], dp[a][i] + pp[i] * pp[j] % p);
                            }
            int min = INF;
            int a = (1 << k) - 1;
            for (int i = 0; i < k; i++)
                min = Math.min(min, dp[a][i]);
            pw.println(min);
        }
        pw.close();
    }
}