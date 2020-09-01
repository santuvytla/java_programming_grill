package com.company;

public class fuel {
    public static void main(String[] args) {
        int target=4;
        int startfuel=1;
        int stations[][]={{1,1},{2,2},{3,1}};
        int k=minstati(target,startfuel,stations);
        System.out.print(k);

    }

    private static int minstati(int target, int startfuel, int[][] stations) {
        if(startfuel>=target)
        {
            return 0;
        }
        if(stations==null)
        {
            return -1;
        }
        int dp[]=new int[stations.length+1];
        dp[0]=startfuel;
        boolean[] visited=new boolean[stations.length];
        for(int i=1;i<dp.length;i++)
        {
            int max=0;
            int selectedstation=-1;
            for(int j=0;j<stations.length;j++)
            {
                if(!visited[j]&&dp[i-1]>=stations[j][0])
                {
                    if(stations[j][1]>max)
                    {
                        max=stations[j][1];
                        selectedstation=j;
                    }
                }

            }
            if(selectedstation!=-1)
            {
                visited[selectedstation]=true;
            }
            if((dp[i]=dp[i-1]+max)>=target)
            {
                return i;
            }
        }
        return -1;
    }
}
