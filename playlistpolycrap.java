import java.util.Scanner;

public class playlistpolycrap {
    /*
    Polycarp loves to listen to music, so he never leaves the player, even on the way home from the university.
    Polycarp overcomes the distance from the university to the house in exactly T minutes.

In the player, Polycarp stores n songs, each of which is characterized by two parameters:
ti and gi, where ti is the length of the song in minutes (1≤ti≤50), gi is its genre (1≤gi≤3).

Polycarp wants to create such a playlist so that he can listen to music all the time on the way from the university to his home,
and at the time of his arrival home, the playlist is over. Polycarp never interrupts songs and always listens to them from beginning to end.
Thus, if he started listening to the i-th song, he would spend exactly ti minutes on its listening.
Polycarp also does not like when two songs of the same genre play in a row (i.e. successively/adjacently) or when the songs in his playlist are repeated.

Help Polycarpus count the number of different sequences of songs (their order matters), the total duration is exactly T,
such that there are no two consecutive songs of the same genre in them and all the songs in the playlist are different.

Input
The first line of the input contains two integers n and T (1≤n≤15,1≤T≤225) — the number of songs in the player and the required total duration, respectively.

Next, the n lines contain descriptions of songs: the i-th line contains two integers ti and gi (1≤ti≤50,1≤gi≤3) — the duration of the i-th song and its genre, respectively.

Output
Output one integer — the number of different sequences of songs, the total length of exactly T,
such that there are no two consecutive songs of the same genre in them and all the songs in the playlist are different.
Since the answer may be huge, output it modulo 109+7 (that is, the remainder when dividing the quantity by 109+7).
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int dp[][][]=new int[1<<15][226][3];
        int k=sc.nextInt();
        int n=sc.nextInt();
        int t[]=new int[15];
        int s[]=new int[15];
        for(int i=0;i<k;i++)
        {
            t[i]=sc.nextInt();
            s[i]=sc.nextInt();
            s[i]--;
        }
        dp[0][0][0]=1;
        int ans=0;
        for(int i=0;i<1<<k;i++) {
            for (int j = 0; j < k; j++) {
                if ((i >> j & 1 ^ 1) != 0) {
                    continue;
                }
                int pi = i ^ 1 << j;

                for (int m = 0; m + t[j] <= n; m++) {
                    for(int l=0;l<3;l++)
                    {
                        if(l==s[j]&&pi!=0)
                        {
                            continue;
                        }
                        dp[i][m+t[j]][s[j]]=dp[i][m+t[j]][s[j]]+dp[pi][m][l];
                    }

                }
            }
            for(int j=0;j<3;j++)
            {
                ans+=dp[i][n][j];
            }
        }
        System.out.println(ans);

        /*
        for(int i=0;i<1<<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if((i>>j&1^1)!=0)
                {
                    System.out.println(i+" "+j+" "+(i>>j));
                }
            }
        }
         */

    }
}
