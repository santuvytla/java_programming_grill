import java.util.Scanner;

public class stickgame {
    /*
    Consider a game where two players remove sticks from a heap. The players move alternately, and the player who removes the last stick wins the game.

A set P={p1,p2,…,pk} determines the allowed moves. For example, if P={1,3,4}, a player may remove 1, 3 or 4 sticks.

Your task is find out for each number of sticks 1,2,…,n if the first player has a winning or losing position.

Input

The first input line has two integers n and k: the number of sticks and moves.

The next line has k integers p1,p2,…,pk that describe the allowed moves. All integers are distinct, and one of them is 1.

Output

Print a string containing n characters: W means a winning position, and L means a losing position.

Constraints
1≤n≤106
1≤k≤100
1≤pi≤n
Example

Input:
10 3
1 3 4

Output:
WLWWWWLWLW
     */
public static boolean dp[]=new boolean[100];

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int p[]=new int[k];
        for(int i=0;i<k;i++)
        {
            p[i]=sc.nextInt();
        }
        for(int i=1;i<=n;i++) {
            for(int j=0;j<k;j++)
            {
                if(p[j]<=i)
                {
                    dp[i]|=!dp[i-p[j]];
                }
            }
            char c = dp[i]?'W':'L';
            System.out.print(c);
        }
    }
}

