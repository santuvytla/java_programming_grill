import java.util.Scanner;

public class bobsquarewin {
// each player picks and square number from n stones and other player does..player who cant loses..starts from player 1..print true if he(playeer 1) wins or false
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    boolean dp[]=new boolean[n+1];
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j*j<=i;j++)
        {
            dp[i]|=!dp[i-j*j];
        }
    }
    System.out.println(dp[n]);
}
}
