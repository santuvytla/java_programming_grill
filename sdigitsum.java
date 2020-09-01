import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class sdigitsum {
    /*
    Find the number of integers between
1
 and
K
 (inclusive) satisfying the following condition, modulo
10
9
+
7
:

The sum of the digits in base ten is a multiple of
D
.
input:
30
4
output:
6
number are 4,8,13,17,22,36

    //generally for checking huge numbers by normal method takes ton of time,so we use dp by method that
    if 253 is number hundreds place can take values 0,1,2 and if 0 or 1 tens place can take any value or else should be restricted to 5
    as 6 can get greater than 253 which is wrong based on question.
    dp[i][j]--it is the number of ways we choose digits so far such that i is the sum of digits modulo D which is the input and j is the smaller already which tells
    whether the choosen digits are smaller than k.
    */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        List<Integer> digits = new ArrayList<>();

        for (; num != 0; num /= 10)
            digits.add(num % 10);
        Collections.reverse(digits);

        Object[] k1 = digits.toArray();
        int k[]=new int[k1.length];
        int p=0;
        for(Object i:k1)
        {
            k[p++]= (int) i;
        }
        int l=k.length;
        int d=sc.nextInt();
        int dp[][]=new int[d][2];//0 is false 1 is true
        dp[0][0]=1; //sum =0s houldnot be counted we will substract this at the end
        for(int where=0;where<l;where++)
        {
            int new_dp[][]=new int[d][2];
            for(int sum=0;sum<d;sum++)
            {
                for(boolean sm_alr:new boolean[]{false,true})
                {
                    for(int digit=0;digit<10;digit++)
                    {
                        if(digit>k[where]&&!sm_alr)
                        {
                            break;
                        }
                        boolean c=sm_alr||(digit<k[where]);
                        new_dp[(sum+digit)%d][c?1:0]+=dp[sum][sm_alr?1:0];

                    }
                }
            }
            dp=new_dp.clone();

        }
        int ans=dp[0][0]+dp[0][1];
        --ans;
        if(ans==-1)
        {
            ans=99999;
        }
        System.out.println(ans);


    }
}
