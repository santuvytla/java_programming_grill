import java.util.Scanner;

public class googlekick2 {
    /*
    aliens have 4keyed piano,but wanted to record n tuned song into it such that 4keyed to memorise the song..
    it is done by storing each tune of high or low or equal freq into piano..first select one key of piano for on tune and for next onwards
    if low below key,if high next key and so on...if cant record as keys are completed it will result in discomfort..
    output:minimum no of discomforts
    this is okay:8 inputs
    2 3 4 5 6 7 8 9
    A B C D A B C D
    output
    1
    here thinking a>b>c>d only problem is actually d>a but pitch 5 didnt follow it..assuming it is correct b c d neednot be discomforted...
    so output is actually 1

    dp[i][4]---if i has the no of tunes takes and 4 corresponds to if 1st key is selected for 1st tune or 2nd or 3rd or 4th.
     */

    public static int arr[]=new int[10000];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        int dp[][]=new int[n+1][4];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<4;j++)
            {
                dp[i][j]=100000;
            }
        }
        for(int i=0;i<4;i++)
        {
            dp[0][i]=0;
        }

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<4;j++)
            {
                for(int k=0;k<4;k++)
                {
                    int b=cmp(j,k);
                    dp[i][k]=Math.min(dp[i][k],dp[i-1][j]+b!=cmp(arr[i-1],arr[i])?1:0);
                }
            }
        }
        int ans=10000000;
        for(int i=0;i<4;i++) {
            ans=Math.min(ans,dp[n-1][i]);
        }
        System.out.println(ans);
    }

    private static int cmp(int j, int k) {
        if(j==k)
        {
            return 0;
        }
        if(j<k)
        {
            return -1;
        }
        return 1;

    }
}
