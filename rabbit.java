import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class rabbit {
    /*
    There are
N
 rabbits, numbered
1
,
2
,
…
,
N
.

For each
i
,
j
 (
1
≤
i
,
j
≤
N
), the compatibility of Rabbit
i
 and
j
 is described by an integer
a
i
,
j
. Here,
a
i
,
i
=
0
 for each
i
 (
1
≤
i
≤
N
), and
a
i
,
j
=
a
j
,
i
 for each
i
 and
j
 (
1
≤
i
,
j
≤
N
).

Taro is dividing the
N
 rabbits into some number of groups. Here, each rabbit must belong to exactly one group. After grouping, for each
i
 and
j
 (
1
≤
i
<
j
≤
N
), Taro earns
a
i
,
j
 points if Rabbit
i
 and
j
 belong to the same group.

Find Taro's maximum possible total score.
     */
    //preproceesing

    public static int n=0;
    public static  int pre[]=new int[100000];
    public static int dp[]=new int[100000];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         n=sc.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        //preprocessing
        for(int mask=0;mask<(1<<n);mask++)
        {
            for(int i=0;i<n;i++)
            {
                if((mask&(1<<i))!=0) //if this bit is on
                {
                    for(int j=i+1;j<n;j++) //next rabbit
                    {
                        if((mask&(1<<j))!=0) //if even this bit is on
                        {
                            pre[mask]+=arr[i][j];
                        }
                    }
                }
            }
        }
        //dp[mask] the best score if we grouped rabbits from mask already

        Arrays.fill(dp,-100000);
        dp[0]=0;
        for(int mask=0;mask<(1<<n);mask++)
        {
            Vector<Integer> not_taken=new Vector<>();
            for(int i=0;i<n;i++)
            {
                if((mask&(1<<i))==0)
                {
                    not_taken.add(i);
                }
                // i need to iterate now on all subsets of not_taken and consider getting extra group
                rec(0,not_taken,dp[mask],mask,0);
            }
        }
        System.out.println(dp[(1<<n)-1]);
    }
    public static void rec(int i,Vector<Integer> not_taken,int score_so_far,int mask,int group) //i is index of 'not taken' we are considering
    {
            if(i==not_taken.size())
            {
                dp[mask]=Math.max(dp[mask],score_so_far+pre[group]);
                return;
            }
            //or go to the next one or go to next one by changing not_taken and mask by next one
            rec(i+1,not_taken,score_so_far,mask,group);
            rec(i+1,not_taken,score_so_far,mask^(1<<not_taken.get(i)),group^(1<<not_taken.get(i))); //not_taken[i] says which rabbit it is
        //also i need to increase the score_so_far by something that is iterate over the rabbits taken.for that let me do some pre preprocessing

    }
}
