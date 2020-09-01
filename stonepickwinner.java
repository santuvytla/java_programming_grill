import java.util.Scanner;

public class stonepickwinner {
    /*
    There is a set
A
=
{
a
1
,
a
2
,
…
,
a
N
}
 consisting of
N
 positive integers. Taro and Jiro will play the following game against each other.

Initially, we have a pile consisting of
K
 stones. The two players perform the following operation alternately, starting from Taro:

Choose an element
x
 in
A
, and remove exactly
x
 stones from the pile.
A player loses when he becomes unable to play. Assuming that both players play optimally, determine the winner.

Input 1

2 4
2 3
Output 1
First
    If Taro removes three stones, Jiro cannot make a move. Thus, Taro wins.

     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        //dp[i] it is true if first player wins and are i stones remaining.
        boolean dp[]=new boolean[k+1];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int stones=0;stones<=k;stones++)
        {
            for(int i:arr) {
                if (i <= stones) {
                    if (!dp[stones - i]) {
                        dp[stones] = true;
                    }
                }
            }
        }
        System.out.println(dp[k]?"First":"Second");
    }
}
