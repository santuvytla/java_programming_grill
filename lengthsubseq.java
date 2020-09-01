import java.util.Scanner;

public class lengthsubseq {
    /*
    B. Codeforces Subsequences
time limit per test2 seconds
memory limit per test512 megabytes
inputstandard input
outputstandard output
Karl likes Codeforces and subsequences. He wants to find a string of lowercase English letters that contains at least k subsequences codeforces. Out of all possible strings, Karl wants to find a shortest one.

Formally, a codeforces subsequence of a string s is a subset of ten characters of s that read codeforces from left to right. For example, codeforces contains codeforces a single time, while codeforcesisawesome contains codeforces four times: codeforcesisawesome, codeforcesisawesome, codeforcesisawesome, codeforcesisawesome.

Help Karl find any shortest string that contains at least k codeforces subsequences.

Input
The only line contains a single integer k (1≤k≤1016).

Output
Print a shortest string of lowercase English letters that contains at least k codeforces subsequences. If there are several such strings, print any of them.
     */
    public static void main(String[] args) {
        /*
        String s="codeforces";
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int dp[][]=new int[1000][1000];



       dp[0][0]=1;

            for (int len = 0; len < 200; len++) {
                for (int i = 0; i < s.length(); i++) {
                    for (int c = 1; c <= 100; c++) //occurances of this letter that i use;
                    {

                          dp[len+c][i]=Math.max(dp[len+c][i+1],dp[len][i]*c);
                    }

                }
                 if(dp[len][s.length()]>=k)
                {
                    System.out.println(len);
                    System.exit(0);
                }
            }

         */
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int small=2;
        while(toten(small)<k)
        {
        small++;
        }
        small--;
        int big=0;
        while (withbig(small,big)<k)
        {
            big++;
        }
        char arr[]="codeforces".toCharArray();
        for(int i=0;i<arr.length;i++)
        {
            if(i<big)
            {
                for(int j=0;j<=small;j++)
                {
                    System.out.print(arr[i]);
                }
            }
            else
            {
                for(int j=0;j<small;j++)
                {
                    System.out.print(arr[i]);
                }

            }
        }
        System.out.println("");
        
        }

    private static int withbig(int small, int big) {
        int base=toten(small);
        for(int i=0;i<big;i++)
        {
            base/=small;
            base*=small+1;
        }
        return base;
    }

    private static int toten(int small) {

        int ans=1;
        for(int i=0;i<10;i++)
        {
            ans*=small;
        }
        return ans;
    }


}

