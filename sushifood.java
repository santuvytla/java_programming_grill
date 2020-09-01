import java.util.Scanner;

public class sushifood {
    /*
    here are
N
 dishes, numbered
1
,
2
,
…
,
N
. Initially, for each
i
 (
1
≤
i
≤
N
), Dish
i
 has
a
i
 (
1
≤
a
i
≤
3
) pieces of sushi on it.

Taro will perform the following operation repeatedly until all the pieces of sushi are eaten:

Roll a die that shows the numbers
1
,
2
,
…
,
N
 with equal probabilities, and let
i
 be the outcome. If there are some pieces of sushi on Dish
i
, eat one of them; if there is none, do nothing.
Find the expected number of times the operation is performed before all the pieces of sushi are eaten.
     */
    public static void main(String[] args) {
        //dp[ones][twos][threes]=as it is not imp to see whether its 2 to 1 or 1 to 0..wat is more imp is number of ones,two,threes until that position.using it to
        // calculate operations. count array has the number of ones,twos and three's.
        //easier to think is dp[one][two][three] have probability to reach that state of that many ones,twos,threes.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt[] = new int[4];
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            cnt[c]++;
        }
        double p[][][]=new double[100][100][100];
        double ev[][][]=new double[100][100][100];
        p[cnt[1]][cnt[2]][cnt[3]]=1;
        //if we take 1 then dp[i-1][j][k],for 2 dp[i+1][j-1][k] for three dp[i][j+1][k] eventually we select one from three so prob is a/a+b+c or b/a+b+c or c/a+b+c
        //expected value array will compute the operations that is wasted (concept is expected value which uses conditional probability)
        for(int c=n;c>=0;c--)
        {
            for(int b=n;b>=0;b--)
            {
                for(int a=n;a>=0;a--)
                {
                    if(a==0&&b==0&&c==0)
                    {
                        continue;
                    }
            double p_waste=(double)(n-(a+b+c))/n; //prob that none is picked or helpful(waste operation)
                    //expected value is the gp of p_waste so ev will be
                    double ev_waste=p_waste/(1-p_waste);
                    ev[a][b][c]+=ev_waste*p[a][b][c];
                    if(a!=0)
                    {
                        double p_go=(double)a/(a+b+c);
                        p[a-1][b][c]+=p[a][b][c]*p_go;
                        ev[a-1][b][c]+=ev[a][b][c]*p_go;

                    }
                    if(b!=0)
                    {
                        double p_go=(double)b/(a+b+c);
                        p[a+1][b-1][c]+=p[a][b][c]*p_go;
                        ev[a+1][b-1][c]+=ev[a][b][c]*p_go;
                    }
                    if(c!=0)
                    {
                        double p_go=(double)c/(a+b+c);
                        p[a][b+1][c-1]+=p[a][b][c]*p_go;
                        ev[a][b+1][c-1]+=ev[a][b][c]*p_go;
                    }

                }
            }
        }
        double ans=ev[0][0][0]+cnt[1]+2*cnt[2]+3*cnt[3];
System.out.println(ans);
    }
}